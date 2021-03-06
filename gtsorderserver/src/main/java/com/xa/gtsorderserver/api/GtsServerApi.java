package com.xa.gtsorderserver.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xa.gtsorderserver.request.gtsserver.AppTransactionRequest;
import com.xa.gtsorderserver.request.gtsserver.GlobalTransactionRequest;
import com.xa.gtsorderserver.response.DataResponse;

@FeignClient(value="gtsserver")
public interface GtsServerApi {

	//注册全局事务
	@RequestMapping(value = "/gts/global/registertransaction",method = RequestMethod.POST)
	public DataResponse<Boolean> registGlobalTransaction(@RequestBody GlobalTransactionRequest request);
	
	//提交全局事务
	@RequestMapping(value = "/gts/global/subimttransaction",method = RequestMethod.POST)
	public DataResponse<Boolean> sumbitGlobalTransaction(@RequestBody GlobalTransactionRequest request);
	
	//注册各应用事务加入到全局事务
	@RequestMapping(value = "/gts/app/registertransaction",method = RequestMethod.POST)
	public DataResponse<Boolean> registerAppTransaction(@RequestBody AppTransactionRequest request);
}
