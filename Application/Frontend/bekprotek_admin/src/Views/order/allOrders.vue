<template>
  <table style="margin:auto">
    <tr>
      <th>Order Number</th>
      <th>Customization</th>
      <th>accepted</th>
      <th>Customization</th>
      <th>Accept</th>
    </tr>
    <tr class="info"
        v-for="order in orders"
        :key="order.id">
      <td>1111</td>
      <td>{{order.customization}}</td>
      <td>{{order.accepted}}</td>
      <td>Logo</td>
      <td>
        <button class="accept" @click="acceptedOrder(order.id)">Accepteer</button>
        <button class="decline" @click="declinedOrder(order.id)">Weiger</button>
      </td>
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
import {orders} from "../../Services/index.js";
import {id} from "vuetify/locale";

export default {
  computed: {
    id() {
      return id
    }
  },
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
      orders: [],
      order: '',
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
      this.orders  = await orders.getByID(id)
      this.loading = false
      console.log(this.orders)
    },
    async getAll() {
      this.loading = true
      this.orders = await orders.getOrders()
      this.loading = false
    },
    onCloseTrigger() {
      this.openPreview = false
    },

    async acceptedOrder(id){
      this.order = await orders.getByID(id)
      this.order.accepted = true;
      console.log(this.order.accepted)
    },
    async declinedOrder(id){
      this.order = await orders.getByID(id)
      console.log(this.order.accepted)
    }

  },

  async mounted() {
    await this.getAll()
  }
}
</script>