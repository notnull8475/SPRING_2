import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path: '/',name: 'home',component: () => import('@/views/Home.vue')},
    {path: '/products',name: 'products',component: () => import('@/views/ProductList.vue')},
    {path: '/login',name: 'login',component: ()=>import('@/views/Login.vue')}
  ]
})

export default router
