package com.xiaotao.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.print.attribute.Size2DSyntax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaotao.common.pojo.EasyUIDataGridResult;
import com.xiaotao.common.pojo.XiaotaoResult;
import com.xiaotao.mapper.TbItemDescMapper;
import com.xiaotao.mapper.TbItemMapper;
import com.xiaotao.mapper.TbItemParamItemMapper;
import com.xiaotao.mapper.TbItemParamMapper;
import com.xiaotao.pojo.TbItem;
import com.xiaotao.pojo.TbItemDesc;
import com.xiaotao.pojo.TbItemExample;
import com.xiaotao.pojo.TbItemExample.Criteria;
import com.xiaotao.pojo.TbItemParamExample;
import com.xiaotao.pojo.TbItemParamItem;
import com.xiaotao.pojo.TbItemParamItemExample;
import com.xiaotao.service.ItemService;
import com.xiaotao.utils.IDUtils;
import com.xiaotao.utils.JsonUtils;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper descMapper;
	@Autowired
	private TbItemParamItemMapper paramItemMapper;
	@Autowired
	private TbItemParamItemMapper itemParamMapper;
	
	@Override
	public TbItem getItemById(long itemId) {
		TbItemExample example = new TbItemExample();
		//创建查询条件
		Criteria criteria =example.createCriteria();
		criteria.andIdEqualTo(itemId);
		
		List<TbItem> lists = tbItemMapper.selectByExample(example);
		TbItem tbItem = null;
		if(lists != null || lists.size()>0){
			tbItem = lists.get(0);
		}
		return tbItem;
		
	}

	@Override
	public EasyUIDataGridResult getItemList(int page, int rows) {
		//page当前页数，rows行数
		PageHelper.startPage(page, rows);
		
		TbItemExample example = new TbItemExample();
		List<TbItem> lists = tbItemMapper.selectByExample(example);
		PageInfo<TbItem> pageInfo = new PageInfo<>(lists);
		EasyUIDataGridResult easyUIDataGridResult = new EasyUIDataGridResult();
		easyUIDataGridResult.setRows(lists);
		easyUIDataGridResult.setTotal(pageInfo.getTotal());
		System.out.println(lists.size());
		return easyUIDataGridResult;
	}

	@Override
	public XiaotaoResult createItem(TbItem item, String desc,String itemParam) {
		
		// 生成商品id
				long itemId = IDUtils.genItemId();
				// 补全TbItem属性
				item.setId(itemId);
				// '商品状态，1-正常，2-下架，3-删除'
				item.setStatus((byte) 1);
				// 创建时间和更新时间
				Date date = new Date();
				item.setCreated(date);
				item.setUpdated(date);
				// 插入商品表
				tbItemMapper.insert(item);
				// 商品描述
				TbItemDesc itemDesc = new TbItemDesc();
				itemDesc.setItemId(itemId);
				itemDesc.setItemDesc(desc);
				itemDesc.setCreated(date);
				itemDesc.setUpdated(date);
				// 插入商品描述数据
				descMapper.insert(itemDesc);
				//添加商品规格参数
				
				TbItemParamItem itemParamItem = new TbItemParamItem();
				
				itemParamItem.setItemId(itemId);
				itemParamItem.setParamData(itemParam);
				itemParamItem.setCreated(date);
				itemParamItem.setUpdated(date);
				
				paramItemMapper.insert(itemParamItem);
				

				return XiaotaoResult.ok();

	}
	/**
	 * 获取商品参数展示html代码
	 */
	@Override
	public String getItemParanHtml(long itemId) {
		// 根据商品id查询规格参数
				TbItemParamItemExample example = new TbItemParamItemExample();
				com.xiaotao.pojo.TbItemParamItemExample.Criteria criteria = example.createCriteria();
				criteria.andItemIdEqualTo(itemId);
				//执行查询
				List<TbItemParamItem>list = itemParamMapper.selectByExampleWithBLOBs(example);
				if (list == null || list.isEmpty()) {
					return"";
				}
				//取规格参数
				TbItemParamItem itemParamItem = list.get(0);
				//取json数据
				String paramData = itemParamItem.getParamData();
				//转换成java对象
				List<Map>mapList = JsonUtils.jsonToList(paramData, Map.class);
				//遍历list生成html
				StringBuffer sb = new StringBuffer();
				
				sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
				sb.append("	<tbody>\n");
				for (Map map : mapList) {
					sb.append("		<tr>\n");
					sb.append("			<th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
					sb.append("		</tr>\n");
					//取规格项
					List<Map> mapList2 = (List<Map>) map.get("params");
					for (Map map2 : mapList2) {
						sb.append("		<tr>\n");
						sb.append("			<td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
						sb.append("			<td>"+map2.get("v")+"</td>\n");
						sb.append("		</tr>\n");
					}
				}
				sb.append("	</tbody>\n");
				sb.append("</table>");
				
				return sb.toString();

	}

}
