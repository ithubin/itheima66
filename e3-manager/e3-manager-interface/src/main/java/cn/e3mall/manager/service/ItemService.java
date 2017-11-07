package cn.e3mall.manager.service;

import cn.e3mall.pojo.TbItem;
import cn.e3mall.utils.PageBeanResult;

public interface ItemService {
	/**
	 * 需求:根据id查询商品数据
	 * 参数: Long itemId
	 * 返回值:TbItem
	 */
	public TbItem findItemById(Long itemId);
	/**
	 * 需求:分页查询商品列表
	 * 参数:Integer page,Integer rows
	 * 返回值:PageBeanResult
	 */
	public PageBeanResult findItemByPage(Integer page,Integer rows);
}
