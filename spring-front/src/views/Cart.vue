<template>
  <h2>Cart</h2>
  <div>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">productId</th>
        <th scope="col">productTitle</th>
        <th scope="col">quantity</th>
        <th scope="col">pricePerProduct</th>
        <th scope="col">price</th>
        <th scope="col">Action</th>
      </tr>
      </thead>
      <tbody v-for="(cartItem, index) in cartItems" :key="index">
      <tr>
        <td>{{ cartItem.productId }}</td>
        <td>{{ cartItem.productTitle }}</td>
        <td>{{ cartItem.quantity }}</td>
        <td>{{ cartItem.pricePerProduct }}</td>
        <td>{{ cartItem.price }}</td>
        <td><a :href="'/cart/delete/' + order.id" class="btn btn-primary">Delete</a></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import DataService from '@/services/DataService';

export default {
  name: 'cartItems',
  data() {
    return {
      cartItems: []
    }
  },
  methods: {
    retrieveCart() {
      DataService.getOrders()
          .then(response => {
            this.cartItems = response.data.content
          })
          .catch(e => console.log(e))
    }
  },
  async mounted() {
    this.retrieveCart()
  }
}
</script>