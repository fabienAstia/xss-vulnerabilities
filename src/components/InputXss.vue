<script setup>
    import {ref} from 'vue'
    const payload = ref('')
    const injectHtml = ref('')
</script>

<template>

    <div class="m-3">
        <h4>Window</h4>
        <div class="window p-3" >
                {{ payload}} 
                <p v-html="injectHtml"></p>
        </div>
    </div>

    <div class="m-3">
        <label for="">GoodVue- Try a payload: </label>
        <input type="text"  class="form-control" v-model="payload">
        <button class="btn btn-primary mt-3">submit </button>
    </div>
   
    <div class="m-3" >
        <label for="">BadVue- Try a payload:</label>
        <textarea name="" id="" class="form-control" v-model="injectHtml"></textarea>
        <button class="btn btn-primary mt-3">submit </button>
    </div>

    <div >

    </div>
    
</template>


<!-- SCRIPTS XSS -->
 <!-- 
Fucntionning :
    HTML tags : strong, h1, h2..., input
    <input type="text" value="whatever" style="background-color:red"></input>
 -->

 <!-- Not Fucntionning: -->
<!-- <script>alert('youhou')</script> -->


<style scoped>
    .window{
        height: 180px;
        border: 2px solid black;
    }
</style>

