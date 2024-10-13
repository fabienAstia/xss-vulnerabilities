<script setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router';

import axios from 'axios'

const instructions = ref([])
const instruction = ref({id: '', name: ''})
const router = useRouter();


const addInstruction = async() => {
    const url = 'http://localhost:8080/xss/instruction';
    const options = {
        method: 'POST',
        headers: {"Content-type": "application/json"},
        body: JSON.stringify(instruction.value)
    }
    try{
        const response = await fetch (url, options);
        if(response.ok) {
            alert('You have created a new instruction.')
            instructions.value.push(instruction)
            instruction.value.name= '';
            getInstructions();
        } else {
            alert('A client or server error has occured');
        }
    } catch (error) {
        alert('An unexpected error has occured!');
        console.error('An unexpected error has occured', error);
    }
}

// AFFICHAGE des instructions
onMounted(() => {
  getInstructions();
});
const getInstructions =async() => {
    const url = 'http://localhost:8080/xss/instruction';
    const response = await fetch (url);
    const data = await response.json();
    console.log(data);
    instructions.value = data;
}

//Selectionner une instruction
const selectInstruction = (instruction) => {
    console.log('Sélection de l\'instruction :', instruction);
    router.push({name: 'responseById', params: {instructionId: instruction.id, instructionName: instruction.name}})
}

</script>

<template>
    <section>
        <h3 class="m-3">Admin</h3>
        <div class="m-3">
            <label for="name">New Instruction: </label>
            <input type="text" class="form-control" placeholder="My instruction" v-model="instruction.name">
            <button type="submit" class="btn btn-primary mt-3" @click="addInstruction">submit </button>
        </div>
    </section>
    
    <section>
        <table class="table table-hover">
            <thead class="table-dark">
                <tr data-bs-theme="dark">
                    <th class="col-1">ID</th>
                    <th class="col-9">instruction</th>
                    <th class="col-1">Operations</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(instruction, index) in instructions" :key="instruction.id" >
                    <td><span class="col-1">{{instruction.id}}</span></td>
                    <td><span>{{instruction.name}}</span></td>
                    <td>
                        <div class="d-flex">
                            <button @click="selectInstruction(instruction)" class="btn btn-primary"> Select</button>
                            <button @click="editInstruction(instruction.id)" class="btn"><img src="../../public/bluePencil.svg" width="25px"></button> 
                            <button @click="updateQuestion(instruction.id)" class="btn"><img src="../../public/orangeArrows.svg" width="25px"></button>
                            <button @click="deleteQuestion(instruction.id)" class="btn"><img src="../../public/redTrash.svg" width="25px"></button>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </section>
    <router-link to="/response/:indstructionId/:instructionName" class="btn btn-warning m-3">Go to topic</router-link>
</template>

<style scoped>
.window {
    height: 180px;
    border: 2px solid black;
}
</style>
