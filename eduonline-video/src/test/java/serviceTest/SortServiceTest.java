package serviceTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wrw.eduonline.entity.Sort;
import com.wrw.eduonline.service.SortService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
@Rollback
public class SortServiceTest {

	@Resource
	private SortService sortService;
	
	@Test
	public void queryAllTest() throws Exception {
		List<Sort> sortList = new ArrayList();
		sortList = sortService.queryAll();
		Map<Long, String> yijicaidan= new HashMap<Long, String>();
		Map<Long, String> erjicaidan= new HashMap<Long, String>();
		for(Sort sort : sortList) {
			if (sort.getType().equals("0")) {
				yijicaidan.put(sort.getId(), " 0-----------" + sort.getName());
				System.out.println("0-----------" + sort.getName());
			}
			if (sort.getType().equals("1")) {
				erjicaidan.put(sort.getId(), " 1-----------" + sort.getName() + yijicaidan.get(sort.getParentId()));
				System.out.println("1-----------" + sort.getName() + yijicaidan.get(sort.getParentId()));
			}
			if (sort.getType().equals("2")) {
				System.out.println("2-----------" + sort.getName() + erjicaidan.get(sort.getParentId()));
			}
		}
	}
}
