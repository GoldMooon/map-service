import React from 'react';
import './App.css';

import Header from './components/Header';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'react-bootstrap/dist/react-bootstrap.min';
import NavMenu from './container/NavMenu';
import LocalItem from './container/LocalItem';

function App() {
  return (
    <div>
      <Header/>
      <div className="main">
        <NavMenu />
        <LocalItem />
      </div>
    </div>
  );
}

export default App;
