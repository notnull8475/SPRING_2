<template>
  <h2>Orders</h2>
  <div>
    <table class="table">
      <thead>
      <tr>
        <th scope="col">id</th>
        <th scope="col">username</th>
        <th scope="col">items</th>
        <th scope="col">address</th>
        <th scope="col">phone</th>
        <th scope="col">totalPrice</th>
        <th scope="col">Actions</th>
      </tr>
      </thead>
      <tbody v-for="(order, index) in orders" :key="index">
      <tr>
        <td>{{ order.id }}</td>
        <td>{{ order.username }}</td>
        <td>{{ order.items }}</td>
        <td>{{ order.address }}</td>
        <td>{{ order.phone }}</td>
        <td>{{ order.totalPrice }}</td>
        <td><a :href="'/orders/place/' + order.id" class="btn btn-primary">Оформить</a></td>
        <td><a :href="'/orders/delete/' + order.id" class="btn btn-primary">Delete</a></td>
      </tr>
      </tbody>
    </table>
  </div>
</template>
<script>
import DataService from '@/services/DataService';

export default {
  name: 'orders',
  data() {
    return {
      orders: []
    }
  },
  methods: {
    retrieveOrders() {
      DataService.getOrders()
          .then(response => {
            this.orders = response.data.content
          })
          .catch(e => console.log(e))
      // .catch(e => alert(e))
    }
  },
  async mounted() {
    this.retrieveOrders()
  }
}
</script>