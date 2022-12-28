<script setup>
import {RouterLink} from 'vue-router'</script>

<template>
  <header>
    <div class="container">
      <nav class="navbar navbar-expand-lg bg-dark text-white">
        <div class="container-fluid">
          <a class="navbar-brand text-white" href="#">Navbar</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                  aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <RouterLink to="/" class="nav-link text-white">Home</RouterLink>
              <RouterLink to="/products" class="nav-link text-white">Products</RouterLink>
              <RouterLink to="/login" class="nav-link text-white">Login</RouterLink>
            </div>
          </div>
        </div>
      </nav>
    </div>
  </header>
</template>