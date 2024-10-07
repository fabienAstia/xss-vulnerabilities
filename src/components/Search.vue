<script setup>
import { ref, onMounted } from 'vue';

const pictureDuck = ref('');
const countries = ref([]);

// Fonction pour récupérer une image de canard
async function fetchDucks() {
  try {
    const response = await fetch('https://random-d.uk/api/v2/randomimg');
    pictureDuck.value = response.url;
  } catch (error) {
    console.error('Erreur lors de la récupération de l\'image :', error);
  }
}

// Fonction pour récupérer les pays
async function fetchCountries() {
  try {
    const response = await fetch('https://restcountries.com/v3.1/all?fields=name');
    const data = await response.json();
    countries.value = data.map(country => country.name.common); // Stocker les pays
  } catch (error) {
    console.error('Erreur lors de la récupération des pays :', error);
  }
}
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

    <button class="mt-3" type="button" @click="fetchCountries">Afficher les merveilleux pays du monde</button>

    <ul v-if="countries.length > 0" id="target">
      <li v-for="(country, index) in countries" :key="index">{{ country }}</li>
    </ul>
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