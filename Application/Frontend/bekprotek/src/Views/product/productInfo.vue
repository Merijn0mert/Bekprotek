<template>
  <div class="productDetail">
    <div v-if="this.product">
    <h1 class="productTitle">{{ product.name }}</h1>
    <p class="productDesc">This is a description</p>
    <div class="productImage">Image</div>
    </div>
    <div v-else>
      <p>Loading...</p>
    </div>
  </div>

</template>

<script>
import { products } from '@/Services/index.js'
import "@/Layouts/productDetail.css"

export default {
  props: ['id'],
  data() {
    return {
      product: null,
      loading: true
    };
  },
  methods: {
    async fetchProduct() {
      this.loading = true;
      try {
        console.log(`Fetching product with ID: ${this.id}`); // Add this line to debug
        this.product = await products.getByID(this.id);
        console.log("hello" + this.product.name);
      } catch (error) {
        console.error("Error fetching product:", error);
      } finally {
        this.loading = false;
      }
    }
  },
  mounted() {
    this.fetchProduct();
  }
}
</script>

<style scoped>
/* Add your styles here */
</style>
