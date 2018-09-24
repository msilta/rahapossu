import DefaultLayout from 'layouts/Default.vue';
import Home from 'pages/Home.vue';
import About from 'pages/About.vue';
import Portfolios from 'pages/Portfolios.vue';

const routes = [
  {
    path: '/',
    component: DefaultLayout,
    children: [
      {
        path: '',
        name: 'home',
        component: Home,
      },
      {
        path: '/about',
        name: 'about',
        component: About,
      },
      {
        path: '/portfolios',
        name: 'portfolios',
        component: Portfolios,
      },
    ],
  },
];

// Always leave this as last one
if (process.env.MODE !== 'ssr') {
  routes.push({
    path: '*',
    component: () => import('pages/Error404.vue'),
  });
}

export default routes;
