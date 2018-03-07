package service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eduonline.service.UserOwnCoursesService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class UserOwnCoursesServiceTest {

	@Resource
	private UserOwnCoursesService userOwnCoursesService;
	
	@Test
	public void markUserCourseTest() {
		String courseIds = "13,14";
		userOwnCoursesService.markUserCourse(13L, courseIds);
		
	}
	
	@Test
	public void findUserIsOwnTest() {
		userOwnCoursesService.findUserIsOwn(14L, "26");
	}
	
}
