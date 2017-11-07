package cn.e3mall.manager.service;

import java.util.List;

import cn.e3mall.utils.TreeNode;

public interface ItemCatService {
	
	/**
	 * 需求:根据父id查询子节点,按需加载
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 */
	public List<TreeNode> findItemCatWithParentId(Long parentId);

}
