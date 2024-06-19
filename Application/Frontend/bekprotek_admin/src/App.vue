<template>
  <navBar v-if="!$route.meta.hideNavbar" />
  <RouterView/>
</template>

<script>
import { RouterView } from 'vue-router'
import navBar from "./components/Navbar/navBar.vue";
export default {
  components: {
    RouterView,
    navBar
  }
}
</script>