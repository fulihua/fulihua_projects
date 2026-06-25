<template>
  <div class="book-list">
    <!-- 绝对定位固定左上角 -->
    <div class="back-text" @click="$router.push('/')">首页</div>

    <h2>全部图书</h2>
    <div class="cate-box">
      <button @click="currentCate = '全部'">全部</button>
      <button @click="currentCate = '计算机'">计算机</button>
      <button @click="currentCate = '文学'">文学</button>
      <button @click="currentCate = '教材'">教材</button>
    </div>

    <div class="book-container">
      <BookCard 
        v-for="item in filterBooks" 
        :key="item.id" 
        :item="item"
      />
    </div>
  </div>
</template>

<script setup>
import { ref, computed } from 'vue'
import BookCard from '../components/BookCard.vue'
import allBooks from '../data/books.json'

const currentCate = ref('全部')//分类筛选响应式变量（核心数据）
const filterBooks = computed(() => {
  if (currentCate.value === '全部') return allBooks
  return allBooks.filter(item => item.category === currentCate.value)
})//计算属性过滤图书

//const currentCate = ref('全部')
//创建响应式变量，页面刚加载默认选中分类为「全部」，点击分类按钮可以修改这个值。
//filterBooks 是计算属性，会实时监听 currentCate 的变化：
//如果当前选中值是「全部」，直接返回完整图书数组 allBooks，页面展示所有书籍；
//如果选中文学 / 计算机 / 教材等其他分类，就用 filter 遍历所有图书，只保留 category 和当前选中分类一致的图书，返回筛选后的新数组。
//模板循环 filterBooks，页面会自动同步展示对应图书。
</script>



<style scoped>
.book-list {
  padding: 0 20px;
  padding-top: 40px; /* 顶部空出位置，防止文字盖住标题 */
  padding-bottom: 30px;
  position: relative; /* 给绝对定位做参照物 */
}
/* 强制左上角固定 */
.back-text {
  position: absolute;
  top: 10px;
  left: 20px;
  font-size: 18px;
  font-weight: bold;
  cursor: pointer;
  color: #222;
}
.back-text:hover {
  color: #959799;
}
.cate-box {
  display: flex;
  gap: 12px;
  margin: 16px 0;
}
.cate-box button {
  padding: 5px 12px;
  border: 1px solid #ccc;
  background: #fff;
  border-radius: 3px;
  cursor: pointer;
}
.cate-box button:hover {
  background: #f0f6ff;
}
.book-container {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
}

/*
1. ref 本质
ref 会把普通数据包裹成一个对象，真正的值存在对象的 .value 属性里。
一句话记牢
脚本 JS 里操作 → 加 .value；HTML 模板里使用 → 不加 .value

结论：ref和路由完全没关系，两个独立工具，各司其职
ref：Vue 核心响应式 API，管理页面内的数据（分类、轮播数字、图书信息），数据变页面自动刷新。
路由 (vue-router)：单独插件，管理页面跳转、浏览器地址栏，控制切换首页 / 介绍 / 列表 / 详情页。

</style>