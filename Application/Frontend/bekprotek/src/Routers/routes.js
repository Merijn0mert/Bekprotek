import productInfo from "../Views/product/productInfo.vue";

export default [
    /**
     * Login Route
     * Path: /login
     * Name: login
     * Componenet: Login.vue
     */
    { 
        path: '/', 
        strict: true,
        sensitive: true,
        component: () => import('@/Views/HelloWorld.vue') 
    },
    {
        path: '/products',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/product/productList.vue'),
/*        children: [
            {
                strict: true,
                sensitive: true,
                path: '/productInfo',
                component: '@/Views/product/productList.vue',
            },
        ]*/
    },

    {
        path: '/product/:id',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/product/productInfo.vue'),
        props: true

    },
    {
        path: '/vieworder',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/order/orderList.vue')
    },
    {
        path: '/orderproduct',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/order/createOrder.vue')
    },
    {
        path: '/websocket',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/WebSocket.vue')
    },
    {
        path: '/createOrder',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/order/createOrder.vue')
    },
    {
        path: '/signin',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/authentication/authentication.vue'),
        meta: {
            hideNavbar: true,
        }
    },

]