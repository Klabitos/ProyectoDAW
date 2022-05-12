<template lang="">
    <div>
        <div class="d-flex justify-content-between align-items-center">
            <div class=" d-flex col-10 align-items-center justify-content-between">
                <h2 class="ms-3 mt-2 colorMoradoTexto">Welcome, {{this.username}}</h2>
                <h5 class="nombreOutfit titulo">{{this.outfit.nombre}}</h5>
            </div> 
            <div class="outfit col-2">  
                <div class="d-flex justify-content-around me-3">
                    <button :class="this.comprobarEstilosSet(1)" @click="this.numSetActivo=1; this.activarOutfit(1);">1&nbsp;</button>
                    <button :class="this.comprobarEstilosSet(2)" @click="this.numSetActivo=2; this.activarOutfit(2);">2</button>
                    <button :class="this.comprobarEstilosSet(3)" @click="this.numSetActivo=3; this.activarOutfit(3);">3</button>
                    <button :class="this.comprobarEstilosSet(4)" @click="this.numSetActivo=4; this.activarOutfit(4);">4</button>
                </div>
            </div>


        </div>
        <div class="carouselOwn" @click="this.actualizarValoresTermicos()" v-if="this.datosListos">
            <div class="d-flex justify-content-between">
                <div class="iconoPre align-self-center ms-3" @click="preCabeza(); this.desActivarOutfits();"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                <div>
                    <img :src='require(`../img/carousel/${this.obtenerURLCabeza()}`)' class="" alt="..." width="100" height="100">
                </div>
                <div class="iconoNext align-self-center me-3" @click="nextCabeza(); this.desActivarOutfits();"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
                    
            </div>
            <div class="d-flex justify-content-between" >
                <div class="iconoPre align-self-center ms-3" @click="preTronco(); this.desActivarOutfits();"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                <div>
                    <img :src='require(`../img/carousel/${this.obtenerURLTronco()}`)' class="imagenRopa" alt="..." width="200" height="180">
                </div>
                <div class="iconoNext align-self-center me-3" @click="nextTronco(); this.desActivarOutfits();"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
            </div>
            <div class="d-flex justify-content-between">
                <div class="iconoPre align-self-center ms-3"  @click="prePiernas(); this.desActivarOutfits();"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                <div>
                    <img :src='require(`../img/carousel/${this.obtenerURLPiernas()}`)' class="" alt="..." width="300" height="250" >
                </div>
                <div class="iconoNext align-self-center me-3" @click="nextPiernas(); this.desActivarOutfits();"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
            </div>
            <div class="d-flex justify-content-between" >
                <div class="iconoPre align-self-center ms-3 mb-3" @click="prePies(); this.desActivarOutfits();"><br><i class="bi bi-arrow-left-circle"></i><br>&nbsp;</div>
                <div >
                    <img :src='require(`../img/carousel/${this.obtenerURLPies()}`)' class="" alt="..." width="100" height="80" >
                </div>
                <div class="iconoNext align-self-center me-3 mb-3" @click="nextPies(); this.desActivarOutfits();"> <br> <i class="bi bi-arrow-right-circle"> <br> &nbsp;</i></div>
            </div>
        </div>

        <div class="d-flex justify-content-around outputRopa">
            <div class="cuadradoOutput">
                <i class="bi bi-person-fill"></i>
                <OutPutArmario nombre="Standard" :valor="this.valorStandard"></OutPutArmario> 
            </div>
            <div class="cuadradoOutput">
                <i class="bi bi-brightness-high"></i>
                <OutPutArmario nombre="Sport" :valor="this.valorDeporte"></OutPutArmario>  
            </div>
            <div class="cuadradoOutput">
                <i class="bi bi-bicycle"></i>
                <OutPutArmario nombre="Scooter" :valor="this.valorScooter"></OutPutArmario>   
            </div>
        </div>
    </div>
</template>
<script>
import obtenerSetsUsuarioActivo from "../mixin/obtenerSetsUsuarioActivo";
import axios from "axios";
import OutPutArmario from "../components/OutPutArmario.vue";
import funcionalidadRopas from "../mixin/funcionalidadRopas"
export default {
    name:"ArmarioCarrousel",
    props:[
        "username", "idCiudad"
    ],
    mixins:[
        obtenerSetsUsuarioActivo, funcionalidadRopas
    ],
    components:{
        OutPutArmario
    },
    data(){
        return{
            outfit:{
                nombre:" "
            },
            numSetActivo:0,
            nickname:"",

            valorStandard:0,
            valorScooter:0,
            valorDeporte:0,
            infoMeteo:{},
            idCiudadUsado:3111108, 
   
        }       
    },
    updated(){
        if(this.idCiudad!=this.idCiudadUsado){
            this.idCiudadUsado=this.idCiudad
            this.obtenerDatosMeteorologicos();
            setTimeout(() => {
            this.actualizarValoresTermicos();
            }, 500);
        }
    },
    async created(){
        this.nickname=this.$route.params.username 
        await this.obtenerIdUsuarioActivoConUsername(this.nickname);
        await this.obtenerDatosMeteorologicos();
        await this.obtenerDatosGenericosRopa();
        await this.filtrarRopa();
        setTimeout(() => {
            this.actualizarValoresTermicos();
        }, 500);
    },
    methods:{
        activarOutfit(numSet){
            if(this.existeSet(numSet)){
                let setRequerido = this.todosSetUsuario.filter(set => set.numConjunto==numSet);
                this.outfit.nombre=setRequerido[0].nombreConjunto;
                this.ropaActivaID.cabeza=setRequerido[0].idPrendaCabeza;
                this.ropaActivaID.tronco=setRequerido[0].idPrendaTorso;
                this.ropaActivaID.piernas=setRequerido[0].idPrendaPierna;
                this.ropaActivaID.pies=setRequerido[0].idPrendaPies;
                this.actualizarValoresTermicos();
            }else{
                this.outfit.nombre="";
            }
        },
        desActivarOutfits(){
            this.outfit.nombre="";
            this.numSetActivo=0;
        },
        existeSet(numSet){
            if(this.todosSetUsuario.filter(set => set.numConjunto==numSet).length>0){
                return true;
            }else{
                return false;
            }
        },
        async obtenerDatosMeteorologicos(){
            await axios.get(` https://api.openweathermap.org/data/2.5/weather?id=${this.idCiudad}&appid=2244d4e3a6d3390022cd31a6cd02bd7c&units=metric`)
            .then(response => this.infoMeteo = response.data)
            .catch(response => console.log("Error al recuperar datos"+ response.status)); 

        },
        async actualizarValoresTermicos(){
            if(this.infoMeteo.main==null){
                setTimeout(() => {
                    this.actualizarValoresTermicos();
                }, 200);
            }else{
                this.valorStandard = (await this.calcularValorTermicoStandard()).toFixed(2);
                this.valorScooter = (await this.calcularValorTermicoScooter()).toFixed(2);
                this.valorDeporte = (await this.calcularValorTermicoDeporte()).toFixed(2);
            }
        },
        async calcularValorTermicoStandard(){
            return (((await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.cabeza)*2)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.tronco)*4)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.piernas)*2)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.pies)))
            /9)*this.infoMeteo.main.feels_like;
        },
        async calcularValorTermicoDeporte(){
            return (((await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.cabeza)*2)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.tronco)*4)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.piernas)*2)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.pies)))
            /9)*this.infoMeteo.main.feels_like*1.2;
        },
        async calcularValorTermicoScooter(){
            return (((await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.cabeza)*2)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.tronco)*4)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.piernas)*2)
            +(await this.obtenerValorTermicoPrendaEspecificaUsuario(this.ropaActivaID.pies)))
            /9)*this.infoMeteo.main.feels_like*0.7;
        },


        async obtenerValorTermicoPrendaEspecificaUsuario(idPrenda){
            let valor;
            await axios.get(`/meteOwn/v1/ropausuario?nickname=${this.username}&idRopa=${idPrenda}`)
            .then(response => valor= response.data[0].valorCalorRopa)
            .catch(response => console.log("Error al recuperar datos"+ response.status));
            return  valor;
        },
        

        comprobarEstilosSet(numSet){
            if(this.existeSet(numSet)){
                if(this.numSetActivo==numSet){
                    return "elegido"
                }else{
                    return "noElegido"
                }
            }else{
                return "noDisponible"
            }
        },
    }
}
</script>
<style scoped>

    .nombreOutfit{
        text-align: center;
        font-size: 2rem;
        width: 500px;
    }

    .noDisponible{
        background-color: var(--colorMoradoSuave);
        border-color:rgb(75, 74, 74);
        border-radius: 25px;
        margin: 1%;
        padding: 12%;
        color: black;
        cursor: unset;
    }

    .elegido{
        background-color: purple;
        border-color:var(--colorMoradoTerciario);
        border-radius: 25px;
        margin: 1%;
        padding: 12%;
        color: white;
    }

    .noElegido{
        background-color: var(--colorMoradoSecundario);
        border-color:var(--colorMoradoTerciario);
        border-radius: 25px;
        margin: 1%;
        padding: 10%;
        color: white;
    }

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

    .outputRopa{
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        border: 2px solid var(--colorMoradoTerciario);
        background-color: var(--colorMoradoSuave);
        margin-top: 25px;
        padding-top: 10px;
        padding-bottom: 10px;
        height: 100px;
    }

    .cuadradoOutput{
        color: white;
        background-color: var(--colorMoradoSecundario);
        border-color:var(--colorMoradoTerciario);
        width: 20%;
        border-radius: 5px;
    }


    @media screen and (max: width 600px) {
        .nombreOutfit{
            font-size: 1rem;
            width: 100px;
        }
    }
</style>