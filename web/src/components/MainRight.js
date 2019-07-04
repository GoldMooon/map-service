import React from 'react'
import LocalSearchDetail from './LocalSearchDetail';

const MainRight = (state) => {
  return (
    <div className="main-right">
      <LocalSearchDetail obj={state.obj}/>
    </div>
  )
}

export default MainRight
