<template lang="">
    <div>
        <div class="alert alert-danger" role="alert" v-if="this.fail">
            Wrong login. Try again.
        </div>
        <div>
            <h1 class="display-1 titulo">MeteOwn</h1>
        </div>

        <div class="carouselPropio">
            <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
                </div>
                
                <div class="carousel-inner">
                    <div class="carousel-item active" data-bs-interval="5000">
                        <img src="../img/sol.jpg" class="d-block w-100" alt="..." width="500" height="500" >
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Is it too sunny?</h5>
                            <p>Check your outfit with our virtual wardrove.</p>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="5000">
                        <img src="../img/nieve.jpg" class="d-block w-100" alt="..." width="500" height="500">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Be ready</h5>
                            <p>Prepare yourself for adverse climatological situations.</p>
                        </div>
                    </div>
                    <div class="carousel-item" data-bs-interval="5000">
                        <img src="../img/lluvia.jpg" class="d-block w-100" alt="..." width="500" height="500">
                        <div class="carousel-caption d-none d-md-block">
                            <h5>Your virtual wardrove</h5>
                            <p>With different clothes allowing different outfits.</p>
                        </div>
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
        <div class="d-flex justify-content-around textZone">
            <div class="preBotones">
                <h2 class="colorMoradoTexto">
                    What is MeteOwn?
                </h2>
                <p class="textoInformativo text-center">
                    MeteOwn is an online application that allows you to use its virtual wardrove so our complex algorithm is able to give you feedback about your hypothetical confort wearing any kind of outfit with the current weather information
                </p>
            </div>
            <div class="botones">   
                <button class="btn hoverMeScale text-white btnHover" data-bs-toggle="modal" data-bs-target="#modalLogin">Login</button><br>       
                <button class="btn btn-secondary mt-3 btnHover">
                    <router-link class="nav-link text-white " to="/SignUp" >Sign Up</router-link>
                </button><br>
                <button class="btn btn-secondary mt-3 btnHover">
                    <router-link class="nav-link text-white" to="/MeteOwn/FAQ" >FAQ</router-link>
                </button><br>
            </div>
            <div class="postBotones">
                <h2 class="colorMoradoTexto">
                    How does it work?
                </h2>
                <p class="textoInformativo text-center">
                    MeteOwn  uses a complex API callew OpenWeatherMap. It provides us with precise information about the weather and the forecast for the upcoming days. It also provides us with precipitation layers that are used in our interactive map.
                </p>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name:"Home",
    data(){
        return{
            fail:false,
        }
    },
    created(){
        let url =new URL(window.location.href)
        if(url.searchParams.get('error')=='true'){
            this.fail=true;
        }else{
            this.fail=false;
        }
    },

}
</script>
<style>

/* COLORES */
    .blue{
        color: blue;
    }
    .red{
        color: red;
    }
    .verde{
        color: lightgreen;
    }
    .colorMoradoTexto{
        color: var(--colorMoradoTerciario);
    }

/* TEXTOS */
    .titulo{
        font-family: var(--titulos);
        font-size: 4rem;
        color: var(--colorMoradoTerciario);
    }
    .textZone div{
        width: 33%;
    }


</style>
<style scoped>
    .textZone{
        width: 90%;
        margin-right: auto;
        margin-left: auto;
    }

    @media screen and (max-width:768px) { 

        .textZone{
            display: flex;
            flex-direction: row;
            flex-wrap: wrap;
        }

        .preBotones{
            order: 2;
            width: 40%;
            margin-right: 5%;
            margin-top: 5%;
        }
        .postBotones{
            order: 2;
            width: 40%;
            margin-left: 5%;
            margin-top: 5%;
        }
        .botones{
            width: 100%;
            order: 1;
        }
    }

    @media screen and (max-width: 550px){
        .preBotones{
            order: 2;
            width: 90%;
            margin-top: 5%;
            margin-left: auto;
            margin-right: auto;
        }
        .postBotones{
            order: 3;
            width: 90%;
            margin-top: 5%;
            margin-left: auto;
            margin-right: auto;
        }
        .botones{
            width: 100%;
            order: 1;
        }
    }





    /* CAROUSEL */
    .carouselPropio{
        box-shadow: 0 10px 16px 0 rgba(0,0,0,0.2),0 6px 20px 0 rgba(0,0,0,0.19) !important;
        width: 90%;
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 40px;
    }

    .btn{
        width: 70%;
        margin-left: auto;
        margin-right: auto;
        background-color: var(--colorMoradoSecundario);
        border-color:var(--colorMoradoTerciario);
        color: white;
    }
    .textoInformativo{
        text-align: justify;
    }
    .btnHover:hover{
    background-color: var( --colorMoradoTerciario);
    transition: all 0.5 ease;
            
    }

   
</style>