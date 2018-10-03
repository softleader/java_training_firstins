const path = require('path');
const webpack = require('webpack');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const proxy = process.env.npm_config_proxy || "http://localhost:8080/";

module.exports = {
  entry: [
    "webpack-dev-server/client?http://localhost:3000",
    "webpack/hot/only-dev-server",
    "./js/app.js"
  ],
  output: {
    filename: 'softleader-web-resources.js',
    chunkFilename: '[name].js',
    publicPath: 'http://localhost:3000/'
  },
  module: {
    loaders: [{
      test: /\.(js|jsx)$/,
      exclude: [
        path.resolve(__dirname, 'node_modules')
      ],
      loaders: ['babel-loader']
    }, {
      test: /\.css$/,
      loader: "style-loader!css-loader"
    }, {
      test: /\.png$/,
      loader: "url-loader?limit=100000"
    }, {
      test: /\.jpg$/,
      loader: "file-loader"
    }, {
      test: /\.(woff|woff2)(\?v=\d+\.\d+\.\d+)?$/,
      loader: 'url?limit=10000&mimetype=application/font-woff'
    }, {
      test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/,
      loader: 'url?limit=10000&mimetype=application/octet-stream'
    }, {
      test: /\.eot(\?v=\d+\.\d+\.\d+)?$/,
      loader: 'file'
    }, {
      test: /\.svg(\?v=\d+\.\d+\.\d+)?$/,
      loader: 'url?limit=10000&mimetype=image/svg+xml'
    }]
  },
  plugins: [
    new webpack.HotModuleReplacementPlugin(),
    new webpack.NoErrorsPlugin(),
    new HtmlWebpackPlugin({
      template: './index.html'
    }),
    new webpack.ProvidePlugin({
      jQuery: 'jquery',
      $: 'jquery',
      jquery: 'jquery'
    })],
  devServer: {
    port: 3000,
    proxy: {
      '**': {
        target: proxy,
        secure: false,
        prependPath: false
      }
    },
    publicPath: 'http://localhost:3000/',
    historyApiFallback: true
  }
};
