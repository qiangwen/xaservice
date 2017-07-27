package com.xa.gtsaccountserver.xa;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.XAConnection;
import javax.transaction.xa.XAException;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.alibaba.druid.pool.xa.DruidPooledXAConnection;
import com.alibaba.druid.pool.xa.DruidXADataSource;
import com.alibaba.druid.pool.xa.JtdsXAConnection;
import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.alibaba.druid.util.H2Utils;
import com.alibaba.druid.util.JdbcUtils;
import com.alibaba.druid.util.MySqlUtils;
import com.alibaba.druid.util.OracleUtils;
import com.alibaba.druid.util.PGUtils;

/**
 * 模拟DruidXaDatasource
 * @author qiang.wen
 * @date 2017年7月27日 上午11:19:04
 */
public class GTSXaDataSource implements Serializable{

	private final static Log  LOG              = LogFactory.getLog(DruidXADataSource.class);

    private static final long serialVersionUID = 1L;

    private Object h2Factory = null;
    
    private DruidDataSource druidDataSource;
    
    private String dbType;
    
    public GTSXaDataSource(DruidDataSource druidDataSource){
    	this.druidDataSource = druidDataSource;
    	this.dbType = druidDataSource.getDbType();
    }

    public XAConnection getXAConnection() throws SQLException {
        DruidPooledConnection conn = druidDataSource.getConnection();

        Connection physicalConn = conn.unwrap(Connection.class);

        XAConnection rawXAConnection = createPhysicalXAConnection(physicalConn);

        return new DruidPooledXAConnection(conn, rawXAConnection);
    }

    private XAConnection createPhysicalXAConnection(Connection physicalConn) throws SQLException {
        if (JdbcUtils.ORACLE.equals(dbType)) {
            try {
                return OracleUtils.OracleXAConnection(physicalConn);
            } catch (XAException xae) {
                LOG.error("create xaConnection error", xae);
                return null;
            }
        }

        if (JdbcUtils.MYSQL.equals(dbType) || JdbcUtils.MARIADB.equals(dbType)) {
            return MySqlUtils.createXAConnection(druidDataSource.getDriver(), physicalConn);
        }

        if (JdbcUtils.POSTGRESQL.equals(dbType)) {
            return PGUtils.createXAConnection(physicalConn);
        }

        if (JdbcUtils.H2.equals(dbType)) {
        	 h2Factory = H2Utils.createJdbcDataSourceFactory();
            return H2Utils.createXAConnection(h2Factory, physicalConn);
        }

        if (JdbcUtils.JTDS.equals(dbType)) {
            return new JtdsXAConnection(physicalConn);
        }

        throw new SQLException("xa not support dbType : " + this.dbType);
    }
}
