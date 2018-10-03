const webpack = require("webpack");
const config = require("../webpack.config");
const path = require('path');
const fs = require('fs-extra');
const ncp = require('ncp').ncp;

console.log('Creating an optimized dev build...');

const targetJsPath = path.resolve(__dirname, '../../lecture-w6-spring-mvc/src/main/resources/static/js');
const targetIndexPath = path.resolve(__dirname, '../../lecture-w6-spring-mvc/src/main/resources/templates/index.html');
const cfg = config;

cfg.entry = {
  app: ['@babel/polyfill', path.resolve(__dirname, "../js/app.js")]
};

cfg.output = Object.assign({}, cfg.output, {
  path: path.resolve(__dirname, '../build')
});

delete cfg.output["publicPath"];
cfg.plugins = [
  new webpack.ProvidePlugin({
  jQuery: 'jquery',
  $: 'jquery',
  jquery: 'jquery'
})];
cfg.devServer = {};

fs.copy(path.resolve(__dirname, '../index_dev.html'), targetIndexPath, function (err) {
  if (err) return console.error(err);
  console.log("Copied index_dev.html to " + targetIndexPath);
});

// delete build folder
const deleteFolderRecursive = function (path) {
  if (fs.existsSync(path)) {
    fs.readdirSync(path).forEach(function (file, index) {
      const curPath = path + "/" + file;
      if (fs.lstatSync(curPath).isDirectory()) { // recurse
        deleteFolderRecursive(curPath);
      } else { // delete file
        fs.unlinkSync(curPath);
      }
    });
    // fs.rmdirSync(path);
  }
};

deleteFolderRecursive(cfg.output.path);
deleteFolderRecursive(targetJsPath);
console.log('Successfully deleted build folder');

webpack(cfg).run(function (err, stats) {
  if (err) {
    throw new Error(err);
  }
  const jsonStats = stats.toJson();
  if (jsonStats.errors.length > 0) {
    throw new Error(jsonStats.errors);
  }
  console.log('Successfully compiled: ' + path.resolve(cfg.output.path, cfg.output.filename));

  ncp(cfg.output.path, targetJsPath, function (err) {
    if (err) return console.error(err);
    console.log("Copied /build to " + targetJsPath)
  });
});