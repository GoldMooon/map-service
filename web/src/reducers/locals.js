const locals = (state = { obj: {} }, action) => {
  switch (action.type) {
    case 'SET_LOCAL_DETAIL':
      return Object.assign({}, state, {
        obj: action.obj
      });
    default:
      return state
  }
}

export default locals