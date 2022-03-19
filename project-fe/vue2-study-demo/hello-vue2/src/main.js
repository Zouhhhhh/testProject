import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

console.log("当前环境", process.env.NODE_ENV);
console.log("当前后端地址", process.env.VUE_APP_URL);


//创建Vue实例
const x = new Vue({
  //el: '#app',   //el用于指定当前Vue实例为哪个容器服务，值通常为css选择器字符串
  // render: h => h(App)
});


//create project时自动生成的
new Vue({
  render: h => h(App),
}).$mount('#app')


//可以写成
// new Vue({
//   el: '#app',
//   render: h => h(App),
// })
