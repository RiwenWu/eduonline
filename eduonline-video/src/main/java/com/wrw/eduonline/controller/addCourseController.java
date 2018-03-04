package com.wrw.eduonline.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wrw.eduonline.entity.Course;
import com.wrw.eduonline.entity.CourseVideo;
import com.wrw.eduonline.entity.Course_Sort;
import com.wrw.eduonline.entity.Cover;
import com.wrw.eduonline.entity.OfflineCourse;
import com.wrw.eduonline.entity.Sort;
import com.wrw.eduonline.entity.Video;
import com.wrw.eduonline.entity.dto.SortDTO;
import com.wrw.eduonline.service.CourseService;
import com.wrw.eduonline.service.CourseSortService;
import com.wrw.eduonline.service.CourseVideoService;
import com.wrw.eduonline.service.CoverService;
import com.wrw.eduonline.service.OfflineCourseService;
import com.wrw.eduonline.service.SortService;
import com.wrw.eduonline.service.VideoService;

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
	@Autowired
	private VideoService videoService;
	@Autowired
	private CourseVideoService courseVideoService;
	@Autowired
	private OfflineCourseService offlineCourseService;

	/**
	 * 保存课程封面
	 * 
	 * @param bindingResult
	 * @param redirectAttributes
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/cover_save.json", method = RequestMethod.POST)
	public Map<String, Object> saveCover(HttpServletRequest request, Cover cover, MultipartFile file) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		if (file != null && file.getOriginalFilename() != null && file.getOriginalFilename().length() > 0) {
			// 图片服务器路径
			String file_path = request.getSession().getServletContext().getRealPath("");
			// 原始文件名
			String originalFileName = file.getOriginalFilename();
			// 新文件名，添加原始文件名后缀
			String newFileName = "statics/images/" + UUID.randomUUID()
					+ originalFileName.substring(originalFileName.lastIndexOf("."));
			// 创建新文件，路径为：图片服务器路径+新文件名
			File newFile = new File(file_path + newFileName);
			// 将内存中的数据写入磁盘
			file.transferTo(newFile);
			// 将新文件名写入Cover中
			cover.setPicurl(newFileName);
			// 存数据库
			try {
				coverService.insertSelective(cover);
				// id存到session中
				request.getSession().setAttribute("CoverId", cover.getId());
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("code", 0);
		} else {// 图片不存在
			map.put("code", 1);
		}
		return map;
	}

	/**
	 * 根据type返回对应的列表
	 * 
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
	 * 
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@ResponseBody
	@RequestMapping(value = "/addCourse.json")
	public Map<String, Object> addCourse(HttpServletRequest request, HttpServletResponse response, String courseName,
			String freeState, String courseIntroduce, long sortId,
			@RequestParam(value = "salary", required = false) String salary) {

		Map<String, Object> map = new HashMap<String, Object>();
		Course course = new Course();
		Course_Sort cs = new Course_Sort();

		map.put("bool", false);
		// 判断是否上传封面
		if (request.getSession().getAttribute("CoverId") == null
				|| request.getSession().getAttribute("CoverId") == "") {
			map.put("msg", "请上传课程封面");
			return map;
		}
		// 从session中获取封面的Id
		Long coverId = (Long) request.getSession().getAttribute("CoverId");

		// 构建course对象内容
		course.setName(courseName);
		course.setFreeState(freeState);
		course.setCoverId(coverId);
		course.setIntroduce(courseIntroduce);
		if (salary != null) {
			course.setSalary(new BigDecimal(salary));
		}
		// 构建courseSort对象内容
		cs.setSortId(sortId);

		try {
			// course入库
			courseService.insertSelective(course);
			// course的Id放入session中
			request.getSession().setAttribute("CourseId", course.getId());
			// course_sort入库
			cs.setCourseId(course.getId());
			courseSortService.insertSelective(cs);
			map.put("bool", true);
		} catch (Exception e) {
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
	@RequestMapping(value = "/video_save.json")
	public Map<String, Object> videoSave(HttpServletRequest request, HttpServletResponse response, MultipartFile file)
			throws IllegalStateException, IOException {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 1);
		Video video = new Video();
		CourseVideo cv = new CourseVideo();

		// 从session中获取course的Id
		Long courseId = (Long) request.getSession().getAttribute("CourseId");
		if (courseId.equals(null)) {
			return map;
		}

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
				// video的Id放入session
				request.getSession().setAttribute("VideoId", video.getId());
				cv.setVideoId(video.getId());
				cv.setCourseId(courseId);
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
	 * 设置章节名称
	 * 
	 * @param request
	 * @param response
	 * @param videoName
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/video_name_save.json")
	public Map<String, Object> videoNameSave(HttpServletRequest request, HttpServletResponse response,
			String videoName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		Video video = new Video();

		// 从session中获取course的Id
		Long videoId = (Long) request.getSession().getAttribute("VideoId");
		if (videoId.equals(null)) {
			return map;
		}

		try {
			video.setId(videoId);
			video.setTitle(videoName);
			videoService.updateByPrimaryKeySelective(video);
			map.put("bool", true);
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
	@RequestMapping(value = "/addOffLineCourse.json")
	public Map<String, Object> addOffLineCourse(HttpServletRequest request, HttpServletResponse response, String title,
			String startAndEnd, String place, String detail) throws ParseException {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bool", false);
		OfflineCourse offlineCourse = new OfflineCourse();
		Course course = new Course();
		// 从session中获取course的Id
		Long courseId = (Long) request.getSession().getAttribute("CourseId");
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
			course.setId(courseId);
			course.setOfflinecourseId(offlineCourse.getId());
			courseService.updateByPrimaryKeySelective(course);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
