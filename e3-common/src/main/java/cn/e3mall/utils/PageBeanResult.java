package cn.e3mall.utils;

import java.io.Serializable;
import java.util.List;

public class PageBeanResult implements Serializable{
	
	//总记录
	private Long total;
	
	private List<?> rows;

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
	
	

}
