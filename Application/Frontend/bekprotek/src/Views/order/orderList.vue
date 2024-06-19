<template>
    <table style="margin:auto">
      <tr>
        <th>Order Number</th>
        <th>Product</th>
        <th>Description</th>
        <th>Customization</th>
        <th>Accepted</th>
      </tr>
      <tr
          v-for="product in products"
          :key="product.id">
        <td>1111</td>
        <td>{{product.name}}</td>
        <td>{{product.desc}}</td>
        <td>Logo</td>
        <td>No</td>
      </tr>
    </table>

</template>

<style scoped>
.datatable-header {
  display: flex;
  justify-content: space-between;
}

.datatable-state {
  text-align: center;
  font-size: 0.9rem;
  padding: 0.5em;
}
</style>

<script>

/*import Loading from '@/components/Loading.vue'*/
/*import Preview from '@/components/global/Preview.vue'*/
import "@/Layouts/orderTable.css"
import DataTable from 'primevue/datatable'
import Column from 'primevue/column'
import Button from 'primevue/button'
import InputText from 'primevue/inputtext'
import Paginator from 'primevue/paginator'
import ProgressSpinner from 'primevue/progressspinner'
import {products} from "../../Services/index.js";

export default {
  components: {
/*    Preview,*/
    DataTable,
    Column,
    Button,
    InputText,
    Paginator,
    ProgressSpinner,
/*    Loading*/
  },

  data() {
    return {
      loading: false,
      identifier: 0,
      selected: null,
      openPreview: false,
      products: [],
    }
  },

  methods: {
    async onPageChange(e) {
      this.page = e.page
      await this.getAll(this.page)
    },

    onRowClick(e) {
      this.identifier = e.data.id
      this.openPreview = true
    },
    async getByID(id)
    {
      this.loading = true
      this.products  = await products.getByID(id)
      this.loading = false
      console.log(this.products)
    },
    async getAll() {
      this.loading = true
      this.products = await products.getProducts()
      this.loading = false
      console.log(this.products)
    },
    onCloseTrigger() {
      this.openPreview = false
    },

  },

  async mounted() {
    await this.getAll()
  }
}
</script>