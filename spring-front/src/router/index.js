import {createRouter, createWebHistory} from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {path: '/',name: 'home',component: () => import('@/views/Home.vue')},
    {path: '/products',name: 'products',component: () => import('@/views/ProductList.vue')},
    {path: '/login',name: 'login',component: ()=>import('@/views/Login.vue')},
    {path: '/orders', name: 'orders', component: ()=>import('@/views/Orders.vue')},
    {path: '/cart', name: 'cart', component: ()=>import('@/views/Cart.vue')},
    {path: '/product_edit', name: 'product_edit', component: ()=>import('@/views/EditProduct.vue')}
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
