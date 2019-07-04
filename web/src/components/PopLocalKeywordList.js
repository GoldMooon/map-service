import React, { Component } from 'react';
import CommonList from './CommonList';
import axios from 'axios';

class PopLocalKeywordList extends Component {

  constructor(props) {
    super(props);
    this.state = {
      list: []
    };
  }

  componentWillMount() {
    this.requestPopLocalSearchKeyword();
  }

  render() {

    const { list } = this.state;


    return (
      <div style={{height:  window.innerHeight + 'px'}}>

        <CommonList list={list} />

      </div>
    );
  }

  requestPopLocalSearchKeyword = () => {
    axios.get('/api/local/search/histories/pop/keyword', {
      params: {
        user_id: 2,
        limit: 10
      }
    })
      .then((response) => {

        let list = [];
        if (response.data) {
          list = response.data.map((content) => ({
            str: content.keyword + "(" + content.sum_count + ")",
            obj: content
          }))
        }

        this.setState({
          list
        })
      })
      .catch((error) => {
        // console.log(error);
      })
      .finally(() => {
        // always executed
      });
  };

}

export default PopLocalKeywordList;