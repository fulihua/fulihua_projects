<template>
  <div class="book-card">
    <!-- 图书封面 -->
    <img :src="item.cover" alt="图书封面" class="book-img" />
    <!-- 图书信息 -->
    <div class="book-info">
      <h4 class="book-title" @click="$router.push(`/bookdetail/${item.id}`)"><!--路由跳转逻辑-->
        <!--这里把当前点击这本书的 id 拼到网址上，跳转页面
比如点 id=2 的书，浏览器地址变成：/bookdetail/2
3. 跳转到 BookDetail.vue 详情页后，再从网址里把这个数字取出来，这就是要查找的目标 id。-->
<!--${} 的作用：把变量的值塞进字符串里拼接
/bookdetail/ 是固定文字路径；
shturl. 是当前图书的编号变量；
${shturl.} 会自动把 id 数字替换到字符串中间，完成拼接。
-->
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
  /*黑色、透明度仅 8%，淡淡的浅阴影，不会厚重刺眼。作用：让卡片从白色背景上浮出来，区分层次。*/
  /* 鼠标悬浮微微上浮，增加交互质感 */
  transition: all 0.3s ease;
  /*all：卡片所有样式变化（位置、阴影等）都做动画；
  0.3s：动画时长 0.3 秒；
  ease：先慢、中间快、结尾慢，流畅不卡顿。
  没有这行，悬浮效果会瞬间变化，加上后会平滑渐变。*/
  overflow: hidden;
  /*overflow: hidden
隐藏超出卡片范围的内容。
比如图片边角、文字如果超出圆角区域，会被裁剪，保证圆角不会失效。
*/
}
/* 悬浮上浮效果 */
.book-card:hover {
  transform: translateY(-6px);
  /*translateY 垂直方向位移，-6px 代表向上移动 6 像素。鼠标放卡片上，卡片轻轻往上飘，立体交互感。*/
  box-shadow: 0 6px 16px rgba(0, 0, 0, 0.12);/*悬浮时阴影加深、变大：
模糊范围变大，透明度提升到 12%，阴影更明显，强化 “上浮” 的立体效果。*/
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