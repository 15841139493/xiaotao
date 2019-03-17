package com.xiaotao.service;

import com.xiaotao.common.pojo.XiaotaoResult;

public interface ItemParamService {

		XiaotaoResult getItemParamByCid(long cid);
		
		XiaotaoResult insertItemParam(Long cid, String paramData);
}
