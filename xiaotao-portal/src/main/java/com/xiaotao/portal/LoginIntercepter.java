package com.xiaotao.portal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.xiaotao.pojo.TbUser;
import com.xiaotao.portal.service.UserService;

public class LoginIntercepter implements HandlerInterceptor {

	@Autowired 
	private UserService userService;
	@Value("${SSO_LOGIN_URL}")
	private String SSO_LOGIN_URL;

	//handler执行之前
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object arg2, Exception arg3)
			throws Exception {
		


	}
	//**执行之后但返回modleAndView之前
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}
	//已经返回modleandview
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		// 1、拦截请求url
		// 2、从cookie中取token
		// 3、如果没有toke跳转到登录页面。
		// 4、取到token，需要调用sso系统的服务查询用户信息。
		TbUser user = userService.getUserByToken(request, response);
		// 5、如果用户session已经过期，跳转到登录页面
		if (user == null) {
			response.sendRedirect(SSO_LOGIN_URL + "?redirectURL="+request.getRequestURL());
			return false;
		}
		request.setAttribute("user",user);
		// 6、如果没有过期，放行。
		return true;
	}

}
