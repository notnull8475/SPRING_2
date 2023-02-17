<template>
  <h2>Products</h2>
  <div>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">TITLE</th>
        <th scope="col">PRICE</th>
        <th scope="col">DESCRIPTION</th>
        <th scope="col">Add to Cart</th>
        <th v-if="checkUser()" scope="col">Edit product</th>
      </tr>
      </thead>
      <tbody v-for="(product, index) in products" :key="index">
      <tr>
        <td>{{ product.id }}</td>
        <td>{{ product.title }}</td>
        <td>{{ product.price }}</td>
        <td>{{ product.description }}</td>
        <td><a @click="addProductToCart(product.id)" class="btn btn-primary">Add to Cart</a></td>
        <td><a v-if="checkUser()" @click="addProductToCart(product.id)" class="btn btn-primary">Edit product</a></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import DataService from '@/services/DataService';

export default {
  name: 'products',
  data() {
    return {
      products: []
    }
  },
  methods: {
    retrieveProducts() {
      DataService.getAllProducts()
          .then(response => {
            this.products = response.data.content
          })
          .catch(e => console.log(e))
          // .catch(e => alert(e))
    },
    addProductToCart(productId) {
      DataService.addProductToCart(localStorage.getItem("uuid"),productId)
          .then(r => console.log("product Added"))
    },
    checkUser(){
      if (localStorage.getItem("user")){ return true} else {
        return false
      }
    }
  },
  async mounted() {
    this.retrieveProducts()
  }
}
</script>