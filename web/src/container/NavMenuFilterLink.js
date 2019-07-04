import { connect } from 'react-redux'
import { setNavMenuFilter } from '../actions'
import NavMenuLink from '../components/NavMenuLink'

const mapStateToProps = (state, ownProps) => ({
  active: ownProps.filter === state.navMenuFilter
})

const mapDispatchToProps = (dispatch, ownProps) => ({
  onClick: () => dispatch(setNavMenuFilter(ownProps.filter))
})

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(NavMenuLink)