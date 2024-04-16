import Vue from 'vue'
import Router from 'vue-router'


import Login from '@/components/Login'
import SignUp from '@/components/SignUp'
import Response from '@/components/Response.vue'
Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/signup',
      name: 'SignUp',
      component: SignUp
    },
    {
      path: '/response',
      name: 'Response',
      component: Response
    }
  ]
})