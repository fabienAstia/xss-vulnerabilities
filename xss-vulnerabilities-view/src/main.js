import '../node_modules/bootstrap/dist/css/bootstrap.css'
import { createApp } from 'vue'
import App from './App.vue'
import router from './router/router.js';

const app = createApp(App)

app.use(router)
app.mount('#app')
