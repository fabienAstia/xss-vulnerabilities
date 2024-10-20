<script setup>
import { ref, onMounted } from 'vue'

const instruction = ref({ id: '', name: '' })
const answers = ref([]);

const getForum = async () => {
  try {
    const response = await fetch('http://localhost:8080/xss/forum');
    if (response.ok) {
      const data = await response.json();
      instruction.value.id = data.instruction.id;
      instruction.value.name = data.instruction.name;
      answers.value = data.answers || [];
    } else {
      console.error('Error while retrieving data:', response.statusText);
    }
  } catch (err) {
    console.error('Error during fetch:', err);
  }
};

onMounted(() => {
  getForum();
});

</script>

<template>

  <section class="container">
    <div class="card p-1 bg-warning-subtle">
      <p class="m-3 fw-medium">{{ instruction.id }}-{{ instruction.name }}</p>
    </div>

    <router-link to="/response" class="btn btn-warning m-3">New response</router-link>
    
    <div class="m-3" v-for="answer in answers" :key="answer.id">
      <div class="card p-3 bg-light">
        <p class="fw-light fs-6 m-0">Response from: <strong><span v-html="answer.firstname"></span></strong></p>
        <p v-html="answer.answer"></p>
      </div>
    </div>
  </section>

</template>


<style scoped>
.container {
  position: relative;
  height: 100vh;
}
</style>
