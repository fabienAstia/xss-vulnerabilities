<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';

const instruction = ref({})
const answers = ref([]);
const answer = ref({id: '',firstname: '', answer: ''})

onMounted(() => {
    getForum();
});
const getForum = async () => {
  try {
    const response = await fetch('http://localhost:8080/xss/forum'); 
    if (response.ok) {
      const data = await response.json();
      console.log(data);
      answers.value = data.response;
      instruction.value = data.instruction;

    } else {
      console.error('Erreur lors de la récupération des données:', response.statusText);
    }
  } catch (err) {
    console.error('Erreur lors du fetch:', err);
  }
};



// const getResponses = async () => {
//   try {
//     const response = await fetch('http://localhost:8080/xss/forum'); 
//     if (response.ok) {
//       const data = await response.json();
//       console.log(data);
//       responses.value = data.response;
//       instruction.value = data.instruction.name;
//     } else {
//       console.error('Erreur lors de la récupération des données:', response.statusText);
//     }
//   } catch (err) {
//     console.error('Erreur lors du fetch:', err);
//   }
// };

// const firstname = response.firstname;
// const answer = response.answer;
</script>

<template>
    
    <section class="card p-3 m-3">
      <h3 class="m-3">{{ instruction }}</h3>
    </section>
    
    <section class="m-3" v-for="answer in answers" :key="answer.id">
        <div class="card p-3 bg-light">
            <p class="fw-light fs-6 m-0 ">Response from: {{answer.firstname }} </p>
            <p>{{ answer.answer }}</p>
        </div>
    </section>
    
    <router-link to="/" class="btn btn-warning m-3">New response</router-link>

</template>

