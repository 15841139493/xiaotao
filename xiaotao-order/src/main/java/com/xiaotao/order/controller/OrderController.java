package com.xiaotao.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.order.pojo.OrderInfo;
import com.xiaotao.order.service.OrderService;
import com.xiaotao.utils.ExceptionUtil;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/order/create", method=RequestMethod.POST)
	@ResponseBody
	public XiaotaoResult createOrder(@RequestBody OrderInfo orderInfo) {
		try {
			XiaotaoResult result = orderService.createOrder(orderInfo);
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return XiaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}


}
