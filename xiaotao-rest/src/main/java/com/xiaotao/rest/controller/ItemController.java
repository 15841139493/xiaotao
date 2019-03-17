package com.xiaotao.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.pojo.TbItem;
import com.xiaotao.pojo.TbItemDesc;
import com.xiaotao.pojo.TbItemParamItem;
import com.xiaotao.rest.service.ItemService;
import com.xiaotao.utils.ExceptionUtil;

@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	/**
	 * 查询商品基本信息
	 * <p>Title: getItemById</p>
	 * <p>Description: </p>
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/base/{itemId}")
	@ResponseBody
	public XiaotaoResult getItemById(@PathVariable Long itemId) {
		try {
			TbItem item = itemService.getItemById(itemId);
			return XiaotaoResult.ok(item);
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	/**
	 * 根据id查询商品详情
	 * @param itemId
	 * @return
	 */
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public XiaotaoResult getItemDescById(@PathVariable Long itemId) {
		try {
			TbItemDesc itemDesc = itemService.getItemDescById(itemId);
			return XiaotaoResult.ok(itemDesc);
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public XiaotaoResult getItemParamById(@PathVariable Long itemId) {
		try {
			TbItemParamItem itemParamItem = itemService.getItemParamById(itemId);
			return XiaotaoResult.ok(itemParamItem);
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}


}
