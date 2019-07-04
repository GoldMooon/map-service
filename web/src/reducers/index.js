import { combineReducers } from 'redux'
import navMenuFilter from './navMenuFilter'
import locals from './locals';

export default combineReducers({
  locals,
  navMenuFilter,
})