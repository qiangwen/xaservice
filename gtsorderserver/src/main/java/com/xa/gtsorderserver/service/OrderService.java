package com.xa.gtsorderserver.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.XAConnection;
import javax.transaction.xa.Xid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.gtsorderserver.enums.App;
import com.xa.gtsorderserver.util.XidUtil;
import com.xa.gtsorderserver.xa.XAService;

/**
 * 模拟订单支付
 * @author qiang.wen
 * @date 2017年7月26日 上午10:48:30
 */
@Service
public class OrderService {
	
	@Autowired
	private XAService xaService;
	
	private static final String add_order_sql =  "insert into bizorder values(?,?,?,?)";

	/**
	 * 购买订单
	 * @author qiang.wen
	 * @throws Exception 
	 * @date 2017年7月26日 上午10:49:37
	 */
	public void purchaseOrder() throws Exception{
	    //获取xaConnection
		XAConnection xaConnection = xaService.getXaConnection();
		//开启一个全局事务
		Xid xid = XidUtil.genXid(App.ORDERSEVER);//获取xid
		xaService.startXa(xaConnection, xid);
		//执行sql语句
		Connection conn = xaService.getConnection(xaConnection);
		addOrder(conn);
		xaService.endXa(xaConnection, xid);
		xaService.prepareXa(xaConnection, xid);
	}
	
	public void addOrder(Connection conn) throws SQLException{
		PreparedStatement preState = conn.prepareStatement(add_order_sql);
		preState.setInt(1, 2);
		preState.setBigDecimal(2, BigDecimal.TEN);
		preState.setInt(3, 7);
		preState.setInt(4, 3);
		preState.executeUpdate();
	}
}
