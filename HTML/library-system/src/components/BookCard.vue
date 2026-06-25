<template>
  <div class="book-card">
    <!-- 图书封面 -->
    <img :src="item.cover" alt="图书封面" class="book-img" />
    <!-- 图书信息 -->
    <div class="book-info">
      <h4 class="book-title" @click="$router.push(`/bookdetail/${item.id}`)"><!--路由跳转逻辑-->
  {{ item.title }}
</h4>
      <p class="book-author">作者：{{ item.author }}</p>
      <p class="book-type">分类：{{ item.category }}</p>
      <p class="book-stock">库存：{{ item.stock }}本</p>
    </div>
  </div>
</template>

<script setup>
// 接收父组件传过来的图书对象（组件传值核心）
const props = defineProps(['item'])
</script>

<style scoped>
.book-card {
  width: 190px;
  background: #fff;
  /* 圆角统一页面风格 */
  border-radius: 10px;
  /* 柔和轻微阴影，不厚重 */
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  /* 鼠标悬浮微微上浮，增加交互质感 */
  transition: all 0.3s ease;
  overflow: hidden;
}
/* 悬浮上浮效果 */
.book-card:hover {
  transform: translateY(-6px);
  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.12);
}
/* 封面图圆角贴合卡片 */
.book-img {
  width: 100%;
  height: 220px;
  object-fit: cover;
  display: block;
}
.book-info {
  padding: 12px;
}
.book-title {
  font-size: 16px;
  color: #2c3e50;
  margin: 0 0 6px;
  font-weight: bold;
  white-space: nowrap;
  overflow: hidden;
  text-overflow: ellipsis;
  cursor: pointer;
}
.book-title:hover {
  color: #3474bb;
  text-decoration: underline;
}
.book-author, .book-type, .book-stock {
  font-size: 13px;
  color: #666;
  margin: 4px 0;
}
</style>