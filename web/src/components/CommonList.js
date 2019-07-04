import React, { Component } from 'react';
import ListGroup from 'react-bootstrap/ListGroup';
import CommonPagination from './CommonPagination';
import FilterLink from '../container/LocalItermFilterLink';


class CommonList extends Component {

  static defaultProps = {
    list: [],
    listItemClickable: false,
  };

  render() {
    const { pageNumber, totalPage, keyword, list, pageOnClick } = this.props;
    // console.log(this.props);
    return (
      <div style={{ height: '500px' }}>
        <ListGroup>
          {
            list.map((content) =>
              <FilterLink obj={content.obj}>
                {content.str}
              </FilterLink>
            )
          }
        </ListGroup>

        <CommonPagination
          keyword={keyword}
          pageNumber={pageNumber}
          totalPage={totalPage}
          onClick={pageOnClick} />
      </div>
    );
  }
}

export default CommonList;