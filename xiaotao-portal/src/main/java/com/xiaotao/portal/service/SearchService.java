package com.xiaotao.portal.service;

import com.xiaotao.portal.pojo.SearchResult;

public interface SearchService {
	
	SearchResult search(String keyword, int page, int rows);
}
