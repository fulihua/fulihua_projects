<template>
  <div class="home">
    <div class="page-title">
      <h2>校园图书馆首页</h2>
      <p>书香润心灵，阅读伴成长</p>
    </div>

    <Carousel />

    <div class="nav-wrap">
      <span class="nav-word" @click="$router.push('/intro')">图书馆介绍</span>
      <span class="nav-word" @click="$router.push('/booklist')">全部图书</span>
    </div>

    <div class="hot-section">
      <h3>热门推荐图书</h3>
      <!-- 外层居中容器 -->
      <div class="center-box">
        <!-- 可视窗口，只显示4本书宽度 -->
        <div class="hot-view">
          <!-- 滑动容器：带动画位移 -->
          <div class="scroll-wrap" :style="{ transform: `translateX(-${offset}px)` }">
            <BookCard
              v-for="item in literaryBooks"
              :key="item.id"
              :item="item"
              class="book-item"
            />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, onMounted, onUnmounted } from 'vue'
import Carousel from '../components/Carousel.vue'
import BookCard from '../components/BookCard.vue'
import allBooks from '../data/books.json'

// 筛选文学类全部书籍
const literaryBooks = allBooks.filter(item => item.category === '文学')
// 单本书宽度+间距
const itemWidth = 210
// 偏移像素
const offset = ref(0)
let timer = null

// 最大滚动距离：总长度 - 可视4本宽度
const maxScroll = (literaryBooks.length - 4) * itemWidth

// 每次向右滑动一本
const slideOne = () => {
  if (offset.value >= maxScroll) {
    offset.value = 0
  } else {
    offset.value += itemWidth
  }
}

// 页面加载开启自动轮播，4秒滑一本
onMounted(() => {
  timer = setInterval(slideOne, 4000)
})

// 销毁清除定时器
onUnmounted(() => {
  clearInterval(timer)
})
</script>

<style scoped>
/* 整体页面柔和底色，告别纯白单调 */
.home {
  padding: 0 20px;
  padding-bottom: 50px;
  background-color: #f8f9fa;
  min-height: 100vh;
}

/* 顶部标题美化 */
.page-title {
  text-align: center;
  padding: 30px 0;
  border-bottom: 1px solid #dde0e4;
  margin-bottom: 25px;
}
.page-title h2 {
  color: #2c3e50;
  font-size: 28px;
  margin: 0 0 8px;
}
.page-title p {
  color: #7f8c8d;
  font-size: 15px;
  margin: 0;
  letter-spacing: 1px;
}

/* 导航栏美化 */
.nav-wrap {
  display: flex;
  justify-content: space-between;
  margin: 25px 0 35px;
  padding: 0 10px;
}
.nav-word {
  font-size: 18px;
  font-weight: bold;
  color: #2c3e50;
  cursor: pointer;
  padding: 6px 12px;
  border-radius: 6px;
  transition: all 0.3s ease;
}
.nav-word:hover {
  background-color: #e8edf2;
  color: #3474bb;
}

/* 热门图书板块容器，加底色圆角 */
.hot-section {
  background: #ffffff;
  padding: 30px 0;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0, 0, 0, 0.05);
}
.hot-section h3 {
  text-align: center;
  color: #2c3e50;
  font-size: 22px;
  margin-top: 0;
  position: relative;
}
/* 标题装饰短线 */
.hot-section h3::after {
  content: '';
  display: block;
  width: 60px;
  height: 3px;
  background: #3474bb;
  margin: 10px auto 25px;
  border-radius: 2px;
}

/* 居中容器，让轮播框整体页面居中 */
.center-box {
  display: flex;
  justify-content: center;
}
/* 可视区域，固定宽度，超出隐藏，同时放下4本书 */
.hot-view {
  width: calc(210px * 4);
  overflow: hidden;
}
/* 滑动容器，横向排列+平滑过渡动画 */
.scroll-wrap {
  display: flex;
  gap: 20px;
  transition: transform 0.6s ease-in-out;
}
/* 单本书卡片宽度 */
.book-item {
  flex-shrink: 0;
  width: 190px;
}
</style>