import fetch from 'isomorphic-fetch';

export const getAll = (type, url) => {
  return function (dispatch) {
    return fetch(url, {
      method: 'GET',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json; charset=utf-8'
      }
    })
      .then(response => response.json())
      .then(data => dispatch({type, data}))
  }
};

export const add = (type, url, params) => {
  return function (dispatch) {
    return fetch(url, {
      method: 'POST',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json; charset=utf-8'
      },
      body: JSON.stringify(params)
    })
      .then(response => response.json())
      .then(data => dispatch({type, data}))
  }
};

export const update = (type, url, params) => {
  return function (dispatch) {
    return fetch(url, {
      method: 'PUT',
      headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json; charset=utf-8'
      },
      body: JSON.stringify(params)
    })
      .then(response => response.json())
      .then(data => dispatch({type, data}))
  }
};