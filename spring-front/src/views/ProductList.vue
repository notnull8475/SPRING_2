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
        <th scope="col" v-if="false">Actions</th>
      </tr>
      </thead>
      <tbody v-for="(product, index) in products" :key="index">
      <tr>
        <td>{{ product.id }}</td>
        <td>{{ product.title }}</td>
        <td>{{ product.price }}</td>
        <td>{{ product.description }}</td>
        <td v-if="false"><a :href="'/products/' + product.id" class="btn btn-primary">Edit</a></td>
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
    }
  },
  async mounted() {
    this.retrieveProducts()
  }
}
</script>