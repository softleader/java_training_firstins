import {MEMBER_EVENTS} from "../constants/Events";

const member = (state = {
  list: [], message: ''
}, action) => {
  switch (action.type) {
    case MEMBER_EVENTS.GET_ALL:
      return Object.assign({}, state, {
        list: action.data
      });
    case MEMBER_EVENTS.ADD:
      let response = action.data;
      //判斷後端回傳的狀態
      if (response.statusCode === '200') {
      return Object.assign({}, state, {
        list: [...state.list, response.data],
        message: ''
      });
      } else {
        console.log(response); //FIXME DEBUG LOG
        return Object.assign({}, state, {
          message: response.message
        })
      }
    case MEMBER_EVENTS.UPDATE:
      let newList = state.list.map(e => {
        if(e.id === action.data.id) {
          return action.data;
        }
        return e;
      });
      return Object.assign({}, state, {list: newList});
    case MEMBER_EVENTS.REMOVE:
      newList = state.list.map(e => {
        if(e.id === action.id) {
          return undefined;
        }
        return e;
      }).filter(e => e);
      return Object.assign({}, state, {list: newList});
    default:
      return state;
  }
};

export default member;