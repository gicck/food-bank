<template>
  <div>
    <h2 class="my-6 text-2xl font-semibold text-gray-700 dark:text-gray-200">
      Crear Orden de Entrega
    </h2>
    <CreateOrder msg="Orders Page" />
  </div>
</template>

<script>
// @ is an alias to /src
import CreateOrder from "@/components/CreateOrder.vue";

export default {
  name: "Home",
  components: {
    CreateOrder
  }
};
</script>
