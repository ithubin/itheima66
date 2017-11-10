package cn.e3mall.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.mapper.TbContentCategoryMapper;
import cn.e3mall.pojo.TbContentCategory;
import cn.e3mall.pojo.TbContentCategoryExample;
import cn.e3mall.pojo.TbContentCategoryExample.Criteria;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.TreeNode;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {
	
	
	//查询内容分类表,注入内容分类mapper接口代理对象
	@Autowired
	private TbContentCategoryMapper categoryMapper;
	
	/**
	 * 需求:根据父id查询树形子节点
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 * 发布服务
	 */
	public List<TreeNode> findContentCategoryByParentId(Long parentId) {
		//创建树形节点封装集合对象List<TreeNode>
		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
		
		// 创建内容分类表example对象
		TbContentCategoryExample example = new TbContentCategoryExample();
		//创建criteria对象
		Criteria createCriteria = example.createCriteria();
		//设置查询参数,根据父id查询树形子节点
		createCriteria.andParentIdEqualTo(parentId);
		//查询
		List<TbContentCategory> list = categoryMapper.selectByExample(example);
		//遍历循环,把内容分类数据封装树形节点集合中
		for (TbContentCategory tbContentCategory : list) {
			//创建单个树形节点对象
			TreeNode node = new TreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			
			treeNodeList.add(node);
		}
		return treeNodeList;
	}

	/**
	 * 需求:新建树形分类节点
	 * 参数:Long parentId,String name
	 * 返回值:E3mallResult.ok(TbCOntentCategory)
	 * 业务:
	 * 1,如果新建节点父节点是子节点,更新父节点状态.
	 * 2,如果新建节点父节点是父节点,直接添加即可
	 */
	public E3mallResult createNode(Long parentId, String name) {
		// 创建分类对象,封装分类数据
		TbContentCategory category = new TbContentCategory();
		//设置父id
		category.setParentId(parentId);
		//节点名称
		category.setName(name);
		
		//状态。可选值:1(正常),2(删除)
		category.setStatus(1);
		//排列序号，表示同级类目的展现次序，如数值相等则按名称次序排列。取值范围:大于零的整数
		category.setSortOrder(1);
		//该类目是否为父类目，1为true，0为false
		category.setIsParent(false);
		//节点时间
		Date date = new Date();
		category.setUpdated(date);
		category.setCreated(date);
		//保存节点	
		categoryMapper.insert(category);
		
		
		//根据新建节点父id查询父节点数据
		//关系:当前节点父id是当前节点父节点的id
		TbContentCategory contentCategory = categoryMapper.selectByPrimaryKey(parentId);
		//判断父节点是否是子节点
		if(!contentCategory.getIsParent()){
			//表示此节点是子节点,修改父节点状态
			contentCategory.setIsParent(true);
			//修改
			categoryMapper.updateByPrimaryKey(contentCategory);
		}
		
		//返回新建节点对象
		return E3mallResult.ok(category);
	}

}
