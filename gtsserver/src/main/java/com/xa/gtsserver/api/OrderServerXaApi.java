package com.xa.gtsserver.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xa.gtsserver.response.DataResponse;

/**
 * orderServer xa api
 * @author qiang.wen
 * @date 2017年7月28日 下午1:43:44
 */
@FeignClient(value="orderserver",path="/orderserver/xa")
public interface OrderServerXaApi{

	@RequestMapping(value = "/submittransaction",method=RequestMethod.POST)
	public DataResponse<Boolean> submitTransaction(@RequestParam("appXid") String appXid);
	
	@RequestMapping(value = "/rollbacktransaction",method=RequestMethod.POST)
	public DataResponse<Boolean> rollbackTransaction(@RequestParam("appXid") String appXid);
}
