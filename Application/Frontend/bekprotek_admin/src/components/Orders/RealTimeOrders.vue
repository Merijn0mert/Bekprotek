<!-- src/components/RealTimeOrders.vue -->
<template>
  <div>
    <h2>Real-Time Orders</h2>
    <ul>
      <li v-for="order in orders" :key="order.id">
        {{ order.name }}: {{ order.message }}
      </li>
    </ul>
  </div>
</template>

<script>
import {websocket} from "../../Services/index.js";

export default {
  data() {
    return {
      orders: []
    };
  },
  created() {
    websocket.connectWebSocket(this.handleIncomingMessage);
  },
  methods: {
    handleIncomingMessage(data) {
      const order = JSON.parse(data);
      this.orders.push(order);
    }
  }
};
</script>

<style scoped>
/* Add your styles here */
</style>
