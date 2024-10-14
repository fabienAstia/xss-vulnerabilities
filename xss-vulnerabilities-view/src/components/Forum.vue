<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';

const instruction = ref({id:'', name:''})
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
      answers.value = data.answers || [];
      instruction.value.name = data.instruction.name;
      instruction.value.id = data.instruction.id;
   
    } else {
      console.error('Erreur lors de la récupération des données:', response.statusText);
    }
  } catch (err) {
    console.error('Erreur lors du fetch:', err);
  }
};
//Selectionner une instruction
// const selectInstruction = (instruction) => {
//     console.log('Sélection de l\'instruction :', instruction);
//     router.push({name: 'responseById', params: {instructionId: instruction.id, instructionName: instruction.name}})
// }
</script>

<template>
    
    <section class="card p-1 m-3 bg-warning">
      <p class="m-3 fw-medium">{{instruction.id}}-{{instruction.name}}</p> 
    </section>
    
    <section class="m-3" v-for="answer in answers" :key="answer.id">
        <div class="card p-3 bg-light">
            <p class="fw-light fs-6 m-0 " >Response from: <strong><span v-html= "answer.firstname"></span></strong></p>
            <p v-html="answer.answer"></p>
        </div>
    </section>
    
    <router-link to="/response/:instructionId/:instructionName" class="btn btn-warning m-3">New response</router-link>

</template>

