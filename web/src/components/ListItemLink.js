import React from 'react'
import PropTypes from 'prop-types'
import ListGroupItem from 'react-bootstrap/ListGroupItem';

const ListItemLink = ({ children, onClick }) => (
  <ListGroupItem onClick={onClick} >
    {children}
  </ListGroupItem>
)

ListItemLink.propTypes = {
  children: PropTypes.node.isRequired,
  onClick: PropTypes.func.isRequired
}

export default ListItemLink