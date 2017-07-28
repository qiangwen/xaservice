package com.xa.gtsserver.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xa.gtsserver.response.DataResponse;

/**
 * accountServer xa api
 * @author qiang.wen
 * @date 2017年7月28日 下午1:44:06
 */
@FeignClient(value="accountserver",path = "/accountserver/xa")
public interface AccountServerXaApi{

	@RequestMapping(value = "/submittransaction",method=RequestMethod.POST)
	public DataResponse<Boolean> submitTransaction(@RequestParam("appXid") String appXid);
	
	@RequestMapping(value = "/rollbacktransaction",method=RequestMethod.POST)
	public DataResponse<Boolean> rollbackTransaction(@RequestParam("appXid") String appXid);
}
