<template>
  <div class="orders">
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
