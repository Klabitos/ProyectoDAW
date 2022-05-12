<template>
    <nav class="navbar navbar-expand-lg navbar-light ">
        <div class="container-fluid">
            <div class=" navbar-collapse" id="navbarNav">
                <ul class="navbar-nav align-items-center justify-content-around">
                    <li class="nav-item">
                        <router-link class="nav-link bordeDerecho tituloMenu text-white titulo" to="/"><h2 class="tituloMain">MeteOwn &nbsp;</h2></router-link>
                    </li>
                    <li class="nav-item">
                        <router-link :class="clasesMenu" to="/"><span>Home</span> <br> <i class="bi bi-house"></i> </router-link>                  
                    </li>
                    <li class="nav-item">
                        <a class="nav-link hoverMeScale text-white" href="#" data-bs-toggle="modal" data-bs-target="#modalLogin" v-if="!this.logeado"><span>Modify Clothes</span> <br> <i class="bi bi-archive"></i></a>
                        <router-link :class="clasesMenu" :to="this.rutaModifyClothes()" v-else><span>Modify Clothes</span> <br> <i class="bi bi-archive"></i></router-link>
                        
                    </li>
                    <li class="nav-item bordeDerecho">
                        <router-link :class="clasesMenu" to="/MeteOwn/FAQ"><span>FAQ</span> <br> <i class="bi bi-question-circle"></i> </router-link>
                        
                    </li>
                    <li class="nav-item bordeDerecho">
                        <a class="nav-link hoverMeScale text-white" href="#" data-bs-toggle="modal" data-bs-target="#modalLogin" v-if="!this.logeado"><span>Weather Me</span><br> <i class="bi bi-file-earmark-person"></i></a>
                        <router-link :class="clasesMenu" :to="this.rutaWeatherMe()" v-else><span>Weather Me</span><br> <i class="bi bi-file-earmark-person"></i> </router-link>
                        
                    </li>
                    <li class="nav-item bordeDerecho">
                        <a v-if="!this.logeado" class="nav-link hoverMeScale text-white" href="#" data-bs-toggle="modal" data-bs-target="#modalLogin"><span>Settings</span> <br> <i class="bi bi-gear"></i></a>
                        <router-link :class="clasesMenu" :to="this.rutaSettings()" v-else><span>Settings</span> <br> <i class="bi bi-gear"></i> </router-link>
                    </li>
                    <div class="d-flex botonesZonaDerecha botonNoLogin" v-if="!this.logeado">
                        <li class="nav-item me-3">
                            <button class="btn hoverMeScale text-white btnHover ">
                                <router-link class="nav-link text-white" to="/SignUp" ><span>Sign Up </span><i class="bi bi-signpost"></i></router-link>
                            </button>
                        </li>
                        <li class="nav-item " data-bs-toggle="modal" data-bs-target="#modalLogin">
                            <button class="btn hoverMeScale text-white btnHover "><span>Login </span><i class="bi bi-door-open"></i></button>
                        </li>
                    </div>
                    <div v-else class="d-flex justify-content-around align-items-center botonesZonaDerecha">
                        <button class="hoverMeScale me-3 usernameButton btnHover">
                            <h3 @click="goToPersonalPage()" >
                                {{this.nickname}} 
                            </h3></button>
                        <button type="button" class="btn hoverMeScale text-white ms-4 btnHover logOut" @click="logOut">
                            <span>LogOut</span> <i class="bi bi-door-closed"></i>
                        </button>
                    </div>
                </ul>
            </div>
        </div>
    </nav>
</template>
<script>
import axios from "axios"
export default {
    name:"Menu",
    props:[
        "logged", "username"
    ],
    data(){
        return{
            logeado:false,
            nickname:"",
            clasesMenu: "nav-link hoverMeScale text-white",
            clasesMenuActivo: "nav-link hoverMeScale text-white active"
        }
    },
    methods:{
        async comprobarLoginCorrecto(){ 
            const logged = await axios.get(`/meteOwn/v1/username/active`)
            .then(response => this.logeado = this.comprobarFormatoAdecuadoUsername(response.data))
            .catch(response => this.logeado= false);
        },
        rutaModifyClothes(){
            return `/MeteOwn/ModifyClothes/${this.nickname}`;
        },

        rutaWeatherMe(){
            return `/MeteOwn/WeatherMe/${this.nickname}`;
        },

        rutaSettings(){
            return `/MeteOwn/Settings/${this.nickname}`;
        },
 
        comprobarFormatoAdecuadoUsername(logged) {
            if(logged.length<20){
                this.nickname=logged;
                return true;
            }else{
                return false;
            }
        },
        logOut(){
            location.href="http://localhost:8080/meteOwn/logout";
            this.$router.push({name:"Home"});
            this.logeado=false;
            this.nickname="";
        },
        goToPersonalPage(){
            this.$router.push({name:"WeatherMe", params:{username:`${this.nickname}`}});
        }

        
    },
    created() {
            this.comprobarLoginCorrecto();
        },
}
</script>
<style>
    .bordeDerecho{
        padding-right: 50px;
        border-right: 1px solid grey;
    } 
</style>
<style scoped>


    .navbar-nav{
        width: 80%;
        margin-left: auto;
        margin-right: auto;
    }
    .tituloMenu{
        padding-right: 10px;
    }
    .navbar{
        border-bottom: 1px solid var(--colorMoradoTerciario);
    }
    .hoverMeScale:hover{
        transform: scale(1.1);
        transition: transform .2s;
        
    }
    .active{
        text-decoration: underline;
    }
    
    /*  BOTONES */
    .btnHover:hover{
        background-color: var( --colorMoradoTerciario);
        border: 1px solid white;
        transition: all 0.5 ease;       
    }
    .usernameButton{
        color: var(--colorMoradoTerciario);
        display: inline-block;
        font-weight: 400;
        line-height: 1.5;
        text-align: center;
        text-decoration: none;
        user-select: none;border: 1px solid transparent;
        padding: .375rem .75rem;
        font-size: 1rem;
        border-radius: .25rem;
        transition: color .15s ease-in-out,background-color .15s ease-in-out,border-color .15s ease-in-out,box-shadow .15s ease-in-out;
        background-color: whitesmoke;
        width: 200px;
        height: 50px;
        margin-bottom: 5px;
    }
    .usernameButton:hover{
        color: white;
    }
    .btn{
        width: 200px;
        height: 50px;
        margin-bottom: 5px;
        background-color: var(--colorMoradoSecundario);
        border-color:var(--colorMoradoTerciario);
    }

</style>
<style scoped>
    i{
        color: white;
    }
    nav{
        background-color: var(--colorMoradoPrincipal)
    }

    .navbar-nav {
            display: flex;
            flex-direction: row;
            padding-left: 0;
            margin-bottom: 0;
            list-style: none;
    }



    @media screen and (max-width: 1450px){
        

        .botonesZonaDerecha{
            width: 20%;
            margin-left: 20px;
        }

        .botonNoLogin .btn{
            width: 120px;
        }

        .bordeDerecho{
            padding: 0;
            border: 0;
        }
        .tituloMain {
            margin-top: 0rem;
        }

        .logOut{
            height: 55px;
        }

    }

    @media screen and (max-width: 1100px){
        .botonesZonaDerecha{
            width: 10%;
            margin-left: 100px;
        }
        .botonNoLogin .btn{
            position: relative;
            right: 100px;
        }
    }

    @media screen and (max-width: 915px){
        .botonesZonaDerecha{
            width: 10%;
            margin-left: 100px;
        }
        span{
            display: none;
        }
        .nav-item i{
            position: relative;
            bottom: 10px;
        }

        .botonNoLogin i{
            position: relative;
            bottom: 1px;
        }
        .tituloMain{
            margin-top: 20px;
        }

        .botonNoLogin .btn{
            width: 50px;
        }
    }

    @media screen and (max-width: 714px){

        .tituloMain{
            display: none;
        }
        .nav-item *{
            position: relative;
            right: 50px;
        }

        .botonNoLogin .nav-item *{
            position: relative;
            right: 0px;
        }

        .botonNoLogin{
            position: relative;
            right: 35px;
        }

        .botonesZonaDerecha{
            width: 10%;
            margin-left: 0px;
        }
    }

    @media screen and (max-width: 542px){
        .botonesZonaDerecha{
            width: 10%;
            margin-left: -50px;
        }

        .logOut{
            position: relative;
            right: 35px;
        }

    }


</style>

