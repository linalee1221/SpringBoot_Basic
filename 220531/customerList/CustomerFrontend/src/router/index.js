import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    alias: '/customers',
    name: 'customers',
    component: () => import('@/components/CustomerList')
  },
  {
    path: '/add',
    name: 'add-customer',
    component: () => import('@/components/AddCustomer')
  },
  {
    path: '/customers/:id',
    name: 'edit-customer',
    component: () => import('@/components/EditCustomer')
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
