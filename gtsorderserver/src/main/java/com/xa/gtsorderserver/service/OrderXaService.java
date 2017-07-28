package com.xa.gtsorderserver.service;

import javax.sql.XAConnection;
import javax.transaction.xa.Xid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xa.gtsorderserver.domain.GtsId;
import com.xa.gtsorderserver.util.XidUtil;
import com.xa.gtsorderserver.xa.XAService;

@Service
public class OrderXaService {

	@Autowired
	private XAService xaService;

	public boolean submitTransaction(String appXid) throws Exception {
		XAConnection xaConnection = xaService.getXaConnection();
		String[] ids = appXid.split(":");
		GtsId gtsId = new GtsId(ids[0], ids[1], Integer.parseInt(ids[2]));
		Xid xid = XidUtil.genXid(gtsId);
		xaService.commitXa(xaConnection, xid);
		return true;
	}

	public boolean rollbackTransaction(String appXid) throws Exception {
		XAConnection xaConnection = xaService.getXaConnection();
		String[] ids = appXid.split(":");
		GtsId gtsId = new GtsId(ids[0], ids[1], Integer.parseInt(ids[2]));
		Xid xid = XidUtil.genXid(gtsId);
		xaService.rollbackXa(xaConnection, xid);
		return true;
	}
}
