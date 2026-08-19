<template>
  <header class="site-header">
    <RouterLink class="brand" to="/">{{ site.brand }}</RouterLink><!--生成一个无刷新跳转到首页的导航文字，文字内容从 site.json 配置文件读取，写在页面上显示。site.brand：json 文件中 brand 对应的文字（比如 “品牌”）-->
    <nav> 
      <RouterLink to="/">首页</RouterLink><!--这个'/'对应index.js里面的内容，其中规定了'/'匹配HomeView的内容-->
      <RouterLink to="/about">品牌</RouterLink><!--而在index.js中规定了这个'/about'匹配的是AboutView的内容-->
    </nav>
  </header>
</template>

<script setup>
import site from '../data/site.json'
console.log(site)
</script>

<style scoped>
.site-header {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 24px;
  padding: 16px 8vw;
  background: #fffaf2;
  border-bottom: 1px solid #eee1cf;
}

.brand {
  color: #111827;
  font-size: 22px;
  font-weight: 800;
}

nav {
  display: flex;
  align-items: center;
  gap: 16px;
  color: #6b7280;
}

nav a {
  padding: 6px 0;
}

.router-link-active {
  color: #111827;
  font-weight: 700;
}

.user-chip {
  border-radius: 20px;
  padding: 8px 12px;
  background: #ebe4d8;
}

nav button {
  border: 0;
  color: #6b7280;
  background: transparent;
}
</style>
