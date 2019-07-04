import React, { Component } from 'react';
import { Navbar, Nav } from 'react-bootstrap'
import { NavMenuFilters } from '../actions'
import FilterLink from '../container/NavMenuFilterLink';

class Header extends Component {
  render() {
    return (
      <Navbar bg="dark" variant="dark">
        <Navbar.Brand href="#">로컬 검색 페이지</Navbar.Brand>
        <Nav className="main">
          <FilterLink filter={NavMenuFilters.NAV_SEARCH}>로컬 검색</FilterLink>
          <FilterLink filter={NavMenuFilters.NAV_HISTORY}>로컬 히스토리 목록</FilterLink>
          <FilterLink filter={NavMenuFilters.NAV_POP}>인기 키워드 목록</FilterLink>
        </Nav>
      </Navbar>
    );
  }
}

export default Header;
