<script setup>
import { ref } from 'vue'
import Search from './Search.vue'
const listItem = ref('')
</script>

<template>
    <h3 class="h3 m-3">List of Cross-Site Scripting Attacks</h3>
    <section>
        <ul class="m-3">
            <li>Reflected XSS Attacks</li>
            <li>DOM-based XSS Attacks!!</li>
            <li id="target"></li>
        </ul>

        <div class="m-3">
            <label for="tooBad">Do you know other XSS Attacks ? Add it to the list</label>
            <input type="text" id="tooBad" class="form-control" v-model="listItem" placeholder="New XSS">
            <button @click="submitItem" class="btn btn-primary mt-3">submit </button>
        </div>
    </section>

    <Search/>

    <router-link to="/" class="btn btn-warning m-3">Back</router-link>

</template>

<!-- SCRIPTS XSS
Fucntionning :
    //No XSS
    HTML tags : strong, h1, h2..., input
    <input type="text" value="whatever" style="color:white; background-color:red"></input> => no XSS

    //XSS Non-persistent (reflected)
    <img src=whatever onerror=alert('youhou')>
    <img src=whatever onerror="window.location='https://github.com/fabienAstia/xss-vulnerabilities/tree/main';">
    <img src=whatever onerror=console.log("Error is sucess")>
    <img src/onerror=prompt('Sorry,&nbsp;an&nbsp;error&nbsp;was&nbsp;occur.&nbsp;Please,&nbsp;enter&nbsp;your&nbsp;Id&nbsp;to&nbsp;continue')>

    //XSS DOM-based
    <a onmouseover="alert('youhou')"\>Click me!</a>
    <a onmouseover="document.body.style='color:blue;'"\>Click me!</a>
    <a onmouseover="document.body.style='transform:rotate(180deg);'"\>Click me!</a>
-->