import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import VueFormulate from "@braid/vue-formulate";
import "./assets/css/tailwind.css";
import "./assets/css/snowman.css";
import "leaflet/dist/leaflet.css";

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");

Vue.use(VueFormulate, {
  classes: {
    outer: ({ isGrouped }) => {
      return isGrouped ? "mb-1" : "mb-4";
    },
    wrapper: ({ classification }) => {
      switch (classification) {
        case "box":
          return "flex";
        default:
          return "";
      }
    },
    element: ({ classification, hasValue }) => {
      switch (classification) {
        case "group":
          return "mt-2";
        case "select":
          return !hasValue ? "text-gray-500 font-light" : "";
        default:
          return "";
      }
    },
    input: ({ classification }) => {
      switch (classification) {
        case "button":
          return "flex mx-auto text-white bg-indigo-500 border-0 py-2 px-8 focus:outline-none hover:bg-indigo-600 rounded text-lg";
        case "textarea":
          return "form-textarea mt-1 block w-full focus:outline-none focus:shadow-outline-blue focus:border-blue-300 transition duration-150 ease-in-out sm:text-sm sm:leading-5";
        case "group":
          return "w-full bg-gray-100 rounded border border-gray-400 focus:outline-none h-48 focus:border-indigo-500 text-base px-4 py-2 resize-none block";
        default:
          return "mt-1 form-input block w-full py-2 px-3 border border-gray-300 rounded-md shadow-sm focus:outline-none focus:shadow-outline-blue focus:border-blue-300 transition duration-150 ease-in-out sm:text-sm sm:leading-5";
      }
    },
    decorator: ({ hasValue }) => {
      let base = "border rounded inline-block w-4 h-4 mr-2";
      if (hasValue) {
        base += " bg-green-700";
      }
      return base;
    },
    label: "block text-sm font-medium leading-5 text-gray-700",
    help: "mt-2 text-sm text-gray-500",
    error: "text-red-700 text-xs mb-1"
  },
  locales: {
    en: {
      required() {
        return `El campo es requerido.`;
      }
    }
  }
});
