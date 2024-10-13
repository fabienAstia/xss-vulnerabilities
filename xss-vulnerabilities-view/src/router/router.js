import { createRouter, createWebHistory } from "vue-router";
import Instruction from '../components/Instruction.vue'
import Response from "../components/Response.vue";
import Forum from "../components/Forum.vue"

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "response",
      component: Response
    },
    {
      path: "/instruction",
      name: "instruction",
      component: Instruction
    },
    {
      path: "/response/:instructionId",
      name: "responseById",
      component: Response,
    },
    {
      path:'/forum',
      name: "forum",
      component: Forum,
    }
  ],
});

export default router;
