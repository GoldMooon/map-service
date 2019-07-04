export const setNavMenuFilter = filter => ({
  type: 'SET_NAV_FILTER',
  filter
})

export const NavMenuFilters = {
  NAV_SEARCH: 'NAV_SEARCH',
  NAV_POP: 'NAV_POP',
  NAV_HISTORY: 'NAV_HISTORY'
}

export const setLocalDetail = obj => ({
  type: 'SET_LOCAL_DETAIL',
  obj
})

export const ListItemFilters = {
  ITEM_LOCAL_SEARCH: 'ITEM_LOCAL_SEARCH'
}