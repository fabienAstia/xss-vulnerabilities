import { createRouter, createWebHistory } from "vue-router";
import InputXss from "../components/InputXss.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "input",
      component: InputXss,
    },
    {
      path: "/submit-xss",
      name: "submit",
      component: () => import('../components/SubmitXss.vue')
    },
  ],
});

export default router;