<template>
<div> 
  <ModalLogin></ModalLogin>
  <Menu></Menu>
  <router-view/>
</div>

</template>

<script>

import Menu from "./components/Menu.vue"
import ModalLogin from "./components/ModalLogin.vue"
export default {
  components:{
    Menu,
    ModalLogin
  },
  data(){
    return{
     
    }
  },
  methods:{
    
  }
}
</script>


<style>
:root {
  /*TODO CAMBIAR TEMATICA DE COLORES EN AJUSTES?*/
  --mainStyle: 'Delius', cursive;
  --secondStyle: 'Comic Neue', cursive;
  --titulos: 'Satisfy', cursive;
  --colorMoradoPrincipal: rgb(105, 77, 104);
  --colorMoradoSecundario: rgb(122, 67, 121);
  --colorMoradoTerciario: rgb(92, 30, 91); /*AL 0.5 DE OPACITY PARA FONDO SUAVE TAMBIEN*/
  --colorMoradoSuave: rgba(211, 191, 211, 0.384);
}
#app {
  font-family: var(--mainStyle);
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}



#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

@media screen and (max-width:768px) { 
    Menu{
      margin-top: 2000px;
    }
}


</style>
