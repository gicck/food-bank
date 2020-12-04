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
      import(/* webpackChunkName: "about" */ "../views/order/OrderDetail.vue")
  },
  {
    path: "/about",
    name: "About",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/about/About.vue")
  },
  {
    path: "/orders",
    name: "Orders",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/order/Orders.vue")
  },
  {
    path: "/deliveryView",
    name: "Deliveries",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/delivery/Deliveries.vue")
  },
  {
    path: "/deliveryDetail",
    name: "DeliveryDetail",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/delivery/DeliveryDetail.vue"
      )
  },
  {
    path: "/deliveryCreate",
    name: "DeliveryCreate",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/delivery/DeliveryCreate.vue"
      )
  },
  {
    path: "/recipientView",
    name: "Recipients",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/recipient/Recipients.vue"
      )
  },
  {
    path: "/recipientCreate",
    name: "RecipientCreate",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/recipient/RecipientCreate.vue"
      )
  },
  {
    path: "/donorCreate",
    name: "DonorCreate",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(
        /* webpackChunkName: "about" */ "../views/donor/DonorCreate.vue"
      )
  },
  {
    path: "/recipients/:id",
    name: "RecipientDetail",
    props: parseProps,
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/recipient/RecipientDetail.vue")
  },
  {
    path: "/donors/:id",
    name: "DonorDetail",
    props: parseProps,
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/donor/DonorDetail.vue")
  },
  {
    path: "/donorView",
    name: "Donors",
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () =>
      import(/* webpackChunkName: "about" */ "../views/donor/Donors.vue")
  }
];

const router = new VueRouter({
  routes
});

export default router;
