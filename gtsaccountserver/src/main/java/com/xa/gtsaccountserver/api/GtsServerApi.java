package com.xa.gtsaccountserver.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xa.gtsaccountserver.request.gtsserver.AppTransactionRequest;
import com.xa.gtsaccountserver.request.gtsserver.GlobalTransactionRequest;
import com.xa.gtsaccountserver.response.DataResponse;

@FeignClient(value="gtsserver")
public interface GtsServerApi {

	//注册全局事务
	@RequestMapping(value = "/gts/global/registertransaction",method = RequestMethod.POST)
	public DataResponse<Boolean> registGlobalTransaction(GlobalTransactionRequest request);
	
	//注册各应用事务加入到全局事务
	@RequestMapping(value = "/gts/app/registertransaction",method = RequestMethod.POST)
	public DataResponse<Boolean> registerAppTransaction(AppTransactionRequest request);
}
