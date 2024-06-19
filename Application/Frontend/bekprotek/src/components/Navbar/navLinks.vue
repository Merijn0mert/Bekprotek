<template>
  <RouterLink :to="to" :class="[customizable ? `sidebar-nav-link sidebar-nav-link-${color}` : 'sidebar-nav-link']" exact-active-class="sidebar-nav-link-active">
    <slot name="icon"></slot>
    {{ text }}
  </RouterLink>
</template>

<script>
import { RouterLink } from 'vue-router'

export default {
  components: {
    RouterLink
  },

  props: {
    /**
     * The text that will be displayed on the nav-link.
     */
    text: String,

    /**
     * The destination for the RouterLink.
     * Default: '/'
     */
    to: {
      type: [String, Object],
      default: '/'
    },

    /**
     * Being able to change the color of the button.
     * Default: 'danger'
     */
    color: {
      type: String,
      default: 'danger'
    },

    /**
     * Indicates that the button is customizable.
     */
    customizable: {
      type: Boolean,
      default: false
    }
  }
}
</script>