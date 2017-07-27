package com.xa.gtsorderserver.xa;

import java.sql.Connection;

import javax.sql.XAConnection;
import javax.transaction.xa.XAResource;
import javax.transaction.xa.Xid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * 操作xa事务
 * @author qiang.wen
 * @date 2017年7月26日 上午10:59:41
 */
@Service
public class XAService {
	
	@Autowired
	@Qualifier("gtsXaDataSouce")
	private GTSXaDataSource xaDataSource;
	
	public XAConnection getXaConnection() throws Exception{
		XAConnection xaConnection = xaDataSource.getXAConnection();
		return xaConnection;
	}
	
	public Connection getConnection(XAConnection xaConnection) throws Exception{
		Connection connc = null;
		if(xaConnection != null){
			connc =  xaConnection.getConnection();
		}
		return connc;
	}
	
	public void startXa(XAConnection xaConnection,Xid xid) throws Exception{
		XAResource xaResource = xaConnection.getXAResource();
		if(xaResource != null){
			xaResource.start(xid, XAResource.TMNOFLAGS);
		}
	}
	
	public void endXa(XAConnection xaConnection,Xid xid) throws Exception{
		XAResource xaResource = xaConnection.getXAResource();
		if(xaResource != null){
			xaResource.end(xid, XAResource.TMSUCCESS);
		}
	}
	
	public void prepareXa(XAConnection xaConnection,Xid xid) throws Exception{
		XAResource xaResource = xaConnection.getXAResource();
		if(xaResource != null){
			xaResource.prepare(xid);
		}
	}
	
	public void commitXa(XAConnection xaConnection,Xid xid) throws Exception{
		XAResource xaResource = xaConnection.getXAResource();
		if(xaResource != null){
			xaResource.commit(xid, false);
		}
	}
	
	public void rollbackXa(XAConnection xaConnection,Xid xid) throws Exception{
		XAResource xaResource = xaConnection.getXAResource();
		if(xaResource != null){
			xaResource.rollback(xid);
		}
	}
	
	public Xid[] recoverXa(XAConnection xaConnection) throws Exception{
		XAResource xaResource = xaConnection.getXAResource();
		Xid[] xids = null;
		if(xaResource != null){
			xids = xaResource.recover(XAResource.TMSTARTRSCAN);
		}
		return xids;	
	}
	
	
	public void commit() throws Exception{
		XAConnection xaConnection = getXaConnection();
		Xid[] xids = recoverXa(xaConnection);
		for(Xid xid:xids){
			commitXa(xaConnection, xid);
		}
	}
	
	public void rollback() throws Exception{
		XAConnection xaConnection = getXaConnection();
		Xid[] xids = recoverXa(xaConnection);
		for(Xid xid:xids){
			rollbackXa(xaConnection, xid);
		}
	}
}
