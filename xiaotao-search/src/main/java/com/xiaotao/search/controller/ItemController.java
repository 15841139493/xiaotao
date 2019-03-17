package com.xiaotao.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.search.service.ItemService;
import com.xiaotao.utils.ExceptionUtil;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/importall")
	@ResponseBody
	public XiaotaoResult importAll() {
		try {
			XiaotaoResult result = itemService.importItems();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
