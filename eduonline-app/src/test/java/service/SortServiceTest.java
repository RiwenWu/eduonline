package service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eduonline.model.Sort;
import com.eduonline.service.SortService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class SortServiceTest {
	
	@Resource
	private SortService sortService;

	@Test
	public void insertSelective() throws Exception {
		/*
		Sort sort = new Sort();
		sort.setName("常用工具");
		sort.setParentId((long)2);
		sort.setType("1");
		sortService.insertSelective(sort);
		*/
		String[] title = {"知识管理","习惯养成","演讲与口才","个人品牌","思维方式"};
		Sort sort = new Sort();
		for(int i = 0 ;i < title.length; i++) {
			sort.setName(title[i]);
			sort.setParentId((long)20);
			sort.setType("2");
			sortService.insertSelective(sort);
		}
		
	}
}
