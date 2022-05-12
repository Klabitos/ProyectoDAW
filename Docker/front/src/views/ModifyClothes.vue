<template lang="">
    <div class="alert alert-success" role="alert" v-if="this.exitoOperacion">
    Clothes modified!
    </div>
    <div class="mt-2 p-2  outerContainer">
        <div class="modifySet" v-if="this.datosListos && !this.zonaCloth">
            <h6 class="titulo display-3 text-start">Modify Outfit</h6>
            <div class="carouselOwn" >
                <div class="d-flex justify-content-between">
                    <div class="iconoPre align-self-center ms-3" @click="preCabeza()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div>
                        <img :src='require(`../img/carousel/${this.obtenerURLCabeza()}`)' class="" alt="..." width="100" height="100">
                    </div>
                    <div class="iconoNext align-self-center me-3" @click="nextCabeza()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
                        
                </div>
                <div class="d-flex justify-content-between" >
                    <div class="iconoPre align-self-center ms-3" @click="preTronco()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div>
                        <img :src='require(`../img/carousel/${this.obtenerURLTronco()}`)' class="imagenRopa" alt="..." width="200" height="180">
                    </div>
                    <div class="iconoNext align-self-center me-3" @click="nextTronco()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
                </div>
                <div class="d-flex justify-content-between">
                    <div class="iconoPre align-self-center ms-3"  @click="prePiernas()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div>
                        <img :src='require(`../img/carousel/${this.obtenerURLPiernas()}`)' class="" alt="..." width="300" height="250" >
                    </div>
                    <div class="iconoNext align-self-center me-3" @click="nextPiernas()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
                </div>
                <div class="d-flex justify-content-between" >
                    <div class="iconoPre align-self-center ms-3 mb-3" @click="prePies()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div >
                        <img :src='require(`../img/carousel/${this.obtenerURLPies()}`)' class="" alt="..." width="100" height="80" >
                    </div>
                    <div class="iconoNext align-self-center me-3 mb-3" @click="nextPies()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i>
                    </div>
                </div>
            </div>
        </div>

        <div class="modifyCloth" v-if="this.zonaCloth">
            <h2 class="titulo display-3 text-start">Modify Clothes</h2>
            <div class="carouselOwn" v-if="this.datosListos">
                <h2 class="titulo display-6 mt-2">{{this.selectParteCuerpo}}</h2>
                <div class="d-flex justify-content-between mt-4" v-if="this.selectParteCuerpo=='Head'">
                    <div class="iconoPre align-self-center ms-3" @click="preCabeza()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div>
                        <img :src='require(`../img/carousel/${this.obtenerURLCabeza()}`)' class="" alt="..." width="100" height="100">
                    </div>
                    <div class="iconoNext align-self-center me-3" @click="nextCabeza()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>         
                </div>
                <div class="d-flex justify-content-between" v-else-if="this.selectParteCuerpo=='Chest'">
                    <div class="iconoPre align-self-center ms-3" @click="preTronco()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div>
                        <img :src='require(`../img/carousel/${this.obtenerURLTronco()}`)' class="imagenRopa" alt="..." width="200" height="180">
                    </div>
                    <div class="iconoNext align-self-center me-3" @click="nextTronco()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
                </div>
                <div class="d-flex justify-content-between" v-else-if="this.selectParteCuerpo=='Legs'">
                    <div class="iconoPre align-self-center ms-3"  @click="prePiernas()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div>
                        <img :src='require(`../img/carousel/${this.obtenerURLPiernas()}`)' class="pantalon" alt="..." width="300" height="250" >
                    </div>
                    <div class="iconoNext align-self-center me-3" @click="nextPiernas()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
                </div>
                <div class="d-flex justify-content-between" v-else-if="this.selectParteCuerpo=='Feet'">
                    <div class="iconoPre align-self-center ms-3 mb-3" @click="prePies()"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                    <div >
                        <img :src='require(`../img/carousel/${this.obtenerURLPies()}`)' class="" alt="..." width="100" height="80" >
                    </div>
                    <div class="iconoNext align-self-center me-3 mb-3" @click="nextPies()"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
                </div>
                <div>
                    <select name="" id="" class="m-4" v-model="selectParteCuerpo">
                        <option value="Head">Head</option>
                        <option value="Chest">Chest</option>
                        <option value="Legs">Legs</option>
                        <option value="Feet">Feet</option>
                    </select>
                </div>
                
            </div>
        </div>
        <div class="formularioModificacionValores mt-3">
            <button class="m-3 botonGrande" @click="cambiarModificadorVisible()" v-if="!this.zonaCloth">Change to Clothes</button>
            <button class="m-3 botonGrande" @click="cambiarModificadorVisible()" v-else>Change to Outfits</button>
            <div class="cuadradoFormularioMofificacionValores mt-4" v-if="this.zonaCloth">
                <p>
                    <h5 class="fw-bold">Change the value the clothes</h5>
                    Change this property will change the value of the clothes and therefore all your personal forecast with it from now on.
                </p>
                <div class="align-items-center">
                    <span :class="estilosCooler">Cooler</span>
                    <input class="" type="range" :min="this.valorTermicoRopaMin" :max="this.valorTermicoRopaMax"  step="0.01" v-if="this.zonaCloth" v-model="this.valorTermicoRopa"> 
                    <input type="range" min="2" max="2" value="0" step="0.5" v-else> 
                    <span :class="estilosHotter" >Hotter</span>
                </div>
                    <span v-if="this.valorTermicoRopa==0">Move the cursor to modify the clothes.</span>
                    <br>
                    <button class="botonStandard" @click="this.valorTermicoRopa!=0?this.confirm=true:null;">Save changes</button>
            </div>
            <div class="cuadradoFormularioMofificacionValores mt-4" v-else>
                <div>
                    <h3>Choose the Outfit you want to modify</h3>
                    <div class="d-flex justify-content-around me-3">
                        <button :class="this.boton[0]" @click="this.activarSet(0)" >1</button>
                        <button :class="this.boton[1]" @click="this.activarSet(1)">2</button>
                        <button :class="this.boton[2]" @click="this.activarSet(2)">3</button>
                        <button :class="this.boton[3]" @click="this.activarSet(3)">4</button>
                    </div>
                    <label for="">Type the name of the new Outfit</label> <br>
                    <input type="text" v-model="this.nombreSet">
                </div>

                    <button class="botonStandard" @click="this.confirmSet=true">Save changes</button>
            </div>
            <div class="cuadradoFormularioMofificacionValores mt-4" v-if="this.confirm">
                <p class="m-4">Are you really sure you want to modify this clothes?</p>
                <button class="botonAzulado m-3 p-2" @click="modificarValorTermicoRopa()">Confirm</button> 
                <button class="botonRojo  m-3 p-2" @click="this.confirm=false; this.valorTermicoRopa=0;">Cancel</button>
            </div>
            <div class="cuadradoFormularioMofificacionValores mt-4" v-if="this.confirmSet">
                <p class="m-4">Are you really sure you want to modify this Outfit?</p>
                <button class="botonAzulado m-3 p-2" @click="modificarSet()">Confirm</button> 
                <button class="botonRojo  m-3 p-2" @click="this.confirmSet=false;">Cancel</button>
            </div>
        </div>
        
    </div>
</template>
<script>
import obtenerSetsUsuarioActivo from "../mixin/obtenerSetsUsuarioActivo";
import comprobarLoginCorrecto from "../mixin/comprobarLoginCorrecto";
import funcionalidadRopas from "../mixin/funcionalidadRopas"
import axios from "axios"
export default {
    props:[
        "username"
    ],
    mixins:[
        obtenerSetsUsuarioActivo, comprobarLoginCorrecto, funcionalidadRopas
    ],
    data(){
        return{
            zonaCloth:true,
            exitoOperacion:false,

            valorTermicoRopaMin:0,
            valorTermicoRopaMax:0,
            valorTermicoRopa:0,
            selectParteCuerpo:"Head",
            confirm:false,
            confirmSet:false,

            infoMeteo:{},

            boton:["noElegido","noElegido","noElegido","noElegido"],
            nombreSet:"",
            setActivo:0,
        }  
    },
    async created(){ //TODO obtener el valor termico actual
        await this.obtenerDatosGenericosRopa();
        await this.filtrarRopa();
        this.nickname=this.$route.params.username 
        this.comprobarLoginCorrecto(this.nickname);
        this.obtenerIdUsuarioActivoConUsername(this.nickname);
        
        this.valorTermicoRopaMin=this.valorTermicoRopa-1;
        this.valorTermicoRopaMax=this.valorTermicoRopa+1;
    },
    methods:{
        activarSet(numSet){
            this.nombreSet="";
            for(let i=0; i<this.boton.length; i++){
                if(i==numSet){
                    this.boton[i]="elegido";
                    this.setActivo=i+1;
                }else{
                    this.boton[i]="noElegido"
                }
            }
            for(let i = 0; i< this.todosSetUsuario.length; i++){
                if(this.todosSetUsuario[i].numConjunto==this.setActivo){
                    this.nombreSet=this.todosSetUsuario[i].nombreConjunto;
                    this.ropaActivaID.cabeza=this.todosSetUsuario[i].idPrendaCabeza;
                    this.ropaActivaID.tronco=this.todosSetUsuario[i].idPrendaTorso;
                    this.ropaActivaID.piernas=this.todosSetUsuario[i].idPrendaPierna; 
                    this.ropaActivaID.pies=this.todosSetUsuario[i].idPrendaPies; 
                }
            }
        },
        modificarSet(){
            let existeNumSet=false;
            if(this.setActivo!=0 && this.nombreSet!=""){
                existeNumSet=this.todosSetUsuario.filter(set => set.numConjunto==this.setActivo);
                if(existeNumSet.length>0){ //UPDATE
                    axios.put(`/meteOwn/v1/conjuntos`, {idUsuario: this.idUsuario, usuario:{idUsuario:this.idUsuario}, prendaCabeza: {idRopa:this.ropaActivaID.cabeza}, prendaTorso: {idRopa:this.ropaActivaID.tronco}, prendaPierna: {idRopa:this.ropaActivaID.piernas}, prendaPies: {idRopa:this.ropaActivaID.pies}, numConjunto:this.setActivo, idConjuntoUsuario:existeNumSet[0].idConjuntoUsuario, nombreCOnjunto:this.nombreSet});
                }else{ //INSERT
                    axios.post('/meteOwn/v1/conjuntos', {usuario:{idUsuario:this.idUsuario}, prendaCabeza: {idRopa:this.ropaActivaID.cabeza}, prendaTorso: {idRopa:this.ropaActivaID.tronco}, prendaPierna: {idRopa:this.ropaActivaID.piernas}, prendaPies: {idRopa:this.ropaActivaID.pies}, numConjunto:this.setActivo, nombreCOnjunto:this.nombreSet});
                }
                this.operacionFinalizada();
            }else{
                alert("Debes seleccionar un número de set");
            }
        },
        obtenerIdRopaCorrespondiente(){
            if(this.selectParteCuerpo=="Head"){
                return this.ropaActivaID.cabeza
            }else if(this.selectParteCuerpo=="Chest"){
                return this.ropaActivaID.tronco
            }else if(this.selectParteCuerpo=="Legs"){
                return this.ropaActivaID.piernas
            }else if(this.selectParteCuerpo=="Feet"){
                return this.ropaActivaID.pies
            }else{
                return null;
            }
        },
        async operacionFinalizada(){
            this.exitoOperacion=true;
            this.confirm=false;
            this.valorTermicoRopa=0;
            this.boton=["noElegido","noElegido","noElegido","noElegido"],
            this.nombreSet="";
            this.setActivo=0;
            this.confirmSet=false;
            this.todosSetUsuario=[];
            setTimeout(() => {
                this.obtenerSetsUsuario();
            }, 1000);
            
            setTimeout(() => {
                this.exitoOperacion=false;
                
            }, 5000);
        },


        modificarValorTermicoRopa(){
            let idRopaCorrespondiente = this.obtenerIdRopaCorrespondiente();
            axios.put(`/meteOwn/v1/ropausuarios`, {idRopa: idRopaCorrespondiente, usuario:{idUsuario:this.idUsuario}, valorCalorRopa: this.valorTermicoRopa})
            this.operacionFinalizada();
        },
        cambiarModificadorVisible(){
            this.boton=["noElegido","noElegido","noElegido","noElegido"]
            this.setActivo=0;
            this.nombreSet="";
            this.zonaCloth=this.zonaCloth?false:true;
            this.confirmSet=false;
            this.confirm=false;
        }
    },    
    computed:{
        estilosCooler(){
            if(this.valorTermicoRopa<0){
                return "me-4 blue";
            }else{
                return "me-4 blue invisible"
            }
        },
        estilosHotter(){
            if(this.valorTermicoRopa>0){
                return "ms-4 red";
            }else{
                return "ms-4 red invisible"
            }
        }
    },
}
</script>
<style scoped >

    /* DIVS PRINCIPALES */

    .outerContainer{
        display: flex;
        justify-content: space-between;
    }

    .modifySet{
        width: 50%;
        height: 90vh;
        margin-left: 8%;
    }
    .modifyCloth{
        width: 44%;
        height: 90vh;
        margin-left: 8%;
    }

    .formularioModificacionValores{
        width: 30%;
        margin-right: 8%;
    }
    .cuadradoFormularioMofificacionValores{
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        border: 2px solid var(--colorMoradoTerciario);
        background-color: var(--colorMoradoSuave);
    }
    .centrarVertical{
        margin-top: 22%;
    }




    /* ICONOS CAROUSEL */

    .iconoPre i{
        color: var(--colorMoradoTerciario);
    }

    .iconoNext, .iconoPre{
        border-radius: 25px;
        width: 200px;
        background-color: var(--colorMoradoSuave);
        cursor: pointer;
        border: 1px solid var(--colorMoradoTerciario);
        transition: 0.5s;
    }

    .iconoNext:hover, .iconoPre:hover{
        background-color: var(--colorMoradoSecundario);
    }
    .iconoNext:hover i, .iconoPre:hover i{
        transition: 0.5s;
        color: white;
    }

    .carousel-control-next, .carousel-control-prev{
        background-color: var(--colorMoradoTerciario);
    }

    .carouselOwn{
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        border: 2px solid var(--colorMoradoTerciario);
        background-color: var(--colorMoradoSuave);
    }

    /* BOTONES */

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
    .botonStandard{
        background-color: var(--colorMoradoSecundario);
        border-color:var(--colorMoradoTerciario);
        padding: 2%;
        margin: 1%;
        color: white;
        transition: all 1.5 ease;       
    }

    .botonGrande{
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        background-color: var(--colorMoradoSecundario);
        border:3px solid var(--colorMoradoTerciario);
        padding: 10%;
        margin: 1%;
        color: white;
        transition: all 1.5 ease;
        border-radius: 25px;    
    }

    .botonStandard:hover, .botonGrande:hover{
            background-color: var( --colorMoradoTerciario);
            border: 2px solid black;
            transition: all 1.5 ease;  
    }

    .elegido{
        background-color: purple;
        border-color:var(--colorMoradoTerciario);
        border-radius: 25px;
        margin: 1%;
        padding: 3%;
        color: white;
    }

    .noElegido{
        background-color: var(--colorMoradoPrincipal);
        border-color:var(--colorMoradoTerciario);
        border-radius: 25px;
        margin: 1%;
        padding: 3%;
        color: white;
    }

    .invisble{
        opacity: 0;
    }
    

    @media screen and (max-width:768px) { 

        .outerContainer{
            flex-direction: column;
        }


        .formularioModificacionValores{
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            order: 1;
            display: block;
        }      
        
        .modifyCloth{
            display: flex;
            order: 2;
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
            display: block;
        }

        .modifySet{
            order: 3;
            width: 80%;
            margin-left: auto;
            margin-right: auto;
            margin-top: 5%;
            display: block;
        }
    }




</style>