package com.xiaotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.mapper.TbItemParamMapper;
import com.xiaotao.pojo.TbItemParam;
import com.xiaotao.pojo.TbItemParamExample;
import com.xiaotao.pojo.TbItemParamExample.Criteria;
import com.xiaotao.service.ItemParamService;

@Service
public class ItemParamServiceImpl implements ItemParamService {

	@Autowired
	private TbItemParamMapper itemParamMapper;

	@Override
	public XiaotaoResult getItemParamByCid(long cid) {
			//根据cid查询规格参数模板
			TbItemParamExample example = new TbItemParamExample();
			Criteria criteria = example.createCriteria();
			criteria.andItemCatIdEqualTo(cid);
			//执行查询   selectByExampleWithBLOBs查询大文本类型
			List<TbItemParam>list = itemParamMapper.selectByExampleWithBLOBs(example);
			
			if (list != null&&list.size() > 0) {
				TbItemParam itemParam = list.get(0);
				return XiaotaoResult.ok(itemParam);
			}
			
		
			return XiaotaoResult.ok();
	}

	@Override
	public XiaotaoResult insertItemParam(Long cid, String paramData) {
		// TODO Auto-generated method stub
		
		//创建一个pojo
		TbItemParam itemParam = new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		//插入记录
		itemParamMapper.insert(itemParam);
		return XiaotaoResult.ok();

	}

}
