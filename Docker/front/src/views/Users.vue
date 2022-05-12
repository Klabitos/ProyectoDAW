<template>
    <div v-if="this.mostrarInfo" class="contenedorUsers">
        <h1 class="titulo mt-4">Usuarios</h1>
        <table class="table table-striped tablaUsers">
            <thead class="cabecera">
                <tr>
                <th scope="col">Username</th>
                <th scope="col">Name</th>
                <th scope="col">Surname</th>
                <th scope="col">Birth Date</th>
                <th scope="col">Email</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(usuario, index) in this.datosUsuarios" :key="index">
                    <th scope="row">{{usuario.nickname}}</th>
                    <td>{{usuario.name}}</td>
                    <td>{{usuario.surname}}</td>
                    <td>{{usuario.fechaNacimiento}}</td>
                    <td>{{usuario.email}}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>
<script>
import axios from "axios";
import comprobarLoginCorrecto from "../mixin/comprobarLoginCorrecto";
import comprobacionTipoRol from "../mixin/comprobacionTipoRol";
export default {
    mixins:[comprobacionTipoRol, comprobarLoginCorrecto],
    name:"Users",
    data(){
        return{
            nickname:"",
            mostrarInfo:false,
            datosUsuarios:[]
        }
    },
    created(){
        this.nickname=this.$route.params.username 
        this.comprobarLoginCorrecto(this.nickname)
        this.obtenerRol(this.nickname);
        this.obtenerTodosUsuarios();
        setTimeout(() => {
            if(!(this.myRole=="ROLE_ADMIN")){
                this.$router.push({name:"Home"});
            }else{
                this.mostrarInfo=true;
            }
        }, 500);
    },methods:{
        obtenerTodosUsuarios(){
                axios.get(`/meteOwn/v1/usuarios`)
                    .then(response => this.datosUsuarios=response.data)
                    .catch(response => console.log("Error al recuperar datos "+ response.status));
        }
    }
}
</script>
<style>
    .tablaUsers{
        margin-top: 50px;
        border: 3px solid black;
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
    }

    .contenedorUsers{
        width: 80%;
        margin-left: auto;
        margin-right: auto;
    }

    .cabecera{
        background-color: var(--colorMoradoSuave);
    }
</style>