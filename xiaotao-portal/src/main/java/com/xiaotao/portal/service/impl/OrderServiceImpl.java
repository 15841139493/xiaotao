package com.xiaotao.portal.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.portal.pojo.OrderInfo;
import com.xiaotao.utils.HttpClientUtil;
import com.xiaotao.utils.JsonUtils;

@Service
public class OrderServiceImpl implements com.xiaotao.portal.service.OrderService {

	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;

	@Override
	public String createOrder(OrderInfo orderInfo) {
		//把OrderInfo转换成json
		String json = JsonUtils.objectToJson(orderInfo);
		//提交订单数据
		String jsonResult = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, json);
		//转换成java对象
		XiaotaoResult xiaotaoResult = XiaotaoResult.format(jsonResult);
		//取订单号
		String orderId = xiaotaoResult.getData().toString();
		return orderId;

	}
}
