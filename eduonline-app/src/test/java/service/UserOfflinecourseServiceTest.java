package service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eduonline.service.UserOfflinecourseService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class UserOfflinecourseServiceTest {

	@Resource
	private UserOfflinecourseService userOfflinecourseService;
	
	@Test
	public void queryOfflineCourseListByuserIdTest() throws Exception {
		List<Map<Object, Object>> offlineCourseList = new ArrayList<Map<Object, Object>>();
		offlineCourseList = userOfflinecourseService.queryOfflineCourseListByuserId(14L);
		for(Map<Object, Object> map : offlineCourseList) {
			for(Object o : map.keySet()) {
				System.out.println("Key = " + o.toString() + " ,value = " + map.get(o));
			}
		}
	}
	

}
