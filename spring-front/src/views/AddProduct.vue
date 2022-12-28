<template>
  <div>
    <div v-if="!submitted">
      <div class="mb-3">
        <label for="title" class="form-label">Title</label>
        <input type="text" class="form-control" id="title" required name="title" v-model="product.title">
      </div>
      <div class="mb-3">
        <label for="description" class="form-label">Description</label>
        <input type="text" class="form-control" id="description" required name="description" v-model="product.description">
      </div>
      <div class="mb-3">
        <label for="price" class="form-label">Price</label>
        <input type="number" class="form-control" id="price" required name="price" v-model="product.price">
      </div>
      <div class="mb-3">
        <button @click="saveProduct" class="btn btn-primary">Submit</button>
      </div>
    </div>
    <div v-else>
      <div class="alert alert-success" role="alert">
        Save product successfully!
      </div>
      <button @click="newProduct" class="btn btn-primary">Add New Product</button>
    </div>
  </div>
</template>

<script>
import DataService from '@/services/DataService'

export default {
  name: 'add-product',
  data() {
    return {
      product: {
        id: null,
        title: "",
        description: "",
        price: ""
      },
      submitted: false
    }
  },
  methods: {
    saveProduct() {
      var data = {
        title: this.product.title,
        description: this.product.description,
        price: this.product.price
      }
      DataService.createProduct(data)
          .then(response => {
            this.product.id = response.data.id
            this.submitted = true;
          })
          .catch( e => {
            alert(e)
          })
    },
    newProduct() {
      this.submitted = false
      this.product = {}
    }
  }
}
</script>