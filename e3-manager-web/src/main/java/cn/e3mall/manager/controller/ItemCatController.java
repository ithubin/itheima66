package cn.e3mall.manager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.manager.service.ItemCatService;
import cn.e3mall.utils.TreeNode;
@Controller
public class ItemCatController {
	
	//注入service服务对象
	@Autowired
	private ItemCatService itemCatService;
	
	
	/**
	 * 需求:根据父id查询子节点,按需加载
	 * 请求:/item/cat/list
	 * 参数:Long parentId (easyui规定传递参数必须是id)
	 * 返回值:List<TreeNode>
	 * 思考:服务是否引用? 一个类发布一次
	 * 业务:
	 * 树形节点加载初始化: 首次加载必须先加载顶级树形节点,设置默认值0
	 */
	@RequestMapping("/item/cat/list")
	@ResponseBody
	public List<TreeNode> findItemCatWithParentId(@RequestParam(value="id",defaultValue="0") Long parentId){
		//调用远程service服务方法,查询商品类目
		List<TreeNode> list = itemCatService.findItemCatWithParentId(parentId);
		return list;
	}

}
