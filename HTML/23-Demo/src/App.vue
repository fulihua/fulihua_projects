<template>
  <div class="app-shell">
    <!-- 只保留顶部头部导航（老师页面唯一顶部栏） -->

    <AppHeader/>

    <!-- 路由渲染容器，首页/关于页面在这里展示 -->
    <main class="app-main">
      <Router-view /><!--实现页面切换功能，是一个存放切换页面的容器-->
    </main >

    <!-- 底部页脚 -->
    <AppFooter/>
  </div>
</template>

<script setup>
import AppHeader from './components/AppHeader.vue';
import AppFooter from './components/AppFooter.vue';
</script>

<style lang="css" scoped>
.app-shell{
  display: flex; 
  flex-direction: column;
  min-height: 100vh;
}
.app-main{
  border: 2px solid green;
  display: flex;
  flex: 1;
  flex-direction: column;
}
</style>