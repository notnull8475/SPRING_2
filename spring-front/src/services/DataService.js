import http from '@/http-common';

class DataService {
    getAllProducts() {
        return http.get('/products')
    }

    getOrders() {
        return http.get('/orders')
    }

    getProductById(id) {
        return http.get('/products/${id}')
    }

    createProduct(product) {
        return http.post('/products', product)
    }
    updateProduct(product) {
        return http.put('/products', product)
    }

    deleteProduct(id){
        return http.delete('/products/${id}')
    }

    getUsersList() {
        return http.get('/users')
    }

    getUser(id) {
        return http.get('/users/${id}')
    }

    createUser(user) {
        return http.post('/users', user)
    }

    updateUser(user) {
        return http.put('/users', user)
    }

    deleteUser(id){
        return http.delete('/users/${id}')
    }

    authUser(auth){
        return http.post('/auth', auth)
    }

    registration(registerUser){
        return http.post('/registration', registerUser)
    }

    
}

export default new DataService();

/*    - POST    - /auth                                   авторизация;
    - GET     - /api/v1/users/                          получение списка пользователей
    - GET     - /api/v1/users/{id}                      получение пользователя по id

    - GET     - /api/v1/products/                       список продуктов
    - GET     - /api/v1/products/{id}                   продукт по id

    - POST    - /api/v1/admin/products/                 создать продукт
    - PUT     - /api/v1/admin/products/                 обновить продукт
    - DELETE  - /api/v1/admin/products/{id}             удалить продукт*/