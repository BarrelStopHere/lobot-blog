'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')

module.exports = merge(prodEnv, {
  NODE_ENV: '"development"',

  //开发环境
  ADMIN_API: '"http://localhost:8607/admin"',
  PICTURE_API: '"http://localhost:8607/picture"',
  WEB_API: '"http://localhost:8607/web"',
  Search_API: '"http://localhost:8607/search"',
  Spider_API: '"http://localhost:8607/spider"',
  FILE_API: '"http://localhost:8607/file"',
  BLOG_WEB_URL: '"http://localhost:9527"',
  SOLR_API: '"http://localhost:8607/solr"',
  ELASTIC_SEARCH: '"http://localhost:8607/es"',
})
