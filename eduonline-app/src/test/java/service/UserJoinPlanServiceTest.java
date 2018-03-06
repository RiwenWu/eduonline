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

import com.eduonline.service.UserJoinPlanService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class UserJoinPlanServiceTest {

	@Resource
	private UserJoinPlanService userJoinPlanService;
	
	@Test
	public void queryJoinListByuIdTest() throws Exception {
		List<Map<String, Object>> joinCourseList = new ArrayList<Map<String, Object>>();
		joinCourseList = userJoinPlanService.queryJoinListByuId(13L);
		for(Map<String, Object> map : joinCourseList) {
			for (String k : map.keySet()) {
				System.out.println("key = " + k + " ,value = " + map.get(k));
			}
		}
	}
	
	@Test
	public void queryClockByuserIdTest() throws Exception {
		List<Map<String, Object>> joinCourseList = new ArrayList<Map<String, Object>>();
		joinCourseList = userJoinPlanService.queryClockByuserId(14L);
		for(Map<String, Object> map : joinCourseList) {
			for (String k : map.keySet()) {
				System.out.println("key = " + k + " ,value = " + map.get(k));
			}
		}
	}
}
