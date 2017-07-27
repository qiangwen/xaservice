package com.xa.gtsorderserver.factory;

import java.math.BigDecimal;
import java.util.Random;

import com.xa.gtsorderserver.domain.Order;

/**
 * 订单工厂类
 * @author qiang.wen
 * @date 2017年7月26日 上午10:52:56
 */
public class OrderFactory {
	
	private static final Random random = new Random();

	private OrderFactory(){}
	
	public static OrderFactory getInstance(){
		return new OrderFactory();
	}
	
	public Order buildOrder(){
		Order order = new Order();
		order.setId(random.nextInt(10));
		order.setOrderMoney(new BigDecimal("10").multiply(new BigDecimal(order.getId())));
		order.setOrderUserId(random.nextInt(100));
		order.setProjectId(random.nextInt(200));
		return order;
	}
}
