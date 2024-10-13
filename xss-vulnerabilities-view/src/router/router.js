import { createRouter, createWebHistory } from "vue-router";
import Instruction from '../components/Instruction.vue'
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
      path: "/instruction",
      name: "instruction",
      component: Instruction
    },
    {
      path: "/response/:instructionId",
      name: "response",
      component: Response,
    }
  ],
});

export default router;
