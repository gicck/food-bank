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
  }
];

const router = new VueRouter({
  routes
});

export default router;
