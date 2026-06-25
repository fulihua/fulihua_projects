<template>
  <div class="detail-page">
    <!-- 顶部统一导航 -->
    <div class="nav-wrap">
      <span class="nav-word" @click="$router.push('/')">首页</span>
      <span class="nav-word" @click="$router.push('/intro')">图书馆介绍</span>
      <span class="nav-word" @click="$router.push('/booklist')">全部图书</span>
    </div>

    <div class="detail-card" v-if="bookInfo">
      <div class="img-box">
        <img :src="bookInfo.cover" alt="图书封面" />
      </div>
      <div class="info-box">
        <h2>{{ bookInfo.title }}</h2>
        <p><strong>作者：</strong>{{ bookInfo.author }}</p>
        <p><strong>图书分类：</strong>{{ bookInfo.category }}</p>
        <p><strong>馆藏库存：</strong>{{ bookInfo.stock }}本</p>
        <div class="desc">
          <h4>图书简介</h4>
          <p>本书为校园图书馆热门馆藏书籍，适合在校师生日常阅读与学习。文学类书籍陶冶情操，专业类书籍辅助课程学习，欢迎前往图书馆借阅。</p>
        </div>
        <button class="back-btn" @click="$router.back()">返回上一页</button>
      </div>
    </div>
    <div v-else class="loading">加载图书信息中...</div>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRoute } from 'vue-router'
import allBooks from '../data/books.json'

const route = useRoute()
const bookInfo = ref(null)

// 根据路由id匹配对应图书
const bookId = Number(route.params.id)
bookInfo.value = allBooks.find(item => item.id === bookId)
</script>

<style scoped>
.detail-page {
  padding: 0 20px;
  padding-bottom: 60px;
  background-color: #f8f9fa;
  min-height: 100vh;
}
.nav-wrap {
  display: flex;
  justify-content: center;
  gap: 40px;
  margin: 20px 0 30px;
}
.nav-word {
  font-size: 18px;
  font-weight: bold;
  color: #2c3e50;
  cursor: pointer;
  padding: 6px 14px;
  border-radius: 6px;
  transition: all 0.3s ease;
}
.nav-word:hover {
  background-color: #e8edf2;
  color: #3474bb;
}
.detail-card {
  max-width: 900px;
  margin: 0 auto;
  background: #fff;
  border-radius: 12px;
  box-shadow: 0 2px 10px rgba(0,0,0,0.05);
  padding: 30px;
  display: flex;
  gap: 35px;
}
.img-box img {
  width: 260px;
  border-radius: 10px;
}
.info-box h2 {
  color: #2c3e50;
  margin-top: 0;
}
.info-box p {
  font-size: 16px;
  line-height: 1.8;
  color: #444;
}
.desc {
  margin: 20px 0;
  padding-top:15px;
  border-top: 1px solid #eee;
}
.back-btn {
  margin-top:15px;
  padding: 8px 22px;
  border: none;
  background: #3474bb;
  color: white;
  border-radius: 6px;
  cursor: pointer;
}
.back-btn:hover {
  background: #28609b;
}
.loading {
  text-align: center;
  font-size:18px;
  color:#666;
  margin-top:80px;
}
</style>