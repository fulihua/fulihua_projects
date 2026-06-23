<template>
  <div class="app-shell">
    <AppHeader/>
    <main class="app-main">
      <HomeView/>
    </main>
    <AppFooter/>
  </div>
</template>

<script setup>
// 同步修改组件导入名称，和文件、模板统一
import AppHeader from './components/AppHeader.vue';
import AppFooter from './components/AppFooter.vue';
import HomeView from './views/HomeView.vue';
</script>

<style lang="css" scoped>
.app-shell{
  display: flex; /* 开启弹性布局，容器拥有flex特性 */
  flex-direction: column;/* 将主轴改为垂直上下，实现子元素上中下排列 */
  min-height: 100vh;/* 容器高度铺满整个浏览器屏幕 */
}
.app-main{
  border: 2px solid green;
  display: flex;
  flex: 1;/*竖向占据了整个空间*/
  flex-direction: column;

}
</style>