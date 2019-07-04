import React, { Component } from 'react';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/es/FormControl';
import Button from 'react-bootstrap/Button';
import CommonList from './CommonList';
import axios from 'axios';
import { ListItemFilters } from '../actions';

class LocalSearchList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      keyword: "",
      pageNumber: 1,
      totalPage: 1,
      list: []
    };
  }

  render() {

    const { keyword, pageNumber, totalPage, list } = this.state;

    return (
      <div style={{ height: window.innerHeight + 'px' }}>
        <Form inline>
          <FormControl type="text" placeholder="장소 키워드를 입력해주세요." className="mr-sm-3" value={keyword} onChange={this.handleFormControlOnChange} />
          <Button onClick={this.handleButtonOnClick}>Search</Button>
        </Form>

        <CommonList
          keyword={keyword}
          pageNumber={pageNumber}
          totalPage={totalPage}
          list={list}
          pageOnClick={this.requestLocalSearch}
          listItemClickable={true}
          listItemFilter={ListItemFilters.ITEM_LOCAL_SEARCH}
        />

      </div>
    );
  }

  handleButtonOnClick = () => {

    const { keyword } = this.state;

    if (keyword === undefined || keyword === "") {
      alert("장소 키워드를 입력해주세요.");
      return;
    }

    this.requestLocalSearch(keyword, 1)

  }

  requestLocalSearch = (keyword, page) => {
    axios.get('/local/search', {
      params: {
        user_id: 2,
        y: 37.514322572335,
        x: 127.06283102249932,
        keyword,
        page,
        size: 15
      }
    })
      .then((response) => {

        let list = [];
        let pageNumber = page;
        let totalPage = 1;
        if (response.data) {
          if (response.data.documents) {
            list = response.data.documents.map((document) => ({
              str: document.place_name,
              obj: document
            }))
          }

          totalPage = response.data.total_page;
        }

        this.setState({
          list, pageNumber, totalPage
        })
      })
      .catch((error) => {
        // console.log(error);
      })
      .finally(() => {
        // always executed
      });
  };

  handleFormControlOnChange = (e) => {
    let { keyword } = this.state;
    keyword = e.target.value;
    this.setState({ keyword })
  }

}

export default LocalSearchList;


