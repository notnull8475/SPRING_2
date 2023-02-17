<template>
  <h2>Cart</h2>
  <div>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">Index</th>
        <th scope="col">productId</th>
        <th scope="col">productTitle</th>
        <th scope="col">quantity</th>
        <th scope="col">pricePerProduct</th>
        <th scope="col">price</th>
        <th scope="col">Delete from cart</th>
      </tr>
      </thead>
      <tbody v-for="(cartItem, index) in cartItems" :key="index">
      <tr>
        <td>{{ index }}</td>
        <td>{{ cartItem.productId }}</td>
        <td>{{ cartItem.productTitle }}</td>
        <td><a @click="changeQuantity(index,'-1')" class="btn">-</a>{{ cartItem.quantity }}<a
            @click="changeQuantity(index,'1')" class="btn">+</a></td>
        <td>{{ cartItem.pricePerProduct }}</td>
        <td>{{ cartItem.price }}</td>
        <td><a @click="deleteFromCart(cartItem.productId)" class="btn btn-primary">Delete</a></td>
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
      DataService.getCart(localStorage.getItem("uuid"), localStorage.getItem("user"))
          .then(response => {
            console.log(response.data.items)
            this.cartItems = response.data.items
          })
          .catch(e => console.log(e))
    },
    changeQuantity(index, delta) {
      if (this.cartItems[index].quantity > 0) {
        // console.log(index, this.cartItems[index].quantity, delta)
        DataService.changeQuantity(index, delta).then(r => {
              this.cartItems[index].quantity = this.cartItems[index].quantity + Number(delta)
              this.cartItems[index].price = this.cartItems[index].pricePerProduct * this.cartItems[index].quantity
            }
        )


      }
    },
    deleteFromCart(productId){
      DataService.deleteProductFromCart(productId).then(this.retrieveCart)
    }
  },
  async mounted() {
    this.retrieveCart()
  }
}
</script>