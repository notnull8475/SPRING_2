import http from '@/http-common';

class DataService {

    // ------------ auth service start --------------------

    authUser(auth) {
        return http.post('/auth/api/v1/auth', auth)
    }

    registration(registerUser) {
        return http.post('/auth/api/v1/registration', registerUser)
    }

    logout() {
        return http.post('/auth/api/v1/auth/logout', localStorage.getItem('user'))
    }

    // ------------ auth service stop ---------------------
    // ----------------------------------------------------
    // ------------ products service start ----------------
    getAllProducts() {
        return http.get('/app/api/v1/products')
    }

    getProductById(id) {
        return http.get(`/app/api/v1/products/${id}`)
        // return http.get('/app/api/v1/products/' + id)
    }

    createProduct(product) {
        return http.post('/app/api/v1/products', product)
    }

    updateProduct(product) {
        return http.put('/app/api/v1/products', product)
    }

    deleteProduct(id) {
        return http.delete(`/app/api/v1/products/${id}`)
    }


    getOrders() {
        return http.get('/app/api/v1/orders')
    }

    createOrder() {
        return http.post('/app/api/v1/orders')
    }

    deleteOrder(orderId) {
        return http.delete(`/app/api/v1/orders/${orderId}`)
    }

    // ------------ products service stop -----------------
    // ----------------------------------------------------
    // ------------ cars service start --------------------
    generateUUID() {
        return http.get('/carts/api/v1/carts/generate_uuid')
    }

    addProductToCart(uuid, productId) {
        return http.get(`/carts/api/v1/carts/${uuid}/add/${productId}`)
    }

    clearCart(uuid) {
        return http.get(`/carts/api/v1/carts/${uuid}/clear`)
    }

    removeProductFromCart(uuid, productId) {
        return http.get(`/carts/api/v1/carts/${uuid}/remove/${productId}`)
    }

    getCart(uuid,user) {
        console.log(`UUID:  ${uuid}`)
        console.log(`Username:  ${user}`)
        return http({
          url:`/carts/api/v1/carts/${uuid}`,
          method: "GET",
          headers: {username:`${user}`}
        })
    }

    // ------------ carts service stop --------------------
}

export default new DataService();