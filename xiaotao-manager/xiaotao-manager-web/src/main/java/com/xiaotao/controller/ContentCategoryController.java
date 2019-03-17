package com.xiaotao.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.service.ContentCatgoryService;

@Controller
@RequestMapping("/content/category")
public class ContentCategoryController {

	@Autowired
	private ContentCatgoryService contentCatgoryService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getContentCatList(@RequestParam(value="id", defaultValue="0")Long parentId) {
		List<EasyUITreeNode> list = contentCatgoryService.getContentCatList(parentId);
		return list;
		
	}
	@RequestMapping("/create")
	@ResponseBody
	public XiaotaoResult createNode(Long parentId, String name) {
		XiaotaoResult result = contentCatgoryService.insertCatgory(parentId, name);
		return result;
	}

}

