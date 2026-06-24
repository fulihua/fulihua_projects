<template>
  <section class="home-hero">
    <div class="hero-text">
      <p class="eyebrow">{{ slides[currentIndex].eyebrow }}</p><!--{{ 变量 }} 是 Vue 的插值表达式，作用：把 JS 数据渲染到页面 HTML 里。
slides 是你定义的轮播数组（存放多张轮播内容）；
currentIndex 是当前展示第几张轮播的下标数字（0、1、2…）。-->
<!--其中这些数据来自index.json文件，与index.json里的数据对应-->
<!--注意：核心原理：数组自带天然顺序下标，不用手动标记序号
你这个 slides 是数组，数组本身自带从 0 开始的数字索引，不需要额外写字段标记第几张。-->
<!--但是注意我们说{{ 变量 }}把 JS 数据渲染到页面 HTML 里（JS 特指：当前 Vue 文件里 <script setup> 标签中的 JavaScript 代码）但是代码里面根本没有slids相关数据，那是因为我们并没有用JS里面的数据而是
    用了defineProps来接收父组件传过来的数据！defineProps = 子组件用来接收父组件传过来的数据。 -->
      <h1>{{ slides[currentIndex].title }}</h1>
      <p class="hero-desc">{{ slides[currentIndex].text }}</p>
      <RouterLink class="primary-button" to="/about">了解品牌</RouterLink>
    </div>
    <div class="carousel" >
      <img v-bind:src="slides[currentIndex].image" v-bind:alt="slides[currentIndex].title" /><!--: 就是 v-bind: 的简写，两者功能 100% 一模一样：-->
      <div class="carousel-controls">
        <button class="carousel-arrow" type="button" @click="prevSlide">上一张</button>
        <div class="carousel-dots">
            <!--<button></button>
            <button></button>
            <button></button>-->
          <button v-for="(slide, index) in slides" :key="slide.title" :class="{ active: currentIndex === index }" type="button" @click="goTo(index)"></button>
          <!--v-for 是 Vue 循环指令，作用：根据数组自动批量生成重复标签，不用手动一个个写按钮。
          语法拆解
            v-for="(slide, index) in slides"
            slides：你父组件传过来的轮播数组（3 条数据）
            slide：循环时，当前遍历到的单条轮播对象
            index：当前这条数据在数组里的下标（0、1、2）
            因为你的 slides 数组有 3 条数据，这段代码会自动生成 3 个圆点按钮，等价于注释里手动写 3 个<button>。

                :key="slide.title"
                循环必须加 key，给每个按钮唯一标识，Vue 用来区分不同元素，避免渲染错乱；这里用轮播标题当唯一标识。
                :class="{ active: currentIndex === index }"
                :class 是 v-bind 简写，动态控制样式类：
                规则：如果当前轮播下标 currentIndex 和按钮的下标 index 相等，就给按钮加上 active 类；
                效果：正在看的那张轮播对应的圆点变黑，其他圆点灰色。
                type="button"
                标准按钮类型，防止误触提交表单。
                @click="goTo(index)"
                @click 是v-on:click简写，点击触发切换函数：
                点击第 2 个圆点，就把index=1传给goTo，currentIndex变成 1，页面切换到第二张轮播。
                其中，goTo 是你自己写的切换轮播的函数，在 HeroCarousel.vue 的 script setup 里定义了。
          -->
        </div>
        <button class="carousel-arrow" type="button" @click="nextSlide">下一张</button>
      </div>
    </div>
  </section>
</template>

<script setup>
import { ref } from 'vue'

defineProps({
  slides: { type: Array, required: true },
})

const currentIndex = ref(0)

function nextSlide() {
  currentIndex.value = (currentIndex.value + 1) % 3
}

function prevSlide() {
  currentIndex.value = (currentIndex.value - 1 + 3) % 3
}

function goTo(index) {
  currentIndex.value = index
}
</script>

<style scoped>
.home-hero {
  display: flex;
  align-items: center;
  gap: 44px;
  width: 1180px;
  min-height: 680px;
  margin: 0 auto;
  padding: 112px 0 24px;
}

.hero-text {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 500px;
}

.carousel {
  width: 636px;
}

.home-hero h1 {
  height: 68px;
  margin: 0;
  color: #111827;
  font-size: 56px;
  line-height: 1;
}

.home-hero p {
  color: #4b5563;
  font-size: 18px;
  line-height: 1.8;
}

.hero-desc {
  height: 70px;
  margin: 0;
}

.button-row {
  margin-top: 0;
}

.hero-text > .primary-button {
  margin-top: 0;
}

.carousel img {
  width: 100%;
  height: 420px;
  object-fit: cover;
  border-radius: 8px;
  box-shadow: 0 18px 45px #d8c8b6;
}

.carousel-controls {
  display: flex;
  align-items: center;
  justify-content: space-between;
  margin-top: 14px;
}

.carousel-arrow {
  border: 0;
  border-radius: 20px;
  padding: 8px 16px;
  color: #111827;
  background: #fff;
}

.carousel-arrow:hover {
  background: #ebe4d8;
}

.carousel-dots {
  display: flex;
  justify-content: center;
  gap: 8px;
}

.carousel-dots button {
  width: 10px;
  height: 10px;
  border: 0;
  border-radius: 10px;
  background: #d1d5db;
}

.carousel-dots button.active {
  background: #111827;
}
</style>


