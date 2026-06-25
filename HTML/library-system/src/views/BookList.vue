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
</style>