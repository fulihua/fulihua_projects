<template>
  <router-view />
</template>

<style>
*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

/*
App.vue 是项目根组件，<router-view/> 是路由页面渲染容器，会根据当前网址加载匹配的页面；这里的样式为全局样式，统一重置页面默认边距，规范全站布局。*/
</style>