import { createRouter, createWebHistory } from 'vue-router'
// 导入页面
import Home from '../views/Home.vue'
import LibraryIntro from '../views/LibraryIntro.vue'
import BookList from '../views/BookList.vue'
import BookDetail from '../views/BookDetail.vue'

// 1. 路由规则数组
const routes = [
    //routes 是数组，数组里每一个对象 = 一条路由规则，一条规则绑定「访问地址 path」和「页面组件 component」。
    //path：浏览器地址栏输入的访问路径
    //component：路径匹配成功后，自动渲染显示的 vue 页面组件

  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/intro',
    name: 'Intro',
    component: LibraryIntro
  },
  {
    path: '/booklist',
    name: 'BookList',
    component: BookList
  },
  // 动态路由：/:id 接收图书id，跳详情页 stage02核心
  //重点：:id 是什么？
//:id 是路由占位符、动态参数，代表这个位置可以是任意数字。
///bookdetail/1、/bookdetail/2、/bookdetail/10 全都匹配这条路由
//斜杠后面的数字会被保存为参数 id，详情页用 route.params.id 取出这个数字

//只用一条路由规则，就能匹配所有图书的详情页，不用给每一本书单独配置地址，这就是动态路由的优势。
 {
  path: '/bookdetail/:id',
  name: 'BookDetail',
  component: () => import('../views/BookDetail.vue')
}
]

// 2. 创建路由器实例

const router = createRouter({
  history: createWebHistory(),
  routes
})
// 3. 导出路由器
export default router

//routes 数组用来统一配置网站全部路由，每一项通过 path 访问路径绑定对应页面组件。
//前三条是静态路由，地址固定；最后一条 /bookdetail/:id 是动态路由，:id 作为参数占位符，路径末尾可携带任意图书编号。跳转时把图书 id 拼在地址中，进入详情页后读取该 id 匹配图书，实现同一个详情页面展示不同书籍信息。

//1.router（路由器实例）
//就是代码里 const router = createRouter(...) 这个对象，是操控跳转的工具。
//功能：跳转页面 $router.push()、返回上一页 $router.back()。
//2.route（当前路由信息）
//代码里 const route = useRoute()，代表当前浏览器地址的信息。
//功能：拿路径上的参数 route.params.id。
//口语里我们说 “路由配置”，泛指整套页面地址规则（routes 数组）。

//写代码要分清：
//router = 跳转工具
//route = 读取当前页面地址参数
