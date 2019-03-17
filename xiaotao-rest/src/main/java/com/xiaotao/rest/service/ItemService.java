package com.xiaotao.rest.service;

import com.xiaotao.pojo.TbItem;
import com.xiaotao.pojo.TbItemDesc;
import com.xiaotao.pojo.TbItemParamItem;


public interface ItemService {

	TbItem getItemById(Long itemId);
	TbItemDesc getItemDescById(Long itemId);
	TbItemParamItem getItemParamById(Long itemId);
	
}
