<template>
  <div class="carousel-wrap" @mouseenter="stopAutoPlay" @mouseleave="startAutoPlay">
    <!-- 轮播图片区域 -->
    <div class="img-box">
      <img :src="currentImg" alt="图书馆轮播图书" />
    </div>

    <!-- 美化后的左右切换按钮 -->
    <button class="btn-prev" @click="prev">&lt;</button>
    <button class="btn-next" @click="next">&gt;</button>

    <!-- 底部指示器小点，按你提供的结构改造 -->
    <div class="carousel-dots">
      <button
        v-for="(slide, currentIndex) in imgList"
        :key="currentIndex"
        :class="{ active: index === currentIndex }"
        type="button"
        @click="goTo(currentIndex)"
      ></button>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted, onUnmounted } from 'vue'

// 本地轮播图片导入
import banner1 from '../assets/banner1.png'
import banner2 from '../assets/banner2.png'
import banner3 from '../assets/banner3.jpg'

const imgList = [banner1, banner2, banner3]
// 当前图片下标
const index = ref(0)
// 计算属性自动同步图片
const currentImg = computed(() => imgList[index.value])

let timer = null
const delay = 3000

// 开启自动轮播
const startAutoPlay = () => {
  timer = setInterval(() => next(), delay)
}
// 暂停自动轮播
const stopAutoPlay = () => {
  clearInterval(timer)
}

// 下一张
const next = () => {
  index.value = index.value >= imgList.length - 1 ? 0 : index.value + 1
}
// 上一张
const prev = () => {
  index.value = index.value <= 0 ? imgList.length - 1 : index.value - 1
}
// 点击小点跳转指定图片
const goTo = (currentIndex) => {
  index.value = currentIndex
}

// 生命周期挂载/销毁定时器
onMounted(() => startAutoPlay())
onUnmounted(() => stopAutoPlay())
</script>

<style scoped>
.carousel-wrap {
  width: 100%;
  height: 450px;
  position: relative;
  overflow: hidden;
  background-color: #cad6e2;
  margin-bottom: 20px;
}
.img-box {
  width: 100%;
  height: 100%;
}
img {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
}

/* 美化左右切换按钮，解决生硬问题 */
.btn-prev,
.btn-next {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  width: 44px;
  height: 44px;
  border-radius: 50%;
  border: none;
  /* 磨砂半透效果，弱化突兀感 */
  background: rgba(255, 255, 255, 0.3);
  backdrop-filter: blur(6px);
  font-size: 20px;
  color: #333;
  cursor: pointer;
  z-index: 9;
  /* 平滑过渡动画 */
  transition: all 0.3s ease;
}
.btn-prev:hover,
.btn-next:hover {
  background: rgba(255, 255, 255, 0.8);
  transform: translateY(-50%) scale(1.08);
}
.btn-prev {
  left: 30px;
}
.btn-next {
  right: 30px;
}

/* 底部轮播小点样式 */
.carousel-dots {
  position: absolute;
  bottom: 30px;
  left: 50%;
  transform: translateX(-50%);
  display: flex;
  gap: 14px;
  z-index: 9;
}
.carousel-dots button {
  width: 12px;
  height: 12px;
  border-radius: 50%;
  border: none;
  background: rgba(255, 255, 255, 0.4);
  cursor: pointer;
  transition: all 0.25s ease;
}
/* 当前激活的小点高亮拉长 */
.carousel-dots button.active {
  background: #ffffff;
  width: 30px;
  border-radius: 6px;
}
</style>