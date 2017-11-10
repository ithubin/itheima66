package cn.e3mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.content.service.ContentCategoryService;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.TreeNode;

@Controller
public class ContentCategoryController {
	
	//注入内容服务对象
	//前提:引入服务
	//1,依赖接口
	//2,dubbo引入服务
	@Autowired
	private ContentCategoryService contentCategoryService;
	
	
	/**
	 * 需求:根据父id查询树形子节点
	 * 请求:/content/category/list
	 * 参数:Long parentId
	 * 返回值:List<TreeNode>
	 * 业务:
	 * 1,easyui框架按需加载每次传递参数名称是id,和业务参数不匹配.
	 * 2,树形节点初始化,首先加载顶级树形节点,传递默认值0
	 */
	@RequestMapping("/content/category/list")
	@ResponseBody
	public List<TreeNode> findContentCategoryByParentId(@RequestParam(value="id",defaultValue="0") Long parentId){
		//调用远程service服务方法
		List<TreeNode> list = contentCategoryService.findContentCategoryByParentId(parentId);
		return list;
	}
	
	/**
	 * 需求:新建树形分类节点
	 * 请求:/content/category/create
	 * 参数:Long parentId,String name
	 * 返回值:json格式E3mallResult.ok(TbCOntentCategory)
	 * 业务:
	 * 1,如果新建节点父节点是子节点,更新父节点状态.
	 * 2,如果新建节点父节点是父节点,直接添加即可
	 */
	@RequestMapping("/content/category/create")
	@ResponseBody
	public E3mallResult createNode(Long parentId,String name){
		//调用远程service服务方法
		E3mallResult result = contentCategoryService.createNode(parentId, name);
		return result;
	}

}
