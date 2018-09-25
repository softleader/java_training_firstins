import * as React from "react";

export default class Promises extends React.Component {

  constructor(props) {
    super(props);
    this.state = {msgs: []};
  }

  componentDidMount() {
    const msgs = [];

    function task1() {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          msgs.push(" task1 done")
          return resolve(" task1");
        }, 3000);
      });
    }

    function task2() {
      return new Promise((resolve, reject) => {
        setTimeout(() => {
          msgs.push(" task2 done")
          return reject(" task2");
        }, 1000);
      });
    }

    task1().then(data => {
      msgs.push(data + " is success");
      this.setState({msgs: msgs});
    });

    task2().then(data => {
      msgs.push(data + " is success");
      this.setState({msgs: msgs});
    }).catch(error => {
      msgs.push(error + " is error");
      this.setState({msgs: msgs});
    });
  }

  render() {
    return this.state.msgs;
  }
}