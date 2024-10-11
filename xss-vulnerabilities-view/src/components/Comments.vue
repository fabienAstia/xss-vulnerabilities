<script setup>
import { ref } from 'vue'
</script>

<template>
    <h3 class="m-3">Topic : Simon says</h3>
    <section class="card p-3 m-3">
        <h4>Create alert box !</h4>
    </section>
    <router-link to="/" class="btn btn-warning m-3">New response</router-link>
    <section class="m-3">
        <div class="card p-3 bg-light">
            <p class="fw-light fs-6 m-0">Response from: Name </p>
            <p>Message</p>
        </div>
    </section>
</template>
