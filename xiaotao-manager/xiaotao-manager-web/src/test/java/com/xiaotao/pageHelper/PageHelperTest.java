package com.xiaotao.pageHelper;

import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaotao.mapper.TbItemMapper;
import com.xiaotao.pojo.TbItem;
import com.xiaotao.pojo.TbItemExample;
//为啥用代理类
public class PageHelperTest {
	@Test
	public void test() throws Exception{
		//获得Mapper代理对象
		//创建一个springMvc容器
		@SuppressWarnings("resource")
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");	
		TbItemMapper itemMapper =applicationContext.getBean(TbItemMapper.class);
		
		//设置分页 只对第一个select有效
		PageHelper.startPage(1,30);
		//执行查询
		TbItemExample itemExample = new TbItemExample();
		List<TbItem> lists = itemMapper.selectByExample(itemExample);
		//取分页结果
		PageInfo<TbItem> pageInfo = new PageInfo<>(lists); 
		long total = pageInfo.getTotal();
		System.out.println("total" + total);
		long totalPage = pageInfo.getPages();
		System.out.println("totalPage"+ totalPage);
		System.out.println("pageSize" +pageInfo.getPageSize());
	}
	
}

