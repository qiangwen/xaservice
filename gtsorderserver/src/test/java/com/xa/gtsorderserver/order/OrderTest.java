package com.xa.gtsorderserver.order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xa.gtsorderserver.bootstrap.GTSOrderServerApplication;
import com.xa.gtsorderserver.domain.Order;
import com.xa.gtsorderserver.factory.OrderFactory;
import com.xa.gtsorderserver.mapper.OrderMapper;
import com.xa.gtsorderserver.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=GTSOrderServerApplication.class)
public class OrderTest {

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired
	private OrderService orderService;
	
	@Test
	public void testAddOrder(){
		
		OrderFactory factory = OrderFactory.getInstance();
		Order order = factory.buildOrder();
		orderMapper.insertOrder(order);
		
	}
	
	@Test
	public void purchaseOrder() throws Exception{
		orderService.purchaseOrder();
	}
}
