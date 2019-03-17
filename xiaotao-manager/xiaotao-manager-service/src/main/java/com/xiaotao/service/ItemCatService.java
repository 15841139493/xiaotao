package com.xiaotao.service;

import java.util.List;

import com.xiaotao.common.pojo.EasyUITreeNode;

public interface ItemCatService {

	 List<EasyUITreeNode> getItemCatList(long parentId); 
}
