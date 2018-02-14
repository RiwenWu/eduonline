package com.wrw.eduonline.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.wrw.eduonline.entity.Course;
import com.wrw.eduonline.entity.Course_Sort;
import com.wrw.eduonline.entity.Cover;
import com.wrw.eduonline.entity.Sort;
import com.wrw.eduonline.entity.dto.SortDTO;
import com.wrw.eduonline.service.CourseService;
import com.wrw.eduonline.service.CourseSortService;
import com.wrw.eduonline.service.CoverService;
import com.wrw.eduonline.service.SortService;

@Controller
@RequestMapping("/video/addCourse")
public class addCourseController {

	@Autowired
	private CourseService courseService;
	@Autowired
	private SortService sortService;
	@Autowired
	private CoverService coverService;
	@Autowired
	private CourseSortService courseSortService;
	
	/**
	 * 保存课程封面
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cover_save.json", method = RequestMethod.POST)
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
	         //id存到session中
	         request.getSession().setAttribute("CoverId", cover.getId());
	         } catch (Exception e) {
	        	 e.printStackTrace();
	         }
	         map.put("code", 0);
	    } else {//图片不存在
	    	map.put("code", 1);
	    }
		return map;
	}
	
	/**
	 * 根据type返回对应的列表
	 * @param type
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/querySortList.json")
	public Map<String, Object> querySortListByType(@RequestParam(defaultValue = "0") String type) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("bool", false);
		List<SortDTO> sortDTOList = new ArrayList<SortDTO>();
		try {
			sortDTOList = sortService.queryAll(" ", type);
			map.put("bool", true);
			map.put("list", sortDTOList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据PId获取分类列表
	 * @param Pid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/querySortListByPId.json")
	public Map<String, Object> querySortListByPId(long Pid) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<Sort> sortList = new ArrayList<Sort>();
		map.put("bool", false);
		
		try {
			sortList = sortService.querySortListByPId(Pid);
			map.put("list", sortList);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "/addCourse.json")
	public Map<String, Object> addCourse(HttpServletRequest request, HttpServletResponse response,
			String courseName, String freeState, String courseIntroduce, long sortId) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		Course course = new Course();
		Course_Sort cs = new Course_Sort();
		
		map.put("bool", false);
		//判断是否上传封面
		if (request.getSession().getAttribute("CoverId").equals(null)) {
			map.put("msg", "请上传课程封面");
		}
		//从session中获取封面的Id
		Long coverId = (Long) request.getSession().getAttribute("CoverId");
		
		//构建course对象内容
		course.setName(courseName);
		course.setFreeState(freeState);
		course.setCoverId(coverId);
		course.setIntroduce(courseIntroduce);
		//构建courseSort对象内容
		cs.setSortId(sortId);
		
		try {
			//course入库
			courseService.insertSelective(course);
			//course_sort入库
			cs.setCourseId(course.getId());
			courseSortService.insertSelective(cs);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return map;
	}
}
