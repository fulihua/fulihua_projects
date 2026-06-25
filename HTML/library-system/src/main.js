import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from './router'
// 导入刚刚导出的路由

createApp(App).use(router).mount('#app')
// 挂载路由，整个网站才能跳转页面