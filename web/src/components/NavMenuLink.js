import React from 'react'
import PropTypes from 'prop-types'
import NavLink from 'react-bootstrap/NavLink';

const NavMenuLink = ({ children, onClick }) => (
  <NavLink onClick={onClick} >
    {children}
  </NavLink>
)

NavMenuLink.propTypes = {
  children: PropTypes.node.isRequired,
  onClick: PropTypes.func.isRequired
}

export default NavMenuLink