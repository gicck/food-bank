import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);
const parseProps = r => ({ id: parseInt(r.params.id) });

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/orders/:id",
    name: "OrderDetail",
    props: parseProps,
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/OrderDetail.vue")
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/About.vue")
  },
  {
    path: "/orders",
    name: "Orders",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Orders.vue")
  },
  {
    path: "/deliveryView",
    name: "Deliveries",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Deliveries.vue")
  },
  {
    path: "/deliveryDetail",
    name: "DeliveryDetail",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/DeliveryDetail.vue")
  },
  {
    path: "/deliveryCreate",
    name: "DeliveryCreate",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/DeliveryCreate.vue")
  },
  {
    path: "/recipientView",
    name: "Recipients",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Recipients.vue")
  },
  {
    path: "/recipientCreate",
    name: "RecipientCreate",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/RecipientCreate.vue")
  },
  {
    path: "/donorView",
    name: "Donors",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/Donors.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
