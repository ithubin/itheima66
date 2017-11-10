package cn.e3mall.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	
	/**
	 * 需求:跳转门户系统首页
	 */
	@RequestMapping("index")
	public String showIndex(){
		return "index";
	}

}
