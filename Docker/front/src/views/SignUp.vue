<template>
    <div class="alert alert-success" role="alert" v-if="this.registradoCorrectamente">
        You have registered successfully. <br> 
    </div>
    <div class="alert alert-danger" role="alert" v-if="this.registroIncorrecto">
       Check all the fields.
    </div>
    <div class="d-flex justify-content-around mt-5">
        <div class="elementoRegistro imagenStock">
            <img src="../img/joven_felices.jpg" alt="" width="550" height="700">
        </div>
        <div class="elementoRegistro formulario">
            <h1 class="display-3">Sign Up</h1>
            <form>
                <div class="campoInput">
                    <label for="">Email</label>
                    <input type="email" placeholder="Email..." required  v-model="this.email" :class="this.obtenerEstilosEmail"> <br>
                </div>
                <div class="campoInput">
                    <label for="">Password</label>
                    <div class="conjuntoInput d-flex justify-content-between">
                        <input type="password" placeholder="Password..." :class="this.obtenerEstilosPass1" v-model="this.password1" required>
                        <i class="bi bi-check-all" v-if="this.password1==this.password2 && this.password1 != ''"></i>
                        <i class="bi bi-check" v-else-if="this.password1!=''"></i>
                        <i class="bi bi-lock" ></i><br>
                    </div>
                </div>
                <div class="campoInput">
                    <label for="">Repeat Password</label>
                    <div class="conjuntoInput d-flex justify-content-between">
                        <input type="password" placeholder="Password..." required :class="this.obtenerEstilosPass2" v-model="this.password2"> 
                        <i class="bi bi-check-all" v-if="this.password1==this.password2 && this.password1 != ''"></i>
                        <i class="bi bi-check" v-else-if="this.password2!='' && this.password1==''"></i>
                        <i class="bi bi-exclamation" v-else-if="this.password2!='' && this.password1!=''"></i>
                        <i class="bi bi-lock"></i><br>
                    </div>
                </div>
                <hr>
                <div class="campoInput">
                    <label for="">Name</label>
                    <div class="conjuntoInput d-flex justify-content-between">
                        <input type="text" placeholder="Name..." v-model="this.nombre" required :class="this.obtenerEstilosNombre">
                        <i class="bi bi-person-fill"></i> <br>
                    </div>
                </div>
                <div class="campoInput">
                    <label for="">Surname</label>
                    <div class="conjuntoInput d-flex justify-content-between">
                        <input type="text" placeholder="Surname..." v-model="this.surname" :class="this.obtenerEstilosSurname" >
                        <i class="bi bi-person-fill"></i> <br>
                    </div>
                </div>
                <div class="campoInput">
                    <label for="">Username</label>
                    <div class="conjuntoInput d-flex justify-content-between" required>
                        <input type="text" placeholder="Nickname..." v-model="this.nickname" :class="this.obtenerEstilosNickname">
                        <i class="bi bi-person-fill"></i> <br>
                    </div>
                    
                </div>
                <p :class="{errorUsuario: !this.nicknameCorrecto && this.activarComprobacionFormatoDinamica, usuarioBien:this.nicknameCorrecto && this.activarComprobacionFormatoDinamica}" v-if=" !this.nicknameCorrecto && this.activarComprobacionFormatoDinamica">Username not avaible.</p>
                <hr>
                <div class="campoInput">
                    <label for="">Birth date</label>
                    <input type="date" v-model="this.birthDate" :class="this.obtenerEstilosFecha"> <br>
                </div>
                <div class="campoInput">
                    <label for="">City</label>
                    <select name="" id="" class="mt-2 mb-2" v-model="this.idCiudad" :class="this.obtenerEstilosDatosCiudad">
                        <optgroup value="" v-for="(comunidad, index) in this.datosCiudadesID.comunidades" :key="index" :label="comunidad.nombre">
                            <option :value="ciudad.id" v-for="(ciudad, index2) in comunidad.provincias" :key="index2">{{ciudad.name}}</option>
                        </optgroup>
                    </select>
                </div>
                <hr>
                <button class="btn" @click="comprobarFormulario">Send</button>
            </form>
        </div>
    </div>
</template>
<script>
import axios from "axios"
import obtenerIdUsuario from "../mixin/obtenerIdUsuario";
export default {
    name:"SignUp",
    mixins: [obtenerIdUsuario],
    data(){
      return{
        datosCiudadesID:{},

        nombre:"",
        email:"",
        password1:"",
        password2:"",
        surname:"",
        nickname:"",
        birthDate:"",
        idCiudad:"",

        nicknameComprobado:"",
        nicknameCorrecto:false,
        emailCorrecto:false,
        
        
        nicknameParaSaberID:"",
        datosRopaSinFiltrar:{},
        datosRopa:{
                cabeza:[],
                tronco:[],
                piernas:[],
                pies:[]
        },
        registroFinalizado:false,
        registradoCorrectamente:false,
        registroIncorrecto:false,

        activarComprobacionFormatoDinamica:false,
      }
    },
    created() {
        this.datosCiudadesID= require('../assets/meteOwn.json'); 
    },
    async updated(){
        if(this.nicknameComprobado!=this.nickname && !this.registroFinalizado){
            this.nicknameCorrecto = await (await axios.get(`/meteOwn/v1/username/${this.nickname!=''?this.nickname:'Klabitos'}`)).data; //Para no generar una llamada a un nickname ocupado
            this.nicknameComprobado=this.nickname
        }
    },
    methods: {
        comprobarFormulario(event){
            event.preventDefault();
            if(this.birthDate==''){this.birthDate='01/01/0001'}
            this.activarComprobacionFormatoDinamica=true;
            if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.exec(this.email) && this.nombre!='' && this.password1==this.password2 && this.password1!='' && this.surname!='' && this.name!='' && this.nickname!='' && this.idCiudad!='' && this.birthDate!='' && this.nicknameCorrecto && this.nickname.length<20){
                this.registroFinalizado=true;
                axios.post('meteOwn/v1/usuarios', {email:this.email, name: this.nombre, surname:this.surname, nickname: this.nickname, idCiudad: this.idCiudad, fechaNacimiento: this.birthDate});
                axios.post('meteOwn/v1/security/user', {username: this.nickname, password:this.password1, enabled: '1'});
                setTimeout(() => {
                    axios.post('meteOwn/v1/security/authority', {username: this.nickname, authority: 'ROLE_USER'});
                    this.insercionTodasRopas();
                    this.exitoFormulario();
                }, 500);
            }else{
                this.registroIncorrecto=true;
            }
        },

        async insercionTodasRopas(){
            this.obtenerIdUsuarioActivo(this.nickname);
            await axios.get(` /meteOwn/v1/ropas`)
                    .then(response => this.datosRopaSinFiltrar = response.data)
                    .catch(response => console.log("Error al recuperar datos"+ response.status));
            await this.filtrarRopa();
            await this.bucleInsercionTodasRopas(); 
        },
        async filtrarRopa(){
            for(let n=0; n< this.datosRopaSinFiltrar.length; n++){
                    if(this.datosRopaSinFiltrar[n].tipoRopa.tipoRopa==1){
                        this.datosRopa.cabeza.push(this.datosRopaSinFiltrar[n]);
                    }else if(this.datosRopaSinFiltrar[n].tipoRopa.tipoRopa==2){
                        this.datosRopa.tronco.push(this.datosRopaSinFiltrar[n]);
                    }else if(this.datosRopaSinFiltrar[n].tipoRopa.tipoRopa==3){
                        this.datosRopa.piernas.push(this.datosRopaSinFiltrar[n]);
                    }else{
                    this.datosRopa.pies.push(this.datosRopaSinFiltrar[n]);
                    }
            }
        },
        bucleInsercionTodasRopas(){  
            for(let n=0; n<this.datosRopa.cabeza.length; n++){
                axios.post('meteOwn/v1/ropausuarios', {idRopa: this.datosRopa.cabeza[n].idRopa, valorCalorRopa: this.datosRopa.cabeza[n].valorCalorPorDefecto, usuario: {idUsuario: this.idUsuario}});
            }    
            for(let n=0; n<this.datosRopa.tronco.length; n++){
                axios.post('meteOwn/v1/ropausuarios', {idRopa: this.datosRopa.tronco[n].idRopa, valorCalorRopa: this.datosRopa.tronco[n].valorCalorPorDefecto, usuario: {idUsuario: this.idUsuario}});
            }
            for(let n=0; n<this.datosRopa.piernas.length; n++){
                axios.post('meteOwn/v1/ropausuarios', {idRopa: this.datosRopa.piernas[n].idRopa, valorCalorRopa: this.datosRopa.piernas[n].valorCalorPorDefecto, usuario: {idUsuario: this.idUsuario}});
            }
            for(let n=0; n<this.datosRopa.pies.length; n++){
                axios.post('meteOwn/v1/ropausuarios', {idRopa: this.datosRopa.pies[n].idRopa, valorCalorRopa: this.datosRopa.pies[n].valorCalorPorDefecto, usuario: {idUsuario: this.idUsuario}});
            }      
        },
        exitoFormulario(){
            this.nombre="";
            this.datosCiudadesID={};
            this.email="";
            this.password1="";
            this.password2="";
            this.surname="";
            this.nickname="";
            this.birthDate="test";
            this.idCiudad="";
            this.registradoCorrectamente=true;
            this.activarComprobacionFormatoDinamica=false;
            this.registroIncorrecto=false;
            this.emailCorrecto=false;
        },
    },
    computed:{
        obtenerEstilosNickname(){
            if(this.nickname=='' && this.activarComprobacionFormatoDinamica || this.nickname>=20 && this.activarComprobacionFormatoDinamica || !this.nicknameCorrecto && this.activarComprobacionFormatoDinamica){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                return 'noError';
            }
        },
       
        obtenerEstilosNombre(){
            if(this.nombre=='' && this.activarComprobacionFormatoDinamica){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                return 'noError';
            }
        },
        obtenerEstilosSurname(){
            if(this.surname=='' && this.activarComprobacionFormatoDinamica){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                return 'noError';
            }
        },

        obtenerEstilosDatosCiudad(){
            if(this.idCiudad=='' && this.activarComprobacionFormatoDinamica){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                return 'noError';
            }
        },
        obtenerEstilosFecha(){
            if(this.birthDate=='01/01/0001' && this.activarComprobacionFormatoDinamica){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                return 'noError';
            }
        },
        obtenerEstilosEmail(){
            if(!/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.exec(this.email) && this.activarComprobacionFormatoDinamica ){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                this.emailCorrecto==true;
                return 'noError';
            }
        },
        obtenerEstilosPass1(){
            if(this.password1=='' && this.activarComprobacionFormatoDinamica){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                return 'noError';
            }
        },
        obtenerEstilosPass2(){
            if((this.password2!=this.password1 || this.password2=='') && this.activarComprobacionFormatoDinamica ){
                return "error"
            }else if(this.activarComprobacionFormatoDinamica){
                return 'noError';
            }
        },
    }
        
    
}
</script>
<style >
    .errorUsuario{
        margin-top: 10px;
        color: red;
        transition: all 1s ease-in, ease-out;
    }
    .usuarioBien{
        transition: all 1s ease-in, ease-out;
    }
    .campoInput{
        display: flex;
        flex-direction: row;
        justify-content: center;
        width: 100%;
        margin-top: 5px;
    }
    .campoInput label{
        width: 40%;
        text-align: left;     
    }
    .campoInput input{
        width: 40%;

    }
    .conjuntoInput{
        width: 40%;
    }
    .conjuntoInput input{
        width: 70%;
    }
    .campoInput select{
        width: 40%;
    }
    .elementoRegistro{
        width: 40%;
    }
    .formulario{
        align-self: center;
        padding: 50px;
        padding-top: 20px;
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
    }
    
</style>
<style scoped>
    .error{
        background-color: rgba(255, 0, 0, 0.116);
        transition: all 0.8s ease-in-out;
        box-shadow: 0 2px 4px 0 rgba(255, 0, 0, 0.644),0 1px 5px 0 rgba(255, 0, 0, 0.486) !important;
    }

    .noError{
        background-color: rgba(144, 238, 144, 0.075);
        transition: all 1s ease-in-out;
    }

    img{
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        
    }
    .btn{
        width: 70%;
        margin-left: auto;
        margin-right: auto;
        background-color: var(--colorMoradoSecundario);
        border-color:var(--colorMoradoTerciario);
        color: white;
    }
    h1{
        padding: 10px;
    }
    i{
        margin-left: 10px;
        font-size: 20px;
    }

    @media screen and (max-width: 1168px){
        .imagenStock{
            display: none;
        }

        .formulario{
            width: 80%;
        }
    }
</style>