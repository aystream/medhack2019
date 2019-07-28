import Vue from 'vue'
import App from './App.vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)
Vue.filter('firstLetter', function (value) {
  if (!value) return ''
  value = value.toString()
  return value.charAt(0).toUpperCase()
})

Vue.filter('secondLetter', function (value) {
  if (!value) return ''
  value = value.toString()
  return value.charAt(1).toUpperCase()
})


Vue.config.productionTip = false

new Vue({
  render: h => h(App),
}).$mount('#app')
