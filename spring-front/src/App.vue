<script setup>
import {RouterView} from 'vue-router'
import HeaderVue from '@/components/HeaderVue.vue'
import FooterVue from '@/components/FooterVue.vue';</script>

<template>
  <div class="d-flex flex-column min-vh-100">
    <HeaderVue/>
    <div class="container">
      <RouterView/>
    </div>

    <FooterVue/>
  </div>

</template>