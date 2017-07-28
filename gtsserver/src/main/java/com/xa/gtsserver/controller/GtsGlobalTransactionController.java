package com.xa.gtsserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xa.gtsserver.enums.ErrorCode;
import com.xa.gtsserver.request.GlobalTransactionRequest;
import com.xa.gtsserver.response.DataResponse;
import com.xa.gtsserver.service.GtsGlobalService;

@RestController
@RequestMapping("/gts/global")
public class GtsGlobalTransactionController {
	
	@Autowired
	private GtsGlobalService gtsGlobalService;

	@RequestMapping(value = "/registertransaction",method = RequestMethod.POST)
	public DataResponse<Boolean> registGlobalTransaction(GlobalTransactionRequest request){
		boolean flag = gtsGlobalService.registGlobalTransaction(request);
		DataResponse<Boolean> dataResponse = DataResponse.build();
		dataResponse.setRetcode(ErrorCode.OK.getCode())
					.setMsg(ErrorCode.OK.getMsg())
					.setData(flag);
		return dataResponse;
		
	}
	
	@RequestMapping(value = "/subimttransaction",method = RequestMethod.POST)
	public DataResponse<Boolean> sumbitGlobalTransaction(GlobalTransactionRequest request){
		boolean flag = gtsGlobalService.sumbitGlobalTransaction(request);
		DataResponse<Boolean> dataResponse = DataResponse.build();
		dataResponse.setRetcode(ErrorCode.OK.getCode())
					.setMsg(ErrorCode.OK.getMsg())
					.setData(flag);
		return dataResponse;
		
	}
}
