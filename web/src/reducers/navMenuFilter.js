import { NavMenuFilters  } from '../actions'

const navMenuFilter = (state = {filter: NavMenuFilters.NAV_SEARCH}, action) => {
  switch (action.type) {
    case 'SET_NAV_FILTER':
      return Object.assign({}, state, {
        filter: action.filter
      });
    default:
      return state
  }
}

export default navMenuFilter