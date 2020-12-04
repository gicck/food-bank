<template>
  <div>
      <pre>{{donor}}</pre>
  </div>
</template>

<script>
import { dataService } from "../../shared";

export default {
    name: "DonorDetail",
    props: {
        id: {
        type: Number,
        default: 0,
        },
    },
    data() {
        return {
        donor: {},
        handleOrderSubmit: async () => {
            // await dataService.updateOrder(this.order);
            // this.$router.push({ name: "Home" });
        }
        };
    },
    async created() {
        this.donor = await dataService.getSingle("donor",this.id);
    },
}
</script>

<style>

</style>