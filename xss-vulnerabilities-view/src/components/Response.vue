<script setup>
import { ref, onMounted } from 'vue'

const instruction = ref([])
const userResponse = ref({ firstname: '', response: '' })

/**
 * Display last instruction
 */
const getInstruction = async () => {
    try {
        const response = await fetch('http://localhost:8080/xss/response');
        if (response.ok) {
            const data = await response.json();
            instruction.value.id = data.id;
            instruction.value.name = data.name;
        } else {
            console.error('Error while retrieving data: ', response.statusText);
        }
    } catch (err) {
        console.error('Error during fetch:', err);
    }
};

/**
 * Send response
 */
const sendResponse = async () => {
    const options = {
        method: 'POST',
        headers: { 'Content-type': "application/json" },
        body: JSON.stringify(userResponse.value)
    }
    try {
        const response = await fetch('http://localhost:8080/xss/response', options);
        if (response.ok) {
            alert('Response sent');
            userResponse.value = { firstname: '', response: '' };
        } else {
            throw new Error('A client or server error has occurred!');
        }
    } catch (err) {
        alert('An unexpected error has occurred!');
        console.error(err);
    }
};

onMounted(() => {
    getInstruction();
});

</script>
<template>
    <section>
        <div class="m-3">
            <h4 class="p-1 bg-light">{{ instruction.id }} - {{ instruction.name }}</h4>
            <div class="window p-3">
                <p v-html="userResponse.response"></p>
            </div>
        </div>
        <div class="m-3">
            <h4>Message</h4>
            <div class="mb-2">
                <label for="firstname">Firstname :</label>
                <input type="text" id="firstname" class="form-control" placeholder="Your name"
                    v-model="userResponse.firstname">
            </div>

            <div>
                <label for="response-edit">Response :</label>
                <textarea id="response-edit" class="form-control" placeholder="My message"
                    v-model="userResponse.response"></textarea>
                <button type="submitItem" class="btn btn-primary mt-3" @click="sendResponse">submit </button>
            </div>
        </div>
    </section>
    <router-link to="/forum" class="btn btn-warning m-3"> Display Answers</router-link>
</template>

<style scoped>
.window {
    height: 180px;
    border: 2px solid black;
}
</style>
