<template>
  <section class="about-section">
    <p class="eyebrow">ABOUT</p>
    <h2>{{ site.about.title }}</h2>
    <p class="about-text">{{ site.about.text }}</p>

    <div class="about-list">
      <div v-for="item in site.about.features" :key="item.title" class="about-item">
        <strong>{{ item.title }}</strong>
        <span>{{ item.text }}</span>
      </div>
    </div>
  </section>
</template>

<script setup>
import site from '../data/site.json'
</script>

<style scoped>
.about-section {
  width: 1180px;
  margin: 0 auto;
  padding: 70px 0;
}

.about-section h2 {
  margin: 0;
  color: #111827;
  font-size: 40px;
}

.about-text {
  color: #6b7280;
  font-size: 18px;
  line-height: 1.8;
}

.about-list {
  display: flex;
  gap: 18px;
  margin-top: 30px;
}

.about-item {
  flex: 1;
  border: 1px solid #eee1cf;
  border-radius: 8px;
  padding: 24px;
  background: #fff;
  box-shadow: 0 12px 32px #e5d8c8;
}

.about-item strong,
.about-item span {
  display: block;
}

.about-item span {
  margin-top: 10px;
  color: #6b7280;
  line-height: 1.7;
}
</style>
