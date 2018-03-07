package service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eduonline.model.Order;
import com.eduonline.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-applicationContext.xml")
public class OrderServiceTest {

	@Resource
	private OrderService orderService;
	
	@Test
	public void queryOrderListByuserIdTest() throws Exception {
		List<Order> orderList = orderService.queryOrderListByuserId(13L, null);
		for(Order order : orderList) {
			System.out.println(order.getOrderno());
		}
	}
	
	@Test
	public void queryCourseListByorderIdTest() throws Exception {
		List<Map<String, Object>> courseList = orderService.queryCourseListByorderId(4L);
		for(Map<String, Object> map : courseList) {
			for(Object o : map.keySet()) {
				System.out.println("key = " + o.toString() + " ,value = " + map.get(o));
			}
		}
	}
	
}
