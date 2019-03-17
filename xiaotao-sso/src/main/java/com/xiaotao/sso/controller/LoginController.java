package com.xiaotao.sso.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.sso.service.LoginService;
import com.xiaotao.utils.ExceptionUtil;

@Controller
public class LoginController {

	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/user/login", method=RequestMethod.POST)
	@ResponseBody
	public XiaotaoResult login(String username, String password, 
			HttpServletRequest request, HttpServletResponse response) {
		try {
			XiaotaoResult result = loginService.login(username, password, request, response);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	
	@RequestMapping("/user/token/{token}")
	@ResponseBody
	public Object getUserByToken(@PathVariable String token, String callback) {
		try {
			XiaotaoResult result = loginService.getUserByToken(token);
			//支持jsonp调用
			if (StringUtils.isNotBlank(callback)) {
				MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
				mappingJacksonValue.setJsonpFunction(callback);
				return mappingJacksonValue;
			}
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
	
	@RequestMapping("/logout/{token}")
	@ResponseBody
	public Object logout(@PathVariable String token) {
		try {
			XiaotaoResult result = loginService.logout(token);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}

}
