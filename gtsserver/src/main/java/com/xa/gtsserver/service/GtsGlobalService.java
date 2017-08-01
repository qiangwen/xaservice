package com.xa.gtsserver.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.gtsserver.api.AccountServerXaApi;
import com.xa.gtsserver.api.OrderServerXaApi;
import com.xa.gtsserver.domain.GtsAppTransaction;
import com.xa.gtsserver.domain.GtsGlobalTransaction;
import com.xa.gtsserver.enums.App;
import com.xa.gtsserver.enums.AppXaStatus;
import com.xa.gtsserver.enums.GlobalXaStatus;
import com.xa.gtsserver.mapper.GtsAppTransactionMapper;
import com.xa.gtsserver.mapper.GtsGlobalTransactionMapper;
import com.xa.gtsserver.request.GlobalTransactionRequest;

/**
 * 全局事务
 * @author qiang.wen
 * @date 2017年7月28日 上午9:34:36
 */
@Service
public class GtsGlobalService {

	@Autowired
	private GtsGlobalTransactionMapper gtsGlobalTransactionMapper;
	
	@Autowired
	private GtsAppTransactionMapper gtsAppTransactionMapper;
	
	@Autowired
	private OrderServerXaApi orderServerXaApi;
	
	@Autowired
	private AccountServerXaApi accountServerXaApi;
	
	public boolean registGlobalTransaction(GlobalTransactionRequest request) {
		GtsGlobalTransaction entity = genGtsGlobalTransaction(request);
		gtsGlobalTransactionMapper.insert(entity);
		return true;
	}

	private GtsGlobalTransaction genGtsGlobalTransaction(GlobalTransactionRequest request) {
		GtsGlobalTransaction entity = new GtsGlobalTransaction();
		entity.setGtsAppId(request.getGtsApp().getAppId());
		entity.setGtsId(request.getGtsId());
		entity.setGtsStatus(GlobalXaStatus.NOCOMMITED.getStatus());
		return entity;
	}

	public boolean sumbitGlobalTransaction(GlobalTransactionRequest request) {
		//---获取全局事务
		GtsGlobalTransaction globalTrans = gtsGlobalTransactionMapper.getByGtsId(request.getGtsId());
		if(globalTrans == null){
			return false;
		}
		List<GtsAppTransaction> appTransList = gtsAppTransactionMapper.findByGlobalTransactionId(globalTrans.getId());
		for(GtsAppTransaction appTransaction : appTransList){
			//循环调用各个应用提交事务
			callAppSumitTransaction(appTransaction);
			//更新状态
			appTransaction.setXaStatus(AppXaStatus.COMMITED.getStatus());
			gtsAppTransactionMapper.updateXaStatus(appTransaction);
		}
		globalTrans.setGtsStatus(GlobalXaStatus.COMMITED.getStatus());
		gtsGlobalTransactionMapper.updateXaStatus(globalTrans);
		return true;
	}

	/**
	 * 调用其它服务的提交事务接口
	 * @param appTransaction
	 * @author qiang.wen
	 * @date 2017年7月28日 下午2:51:50
	 */
	private void callAppSumitTransaction(GtsAppTransaction appTransaction) {
		App app = App.getApp(appTransaction.getAppId());
		String appXid = appTransaction.getAppXid();
		switch (app) {
		case ORDERSEVER:
			orderServerXaApi.submitTransaction(appXid);
			break;
		case ACCOUNTSEVER:
			accountServerXaApi.submitTransaction(appXid);
			break;
		default:
			break;
		}
		
	}

}
