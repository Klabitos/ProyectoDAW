import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import SignUp from '../views/SignUp.vue'
import ModifyClothes from '../views/ModifyClothes.vue'
import WeatherMe from "../views/WeatherMe.vue"
import Settings from "../views/Settings.vue"
import FAQ from "../views/FAQ.vue"
import Users from "../views/Users.vue"

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/SignUp',
    name: 'SignUp',
    component: SignUp
  },
  {
    path: '/MeteOwn/WeatherMe/:username',
    name: 'WeatherMe',
    component: WeatherMe
  },
  {
    path: '/MeteOwn/ModifyClothes/:username',
    name: 'ModifyClothes',
    component: ModifyClothes
  },
  {
    path: '/MeteOwn/Settings/:username',
    name: 'Settings',
    component: Settings
  },
  {
    path: '/MeteOwn/FAQ',
    name: 'FAQ',
    component: FAQ
  },
  {
    path: '/Users/:username',
    name: 'Users',
    component: Users
  },

]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
