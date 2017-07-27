package com.xa.gtsorderserver.util;

import javax.transaction.xa.Xid;

import com.mysql.jdbc.jdbc2.optional.MysqlXid;
import com.xa.gtsorderserver.enums.App;

/**
 * 生成全局gtsid
 * @author qiang.wen
 * @date 2017年7月27日 上午9:29:11
 */
public class XidUtil {
	
	private static final int formatId = 0;

	public static Xid genXid(App app){
		SnowflakeIdService idService = SnowflakeIdService.getInstance(app.getAppId());
		Xid xid = new MysqlXid(idService.nextId().toString().getBytes(), app.name().getBytes(), formatId);
		return xid;
	}
}
