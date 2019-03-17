package com.xiaotao.service.impl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaotao.common.pojo.EasyUITreeNode;
import com.xiaotao.mapper.TbItemCatMapper;
import com.xiaotao.pojo.TbItemCat;
import com.xiaotao.pojo.TbItemCatExample;
import com.xiaotao.pojo.TbItemCatExample.Criteria;
import com.xiaotao.service.ItemCatService;
@Service
public class ItemCatServiceImpl implements ItemCatService {

	@Autowired
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<EasyUITreeNode> getItemCatList(long parentId) {
		// 根据parentId查询分类列表
		TbItemCatExample tbItemCatExample = new TbItemCatExample();
		//设置查询条件
		Criteria criteria= tbItemCatExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		//执行查询
		List<TbItemCat> list = tbItemCatMapper.selectByExample(tbItemCatExample);
		//转换成EasyUITree列表
		List<EasyUITreeNode> nodeList = new ArrayList<>();
		
		for(TbItemCat tbItemCat: list){
			//创建节点对象
			EasyUITreeNode node = new EasyUITreeNode();
			node.setId(tbItemCat.getId());
			node.setText(tbItemCat.getName());
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			//添加到列表中
			nodeList.add(node);

		}

		return nodeList;
	}

}
