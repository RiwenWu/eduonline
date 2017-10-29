package com.wrw.eduonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**   
 *    
 * 项目名称：eduonline-web   
 * 类名称：SysPageController   
 * 类描述：系统页面视图
 * 创建人：wrw   
 * 创建时间：2017年10月29日 下午7:55:46   
 * @version        
 */
@Controller
public class SysPageController {
	
	@RequestMapping("{module}/{url}.flt")
	public String page(@PathVariable("module") String module, @PathVariable("url") String url) {
		return module + "/" +url + ".flt";
	}
}
