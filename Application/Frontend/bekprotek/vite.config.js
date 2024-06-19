import { fileURLToPath, URL } from 'node:url'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
//import vuetify from 'vite-plugin-vuetify'

// https://vitejs.dev/config/
export default defineConfig({
  resolve: { alias: { '@': '/src' } },
    plugins: [
        vue({
            template: {
                compilerOptions: {
                    isCustomElement: (tag) => {
                        return tag.startsWith('ion-') // (return true)
                    }
                },},})
    ],
    server: {
        host: '0.0.0.0',      
        port: 8080
    },
      alias: {
        '@/': fileURLToPath(new URL('./src', import.meta.url)),
        '@/assets': fileURLToPath(new URL('./src/assets', import.meta.url)),
        '@/components': fileURLToPath(new URL('./src/components', import.meta.url)),
        '@/router': fileURLToPath(new URL('./src/router', import.meta.url)),
        '@/stores': fileURLToPath(new URL('./src/stores', import.meta.url)),
        '@/views': fileURLToPath(new URL('./src/views', import.meta.url)),
        '@/layouts': fileURLToPath(new URL('./src/layouts', import.meta.url)),
        '@/routers': fileURLToPath(new URL('./src/routers', import.meta.url)),
        '@/services': fileURLToPath(new URL('./src/services', import.meta.url))
      }
})
