/**
 * @description 应用入口文件
 * 该文件主要负责创建 Vue 应用实例，引入全局样式、根组件以及路由插件，
 * 并将应用挂载到 DOM 节点上。
 */

// 从 Vue 库中导入创建应用实例的方法
import { createApp } from 'vue'

// 导入全局样式文件
import './style.css'

// 导入应用的根组件
import App from './App.vue'

// 导入路由配置实例
import router from './router/index.js';

// 在控制台打印路由实例，通常用于开发调试，检查路由配置是否正确
console.log(router)

// 原始的单行挂载方式（已被注释）：直接链式调用创建并挂载
// createApp(App).mount('#app')

// 调用 createApp 方法，传入根组件 App，创建一个 Vue 应用实例
const vm = createApp(App);

// 在应用实例上安装路由插件，使整个应用支持路由功能
vm.use(router);

// 在控制台打印 Vue 应用实例，通常用于开发调试，检查实例属性及插件是否挂载成功
console.log(vm)

// 将 Vue 应用实例挂载到 index.html 中 id 为 'app' 的 DOM 节点上
vm.mount('#app');