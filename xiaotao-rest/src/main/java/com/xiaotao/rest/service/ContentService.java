package com.xiaotao.rest.service;

import java.util.List;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.pojo.TbContent;

public interface ContentService {

	List<TbContent> getContentList(Long cid);
	XiaotaoResult synContent(Long cid);
}
