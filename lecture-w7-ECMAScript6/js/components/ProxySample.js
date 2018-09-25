import * as React from "react";

export default class ProxySample extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    window.slDocument = new Proxy(document, {
      get: function(target, key) {
        if(key === "hello") {
          return "Hello";
        }
        return target[key];
      }
    });

    alert(slDocument.hello);
    alert(slDocument.location.href);

    return null;
  }
}