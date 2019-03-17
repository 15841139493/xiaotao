package com.xiaotao.controller;

import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.pojo.TbContent;
import com.xiaotao.service.ContentService;
import com.xiaotao.utils.HttpClientUtil;

@Controller
@RequestMapping("/content")
public class ContentController {
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${REST_CONTENT_URL}")
	private String REST_CONTENT_URL;
	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public XiaotaoResult insertContent(TbContent content) {
		XiaotaoResult result = contentService.insertContent(content);
		HttpClientUtil.doGet(REST_BASE_URL + REST_CONTENT_URL + content.getCategoryId());
		return result;
	}

}
