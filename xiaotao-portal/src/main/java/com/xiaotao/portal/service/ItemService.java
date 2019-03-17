package com.xiaotao.portal.service;

import com.xiaotao.portal.pojo.PortIbItem;

public interface ItemService {

	PortIbItem getItemById(Long itemId);
	String getItemDescById(Long itemId);
	String getItemParamById(Long itemId);
}
