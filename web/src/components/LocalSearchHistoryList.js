import React, { Component } from 'react';
import CommonList from './CommonList';
import axios from 'axios';

class LocalSearchHistoryList extends Component {

  constructor(props) {
    super(props);
    this.state = {
      list: []
    };
  }

  componentWillMount() {
    this.requestLocalSearchHistories();
  }

  render() {

    const { list } = this.state;


    return (
      <div style={{height:  window.innerHeight + 'px'}}>

        <CommonList list={list} />

      </div>
    );
  }

  requestLocalSearchHistories = () => {
    axios.get('/api/local/search/histories', {
      params: {
        user_id: 2,
        limit: 10
      }
    })
      .then((response) => {

        let list = [];
        if (response.data) {
          list = response.data.map((content) => ({
            str: content.keyword + " / " + content.updated_at,
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

export default LocalSearchHistoryList;