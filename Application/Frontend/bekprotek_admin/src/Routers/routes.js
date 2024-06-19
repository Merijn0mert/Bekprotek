

export default [

    { 
        path: '/', 
        strict: true,
        sensitive: true,
        component: () => import('@/Views/HelloWorld.vue') 
    },

    {
        path: '/orders',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/order/allOrders.vue')
    },
    {
        path: '/ordersws',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/order/allOrdersWebsocket.vue')
    },
    {
        path: '/addproduct',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/product/addProduct.vue')
    },
/*    {
        path: '/createOrder',
        strict: true,
        sensitive: true,
        component: () => import('@/Views/order/createOrder.vue')
    },*/
/*    {
        path: '/signin',f
        strict: true,
        sensitive: true,
        component: () => import('@/Views/authentication/authentication.vue'),
        meta: {
            hideNavbar: true,
        }
    },*/

]