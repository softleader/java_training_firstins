import * as React from "react";

export default class LetConst extends React.Component {

  constructor(props) {
    super(props);
  }

  render() {
    // before ES6
    function useVar() {
      // TODO: 完成一個 for 迴圈，變數名稱為 i，值從 0 到 9，最後回傳 i
    }

    // after ES6
    function useLet() {
      // TODO
    }

    return 'useVar: ' + useVar() + ', useLet: ' + useLet();
  }
}