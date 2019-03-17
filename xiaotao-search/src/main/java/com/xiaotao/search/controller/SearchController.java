package com.xiaotao.search.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.search.pojo.SearchResult;
import com.xiaotao.search.service.SearchService;
import com.xiaotao.utils.ExceptionUtil;

@Controller
public class SearchController {

	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/q")
	@ResponseBody
	public XiaotaoResult search(@RequestParam(defaultValue="")String keyword, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="30")Integer rows) {
		
		try {
			//转换字符集
			keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
			SearchResult searchResult = searchService.search(keyword, page, rows);
			return XiaotaoResult.ok(searchResult);
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
	}

}
