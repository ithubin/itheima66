package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.TreeNode;

public interface ContentCategoryService {
	
	/**
	 * 需求:根据父id查询树形子节点
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 */
	public List<TreeNode> findContentCategoryByParentId(Long parentId);
	/**
	 * 需求:新建树形分类节点
	 * 参数:Long parentId,String name
	 * 返回值:E3mallResult.ok(TbCOntentCategory)
	 */
	public E3mallResult createNode(Long parentId,String name);

}
