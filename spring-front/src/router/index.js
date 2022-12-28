import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path: '/',name: 'home',component: () => import('@/views/Home.vue')},
    {path: '/products',name: 'products',component: () => import('@/views/ProductList.vue')},
    {path: '/login',name: 'login',component: ()=>import('@/views/Login.vue')}
  ]
})
// router.beforeEach((to, from, next) => {
//   // redirect to login page if not logged in and trying to access a restricted page
//   const publicPages = ['/login'];
//   const authRequired = !publicPages.includes(to.path);
//   const loggedIn = localStorage.getItem('user');
//
//   if (authRequired && !loggedIn) {
//     return next('/login');
//   }
//
//   next();
// })

export default router
