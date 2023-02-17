<script>
import DataService from '@/services/DataService';

export default {
  name: 'auth-user',
  data() {
    return {
      user: {
        username: "",
        password: "",
        uuid: localStorage.getItem('uuid')
      }
    }
  },
  methods: {
    authenticate() {
      DataService.authUser(this.user)
          .then(response => {
            localStorage.token = response.data();
            console.log(localStorage.token)
            // localStorage.setItem(token, response.data())
            alert("response " + response.data())
          })
          .catch(e => alert(e))
    }
  }
}
</script>
<template>
  <div class="d-flex justify-content-center row mt-5">
    <form class="col-4 block">
      <div class="mb-3">
        <label for="username" class="form-label">Username</label>
        <input type="text" class="form-control" id="username" v-model="user.username"/>
      </div>
      <div class="mb-3">
        <label for="password" class="form-label">Password</label>
        <input type="password" class="form-control" id="password" v-model="user.password"/>
      </div>
      <button @click="authenticate" class="btn btn-primary">Submit</button>
    </form>
  </div>
</template>