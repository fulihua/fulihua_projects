/**
 * @module router
 * @description Vue Router 配置文件。
 * 该文件负责定义应用的路由规则，并创建和导出路由实例，
 * 供主应用入口文件（main.js/main.ts）挂载使用。
 */

// 从 vue-router 包中导入创建路由器和 HTML5 历史模式的相关方法
import { createRouter, createWebHistory } from "vue-router";

// 导入路由对应的视图组件
import HomeView from "../views/HomeView.vue";
import AboutView from "../views/AboutView.vue";

/**
 * @constant {Array} routes
 * @description 路由规则数组。
 * 定义了 URL 路径与视图组件之间的映射关系。
 */
const routes = [
  {
    // 匹配根路径 '/'
    path: "/",
    // 路由名称，用于编程式导航 (如: router.push({ name: 'home' }))
    name: "home",
    // 路径匹配时渲染的组件
    component: HomeView,
  },
  {
    // 匹配 '/about' 路径
    path: "/about",
    // 路由名称
    name: "about",
    // 路径匹配时渲染的组件
    component: AboutView,
  } 
]

/**
 * @constant {Router} router
 * @description 创建 Vue Router 实例。
 * 配置了路由的历史模式以及路由规则。
 */
const router = createRouter(
{
  // 使用 HTML5 的 History 模式，通过 process.env.BASE_URL 设置基础路径
  history: createWebHistory(),
  
  // ES6 简写语法，等同于 routes: routes，将上面定义的路由规则数组注入路由实例
//   routes: routes,
  routes
})

// 将配置好的路由实例导出，以便在 Vue 应用中使用
export default router