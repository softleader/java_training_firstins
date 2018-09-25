import * as React from "react";

export default class TemplateStrings extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    const lastName = "David", firstName = "Hsu";

    return `Hello, ${lastName} ${firstName}`;
  }
}

// Work: 修改 LetConst.js，return 的部分使用 TemplateStrings 的寫法