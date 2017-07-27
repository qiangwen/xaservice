package com.xa.gtsorderserver.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xa.gtsorderserver.request.AccountParam;
import com.xa.gtsorderserver.response.DataResponse;

@FeignClient(name="accountserver",path="/xa/account")
public interface XaAccountApi {

	@RequestMapping(value = "/updateaccount",method = RequestMethod.POST)
	public DataResponse<Integer> updateAccount(@RequestBody AccountParam accountParam);
}
