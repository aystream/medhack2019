<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import MedMain from './components/MedMain'
import Schedule from './components/Schedule'
import CallWindow from './components/CallWindow'
import VueRouter from 'vue-router'

const routes = [
  { path: '/', component: Schedule },
  { path: '/call', component: CallWindow }
]

// 3. Создаём экземпляр маршрутизатора и передаём маршруты в опции `routes`
// Вы можете передавать и дополнительные опции, но пока не будем усложнять.
const router = new VueRouter({
  routes // сокращённая запись для `routes: routes`
})


export default {
  name: 'app',
  router: router,
  components: {
    MedMain
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
