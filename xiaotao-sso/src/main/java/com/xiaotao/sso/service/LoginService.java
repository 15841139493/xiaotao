package com.xiaotao.sso.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaotao.common.pojo.XiaotaoResult;

public interface LoginService {
	XiaotaoResult login(String username, String password, HttpServletRequest request,
			HttpServletResponse response);
	XiaotaoResult getUserByToken(String token);
	XiaotaoResult logout(String token);
	
	
}
