package com.xiaotao.sso.service;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.pojo.TbUser;

public interface RegisterService {

	XiaotaoResult checkData(String param, int type);
	XiaotaoResult register(TbUser user);
}
