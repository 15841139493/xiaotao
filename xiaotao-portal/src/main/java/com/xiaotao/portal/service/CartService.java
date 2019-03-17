package com.xiaotao.portal.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.portal.pojo.CartItem;


public interface CartService {

	XiaotaoResult addCart(Long itemId, Integer num, 
		HttpServletRequest request, HttpServletResponse response);
		List<CartItem> getCartItems(HttpServletRequest request);
		XiaotaoResult updateCartItem(long itemId, Integer num, HttpServletRequest request,HttpServletResponse response);
		XiaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);

}
