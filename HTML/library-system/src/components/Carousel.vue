<template>
  <div class="carousel-wrap" @mouseenter="stopAutoPlay" @mouseleave="startAutoPlay">
    <!--@mouseenter：鼠标移入这个 div 区域时触发
触发后执行 stopAutoPlay() 函数，内部 clearInterval(timer) 清除定时器
@mouseleave：鼠标移出这个 div 区域时触发
触发后执行 startAutoPlay() 函数，内部 setInterval(next,4000) 重新开启 4 秒一次的自动轮播
效果：鼠标拿开，图片恢复自动滚动-->
    <!-- 轮播图片区域 -->
    <div class="img-box">
      <img :src="currentImg" alt="图书馆轮播图书" />
      <!--currentImg 是前面写的计算属性，会跟着 index 下标自动切换为当前轮播图的图片资源-->
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
//核心：computed 计算属性
//计算属性会自动监听内部依赖的数据（这里依赖 index.value）：
//只要 index 一变，这段函数会立刻重新执行；
//imgList[index.value] 根据当下下标取出对应图片，赋值给 currentImg；
//模板里直接使用 currentImg 就能展示当前轮播图，不用反复写 imgList[index.value]，代码更简洁。

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

//index.value：当前图片下标，从 0 开始
//imgList.length：一共有多少张图片
//imgList.length - 1：最后一张图片的下标

// 下一张
const next = () => {
  index.value = index.value >= imgList.length - 1 ? 0 : index.value + 1
}

//条件：index.value >= imgList.length - 1
//成立（当前是最后一张）：index.value = 0 → 切回第一张
//不成立（中间图片）：index.value = index.value + 1 → 下标 + 1，显示下一张

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