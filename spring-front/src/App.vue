<script setup>
import {RouterLink, RouterView} from 'vue-router';</script>

<template>
  <header>
    <div class="container">
      <nav class="navbar navbar-expand-lg bg-dark text-white">
        <div class="container-fluid">
          <a class="navbar-brand text-white" href="#">Market :-)</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                  aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
            <div class="navbar-nav">
              <RouterLink to="/" class="nav-link text-white">Главная</RouterLink>
              <RouterLink to="/products" class="nav-link text-white">Товары</RouterLink>
              <RouterLink to="/cart" class="nav-link text-white">Корзина</RouterLink>
              <RouterLink to="/orders" class="nav-link text-white">Заказы</RouterLink>
            </div>
          </div>
          <div class="d-flex">
            <button class="btn btn-outline-success mx-2">Войти</button>
            <button class="btn btn-outline-success">Выйти</button>
          </div>
        </div>
      </nav>
    </div>
  </header>
  <div class="container">
    <RouterView/>
  </div>

  <div class="mt-auto">
    <div class="container">
      <footer class="row row-cols-1 row-cols-sm-2 row-cols-md-5 py-5 my-5 border-top">
        <div class="col mb-3">
          <a href="/" class="d-flex align-items-center mb-3 link-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32">
              <use xlink:href="#bootstrap"></use>
            </svg>
          </a>
        </div>
        <div class="col mb-3">
          <h5>Footer</h5>
        </div>
      </footer>
    </div>
  </div>
</template>