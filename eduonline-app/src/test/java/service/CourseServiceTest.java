package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eduonline.service.CourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class CourseServiceTest {

	@Resource
	private CourseService courseService;
	
	@Test
	public void queryCourseListByPageTest() throws Exception {
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		courseList = courseService.queryCourseListByPage(0, 6);
		
		for (Map<String, Object> m : courseList)  
	    {  
	      for (String k : m.keySet())  
	      {  
	        System.out.println(k + " : " + m.get(k));  
	      }  
	  
	    }  
	}
	
}
