package com.xa.gtsorderserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xa.gtsorderserver.enums.ErrorCode;
import com.xa.gtsorderserver.service.OrderService;

@RestController
@RequestMapping("/xa/order")
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping(value ="buyorder",method=RequestMethod.POST)
	public String purchaseOrder() throws Exception{
		orderService.purchaseOrder();
		return ErrorCode.OK.getMsg();
	}
}
