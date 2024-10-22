<script setup>
import { ref, onMounted } from 'vue'

const instructions = ref([])
const instruction = ref({ id: '', name: '' })
const deleteAnswer = ref('');
const answers = ref([]);


/**
 * Create new instruction
 */
 const addInstruction = async () => {
    const url = 'http://localhost:8080/xss/instruction';
    const options = {
        method: 'POST',
        headers: { "Content-type": "application/json" },
        body: JSON.stringify(instruction.value)
    }
    try {
        const response = await fetch(url, options);
        if (response.ok) {
            alert('You have created a new instruction.')
            instructions.value.push(instruction)
            instruction.value.name = '';
            await getInformations();
        } else {
            alert('A client or server error has occured');
        }
    } catch (error) {
        alert('An unexpected error has occured!');
        console.error('An unexpected error has occured', error);
    }
}

/**
 * Display instructions and answers
 */
const getInformations = async () => {
    const url = 'http://localhost:8080/xss/instruction';
    const response = await fetch(url);
    const data = await response.json();
    instructions.value = data.instruction || [];
    answers.value = data.answers || [];
}

const deleteOne = async () => {
    const id = deleteAnswer.value;
    if (!id) {
        alert('No ID');
        return;
    }
    const url = `http://localhost:8080/xss/instruction/${id}`;
    const options = {
        method: 'DELETE'
    };
    try {
        const response = await fetch(url, options);
        if (response.ok) {
            alert(`Instruction deleted :${id}`);
            deleteAnswer.value = ''; 
            await getInformations();
        } else {
            alert('A client or server error has occurred');
        }
    } catch (error) {
        console.error('Error:', error);
    }
};

onMounted(() => {
    getInformations();
});

</script>

<template>
    <section>
        <h3 class="m-3">Admin</h3>
        <div class="m-3">
            <label for="name">New Instruction: </label>
            <input type="text" class="form-control" placeholder="My instruction" v-model="instruction.name">
            <button type="submit" class="btn btn-primary mt-3" @click="addInstruction">submit </button>
        </div>
        <router-link to="/response" class="btn btn-warning m-1">Go to response</router-link>
        <router-link to="/forum" class="btn btn-warning m-1">Go to forum</router-link>
    </section>

    <section class="mt-4">
        <h5>Instructions list</h5>
        <table class="table table-hover">
            <thead class="table-dark">
                <tr data-bs-theme="dark">
                    <th class="col-1">ID</th>
                    <th class="col-9">instruction</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(instruction, index) in instructions" :key="instruction.id">
                    <td><span class="col-1">{{ instruction.id }}</span></td>
                    <td><span>{{ instruction.name }}</span></td>
                </tr>
            </tbody>
        </table>
    </section>

    <section class="mt-5">
        <h5>Delete answer</h5>
        <div>
            <input v-model="deleteAnswer" placeholder="ID response to delete" />
            <button class="btn btn-danger m-1" @click="deleteOne">Delete</button>
        </div>

        <table class="table table-hover">
            <thead class="table-dark">
                <tr data-bs-theme="dark">
                    <th class="col-1">ID</th>
                    <th class="col-5">Name</th>
                    <th class="col-6">Response</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(answer, index) in answers" :key="answer.id">
                    <td><span class="col-1">{{ answer.id }}</span></td>
                    <td><span>{{ answer.firstname }}</span></td>
                    <td><span>{{ answer.answer }}</span></td>
                </tr>
            </tbody>
        </table>
    </section>
</template>

<style scoped>
.window {
    height: 180px;
    border: 2px solid black;
}
</style>
