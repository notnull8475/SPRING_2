## SPRING 1,2 ##
### back methods ###
    - POST    - /auth                                   авторизация;
    - GET     - /api/v1/users/                          получение списка пользователей 
    - GET     - /api/v1/users/{id}                      получение пользователя по id

    - GET     - /api/v1/products/                       список продуктов
    - GET     - /api/v1/products/{id}                   продукт по id                   

    - POST    - /api/v1/admin/products/                 создать продукт
    - PUT     - /api/v1/admin/products/                 обновить продукт
    - DELETE  - /api/v1/admin/products/{id}             удалить продукт




| service name  | port | prefix |
|---------------|------|--------|
| auth-service  | 8081 | /auth  |
| admin-service | 8082 | /admin |
| app           | 8083 | /app   |
| cart-service  | 8084 | /cart  |

front-service work on node.js port is 8080
=======
### microservices ###
auth
app
gateway
cart
api
front
admin