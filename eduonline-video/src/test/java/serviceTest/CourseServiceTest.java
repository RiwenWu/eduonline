package serviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrw.eduonline.entity.Video;
import com.wrw.eduonline.service.CourseService;
import com.wrw.eduonline.service.VideoService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
public class CourseServiceTest {

	@Resource
	private CourseService courseService;
	@Resource
	private VideoService videoService;
	
	@Test
	public void queryCourselistByPageTest() throws Exception {
		List<Map<String, Object>> courseList = courseService.queryCourselistByPage(2, 12, null);
		for(Map<String, Object> map : courseList) {
			for(String key : map.keySet()) {
				System.out.println("key = " + key + " ,value = " + map.get(key));
			}
		}
		System.out.println(courseList.size());
	}
	
	@Test
	public void queryCourseByIdTest() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map = courseService.queryCourseById(15L);
		for(String key : map.keySet()) {
			System.out.println("key = " + key + " ,value = " + map.get(key));
		}
	}
	
	@Test
	public void queryVideoListByCourseIdTest() throws Exception {
		List<Map<String, Object>> videoList = videoService.queryVideoListByCourseId(15L);
		for(Map<String, Object> map : videoList) {
			for(String key : map.keySet()) {
				System.out.println("key = " + key + " ,value = " + map.get(key));
			}
		}
		System.out.println(videoList.size());
	}
}
