<template>
    <div class="modal fade" id="modalLogin" tabindex="-1" aria-labelledby="modalLoginLabel" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                <div class="modal-body d-flex justify-content-between">
                    <div class="elementoLogin">
                        <img src="../img/bg-2.jpg" alt="">
                    </div>
                    <div class="elementoLogin zonaFormulario">
                        <div class="d-flex justify-content-between">
                            <h2 class="fw-bold">Sign In</h2>
                            <div class="iconosRedes">
                                <a href="https://github.com/" target="#blank">
                                    <i class="bi bi-github"></i>
                                </a>
                                <a href="https://www.google.com/intl/es/gmail/about/" target="#blank">
                                    <i class="bi bi-google"></i>
                                </a>                            
                            </div>
                        </div>
                        <form action="http://localhost:8080/meteOwn/login" method='POST'>
                            <label for="" class="fw-bold">Nickname</label> <br>
                            <input type="text" placeholder="Nickname" name="username"> <br>
                            <label for="" class="fw-bold">Password</label> <br>
                            <input type="password" placeholder="password" name="password"> <br>
                            <button class="btn mt-3 text-white">Sign In</button>
                            <div class="d-flex justify-content-start align-items-center">
                                <div class="d-flex rememberMe align-items-center">
                                    <input type="checkbox">
                                    <label for="" >Remember Me</label>
                                </div>
                                <div class="forgetMe">
                                    <label href="" @click="this.mensajeForgot='Try 1234'">{{this.mensajeForgot}}</label>
                                </div>
                            </div>
                            <div class="d-flex justify-content-center notMember">
                                <span>Not a member? </span>
                                <a class="signUp"  @click="goSignUp" data-bs-dismiss="modal">&nbsp; Sign Up</a>
                            </div>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
    </div>
</template>
<script>

export default {
    name:"ModalLogin",
    data(){
        return{
            mensajeForgot:"Forgot Password"
        }
    },
    methods:{
        goSignUp(){
            this.$router.push('/SignUp')
        }
    },

}
</script>
<style>

</style>
<style scoped>
    .btn-close{
        position: relative;
        left: 97%;
        top: 10px;
    }
    .btn{
        width: 100%;
        height: 60px;
        background-color: var(--colorMoradoSecundario);
        border-color:var(--colorMoradoTerciario);
    }

    .modal-content{
        width: 1000px;
        position: relative;
        left: -250px;
    }

    i{
        color: var(--colorMoradoSecundario);
        border: 1px solid var(--colorMoradoSecundario);
        border-radius: 25px;
        padding: 5%;
        margin-left: 5px;
        margin-right: 0px;
        position: relative;
        top: 10px;
        transition: 0.5s;
        cursor: pointer;
    }
    i:hover{
        background-color: var(--colorMoradoPrincipal);
         color: var(--colorMoradoTerciario);
    }
    .iconosRedes{
        width: 50%;
        position: relative;
        right: -40px;
    }

    form{
        margin-top: 50px;
        margin-right: 10px;
        margin-left: 5px;
    }

    form input{
        margin-top: 10px;
        width: 100%;
        height: 50px;
    }
    form label{
        width: 100%;
        text-align: left;
        margin-top: 20px;
    }

    .elementoLogin{
        width: 48%;
    }
    .rememberMe{
        margin-top: 20px;
        width: 40%;
    }
    .rememberMe input{ /** checkbox */
        color: var(--colorMoradoTerciario);
        position: relative;
        left: -20px;
        top: 5px;
        width: 50%;
        height: 50%;
    }
    .rememberMe label{ 
        color: var(--colorMoradoTerciario);
        position: relative;
        left: -20px;
    }
    .forgetMe{
        position: relative;
        top: 10px;
        margin-left: 30%;
    }

    .elementoLogin img{
        width: 100%;
        margin-bottom: 20px;
        margin-left: 10px;
        
    }

    .notMember{
        margin-top: 60px;
    }

    .signUp{
        text-decoration: none;
        color: var(--colorMoradoTerciario);
    }
    .signUp:hover{
        cursor: pointer;
    }

    @media screen and (max-width: 1012px){

        .modal-content{
            width: 500px;
            position: relative;
            left: -15px;
        }
        .elementoLogin img{
            display: none;
        }
        .zonaFormulario{
            order: 1;
            width: 100%;
            position: relative;
            right: 70px;
        }

        .btn-close{
            position: relative;
            left: 95%;
        }

    }

     @media screen and (max-width: 500px){

        .modal-content{
            width: 400px;
            position: relative;
            left: 40px;
        }


        .btn-close{
            position: relative;
            left: 92%;
        }

    }

</style>