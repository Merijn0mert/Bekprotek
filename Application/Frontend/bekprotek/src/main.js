import { createApp } from 'vue'
// import { createPinia } from 'pinia'
import PrimeVue from 'primevue/config';

import App from './App.vue'
import routers from "./Routers/index.js";
import 'vuetify/styles'
import { createVuetify } from 'vuetify'
import * as components from 'vuetify/components'
import * as directives from 'vuetify/directives'

// Import required Vuetify styles and icons
import '@mdi/font/css/materialdesignicons.css'
import 'material-design-icons-iconfont/dist/material-design-icons.css'

const vuetify = createVuetify({
    components,
    directives,
})

const app = createApp(App)

if (process.env.NODE_ENV === 'development')
    app.config.devtools = true;

//app.use(createPinia())
app.use(routers)
app.use(PrimeVue)
app.use(vuetify)

app.mount('#app')