'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',
  VUE_WEB: '"http://localhost:9527"',
  PICTURE_API: '"http://localhost:8607/picture"',
	WEB_API: '"http://localhost:8607/web"',
  SEARCH_API: '"http://localhost:8607/search"',
})
