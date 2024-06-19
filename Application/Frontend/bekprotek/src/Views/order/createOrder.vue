<template>
  <body class="orderContainer">
  <div class="container">
    <h1>Place an Order</h1>
    <form id="orderForm">
      <label for="product">Product:</label>
      <select id="product" name="product" required>
        <!-- Add your product options here -->
        <option value="Product1">Product1</option>
        <option value="Product2">Product2</option>
        <option value="Product3">Product3</option>
      </select>

      <label for="description">Description:</label>
      <textarea id="description" name="description" required></textarea>

      <label for="customization">Customization:</label>
      <input type="text" id="customization" name="customization" required>

      <button type="submit">Place Order</button>
    </form>
  </div>
  </body>
</template>
<script>
import "@/Layouts/orderProduct.css"
export default {

}
</script>