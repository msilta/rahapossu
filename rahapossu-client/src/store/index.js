import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

// import example from './module-example';

Vue.use(Vuex);

/*
 * If not building with SSR mode, you can
 * directly export the Store instantiation
 */

export default function (/* { ssrContext } */) {
  const Store = new Vuex.Store({
    state: {
      // Portfolios
      portfolios: [],
      portfoliosReady: false,
      // Assets
      assets: [],
    },
    mutations: {
      setPortfolios(state, portfolios) {
        state.portfolios.splice(0, state.portfolios.length);
        state.portfolios.push(...portfolios);
      },
      portfoliosReady(state) {
        state.portfoliosReady = true;
      },
    },
    actions: {
      initPortfolios(context) {
        axios.get('/api/portfolios').then((response) => {
          const portfolios = [];
          if (response.data.page.totalElements > 0) {
            portfolios.push(...response.data._embedded.portfolios);
          }
          context.commit('setPortfolios', portfolios);
          context.commit('portfoliosReady');
        }).catch((error) => {
          console.error(error.message);
        });
      },
    },
  });

  return Store;
}
