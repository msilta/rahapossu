<template>
  <q-page padding>
    <div class="q-headline">Portfolios</div>
    <q-list link>
      <template v-for="portfolio in portfolios">
        <q-item :key="portfolio.id">
          <q-item-main :label="portfolio.name" />
          <q-item-side right>
            <q-btn-group>
              <q-btn color="secondary" label="Rename" />
              <q-btn color="secondary" label="Delete" />
              <q-btn color="secondary" label="Set default" />
            </q-btn-group>
          </q-item-side>
        </q-item>
        <q-item-separator :key="portfolio.id" />
      </template>
    </q-list>
  </q-page>
</template>

<style lang="stylus">
@import '~variables';

.q-headline {
  padding-bottom: 15px;
}
</style>

<script>
export default {
  name: 'PagePortfolios',
  data() {
    return {
      portfolios: this.$store.state.portfolios,
    };
  },
  created() {
    if (!this.$store.state.portfoliosReady) {
      this.$store.dispatch('initPortfolios');
    }
  },
};
</script>
