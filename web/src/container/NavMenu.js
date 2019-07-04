import React from 'react';

import { connect } from 'react-redux'
import { NavMenuFilters } from '../actions'

import MainLeft from '../components/MainLeft';
import LocalSearchList from '../components/LocalSearchList';
import PopLocalKeywordList from '../components/PopLocalKeywordList';
import LocalSearchHistoryList from '../components/LocalSearchHistoryList';

const get = (object) => {
  switch (object.filter) {
    case NavMenuFilters.NAV_SEARCH:
    return <LocalSearchList />
    case NavMenuFilters.NAV_POP:
      return <PopLocalKeywordList />
    case NavMenuFilters.NAV_HISTORY:
      return <LocalSearchHistoryList />
    default:
      throw new Error('Unknown filter: ' + object.filter)
  }
}

const mapStateToProps = state => ({
  view: get(state.navMenuFilter)
});

export default connect(
  mapStateToProps
)(MainLeft)