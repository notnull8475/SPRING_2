<template>
  <div v-if="currentProduct">
    <div class="mb-3">
      <label for="title" class="form-label">Title</label>
      <input type="text" class="form-control" id="title" required name="title"
             v-model="currentProduct.title">
    </div>
    <div class="mb-3">
      <label for="description" class="form-label">Description</label>
      <input type="text" class="form-control" id="description" required name="description" v-model="currentProduct.description">
    </div>
    <div class="mb-3">
      <label for="price" class="form-label">Price</label>
      <input type="number" class="form-control" id="price" required name="price" v-model="currentProduct.price">
    </div>
    <div class="mb-3">
      <button @click="updateProduct" class="btn btn-primary me-3">Update</button>
      <button @click="deleteProduct" class="btn btn-danger">Delete</button>
    </div>
    <div class="alert alert-success" role="alert" v-if="message">
      {{ message }}
    </div>
  </div>
</template>

<script>
import DataService from '@/services/DataService'

export default {
  name: 'edit-product',
  data() {
    return {
      currentProduct: null,
      message: ''
    }
  },
  methods: {
    getProduct(id) {
      DataService.getProductById(id)
          .then(response => {
            this.currentProduct = response.data
          })
          .catch(e => {
            alert(e)
          })
    },
    updateProduct() {
      DataService.updateProduct(this.currentProduct)
          .then(() => {
            this.message = 'The product was updated successfully!'
          })
          .catch(e => {
            alert(e)
          })
    },
    deleteProduct() {
      DataService.deleteProduct(this.currentProduct.id)
          .then(() => {
            this.$router.push({name: 'products'})
          })
          .catch(e => {
            alert(e)
          })
    }
  },
  mounted() {
    this.getProduct(this.$route.params.id)
  }
}
</script>