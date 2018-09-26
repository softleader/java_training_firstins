import * as React from "react";

export default class ForOf extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    const array = ["a", "b", "c"];

    // before ES6
    let result1 = "";
    // TODO: 印出 array 裡的每個 element

    // after ES6
    let result2 = "";
    // TODO

    return `result1: ${result1}, result2: ${result2}`;
  }
}