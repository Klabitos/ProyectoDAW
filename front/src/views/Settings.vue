<template lang="">
    <div>
        <div class="alert alert-success" role="alert" v-if="this.modCorrectamente">
            You have modified your user information successfully. <br> 
        </div>
        <div class="alert alert-danger" role="alert" v-if="this.modIncorrecto">
            Check all the fields and complete correctly.
        </div>
        <div class="container light-style flex-grow-1 container-p-y">

    <h4 class="display-1 titulo mt-5">
      Account settings
    </h4>

    <div class="card overflow-hidden fondoMoradoClarito">
        <div class="row row-bordered row-border-light">
            <div class="col-md-3 pt-0">
                <div class="list-group list-group-flush account-settings-links">
                    <h4 :class="obtenerClaseGeneral" @click="setActiveGeneral">User Information</h4>     
                    <h4 :class="obtenerClaseCity" @click="setActiveCity">Change city</h4>
                    <h4 :class="obtenerClaseFile" @click="setActiveFile" v-if="this.role=='ROLE_ADMIN'">ADMIN</h4>
                </div>
            </div>
        <div class="col-md-9">
            <div class="tab-content">
                <div class="" id="account-general" v-if="this.mostrarGeneral">
                    <div class="card-body">
                        <div class="form-group">
                            <label class="form-label fw-bold colorMoradoTexto">Username</label>
                            <input type="text" class="form-control mb-1" v-model="this.datosUsuario.nickname" readonly>
                        </div>
                        <div class="form-group">
                            <label class="form-label fw-bold colorMoradoTexto">Name</label>
                            <input type="text" class="form-control" v-model="this.datosUsuario.name">
                        </div>
                        <div class="form-group">
                            <label class="form-label fw-bold colorMoradoTexto">Surname</label>
                            <input type="text" class="form-control" v-model="this.datosUsuario.surname">
                        </div>
                        <div class="form-group">
                            <label class="form-label fw-bold colorMoradoTexto">E-mail</label>
                            <input type="text" class="form-control mb-1" v-model="this.datosUsuario.email">
                        </div>
                        <div class="form-group">
                            <label class="form-label fw-bold colorMoradoTexto">Birth Date</label>
                            <input type="date" class="form-control" v-model="this.datosUsuario.fechaNacimiento">
                        </div>
                    </div>
                </div>
                
                <div class="" id="account-change-password" v-else-if="this.mostrarFile"> 
                    <div class="card-body pb-2">
                        <div class="form-group">
                            <form action="http://localhost:8080/meteOwn/v1/upload" method="POST" enctype="multipart/form-data">
                                <button class="botonAzulado m-3 ps-4 pe-4" @click="this.mostrarUsuarios()">Mostrar todos usuarios</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="" id="account-info" v-else>
                    <div class="card-body pb-2">
                        <div class="form-group">
                            <p>If you want to have a different default city, choose a new one:</p>
                            <div class="campoInput">
                               <label class="form-label fw-bold colorMoradoTexto">City</label>
                                <select name="" id="" class="mt-2 mb-2" v-model="this.datosUsuario.idCiudad">
                                    <optgroup value="" v-for="(comunidad, index) in this.datosCiudadesID.comunidades" :key="index" :label="comunidad.nombre">
                                        <option :value="ciudad.id" v-for="(ciudad, index2) in comunidad.provincias" :key="index2">{{ciudad.name}}</option>
                                    </optgroup>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
      </div>
    </div>
    <div class="confirmacion mt-4" v-if="this.confirm">
        <p class="m-4">Are you really sure you want to modify this information?</p>
        <button class="botonAzulado m-3 p-2" @click="this.comprobarCampos()">Confirm</button> 
        <button class="botonRojo  m-3 p-2" @click="this.confirm=false;">Cancel</button>
    </div>
    <div class="botones" v-else>
      <button type="button" class="btn" @click="this.confirm=true; ">Save changes</button>&nbsp;
       <button type="button" class="btn" @click="this.obtenerInfoUsuario()">Cancel</button>&nbsp;
    </div>

  </div>
    </div>
</template>
<script>
import comprobacionTipoRol from "../mixin/comprobacionTipoRol";
import comprobarLoginCorrecto from "../mixin/comprobarLoginCorrecto";
import obtenerIdUsuario from "../mixin/obtenerIdUsuario";
import axios from "axios"
export default {
    mixins: [comprobacionTipoRol, comprobarLoginCorrecto, obtenerIdUsuario],
    data(){
        return{
            mostrarFile:false,
            mostrarGeneral:true,
            mostrarCity:false,
            nickname:"",
            idUsuario:0,
            datosCiudadesID:{},
            datosUsuario:{},

            image:null,
            role:"",

            confirm:false,
            modCorrectamente:false,
            modIncorrecto:false,

            todosUsuarios:[],
            todasRopas:[],
            todasRopasUsuario:[],
        }
    },
    async created(){
        this.datosCiudadesID= require('../assets/meteOwn.json');
        this.nickname=this.$route.params.username 
        this.obtenerRol(this.nickname);
        this.comprobarLoginCorrecto(this.nickname)
        this.obtenerIdUsuarioActivo(this.nickname); 
        setTimeout(() => {
            this.obtenerInfoUsuario();
            this.role=this.myRole;
        }, 500);
       
        
    },
    methods:{
        comprobarCampos(){
            if(this.datosUsuario.birthDate==''){this.datosUsuario.birthDate='01/01/0001'}
            if(/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.exec(this.datosUsuario.email) && this.datosUsuario.name!=''  && this.datosUsuario.surname!='' && this.datosUsuario.nickname!='' && this.datosUsuario.idCiudad!='' && this.datosUsuario.fechaNacimiento!=''){
                axios.put('/meteOwn/v1/usuarios', {idUsuario:this.datosUsuario.idUsuario, email:this.datosUsuario.email, name: this.datosUsuario.name, surname:this.datosUsuario.surname, nickname: this.datosUsuario.nickname, idCiudad: this.datosUsuario.idCiudad, fechaNacimiento: this.datosUsuario.fechaNacimiento});
                this.modIncorrecto=false;
                this.modCorrectamente=true;
                this.confirm=false,
                setTimeout(() => {
                    this.modCorrectamente=false;
                }, 5000);
                setTimeout(() => {
                    this.obtenerInfoUsuario();
                }, 500);
            }else{
                this.modIncorrecto=true;
            }
        },
        setActiveFile(){
            if(this.role=="ROLE_ADMIN"){
                this.mostrarFile=true;
                this.mostrarGeneral=false;
                this.mostrarCity=false;
            }
        },
        setActiveGeneral(){
            this.mostrarFile=false;
            this.mostrarGeneral=true;
            this.mostrarCity=false;
        },
        setActiveCity(){
            this.mostrarFile=false;
            this.mostrarGeneral=false;
            this.mostrarCity=true;
        },
        async obtenerInfoUsuario(){
            await axios.get(`/meteOwn/v1/usuarios/${this.idUsuario}`)
                    .then(response => this.datosUsuario=response.data)
                    .catch(response => console.log("Error al recuperar datos "+ response.status));
                    this.modIncorrecto=false;
        },
        mostrarUsuarios(){
            this.$router.push({name:"Users", params:{username:this.nickname}});
        }
    },
    computed:{
        obtenerClaseGeneral(){
            if(this.mostrarGeneral){
                return "list-group-item list-group-item-action active";
            }else{
                return "list-group-item list-group-item-action"
            }
        },
        obtenerClaseFile(){
            if(this.mostrarFile){
                return "list-group-item list-group-item-action active";
            }else{
                return "list-group-item list-group-item-action"
            }
        },
        obtenerClaseCity(){
            if(this.mostrarCity){
                return "list-group-item list-group-item-action active";
            }else{
                return "list-group-item list-group-item-action"
            }
        }
    }
}
</script>
<style scoped>
    .botonAzulado{
        background-color: rgb(47, 140, 168);
        border-color:var(--colorMoradoTerciario);
        padding: 2%;
        margin: 1%;
        color: white;
        transition: all 1.5 ease; 
    }

    .botonAzulado:hover{
        background-color: rgb(0, 101, 168);
    }
    .botonRojo:hover{
        background-color: rgb(167, 19, 0);
    }
    .botonRojo{
        background-color: rgb(168, 75, 47);
        border-color:var(--colorMoradoTerciario);
        padding: 2%;
        margin: 1%;
        color: white;
        transition: all 1.5 ease; 
    }

.confirmacion{
            box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        border: 2px solid var(--colorMoradoTerciario);
        background-color: var(--colorMoradoSuave);
}
  .list-group-item.active{
      background-color: var(--colorMoradoSecundario);
      border: 1px solid var(--colorMoradoTerciario);
  }

  .fondoMoradoClarito{
      background-color: var(--colorMoradoSuave);
      border: 2px solid var(--colorMoradoTerciario);
  }

    .btn:hover{
        background-color: var( --colorMoradoTerciario);
        border: 1px solid black;
        transition: all 0.5 ease;     
        color:white;  
    }
    .btn{
        color:white;
        background-color: var( --colorMoradoSecundario);
        width: 200px;
        height: 50px;
        margin-bottom: 5px;
        border:1px solid  var( --colorMoradoTerciario);
    }
    span{
        padding: 50%;
    }

    .fondoMoradoClarito{
        text-align: left;
    }

    .account-settings-links h4{
        cursor: pointer;
    }

    .botones{
        margin-top: 100px;
    }
</style>