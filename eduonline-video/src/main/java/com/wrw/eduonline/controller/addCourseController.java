package com.wrw.eduonline.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wrw.eduonline.entity.Cover;
import com.wrw.eduonline.service.CoverService;
import com.wrw.eduonline.service.SortService;

@Controller
@RequestMapping("/video/addCourse")
public class addCourseController {

	@Autowired
	private SortService sortService;
	@Autowired
	private CoverService coverService;
	
	/**
	 * 保存课程封面
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cover_save", method = RequestMethod.POST)
	public Map<String, Object> saveCover(HttpServletRequest request, Cover cover, BindingResult bindingResult, MultipartFile file,
			RedirectAttributes redirectAttributes) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length()>0){  
	         //图片服务器路径  
	         String file_path = request.getSession().getServletContext().getRealPath("");
	          //原始文件名  
	         String originalFileName = file.getOriginalFilename();  
	         //新文件名，添加原始文件名后缀  
	         String newFileName = "statics/images/" + UUID.randomUUID() + originalFileName.substring(originalFileName.lastIndexOf("."));  
	         //创建新文件，路径为：图片服务器路径+新文件名  
	         File newFile = new File(file_path + newFileName);  
	         //将内存中的数据写入磁盘  
	         file.transferTo(newFile);  
	         //将新文件名写入Cover中  
	         cover.setPicurl(newFileName);
	         //存数据库
	         try {
	         coverService.insertSelective(cover);
	         } catch (Exception e) {
	        	 e.printStackTrace();
	         }
	         System.out.println(cover.getId());
	         map.put("code", 0);
	    } else {//图片不存在
	    	map.put("code", 1);
	    }
		return map;
	}
}
