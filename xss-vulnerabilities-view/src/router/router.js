import { createRouter, createWebHistory } from "vue-router";
import Response from "../components/Response.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: () => import('../components/Home.vue')
    },
    {
      path: "/response",
      name: "response",
      component: Response,
    },
    {
      path: "/instruction",
      name: "instruction",
      component: () => import('../components/Instruction.vue')
    }
  ],
});

export default router;
