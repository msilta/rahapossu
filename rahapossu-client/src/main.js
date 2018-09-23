import Vue from 'vue';

import Quasar from 'quasar-framework/dist/quasar.mat.esm';
import 'quasar-extras/animate';
import 'quasar-extras/roboto-font';
import 'quasar-extras/material-icons';
import '@/styles/quasar.styl';

import App from '@/App.vue';
import router from '@/router';
import store from '@/store';

Vue.use(Quasar, {
  config: {},
});

Vue.config.productionTip = false;

new Vue({
  router,
  store,
  el: '#app',
  render: h => h(App),
});
