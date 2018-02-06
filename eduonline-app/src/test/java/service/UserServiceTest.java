package service;

import static org.junit.Assert.*;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eduonline.model.User;
import com.eduonline.service.UserService;

/**   
 *    
 * 项目名称：eduonline-app   
 * 类名称：UserServiceTest   
 * 类描述：   
 * 创建人：wrw   
 * 创建时间：2018年2月3日 下午9:47:54   
 * @version        
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class UserServiceTest {

	@Resource
	private UserService userService;
	
	@Test
	public void insertSelectiveTest() throws Exception {
		User user = new User();
		user.setAccount("wrw");
		user.setPassword("249991189");
		userService.insertSelective(user);
	}
	
	@Test
	public void selsectByAccountTest() throws Exception {
		User user = userService.selsectByAccount("wrw");
		assertNotNull(user);
	}
}
