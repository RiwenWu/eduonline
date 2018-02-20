package service;

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
}
