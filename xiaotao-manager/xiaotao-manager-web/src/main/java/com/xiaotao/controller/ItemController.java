package com.xiaotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.EasyUIDataGridResult;
import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.pojo.TbItem;
import com.xiaotao.service.ItemService;

@Controller
public class ItemController {
	
	//根据id查询商品信息
	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	private TbItem getItemById(@PathVariable Long itemId) {
		TbItem item = itemService.getItemById(itemId);
		return item;
	}
	
	//获取商品列表 Integer可以为空
	@RequestMapping("/item/list")
	@ResponseBody
	public EasyUIDataGridResult getItemList(Integer page, Integer rows) {
		EasyUIDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	//添加商品信息
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	public XiaotaoResult createItem(TbItem item, String desc, String itemParams) {
		XiaotaoResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
	//展示商品参数
	@RequestMapping("/page/item/{itemId}")
	public String showItemParam(@PathVariable Long itemId, Model model) {
		String myHtml = itemService.getItemParanHtml(itemId);
		model.addAttribute("myHtml", myHtml);
		return "itemparam";
	}



}
