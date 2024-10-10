<script setup>
import { ref, onMounted } from 'vue';

const pictureDuck = ref('');

async function fetchDucks() {
  try {
    const response = await fetch('https://random-d.uk/api/v2/randomimg');
    pictureDuck.value = response.url;
  } catch (error) {
    console.error('Erreur lors de la récupération de l\'image :', error);
  }
}
//CORS error
</script>

<template>
  <section class="m-3">
    <h4 class="h4">Don't be stuck</h4>
    <form role="search">
      <label for="veryBad">Finding a duck picture may help you</label>
      <input class="form-control" type="search" id="veryBad" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success mt-3" type="button" @click="fetchDucks">Find</button>
    </form>

    <div v-if="pictureDuck" class="mt-3">
      <img :src="pictureDuck" alt="Duck Picture" />
    </div>

  </section>
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