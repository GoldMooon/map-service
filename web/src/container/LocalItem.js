import { connect } from 'react-redux';

import MainRight from '../components/MainRight';

const get = (object) => {
  return object.obj;
}

const mapStateToProps = state => ({
  obj: get(state.locals)
});

export default connect(
  mapStateToProps
)(MainRight)