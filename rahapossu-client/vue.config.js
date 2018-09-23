module.exports = {
  devServer: {
    port: 8081,
    proxy: {
      '/api': {
        secure: false,
        target: 'http://localhost:8080',
      },
    },
  },

  pluginOptions: {
    quasar: {
      theme: 'mat',
      importAll: true,
    },
  },
  transpileDependencies: [
    /[\\\/]node_modules[\\\/]quasar-framework[\\\/]/,
  ],
};
