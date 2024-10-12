<script setup>
import { ref, onMounted } from 'vue'
import axios from 'axios'

const responses = ref([]);
const instruction = ref('');

const getResponses = async () => {
    try {
        const response = await axios.get('http://localhost:8080/xss');
        responses.value = response.data.response;
        instruction.value = response.data.instruction.name;
    } catch (err) {
        console.error(err);
    }
};

onMounted(() => {
    getResponses();
});

</script>

<template>
    <h3 class="m-3">Topic : Inputs XSS</h3>
    <section class="card p-3 m-3">
        <h4>{{ instruction }}</h4>
    </section>
    <router-link to="/response" class="btn btn-warning m-3">New response</router-link>
    <section class="m-3"  v-for="message in responses" :key="message.id">
        <div class="card p-3 bg-light">
            <p class="fw-light fs-6 m-0 ">Response from: {{ message.firstname }} </p>
            <p>{{ message.response }}</p>
        </div>
    </section>
</template>
