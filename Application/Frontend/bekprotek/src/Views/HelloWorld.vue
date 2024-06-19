<!-- <script setup>
import { ref } from 'vue'
import { mypage } from '@/services/index.js'

export default{ 
        components: {
            AuthLayout,
            msg: String
        },
        data() {
      return {
        user:{
            Email:'',
            Password:''
        }
      }
    Methods:}

</script> -->

<template>
  <h1>Welkom bij de website van Bekprotek</h1>


  <p>
    Check out
    <a href="https://vuejs.org/guide/quick-start.html#local" target="_blank"
      >create-vue</a
    >, the official Vue + Vite starter
  </p>
  <p>
    Install
    <a href="https://github.com/vuejs/language-tools" target="_blank">Volar</a>
    in your IDE for a better DX
  </p>
  <p class="read-the-docs">Click on the Vite and Vue logos to learn more</p>
</template>

<style scoped>
.read-the-docs {
  color: #888;
}
</style>

<script>
//import { ref } from 'vue'
import { RouterView } from 'vue-router'
import { mypage } from '@/Services/index.js'

    export default {
        components: {
          RouterView,
          mypage,
            msg: String
        },
        data() {
          return {
          user:{
            id: ''
          }
      }},
        methods:{
            
          async getByID(id)
            {
                this.loading = true
                this.user  = await mypage.getByID(id)
                this.loading = false
                console.log(this.user)
            },
      }
    }
</script>