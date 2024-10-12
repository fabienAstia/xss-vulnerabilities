<script setup>
import { ref } from 'vue'
import axios from 'axios'

const name = ref('')

const send = async () => {
    const instruction = name.value.trim();
    console.log(instruction);

    try {
        const response = await axios.put('http://localhost:8080/xss/instruction', { name: instruction } );
        if (response.status === 200) {
            alert('Instruction sent');

        } else {
            throw new Error('A client or server error has occurred!');
        }
    } catch (err) {
        alert('An unexpected error has occurred!');
        console.error(err);
    }
};
</script>

<template>
    <section>
        <h3 class="m-3">Topic : Inputs XSS</h3>
        <div class="m-3">
            <label for="name">New Instruction: </label>
            <input type="text" id="name" class="form-control" placeholder="My instruction" v-model="name">
            <button type="submit" class="btn btn-primary mt-3" @click="send">submit </button>

        </div>
    </section>
    <router-link to="/" class="btn btn-warning m-3">Go to topic</router-link>
</template>

<style scoped>
.window {
    height: 180px;
    border: 2px solid black;
}
</style>
