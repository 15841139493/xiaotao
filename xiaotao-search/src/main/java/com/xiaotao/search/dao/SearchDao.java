package com.xiaotao.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.xiaotao.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
