package com.xa.gtsserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.gtsserver.domain.GtsAppTransaction;
import com.xa.gtsserver.domain.GtsGlobalTransaction;
import com.xa.gtsserver.enums.AppXaStatus;
import com.xa.gtsserver.mapper.GtsAppTransactionMapper;
import com.xa.gtsserver.mapper.GtsGlobalTransactionMapper;
import com.xa.gtsserver.request.AppTransactionRequest;

@Service
public class GtsAppService {

	@Autowired
	private GtsGlobalTransactionMapper gtsGlobalTransactionMapper;
	
	@Autowired
	private GtsAppTransactionMapper gtsAppTransactionMapper;
	
	/**
	 * 注册事务
	 * @param request
	 * @return
	 * @author qiang.wen
	 * @date 2017年7月28日 上午10:20:46
	 */
	public boolean registerAppTransaction(AppTransactionRequest request) {
		//获取所属全局事务
		GtsGlobalTransaction globalTransaction = gtsGlobalTransactionMapper.getByGtsId(request.getGtsId());
		if(globalTransaction == null){
			return false;
		}
		GtsAppTransaction appTransaction = genGtsAppTransaction(request,globalTransaction.getId());
		gtsAppTransactionMapper.insert(appTransaction);
		return true;
	}

	private GtsAppTransaction genGtsAppTransaction(AppTransactionRequest request, int id) {
		GtsAppTransaction transaction = new GtsAppTransaction();
		transaction.setAppId(request.getApp().getAppId());
		transaction.setAppXid(request.getAppXid());
		transaction.setGlobalTransactionId(id);
		transaction.setXaStatus(AppXaStatus.PREPARED.getStatus());
		return transaction;
	}

}
