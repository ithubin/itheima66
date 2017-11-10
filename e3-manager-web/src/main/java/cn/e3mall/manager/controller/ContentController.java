package cn.e3mall.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.content.service.ContentService;
import cn.e3mall.pojo.TbContent;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

@Controller
public class ContentController {
	
	//注入内容服务对象
	//1,依赖内容服务接口
	//2,dubbo引入内容服务
	@Autowired
	private ContentService contentService;
	
	/**
	 * 需求:根据分类id查询内容数据
	 * 请求:/content/query/list
	 * 参数:Long categoryId
	 * 返回值:PageBeanResult
	 * 分页查询:
	 * 1,配置分页插件
	 * 2,设置分页查询当前页,每页显示的条数
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public PageBeanResult findContentByCategoryId(Long categoryId,
			@RequestParam(defaultValue="1") Integer page,
			@RequestParam(defaultValue="10") Integer rows){
		//调用远程service服务方法,查询内容数据
		PageBeanResult result = contentService.findContentByCategoryId(categoryId, page, rows);
		return result;
	}
	
	/**
	 * 需求:保存内容数据
	 * 请求:/content/save
	 * 参数:TbContent content
	 * 返回值:json格式E3mallResult
	 */
	@RequestMapping("/content/save")
	@ResponseBody
	public E3mallResult saveContent(TbContent content){
		//调用远程service服务,保存内容数据
		E3mallResult result = contentService.saveContent(content);
		return result;
	}

}
