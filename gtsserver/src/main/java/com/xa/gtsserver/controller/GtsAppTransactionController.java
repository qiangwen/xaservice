package com.xa.gtsserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xa.gtsserver.enums.ErrorCode;
import com.xa.gtsserver.request.AppTransactionRequest;
import com.xa.gtsserver.response.DataResponse;
import com.xa.gtsserver.service.GtsAppService;

@RestController
@RequestMapping("/gts/app")
public class GtsAppTransactionController {

	@Autowired
	private GtsAppService gtsAppService;
	
	
	@RequestMapping("/registertransaction")
	public DataResponse<Boolean> registerAppTransaction(AppTransactionRequest request){
		boolean flag = gtsAppService.registerAppTransaction(request);
		DataResponse<Boolean> dataResponse = DataResponse.build();
		dataResponse.setRetcode(ErrorCode.OK.getCode())
					.setMsg(ErrorCode.OK.getMsg())
					.setData(flag);
		return dataResponse;
		
	}
}
