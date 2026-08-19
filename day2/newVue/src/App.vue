<template>
  <div>
    <form>
      <table>
        <tbody>
          <tr>
            <td>用户名：</td>
            <td>
              <input type="text" v-model="username" placeholder="请输入用户名">
            </td>
          </tr>
          <tr>
            <td>密&nbsp;码：</td>
            <td>
              <input type="password" v-model="password" placeholder="请输入密码">
            </td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
const username = ref('')
const password = ref('')
</script>

<style lang="css" scoped>
</style>