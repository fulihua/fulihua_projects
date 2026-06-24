<template>
<div>
   <HeroCarousel :slides="site.slides"></HeroCarousel>
   <!--3. 两者缺一不可，分工完全不一样
① import 负责「引入资源」（准备材料）
只写 import，不写标签：材料准备好了，但不摆出来，页面空白。
② template 标签 负责「使用渲染」（摆放材料）
只写标签，不写 import：Vue 不认识 HeroCarousel 这个名字，直接报错找不到组件。
完整流程拆解
1.import HeroCarousel：加载轮播代码，创建变量备用
2.import site：加载 json 数据，创建变量备用
3.<HeroCarousel :slides="site.slides">：
调用组件 + 把数据传给组件，页面渲染轮播文字图片-->
</div>
</template>
<script setup>
import HeroCarousel from '../components/HeroCarousel.vue';
import site from "../data/site.json"
console.log(site);
</script>
<style lang="css" scoped>
/* div {
    display: flex;
    align-items: center;
    gap: 44px;
    width: 1180px;
    min-height: 747px;
    margin: 0 auto;
    padding: 112px 0 24px;
} */


</style>