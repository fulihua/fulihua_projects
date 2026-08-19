<template>
  <footer class="site-footer">
    <div>
      <strong>LUMI Mall</strong>
      <p>Vue3 电商前端实训项目</p>
    </div>
    <p>组件化 / 路由 / JSON 数据 / Flex 布局</p>
  </footer>
</template>

<script setup>

</script>

<style scoped>
.site-footer {
  display: flex;
  align-items: center;
  justify-content: space-between;
  gap: 24px;
  padding: 22px 8vw;
  color: #6b7280;
  background: #fffaf2;
  border-top: 1px solid #eee1cf;
}

.site-footer strong {
  display: block;
  color: #111827;
  font-size: 18px;
}

.site-footer p {
  margin: 4px 0 0;
}
</style>
