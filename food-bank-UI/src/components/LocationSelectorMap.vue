<template>
<div style="height: 500px; width: 100%">
  <l-map
    ref="map"
    @dblclick="onMapClick"
    :zoom="zoom"
    :center="[
      position.lat || userLocation.lat || defaultLocation.lat,
      position.lng || userLocation.lng || defaultLocation.lng
    ]"
  >
     <l-tile-layer
      :url="tileProvider.url"
      :attribution="tileProvider.attribution"
    />
    <l-marker
      v-if="position.lat && position.lng"
      visible
      draggable
      :lat-lng.sync="position"
      @dragstart="dragging = true"
      @dragend="dragging = false"
    >
    <l-tooltip :content="tooltipContent" :options="{ permanent: true }" />
    </l-marker>
  </l-map>  
</div>
</template>
<script>
import { LMap,
  LMarker,
  LTileLayer,
  LTooltip
} from "vue2-leaflet";
import { Icon } from "leaflet"

delete Icon.Default.prototype._getIconUrl;
Icon.Default.mergeOptions({
  iconRetinaUrl: require("leaflet/dist/images/marker-icon-2x.png"),
  iconUrl: require("leaflet/dist/images/marker-icon.png"),
  shadowUrl: require("leaflet/dist/images/marker-shadow.png")
});

export default {
  components: {
    LMap,
    LTileLayer,
    LMarker,
    LTooltip,
  },
  props: {
    value: {
      type: Object,
      required: true
    },
    defaultLocation: {
      type: Object,
      default: () => ({
        lat: 8.9806,
        lng: 38.7578
      })
    }
  },
  data() {
    return {
      loading:false,
      userLocation: {},
      position: {},
      address:"",
      tileProvider: {
        attribution:
          '&copy; <a target="_blank" href="http://osm.org/copyright">OpenStreetMap</a> contributors',
        url: "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
      },
      zoom: 18,
      dragging:false
    }
  },
  mounted() {
    this.getUserPosition();
  },
  watch: {
    position: {
      deep: true,
      async handler(value) {
        // this.address = await this.getAddress();
        this.$emit("input", { position: value, address: this.address });
      }
    }
  },
  computed: {
    tooltipContent() {
      if (this.dragging) return "...";
      if (this.loading) return "Loading...";
      return `<strong>${this.address.replace(
        ",",
        "<br/>"
      )}</strong> <hr/><strong>lat:</strong> ${
        this.position.lat
      }<br/> <strong>lng:</strong> ${this.position.lng}`;
    }
  },
  methods: {
    onMapClick(value) {
      // place the marker on the clicked spot
      this.position = value.latlng;
    },
    async getUserPosition() {
      // check if API is supported
      //TODO wrap this to SET the user location
            // this.userLocation = {
            //   lat: -17.40355440056167,
            //   lng: -66.14374306310076
            // }
            // this.position = this.userLocation;
      if (navigator.geolocation) {
        // get  geolocation
        navigator.geolocation.getCurrentPosition(pos => {
          // set user location
          this.userLocation = {
            lat: pos.coords.latitude,
            lng: pos.coords.longitude
          };
        });
      }
    }
  }
};
</script>