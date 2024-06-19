<template>
  <form id="productForm">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>
    <label for="description">Description:</label>
    <textarea id="description" name="description" required></textarea><br><br>
    <button type="submit" @click="addProduct()">Add Product</button>
  </form>
</template>
<script>
import {products} from '../../Services/index.js';
export default {

  data() {
    return {
      product: '',
    }
  },
  methods: {
    addProduct() {
      document.getElementById('productForm').addEventListener('submit', async function(event) {
        event.preventDefault();

        const product = {
          name: document.getElementById('name').value,
          desc: document.getElementById('description').value,
        };
        products.addProduct(product);
      })
    }
  }
}
</script>