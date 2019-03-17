package com.xiaotao.controller.itemCat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.service.ItemCatService;


@Controller
@RequestMapping("/item/cat")
public class TbItemCatController {
	
	@Autowired
	private ItemCatService itemCatService;
	
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value ="id",defaultValue = "0") Long parentId){
		List<EasyUITreeNode> list = itemCatService.getItemCatList(parentId);
		return list;

	}

}
