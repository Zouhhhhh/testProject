import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

console.log("当前环境", process.env.NODE_ENV);
console.log("当前后端地址", process.env.VUE_APP_URL);

new Vue({
  render: h => h(App),
}).$mount('#app')
