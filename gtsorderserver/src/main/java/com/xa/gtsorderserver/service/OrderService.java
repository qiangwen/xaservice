package com.xa.gtsorderserver.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.XAConnection;
import javax.transaction.xa.Xid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.gtsorderserver.api.XaAccountApi;
import com.xa.gtsorderserver.domain.GtsId;
import com.xa.gtsorderserver.domain.Order;
import com.xa.gtsorderserver.enums.App;
import com.xa.gtsorderserver.request.AccountParam;
import com.xa.gtsorderserver.response.DataResponse;
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
	
	@Autowired
	private XaAccountApi xaAccountApi;
	
	private static final String add_order_sql =  "insert into bizorder(orderMoney,orderUserId,projectId) values(?,?,?)";

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
		GtsId gtsId = XidUtil.genGtsId(App.ORDERSEVER);
		Xid xid = XidUtil.genXid(gtsId);//获取xid
		xaService.startXa(xaConnection, xid);
		//执行sql语句
		Connection conn = xaService.getConnection(xaConnection);
		Order order = addOrder(conn);
		xaService.endXa(xaConnection, xid);
		xaService.prepareXa(xaConnection, xid);
		
		//调用账户服务
		AccountParam accountParam = new AccountParam();
		accountParam.setMoney(order.getOrderMoney());
		accountParam.setUserId(order.getOrderUserId());
		accountParam.setGtsId(gtsId);
		DataResponse<Integer> dataResponse =  xaAccountApi.updateAccount(accountParam);
		dataResponse.getData();
	}
	
	public Order addOrder(Connection conn) throws SQLException{
		Order order = new Order();
		order.setOrderMoney(BigDecimal.TEN);
		order.setOrderUserId(1);
		order.setProjectId(1);
		PreparedStatement preState = conn.prepareStatement(add_order_sql);
		preState.setBigDecimal(1, order.getOrderMoney());
		preState.setInt(2, order.getOrderUserId());
		preState.setInt(3, order.getProjectId());
		preState.executeUpdate();
		return order;
	}
}
