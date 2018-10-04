import React from 'react';
import ReactDOM from 'react-dom';
import MemberList from "./containers/MemberList";
import thunkMiddleware from 'redux-thunk';
import {applyMiddleware, combineReducers, createStore} from "redux";
import reducers from "./reducers/reducers";
import {createLogger} from "redux-logger";
import {Provider} from "react-redux";

const store = createStore(
  combineReducers({
    ...reducers,
  }),
  applyMiddleware(
    thunkMiddleware,
    // createLogger(),
  )
);

window.app = {};

app.create = (dom) => {
  app.run(dom);
};

app.run = (dom) => {
  ReactDOM.render(
    <Provider store={store}>
      <MemberList/>
    </Provider>,
    dom
  )
};