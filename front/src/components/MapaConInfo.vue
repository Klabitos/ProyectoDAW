<template lang="">
    <div class="contenedorMapa">
        <div id="map"></div>
    </div>
</template>
<script>
import "leaflet/dist/leaflet.css";
import L from "leaflet";
export default {
    name:"MapaConInfo",
    props:[
        "coordenadas"
    ],
    data(){
        return{
            map:null,
            coordenadasLatLon:[40.965, -5.66305]
        }
    },
    created(){

    },
    updated(){
        if(this.coordenadasLatLon!=this.coordenadas){
            this.coordenadasLatLon=this.coordenadas;
            this.map.setView([ this.coordenadasLatLon[0], this.coordenadasLatLon[1]], 8);
        }
    },


    mounted() { 
    this.map = L.map("map", {zoomAnimation: false, scrollWheelZoom: false}).setView([ this.coordenadasLatLon[0], this.coordenadasLatLon[1]], 8);

    L.tileLayer("http://{s}.tile.osm.org/{z}/{x}/{y}.png", {
      attribution:
        '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
    }).addTo(this.map);

    var Precipitation = 

        L.tileLayer('http://tile.openweathermap.org/map/precipitation_new/{z}/{x}/{y}.png?appid=d22d9a6a3ff2aa523d5917bbccc89211', {
            maxZoom: 18,
        }),
    /* //CAPA DE TEMPERATURA
        Temp = L.tileLayer('http://tile.openweathermap.org/map/temp_new/{z}/{x}/{y}.png?appid=d22d9a6a3ff2aa523d5917bbccc89211', {
            maxZoom: 18,
            id: 'temp'
        }),
    */
        Wind = L.tileLayer('http://tile.openweathermap.org/map/wind_new/{z}/{x}/{y}.png?appid=d22d9a6a3ff2aa523d5917bbccc89211', {
            maxZoom: 18,
        }),
    /* //CAPA DE PRESIÓN
        Pressure = L.tileLayer('http://tile.openweathermap.org/map/pressure_new/{z}/{x}/{y}.png?appid=d22d9a6a3ff2aa523d5917bbccc89211', {
            maxZoom: 18,
        }),
    */

        Clouds = L.tileLayer('http://tile.openweathermap.org/map/clouds_new/{z}/{x}/{y}.png?appid=d22d9a6a3ff2aa523d5917bbccc89211', {
            maxZoom: 18,
        });

        Precipitation.addTo(this.map);

        var overlays = {"Precipitation": Precipitation, /* "Temperature": Temp,  */"Clouds": Clouds, /*"Pressure": Pressure,*/ "Wind": Wind};
        L.control.layers(overlays, null, {collapsed:true}).addTo(this.map);

    
  },
  beforeDestroy() {
    if (this.map) {
      this.map.remove();
    }
  }
}
</script>
<style scoped>
    .contenedorMapa{
        margin-top: 30px;
        margin-bottom: 30px;
        border: 3px solid var(--colorMoradoTerciario);
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
    }
   #map { height: 400px; }
</style>