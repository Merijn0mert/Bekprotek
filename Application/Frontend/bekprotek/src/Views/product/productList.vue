<template>
  <div class="productCardPos">
    <div
        class="product-item"
        v-for="product in products"
        :key="product.id"
    >
      <div class="productCard">
        <div class="cardproduct">
          <div class="cardImg">
            <h3 class="cardTitle">{{ product.name }}</h3>
            <button class="cardButton" @click="getProductDetail(product.id)">View Details</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.read-the-docs {
  color: gray;
}
</style>

<script>
import Menubar from 'primevue/menubar'
import "@/components/Card/card.css"
import navBar from '@/components/Navbar/navBar.vue'
import {products} from '@/Services/index.js'
import card from '@/components/Card/card.vue'

export default {
  components: {
    Menubar,
    navBar,
    card
  },
  data() {
    return {
      products: [],
      loading: false
    };
  },
  methods: {
    async getProducts() {
      this.loading = true;
      this.products = await products.getProducts();
      this.loading = false;
    },
    getProductDetail(productId) {
      console.log(`Navigating to product ID: ${productId}`); // Add this line to debug
      this.$router.push({ path: `/product/${productId}` });
    }
  },
  mounted() {
    this.getProducts();
  }
}
</script>
