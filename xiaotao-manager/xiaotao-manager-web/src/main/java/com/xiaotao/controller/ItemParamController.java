package com.xiaotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	
	@Autowired
	private ItemParamService itemParamService;
	
	@RequestMapping("/query/itemcatid/{cid}")
	@ResponseBody
	public XiaotaoResult getItemCatByCid(@PathVariable Long cid) {
		XiaotaoResult result = itemParamService.getItemParamByCid(cid);
		return result;
	}
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public XiaotaoResult insertItemParam(@PathVariable Long cid, String paramData) {
		XiaotaoResult result = itemParamService.insertItemParam(cid, paramData);
		return result;
	}

}
