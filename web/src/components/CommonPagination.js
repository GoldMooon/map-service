import React, { Component } from 'react';
import PropTypes from 'prop-types';
import Pagination from 'react-bootstrap/Pagination';

class CommonPagination extends Component {
  static propTypes = {
    onClick: PropTypes.func,
    keyword: PropTypes.string,
    pageNumber: PropTypes.number,
    totalPage: PropTypes.number
  };

  static defaultProps = {
    page: 1,
    totalPage: 1
  };


  render() {

    let onClick = this.props.onClick;
    let keyword = this.props.keyword;
    let pageNumber = this.props.pageNumber;
    let totalPage = this.props.totalPage;

    let startPagination = (pageNumber - 4) > 0 ? (pageNumber - 4) : 1;
    let endPagination = (totalPage < 6 || (pageNumber + 4) >= totalPage) ? totalPage : (pageNumber + 4);

    let pageArr = [];
    for (let i = startPagination; i <= endPagination; i++) {
      pageArr.push(i);
    }

    return (
      <div className="text-center" hidden={pageArr.length === 1}>
        <Pagination>
          {
            pageNumber > 1 ?
              <Pagination.First onClick={onClick ? onClick.bind(this, keyword, 1) : undefined}/>
              : ""
          }
          {
            pageNumber > 1 ?
              <Pagination.Prev onClick={onClick ? onClick.bind(this, keyword, (pageNumber - 1)) : undefined}/>
              : ""
          }
          {
            pageNumber > 5 ?
              <Pagination.Ellipsis />
              : ""
          }
          {
            pageArr.map((page) =>
              <Pagination.Item onClick={onClick ? onClick.bind(this, keyword, page)  : undefined} active={page == pageNumber}>{page}</Pagination.Item>
            )
          }
          {
            (pageNumber + 4) < totalPage ?
              <Pagination.Ellipsis />
              : ""
          }
          {
            pageNumber < totalPage ?
              <Pagination.Next onClick={onClick ? onClick.bind(this, keyword, (pageNumber + 1)) : undefined}/>
              : ""
          }
          {
            pageNumber < totalPage ?
              <Pagination.Last onClick={onClick ? onClick.bind(this, keyword, totalPage) : undefined}/>
              : ""
          }
        </Pagination>
      </div>
    );
  }

}



export default CommonPagination;

