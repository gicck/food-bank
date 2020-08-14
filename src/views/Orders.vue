<template>
  <div class="order sp-12 shadow-xl mt-12 bg-white max-w-sm mx-auto text-left">    
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
