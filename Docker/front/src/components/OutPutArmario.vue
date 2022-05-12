<template>
    <div>
        {{this.nombre}} 
        <h3 v-if="this.valor>115" class="red">HOT +</h3>
        <h3 v-else-if="this.valor>=100" class="red">HOT</h3>
        <h3 v-else-if="this.valor>=90" class="red">HOT -</h3>
        <h3 v-else-if="this.valor>=80" class="verde">PERFECT +</h3>
        <h3 v-else-if="this.valor>=70" class="verde">PERFECT</h3>
        <h3 v-else-if="this.valor>=62" class="verde">PERFECT -</h3>
        <h3 v-else-if="this.valor>=50" class="blue">COLD -</h3>
        <h3 v-else-if="this.valor>=40" class="blue">COLD</h3>
        <h3 v-else-if="this.valor<40" class="blue">COLD +</h3>
        <h3 v-else>Loading...</h3>
    </div>
</template>
<script>
export default {
    props:[
        "nombre", "valor"
    ],
}
</script>
<style>
    
</style>