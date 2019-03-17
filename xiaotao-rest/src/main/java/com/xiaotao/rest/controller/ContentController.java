package com.xiaotao.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.pojo.TbContent;
import com.xiaotao.rest.service.ContentService;
import com.xiaotao.utils.ExceptionUtil;

@Controller
public class ContentController {

	
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/content/{cid}")
	@ResponseBody
	public XiaotaoResult getContentList(@PathVariable Long cid) {
		try {
			List<TbContent> list = contentService.getContentList(cid);
			return XiaotaoResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/sync/content/{cid}")
	@ResponseBody
	public XiaotaoResult sysncContent(@PathVariable Long cid) {
		try {
			XiaotaoResult result = contentService.synContent(cid);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}


	
}
