<script setup>
    import {ref} from 'vue'
    const bypass = ref('')
</script>

<template>
    <h1>How to illustrate XSS vulnerabilities</h1>
    <div class="m-3">
        <h4>Window</h4>
        <div class="window p-3">
                {{ bypass}}
        </div>
    </div>

    <div class="m-3">
        <label for="">Try a bypass: </label>
        <input type="text"  class="form-control" v-model="bypass">
        <button class="btn btn-primary mt-3">submit </button>
    </div>
   
    <div class="m-3">
        <textarea name="" id="" class="form-control"></textarea>
        <button class="btn btn-primary mt-3">submit </button>
    </div>
    
   
</template>

<style scoped>
    .window{
        height: 200px;
        border: 2px solid black;
    }
</style>

