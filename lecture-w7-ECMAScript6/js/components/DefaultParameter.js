import * as React from "react";

export default class DefaultParameter extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    // before ES6
    function abc(x) {
    }

    // after ES6
    function xyz(x = 100) {
      return x;
    }

    return xyz();
  }
}

// Work: 完成 ES6 之前的寫法，如果 x 不存在回傳 100