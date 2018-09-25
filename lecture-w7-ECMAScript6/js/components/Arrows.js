import * as React from "react";

export default class Arrows extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    let array = [0, 1, 2];

    // before ES6

    // after ES6
    array = array.map(e => e + 1);

    return array;
  }
}

// Work: 完成 ES6 之前的寫法，將 array 裡面的值各 + 1，使用 for or map