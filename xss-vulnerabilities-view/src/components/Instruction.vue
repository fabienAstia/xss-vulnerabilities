<script setup>
import { ref } from 'vue'
</script>

<template>
    <section>
        <h3 class="m-3">Topic : Simon says</h3>
        <div class="m-3">
            <label for="instruction">New Instruction: </label>
            <input type="text" id="instruction" class="form-control" placeholder="My instruction">
            <button type="submit" class="btn btn-primary mt-3">submit </button>

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
