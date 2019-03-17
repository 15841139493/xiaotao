package com.xiaotao.service;

import java.util.List;

import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.common.pojo.XiaotaoResult;

public interface ContentCatgoryService {
	
	List<EasyUITreeNode> getContentCatList(Long parentId);
	XiaotaoResult insertCatgory(Long parentId, String name);
}
