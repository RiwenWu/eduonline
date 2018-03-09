package com.wrw.eduonline.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.wrw.eduonline.entity.Course;
import com.wrw.eduonline.entity.CourseVideo;
import com.wrw.eduonline.entity.OfflineCourse;
import com.wrw.eduonline.entity.Video;
import com.wrw.eduonline.service.CourseService;
import com.wrw.eduonline.service.CourseVideoService;
import com.wrw.eduonline.service.OfflineCourseService;
import com.wrw.eduonline.service.SortService;
import com.wrw.eduonline.service.VideoService;

@Controller
@RequestMapping("/video/courseManage")
public class courseManage {

	@Autowired
	private CourseService courseService;
	@Autowired
	private SortService sortService;
	@Autowired
	private VideoService videoService;
	@Autowired
	private CourseVideoService courseVideoService;
	@Autowired
	private OfflineCourseService offlineCourseService;
	
	/**
	 * 根据commendState / inputValue获取courseList
	 * @param commendState
	 * @param inputValue
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListBycommendState.json")
	public Map<String, Object> queryCourseListBycommendState(
			String commendState, @RequestParam(value = "inputValue", required = false) String inputValue,
			Integer page, Integer limit){
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> courseList = new ArrayList();
		map.put("bool", false);
		try {
			courseList = courseService.queryCourseListBycommendState(commendState, inputValue);
			map.put("code", 0);
			map.put("msg", "更新");
			map.put("data", courseList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 修改推荐状态
	 * @param record
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/changeCommendState.json")
	public Map<String, Object> updateByPrimaryKeySelective(String courseId, String commendState){
		Map<String, Object> map = new HashMap<String, Object>();
		Course course = new Course();
		map.put("bool", false);
		Long cId = Long.parseLong(courseId);
		course.setId(cId);
		course.setCommendState(commendState);
		try {
			courseService.updateByPrimaryKeySelective(course);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 根据page获取courseList
	 * @param pageNo
	 * @param pageSize
	 * @param inputValue
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseListByPage.json")
	public Map<String, Object> queryCourseListByPage(Integer pageNo, Integer pageSize, @RequestParam(value = "inputValue", required = false)String inputValue){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		map.put("bool", false);
		try {
			courseList = courseService.queryCourselistByPage(pageNo, pageSize, inputValue);
			int sumNum = courseService.queryCourselistByInputValue(inputValue).size();
			map.put("courseList", courseList);
			map.put("totalPage", sumNum % pageSize == 0 ? sumNum / pageSize : sumNum / pageSize +1);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 打开课程详细页面
	 * @param request
	 * @param response
	 * @param courseId
	 * @return
	 */
	@RequestMapping(value = "/courseDetail.htm")
	public ModelAndView personalDatauserInfo(HttpServletRequest request, HttpServletResponse response, String courseId) {
		ModelAndView mv = new ModelAndView("/video/courseDetail.flt");
		Long cId = Long.parseLong(courseId);
		Map<String, Object> course = new HashMap<String, Object>();
		Map<String, Object> offlineCourse = new HashMap<String, Object>();
		try {
			course = courseService.queryCourseById(cId);
			mv.addObject("Course", course);
			offlineCourse = offlineCourseService.queryOfflineCourseByCourseId(cId);
			mv.addObject("OfflineCourse", offlineCourse);
		} catch(Exception e) {
			
		}
		return mv;
	}
	
	/**
	 * 根据courseId获取课程列表
	 * @param courseId
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/queryCourseById.json")
	public Map<String, Object> queryCourseById(String courseId, Integer page, Integer limit){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		Long cId = Long.parseLong(courseId);
		List<Map<String, Object>> videoList = new ArrayList<Map<String, Object>>();
		try {
			videoList = videoService.queryVideoListByCourseId(cId);
			map.put("bool", true);
			map.put("data", videoList);
			map.put("msg", "更新");
			map.put("code", 0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 保存视频
	 * 
	 * @param file
	 * @return
	 * @throws IOException
	 * @throws IllegalStateException
	 */
	@ResponseBody
	@RequestMapping(value = "/videoSaveAgain.json")
	public Map<String, Object> videoSaveAgain(HttpServletRequest request, HttpServletResponse response, MultipartFile file, String courseId)
			throws IllegalStateException, IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		Video video = new Video();
		CourseVideo cv = new CourseVideo();

		Long cId = Long.parseLong(courseId);

		if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
			// 图片服务器路径
			String file_path = request.getSession().getServletContext().getRealPath("");
			// 原始文件名
			String originalFileName = file.getOriginalFilename();
			// 新文件名，添加原始文件名后缀
			String oldFileName = originalFileName.substring(0, originalFileName.lastIndexOf("."));
			String newFileName = "statics/videos/" + UUID.randomUUID()
					+ originalFileName.substring(originalFileName.lastIndexOf("."));
			// 创建新文件，路径为：图片服务器路径+新文件名
			File newFile = new File(file_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
			// 将新文件名写入中
			video.setPath(newFileName);
			video.setTitle(oldFileName);
			// 存数据库
			try {
				// Video入库
				videoService.insertSelective(video);
				System.out.println(video.getId());
				// video的Id放入session
				request.getSession().setAttribute("VideoId", video.getId());
				cv.setVideoId(video.getId());
				cv.setCourseId(cId);
				// cv入库
				courseVideoService.insertSelective(cv);

				map.put("code", 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	
	/**
	 * 根据videoId改变state
	 * @param videoId
	 * @param state
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateVideoStateById.json")
	public Map<String, Object> updateVideoStateById(String videoId, String state){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		Long vId = Long.parseLong(videoId);
		Video video = new Video();
		video.setId(vId);
		video.setState(state);
		try {
			videoService.updateVideoStateById(video);
			map.put("bool", true);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 发起线下课程
	 * 
	 * @param title
	 * @param startAndEnd
	 * @param place
	 * @param detail
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/addOffLineCourseAgain.json")
	public Map<String, Object> addOffLineCourseAgain(HttpServletRequest request, HttpServletResponse response, String courseId, String title,
			String startAndEnd, String place, String detail) throws ParseException {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		OfflineCourse offlineCourse = new OfflineCourse();
		Course course = new Course();
		Long cId = Long.parseLong(courseId);
		if (courseId.equals(null)) {
			map.put("msg", "看日志出了什么出");
			return map;
		}

		// 日期转化
		SimpleDateFormat temp_date = new SimpleDateFormat("yyyy/MM/dd");
		// 初始化
		offlineCourse.setTitle(title);
		offlineCourse.setPlace(place);
		offlineCourse.setDetail(detail);
		offlineCourse.setStartTime(temp_date.parse(startAndEnd.substring(0, startAndEnd.indexOf("~"))));
		offlineCourse.setEndTime(temp_date.parse(startAndEnd.substring((startAndEnd.indexOf("~") + 2))));

		try {
			offlineCourseService.insertSelective(offlineCourse);
			map.put("bool", true);
			//course 添加offlineCourseId 外键
			course.setId(cId);
			course.setOfflinecourseId(offlineCourse.getId());
			courseService.updateByPrimaryKeySelective(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 发起线下课程
	 * 
	 * @param title
	 * @param startAndEnd
	 * @param place
	 * @param detail
	 * @return
	 * @throws ParseException
	 */
	@ResponseBody
	@RequestMapping(value = "/updateOfflineCourse.json")
	public Map<String, Object> updateOfflineCourse(HttpServletRequest request, HttpServletResponse response, String OfflineCourseId, String title,
			String startAndEnd, String place, String detail) throws ParseException {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		System.out.println(startAndEnd);
		Long oId = Long.parseLong(OfflineCourseId);
		OfflineCourse offlineCourse = new OfflineCourse();

		// 日期转化
		SimpleDateFormat temp_date = new SimpleDateFormat("yyyy/MM/dd");
		// 初始化
		offlineCourse.setId(oId);
		offlineCourse.setTitle(title);
		offlineCourse.setPlace(place);
		offlineCourse.setDetail(detail);
		offlineCourse.setStartTime(temp_date.parse(startAndEnd.substring(0, startAndEnd.indexOf("~"))));
		offlineCourse.setEndTime(temp_date.parse(startAndEnd.substring((startAndEnd.indexOf("~") + 2))));

		try {
			offlineCourseService.updateByPrimaryKeySelective(offlineCourse);
			map.put("bool", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
