package cn.e3mall.content.service.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.mapper.TbContentMapper;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.pojo.TbContentExample;
import cn.e3mall.pojo.TbContentExample.Criteria;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class ContentServiceImpl implements ContentService {
	
	//注入内容mapper接口代理对象
	@Autowired
	private TbContentMapper contentMapper;

	/**
	 * 需求:根据分类id查询内容数据
	 * 参数:Long categoryId
	 * 返回值:PageBeanResult
	 * 分页查询:
	 * 1,配置分页插件
	 * 2,设置分页查询当前页,每页显示的条数
	 */
	public PageBeanResult findContentByCategoryId(Long categoryId,Integer page,Integer rows) {
		// 创建example对象
		TbContentExample example = new TbContentExample();
		//创建criteria对象
		Criteria createCriteria = example.createCriteria();
		//设置查询参数 根据分类id查询内容数据
		createCriteria.andCategoryIdEqualTo(categoryId);
		
		//查询之前,设置分页
		PageHelper.startPage(page, rows);
		
		//执行分页查询
		List<TbContent> list = contentMapper.selectByExample(example);
		//创建PageINfo对象,获取分页信息
		PageInfo<TbContent> pageInfo = new PageInfo<TbContent>(list);
		
		//创建分页包装类对象PageBeanResult
		PageBeanResult result = new PageBeanResult();
		
		//设置总记录数
		result.setTotal(pageInfo.getTotal());
		//设置总记录
		result.setRows(list);
		
		return result;
	}

	/**
	 * 需求:保存内容数据
	 * 参数:TbContent content
	 * 返回值:E3mallResult
	 */
	public E3mallResult saveContent(TbContent content) {
		//广告更新时间
		Date date = new Date();
		content.setUpdated(date);
		content.setCreated(date);
		//保存内容数据
		contentMapper.insert(content);
		
		//返回值
		return E3mallResult.ok();
	}

}
