// const path = require('path');
// const fs = require('fs-extra');

const proxy = process.env.npm_config_proxy || "http://localhost:8080/";
console.log('Start proxy %s to http://localhost:3000/...', proxy);

// const targetIndexFolder = '../softleader-jasmine/src/main/resources/templates';
//
// fs.copy(path.resolve(__dirname, '../index_dev.html'), targetIndexFolder + "/index.html", function (err) {
//   if (err) return console.error(err);
//   console.log("Copied index_dev.html to " + targetIndexFolder + "/index.html");
// });