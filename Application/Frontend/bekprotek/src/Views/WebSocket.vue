<template>
  <div>
    <label for="name">Name:</label>
    <input type="text" id="name" />
    <button id="connectButton" @click="connect()">Connect</button>
  </div>
  <div>
    <label for="message">Message:</label>
    <input type="text" id="message" />
    <button @click="SendToGroupChat()">Send</button>
  </div>
  <div id="messages"></div>
</template>
<style>
/* Custom styling */
body {
  padding: 20px;
}
#messages {
  margin-top: 20px;
}
.outgoing-message {
  text-align: right;
  background-color: #308D46;
  color:white;
  margin-bottom: 10px;
  padding:10px;
  border-radius:5px;
}
.incoming-message {
  text-align: left;
  background-color: #2C3E50;
  color:white;
  margin-bottom: 10px;
  padding:10px;
  border-radius:5px;
}
.gfg-color{
  background-color:#308D46;
  color:white;
}
.gfg-color:hover{
  color:white;
}
.gfg-blue{
  background-color:#2C3E50;
  color:white;
}
.gfg-blue:hover{
  color:white;
}
</style>
<script>
import {products, websocket} from "../Services/index.js";
import DataTable from "primevue/datatable";
import Column from "primevue/column";
import Button from "primevue/button";
import InputText from "primevue/inputtext";
import Paginator from "primevue/paginator";
import ProgressSpinner from "primevue/progressspinner";

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

     connect() {
      websocket.connect()
    },
    SendToGroupChat() {
      websocket.sendToGroupChat()
    },

  },
}
</script>