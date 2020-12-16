<template>
  <div>
    <pre>{{ recipient }}</pre>
  </div>
</template>

<script>
import { dataService } from "../../shared";

export default {
  name: "RecipientDetail",
  props: {
    id: {
      type: Number,
      default: 0
    }
  },
  data() {
    return {
      recipient: {},
      handleOrderSubmit: async () => {
        // await dataService.updateOrder(this.order);
        // this.$router.push({ name: "Home" });
      }
    };
  },
  async created() {
    this.recipient = await dataService.getSingle("recipient", this.id);
  }
};
</script>

<style></style>
