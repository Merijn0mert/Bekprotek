<template>
  <div class="card-productcard">
  <v-card>
    <v-card-title>this is a product {{productName}}</v-card-title>
    <v-card-text>{{ productDesc }}</v-card-text>
  </v-card>
  </div>
</template>
<script>
import './card.css';
import { VCard, VCardText, VCardTitle } from 'vuetify/components/VCard'

export default {
  Components:{
    VCard,
    VCardText,
    VCardTitle,
  },
  props: {
    productName: String,
    productDesc: String,
    productId: Number,
  },
};
</script>