package com.xiaotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.portal.service.StaticPageService;
import com.xiaotao.utils.ExceptionUtil;

@Controller
public class StaticPageController {

	@Autowired
	private StaticPageService staticPageService;
	
	@RequestMapping("/gen/item/{itemId}")
	@ResponseBody
	public XiaotaoResult genItemPage(@PathVariable Long itemId){
		try {
			XiaotaoResult xiaotaoResult = staticPageService.genItemHtml(itemId);
			return xiaotaoResult;
		} catch (Exception e) {
			// TODO: handle exception
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
		
		
	}
}
