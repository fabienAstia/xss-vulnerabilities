<script setup>
    import {ref} from 'vue'
    const payload = ref('')
</script>

<template>
    <h1>Try a payload</h1>
    <div class="m-3">
        <h4>Window</h4>
        <div class="window p-3">
                {{ payload}}
        </div>
    </div>

    <div class="m-3">
        <label for="">Try a payload: </label>
        <input type="text"  class="form-control" v-model="payload">
        <button class="btn btn-primary mt-3">submit </button>
    </div>
   
    <div class="m-3">
        <textarea name="" id="" class="form-control"></textarea>
        <button class="btn btn-primary mt-3">submit </button>
    </div>
    
</template>


<!-- script XSS im trying to send -->
 <script></script>


<style scoped>
    .window{
        height: 200px;
        border: 2px solid black;
    }
</style>

