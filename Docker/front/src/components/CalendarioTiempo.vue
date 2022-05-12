<template lang="">
    <div class="calendario mt-3">
        <span>This is the weather forecast for: </span>
        <select name="" id="" class="mt-2 mb-2" v-model="this.idCiudad">
            <optgroup value="" v-for="(comunidad, index) in this.datosCiudadesID.comunidades" :key="index" :label="comunidad.nombre">
                <option :value="ciudad.id" v-for="(ciudad, index2) in comunidad.provincias" :key="index2">{{ciudad.name}}</option>
            </optgroup>
        </select>
        <div class="pt-1 pb-1 align-items-center filaCalendario" v-for="(dia, index) in this.informacionMeteorologiaEstaSemana" :key="index">
            <h1>{{this.obtenerTemperaturaDia(index)}}</h1>
            <img :src="this.obtenerIconoMeteorologico(index)" alt="">
            <h2>{{this.obtenerDiaSemana(index)}}</h2>
            <h5>{{this.ponerEnMayusculasPrimeraLetra(this.informacionMeteorologiaEstaSemana[index].weather[0].description)}}</h5> 
        </div>
    </div>
</template>
<script>
import axios from "axios";
export default {
    name:"CalendarioTiempo",
    props:[
        "username"
    ],
    emits:[
        "coordenadas", "idCiudad"
    ],
    data(){
        return{
            datosCiudadesID:{},
            informacionMeteorologiaEstaSemana:{},
            idCiudad:"", 
            idCiudadMostrado:"",
            informacioUsuario:{}
        }
    },
    methods:{

        obtenerDiaSemana(diasAdicionalesDespuesDeHoy){
            var options = {  weekday: 'long', year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit', second: '2-digit', hour12: false };
            const today = new Date()
            const diaBuscado = new Date(today)
            diaBuscado.setDate(diaBuscado.getDate() + diasAdicionalesDespuesDeHoy)
            return this.ponerEnMayusculasPrimeraLetra(diaBuscado.toLocaleTimeString('en', options).split(",")[0]); // 'sp-en' para esp
        },
        ponerEnMayusculasPrimeraLetra(palabra){
            palabra=palabra.charAt(0).toUpperCase() + palabra.slice(1);
            return palabra;
        },
        async obtenerTemperaturaSemana(){
            await axios.get(`http://api.openweathermap.org/data/2.5/forecast/daily?id=${this.idCiudad}&cnt=4&appid=2244d4e3a6d3390022cd31a6cd02bd7c&units=metric`) //lang es para esp
            .then(response => this.informacionMeteorologiaEstaSemana = response.data.list)
            .catch(response => console.log("Error al recuperar datos"+ response.status)); 
        },
        obtenerIconoMeteorologico(index){
            let idIcono = this.informacionMeteorologiaEstaSemana[index].weather[0].icon;
            return `http://openweathermap.org/img/wn/${idIcono}@2x.png`;
        },
        obtenerTemperaturaDia(index){
            let temperatura = this.informacionMeteorologiaEstaSemana[index].temp.day;
            return temperatura.toFixed(1)+' ºC'
        },
        obtenerInformacionUsuario(){
            axios.get(`/meteOwn/v1/usuarios/nickname/${this.username}`)
            .then(response => this.informacioUsuario=response.data)
            .catch(response => console.log("Error al recuperar datos"+ response.status)); 
           
        },
        mostrarMapaCiudadAdecuada(){
            let coordenadas = [0,0];
            for(let n=0;  n<this.datosCiudadesID.comunidades.length; n++){
                for(let j=0; j<this.datosCiudadesID.comunidades[n].provincias.length; j++){
                    if(this.datosCiudadesID.comunidades[n].provincias[j].id==this.idCiudad){
                        coordenadas[0]=this.datosCiudadesID.comunidades[n].provincias[j].coord.lat;
                        coordenadas[1]=this.datosCiudadesID.comunidades[n].provincias[j].coord.lon;
                    }
                }
            }
            this.$emit("coordenadas", coordenadas);
            this.$emit("idCiudad", this.idCiudad);
        }
    },
    created(){
        this.obtenerInformacionUsuario();
        this.datosCiudadesID= require('../assets/meteOwn.json');
        setTimeout(() => {
             this.idCiudad= this.informacioUsuario.idCiudad;
             this.idCiudadMostrado= this.informacioUsuario.idCiudad;
             this.mostrarMapaCiudadAdecuada();
             this.obtenerTemperaturaSemana();
             
        }, 500);
        
    },
    updated(){
        if(this.idCiudad!=this.idCiudadMostrado){
            this.obtenerTemperaturaSemana();
            this.mostrarMapaCiudadAdecuada();
            this.idCiudadMostrado=this.idCiudad;
        }
    }
}
</script>
<style scoped>
    .calendario div{
        border-radius: 7px;
        border: 1px solid black;
        background-color: var(--colorMoradoSuave);
    }

    .calendario{
        border-radius: 5px;
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        border: 1px solid var(--colorMoradoTerciario);
        padding: 5px;
        color: white;
        background-color: var(--colorMoradoPrincipal)
    }

    .filaCalendario{
        height: 60px;
        display: flex;
        justify-content: space-around;
    }

    .filaCalendario *{
        text-align: center;
        width: 25%;
    }

    .filaCalendario img{
        width: 10%;
    }

    @media screen and (max-width:1068px) { 
        .filaCalendario *{
            width: 200px;
        }

        .filaCalendario{
            justify-content: center;
        }
    }
    
</style>