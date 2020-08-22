<template>
  <div class="home">
    <HelloWorld
      msg="Welcome to Your Vue.js App"
      class="flex flex-col flex-1 w-full"
    />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "Home",
  components: {
    HelloWorld
  }
};
</script>
