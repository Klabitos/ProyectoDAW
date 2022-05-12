<template lang="" >
    <div >
        <div class="fondoRosa">
            <h1 class="display-1 text-start titulo">FAQ</h1>
            <h3 class="display-6 text-start">Frequently asked question</h3>
            <div class="accordion" id="accordionExample">
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingOne">
                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                        What is MeteOwn?
                    </button>
                    </h2>
                    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <p> MeteOwn is an online application that allows you to use its virtual wardrove so our complex algorithm is able to give you feedback about your hypothetical confort wearing any kind of outfit with the current weather information</p>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingTwo">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                        Is it free?
                    </button>
                    </h2>
                    <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <p>Yes, MeteOwn is free.</p>
                        </div>
                    </div>
                </div>
                
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingThree">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                        What can I do with MeteOwn?
                    </button>
                    </h2>
                    <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <p>With MeteOwn you can know if your current outfit will be enough to withstand teh most severe weather conditions or if your casual outfit will be a right choice in a cold night.</p>
                        </div>
                    </div>
                </div>
                <div class="accordion-item">
                    <h2 class="accordion-header" id="headingState">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseState" aria-expanded="false" aria-controls="collapseState">
                        What is the meaning of Perfect+ and all the similar words?
                    </button>
                    </h2>
                    <div id="collapseState" class="accordion-collapse collapse" aria-labelledby="headingState" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <p class="states">Those are the words MeteOwn uses to identify your confort with the current set of clothes. <br>
                                <ul class="d-flex">
                                    <li class="col-1 m-3"><strong>Hot +</strong> => You are going to be extra hot.</li>
                                    <li class="col-1 m-3"><strong>Hot</strong> => You are going to be hot.</li>
                                    <li class="col-1 m-3"><strong>Hot -</strong> => You are going to be a little bit hot.</li>
                                    <li class="col-1 m-3"><strong>Perfect +</strong> => You are going to be perfect, maybe a little bit hot.</li>
                                    <li class="col-1 m-3"><strong>Perfect</strong> => You are going to be perfect!</li>
                                    <li class="col-1 m-3"><strong>Perfect -</strong> => You are going to be perfect, maybe a little bit cold.</li>
                                    <li class="col-1 m-3"><strong>Cold -</strong> => You are going to be a little bit cold.</li>
                                    <li class="col-1 m-3"><strong>Cold</strong> => You are going to be cold.</li>
                                    <li class="col-1 m-3"><strong>Cold +</strong> => You are going to be extra cold.</li>
                                </ul>
                            </p>
                        </div>
                    </div>
                </div>
                 <div class="accordion-item">
                    <h2 class="accordion-header" id="headingFour">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
                        Where do we get the meteorological information?
                    </button>
                    </h2>
                    <div id="collapseFour" class="accordion-collapse collapse" aria-labelledby="headingFour" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <p>We use a public API with a developer license. Its name is OpenWeatherMap</p>
                        </div>
                    </div>
                </div>
                 <div class="accordion-item">
                    <h2 class="accordion-header" id="headingFive">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
                        Can I upload my own clothes?
                    </button>
                    </h2>
                    <div id="collapseFive" class="accordion-collapse collapse" aria-labelledby="headingFive" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <p>We are working on it.</p>
                        </div>
                    </div>
                </div>
                 <div class="accordion-item">
                    <h2 class="accordion-header" id="headingSix">
                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
                        Who is Pablo Cruz?
                    </button>
                    </h2>
                    <div id="collapseSix" class="accordion-collapse collapse" aria-labelledby="headingSix" data-bs-parent="#accordionExample">
                        <div class="accordion-body">
                            <p>That is me by the way :)</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</template>
<script>
export default {
    
}
</script>
<style scoped>
    h1,h3{
        color: var(--colorMoradoTerciario);
    }

    .fondoRosa{
        padding: 50px;
        height: 95vh;        
    }

    .accordion{
        border: 2px solid var(--colorMoradoTerciario);
    }

    .accordion-button{
        background-color: var(--colorMoradoSuave);
    }

    .accordion-button:not(.collapsed){
        color: white;
        background-color: var(--colorMoradoPrincipal);
        transition: all 1s;
        box-shadow: inset 0 0 0;
    }
</style>