package com.xiaotao.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.mapper.TbContentMapper;
import com.xiaotao.pojo.TbContent;
import com.xiaotao.service.ContentService;

@Service
public class ContentServiceImpl implements ContentService {
	@Autowired
	private TbContentMapper contentMapper;
	@Override
	public XiaotaoResult insertContent(TbContent content) {
		
			content.setCreated(new Date());
			content.setUpdated(new Date());
			//插入数据
			contentMapper.insert(content);
			
			return XiaotaoResult.ok();
		}

}
