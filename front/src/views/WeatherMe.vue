<template lang="">
    <div class="contenedorPrincipal ms-1 mt-1 me-2 mb-1">
        <div class="zonaIzquierda me-1">
            <MapaConInfo class="mapaInfo" :coordenadas="this.coordenadasLatLon"></MapaConInfo>
            <CalendarioTiempo class="calendarioTiempo" :username="this.nickname" @coordenadas="coordenadas" @idCiudad="idCiudad"></CalendarioTiempo>
        </div>
        <ArmarioCarrousel class="armarioCarrousel" :username="this.nickname" :idCiudad="idCiudadParaArmario"></ArmarioCarrousel>
    </div>
</template>
<script>
import axios from "axios"
import ArmarioCarrousel from "../components/ArmarioCarrousel.vue";
import CalendarioTiempo from "../components/CalendarioTiempo.vue";
import MapaConInfo from "../components/MapaConInfo.vue";
import comprobarLoginCorrecto from "../mixin/comprobarLoginCorrecto";
export default {
    name:"WeatherMe",
    mixins: [comprobarLoginCorrecto],
    props:[
        "username"
    ],
    components:{
        ArmarioCarrousel,
        CalendarioTiempo,
        MapaConInfo
    },
    data(){
        return{
            nickname:"",
            coordenadasLatLon:[],
            idCiudadParaArmario:3111108
        }
    },
    methods:{
        coordenadas(coordenadas){
            this.coordenadasLatLon=coordenadas;
        },
        idCiudad(idCiudad){
            this.idCiudadParaArmario=idCiudad
        },
    },
    created(){
        this.nickname=this.$route.params.username 
        this.comprobarLoginCorrecto(this.nickname);
    }
}
</script>
<style scoped>
    .contenedorPrincipal{
        display: flex;
        flex-direction: row;
        justify-content: space-around;
    }
    .zonaIzquierda{
        width: 48%;
    }

    .armarioCarrousel{
        width: 48%;
    }


    @media screen and (max-width:900px) {
        .contenedorPrincipal{
            flex-direction: column;
        }

        .zonaIzquierda{
            order: 1;
            width: 100%;
        }

        .armarioCarrousel{
            order: 2;
            width: 100%;
        }
    }
</style>