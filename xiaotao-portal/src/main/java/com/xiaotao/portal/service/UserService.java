package com.xiaotao.portal.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaotao.pojo.TbUser;

public interface UserService {
	TbUser getUserByToken(HttpServletRequest request, HttpServletResponse response) ;

}
