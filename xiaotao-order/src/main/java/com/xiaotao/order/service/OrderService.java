package com.xiaotao.order.service;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.order.pojo.OrderInfo;

public interface OrderService {
	XiaotaoResult createOrder(OrderInfo orderInfo);

}
