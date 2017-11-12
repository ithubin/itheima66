package cn.e3mall.content.service;

import java.util.List;

import cn.e3mall.pojo.TbContent;
import cn.e3mall.utils.ADItem;
import cn.e3mall.utils.E3mallResult;
import cn.e3mall.utils.PageBeanResult;

public interface ContentService {

	
	/**
	 * 需求:根据分类id查询内容数据
	 * 参数:Long categoryId
	 * 返回值:PageBeanResult
	 */
	public PageBeanResult findContentByCategoryId(Long categoryId,Integer page,Integer rows);
	/**
	 * 需求:保存内容数据
	 * 参数:TbContent content
	 * 返回值:E3mallResult
	 */
	public E3mallResult saveContent(TbContent content);
	/**
	 * 需求:根据分类id查询内容表数据(广告数据根据区域id进行分类维护,查询)
	 * 参数:Long categoryId
	 * 返回值:List<ADitem>
	 * 
	 */
	public List<ADItem> findContentWithADItemByCategoyId(Long categoryId);
}
