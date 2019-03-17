package com.xiaotao.service;

import com.xiaotao.common.pojo.EasyUIDataGridResult;
import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.pojo.TbItem;

public interface ItemService {
	TbItem getItemById(long itemId);
	EasyUIDataGridResult getItemList(int page,int rows);
	XiaotaoResult createItem(TbItem item,String desc,String itemParam);
	String getItemParanHtml(long itemId);
}
