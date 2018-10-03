import React from 'react';
import ReactDOM from 'react-dom';
import MemberList from "./containers/MemberList";

window.app = {};

app.create = (dom) => {
  app.run(dom);
};

app.run = (dom) => {
  ReactDOM.render(<MemberList/>, dom)
};