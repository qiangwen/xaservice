package com.xa.gtsorderserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xa.gtsorderserver.enums.ErrorCode;
import com.xa.gtsorderserver.response.DataResponse;
import com.xa.gtsorderserver.service.OrderXaService;

@RestController
@RequestMapping("/orderserver/xa")
public class XaController {

	@Autowired
	private OrderXaService orderXaService;
	
	/**
	 * 提交事务
	 * @param appXid
	 * @return
	 * @author qiang.wen
	 * @throws Exception 
	 * @date 2017年7月28日 下午2:31:06
	 */
	@RequestMapping("/submittransaction")
	public DataResponse<Boolean> submitTransaction(@RequestParam("appXid") String appXid) throws Exception{
		boolean flag = orderXaService.submitTransaction(appXid);
		DataResponse<Boolean> dataResponse = DataResponse.build();
		dataResponse.setRetcode(ErrorCode.OK.getCode())
					.setMsg(ErrorCode.OK.getMsg())
					.setData(flag);
		return dataResponse;
	}
	
	/**
	 * 回滚事务
	 * @param appXid
	 * @return
	 * @throws Exception
	 * @author qiang.wen
	 * @date 2017年7月28日 下午2:39:42
	 */
	@RequestMapping("/rollbacktransaction")
	public DataResponse<Boolean> rollbackTransaction(@RequestParam("appXid") String appXid) throws Exception{
		boolean flag = orderXaService.rollbackTransaction(appXid);
		DataResponse<Boolean> dataResponse = DataResponse.build();
		dataResponse.setRetcode(ErrorCode.OK.getCode())
					.setMsg(ErrorCode.OK.getMsg())
					.setData(flag);
		return dataResponse;
	}
}
