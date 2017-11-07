package cn.e3mall.manager.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.mapper.TbItemCatMapper;
import cn.e3mall.pojo.TbItemCat;
import cn.e3mall.pojo.TbItemCatExample;
import cn.e3mall.pojo.TbItemCatExample.Criteria;
import cn.e3mall.utils.TreeNode;
@Service
public class ItemCatServiceImpl implements ItemCatService {
	
	//注入商品类目mapper接口代理对象
	@Autowired
	private TbItemCatMapper itemCatMapper;

	/**
	 * 需求:根据父id查询子节点,按需加载
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 * 思考:服务是否发布? 一个类发布一次
	 */
	public List<TreeNode> findItemCatWithParentId(Long parentId) {
		
		//创建树形节点集合对象List<TreeNode>,封装树形节点数据
		List<TreeNode> treeNodeList = new ArrayList<TreeNode>();
		
		// 创建example对象
		TbItemCatExample example = new TbItemCatExample();
		//创建criteria对象
		Criteria createCriteria = example.createCriteria();
		//设置查询参数,根据父id查询子节点
		createCriteria.andParentIdEqualTo(parentId);
		
		//执行查询
		List<TbItemCat> list = itemCatMapper.selectByExample(example);
		//循环集合对象
		for (TbItemCat tbItemCat : list) {
			//创建树形节点对象TreeNode,封装单个树形节点对象值
			TreeNode node = new TreeNode();
			//封装id
			node.setId(tbItemCat.getId());
			//树形节点名称
			node.setText(tbItemCat.getName());
			//树形节点状态
			//如果此节点有子节点 state=closed 表示可打开
			//如果此节点没有子节点  state=open 表示不可打开
			node.setState(tbItemCat.getIsParent()?"closed":"open");
			
			//把树形节点对象放入集合
			treeNodeList.add(node);
			
		}
		return treeNodeList;
	}

}
