import Vue from "vue";
import VueRouter from "vue-router";

// router : 메뉴달기 비교) springboot : controller (메뉴달기)
Vue.use(VueRouter);

const routes = [
  // Home
  {
    path: "/home",
    name: "home",
    component: () => import("@/views/HomeView"),
  },
  // Complain
  {
    path: "/complain",
    name: "complain",
    component: () => import("@/views/ComplainView"),
  },
  // Upload
  {
    path: "/upload",
    name: "upload",
    component: () => import("@/components/UploadImage"),
  },
  // /, /tutorials 메뉴를 클릭하면 TutorialsList.vue 로딩
  // TutorialsList.vue : Tutorial 목록 화면
  {
    path: "/",
    alias: "/tutorials",
    name: "tutorials",
    component: () => import("@/components/tutorials/TutorialsList"),
  },
  // Tutorial.vue : Tutorial 상세 화면
  {
    // :id => params
    path: "/tutorials/:id",
    name: "tutorial-details",
    component: () => import("@/components/tutorials/Tutorial"),
  },
  // AddTutorial.vue : Tutorial 에 목록 추가 화면
  {
    path: "/add",
    name: "add",
    component: () => import("@/components/tutorials/AddTutorial"),
  },
  // Customer 메뉴 달기
  {
    path: "/customers",
    name: "customers",
    component: () => import("@/components/customer/CustomerList"),
  },
  {
    path: "/customers/:id",
    name: "edit-customer",
    component: () => import("@/components/customer/EditCustomer"),
  },
  {
    path: "/add-customer",
    name: "add-customer",
    component: () => import("@/components/customer/AddCustomer"),
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
