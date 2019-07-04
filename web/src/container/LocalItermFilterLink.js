import { connect } from 'react-redux'
import { setLocalDetail } from '../actions'
import ListItemLink from '../components/ListItemLink';

const mapDispatchToProps = (dispatch, ownProps) => ({
  onClick: () => dispatch(setLocalDetail(ownProps.obj))
})

export default connect(
  undefined,
  mapDispatchToProps
)(ListItemLink)