import * as React from "react";

export default class DefaultParameter extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    // before ES6
    function abc(x) {
      // Work: 如果 x 不存在回傳 100
    }

    // after ES6
    function xyz(x) {
      //TODO
      return x;
    }

    return xyz();
  }
}