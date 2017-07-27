package com.xa.gtsaccountserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xa.gtsaccountserver.enums.ErrorCode;
import com.xa.gtsaccountserver.request.AccountParam;
import com.xa.gtsaccountserver.response.DataResponse;
import com.xa.gtsaccountserver.service.AccountService;

@RestController
@RequestMapping("/xa/account")
public class AccountController {
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/updateaccount",method=RequestMethod.POST)
	public DataResponse<Integer> updateAccount(@RequestBody AccountParam accountParam) throws Exception{
		int flag = accountService.updateAccount(accountParam);
		DataResponse<Integer> dataResponse = DataResponse.build();
		dataResponse.setRetcode(ErrorCode.OK.getCode())
					.setMsg(ErrorCode.OK.getMsg())
					.setData(flag);
		return dataResponse;
	}
}
