package com.xa.gtsaccountserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xa.gtsaccountserver.enums.ErrorCode;
import com.xa.gtsaccountserver.response.DataResponse;
import com.xa.gtsaccountserver.service.AccountXaService;

@RestController
@RequestMapping("/accountserver/xa")
public class XaController {
	
	@Autowired
	private AccountXaService accountXaService;

	/**
	 * 提交事务
	 * @param appXid
	 * @return
	 * @author qiang.wen
	 * @throws Exception 
	 * @date 2017年7月28日 下午2:31:06
	 */
	@RequestMapping(value="/submittransaction",method=RequestMethod.POST)
	public DataResponse<Boolean> submitTransaction(@RequestParam("appXid") String appXid) throws Exception{
		boolean flag = accountXaService.submitTransaction(appXid);
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
	@RequestMapping(value = "/rollbacktransaction",method=RequestMethod.POST)
	public DataResponse<Boolean> rollbackTransaction(@RequestParam("appXid") String appXid) throws Exception{
		boolean flag = accountXaService.rollbackTransaction(appXid);
		DataResponse<Boolean> dataResponse = DataResponse.build();
		dataResponse.setRetcode(ErrorCode.OK.getCode())
					.setMsg(ErrorCode.OK.getMsg())
					.setData(flag);
		return dataResponse;
	}
}
