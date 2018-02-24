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

import com.eduonline.model.UserCollection;
import com.eduonline.service.UserCollectionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class UserCollectionServiceTest {

	@Resource
	private UserCollectionService userCollectionService;
	
	@Test
	public void queryUserCouseByIdsTest() throws Exception {
		UserCollection uc = userCollectionService.queryUserCouseByIds(13L, 13L);
		
	}
	
	@Test
	public void queryCourseListByUserIdTest() throws Exception {
		List<Map<String, Object>> courseList = new ArrayList<Map<String, Object>>();
		courseList = userCollectionService.queryCourseListByUserId(13L);
		for (Map<String, Object> map : courseList) {
			for (String key : map.keySet()) {
				System.out.println("key = " + key + " ,value = " + map.get(key));
			}
		}
	}
}
