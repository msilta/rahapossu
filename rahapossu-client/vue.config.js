// vue.config.js
module.exports = {
  devServer: {
    port: 8081,
    proxy: {
      '/api': {
        secure: false,
        target: 'http://localhost:8080',
      },
    },
  }
}

