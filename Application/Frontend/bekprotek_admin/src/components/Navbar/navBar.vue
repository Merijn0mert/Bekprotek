<template>
  <header class="navbar-header">
    <nav class="nav-box">
      <div>
          <h3>Bekprotek</h3>
      </div>
      <div>
      <ul class="nav-body">
        <li>
          <router-link to="/">Home</router-link>
        </li>
        <li>
          <router-link to="/products">products</router-link>
        </li>
        <li>
          <router-link to="/orders">orders</router-link>
        </li>
        <li>
          <a class="nav-button">About</a>
        </li>
        <li>
          <router-link to="/signin">Login</router-link>
        </li>
        <li>
          <router-link to="/ordersws">ws_orders</router-link>
        </li>
        <li>
          <router-link to="/addproduct">add_product</router-link>
        </li>
      </ul>
      </div>
    </nav>
  </header>

</template>

<script>
import './navBar.css'
export default{
  name:"navBar"
}

</script>