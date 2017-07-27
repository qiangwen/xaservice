package com.xa.gtsaccountserver.service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.XAConnection;
import javax.transaction.xa.Xid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.gtsaccountserver.domain.GtsId;
import com.xa.gtsaccountserver.enums.App;
import com.xa.gtsaccountserver.request.AccountParam;
import com.xa.gtsaccountserver.util.XidUtil;
import com.xa.gtsaccountserver.xa.XAService;

/**
 * 模拟账户操作
 * @author qiang.wen
 * @date 2017年7月27日 下午2:28:49
 */
@Service
public class AccountService {

	@Autowired
	private XAService xaService;
	
	private static final String update_account_sql = "update bizaccount set avaliableMoney = avaliableMoney - ?,balance = balance - ? where userId = ? ";
	
	public int updateAccount(AccountParam accountParam) throws Exception {
		//获取xaConnection
		XAConnection xaConnection = xaService.getXaConnection();
		//加入到全局事务
		GtsId gtsId = accountParam.getGtsId();//这个是建立联系的gtsid
		GtsId aGtsId = XidUtil.genGtsId(App.ACCOUNTSEVER);
		Xid xid = XidUtil.genXid(aGtsId);
		xaService.startXa(xaConnection, xid);
		//执行sql
		Connection  conn = xaService.getConnection(xaConnection);
		updateAccount(accountParam,conn);
		xaService.endXa(xaConnection, xid);
		xaService.prepareXa(xaConnection, xid);
		return 0;
	}

	private void updateAccount(AccountParam accountParam, Connection conn) throws Exception {
		PreparedStatement stat = conn.prepareStatement(update_account_sql);
		stat.setBigDecimal(1, accountParam.getMoney());
		stat.setBigDecimal(2, accountParam.getMoney());
		stat.setInt(3, accountParam.getUserId());
		stat.executeUpdate();
	}

}
