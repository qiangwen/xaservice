package com.xa.gtsaccountserver.util;

import javax.transaction.xa.Xid;

import com.mysql.jdbc.jdbc2.optional.MysqlXid;
import com.xa.gtsaccountserver.domain.GtsId;
import com.xa.gtsaccountserver.enums.App;

/**
 * 生成全局gtsid
 * @author qiang.wen
 * @date 2017年7月27日 上午9:29:11
 */
public class XidUtil {
	
	private static final int formatId = 0;
	
	public static Xid genXid(GtsId gtsId){
		Xid xid = new MysqlXid(gtsId.getGtsId().getBytes(), gtsId.getBequalId().getBytes(),gtsId.getFormatId());
		return xid;
	}
	
	public static GtsId genGtsId(App app){
		SnowflakeIdService idService = SnowflakeIdService.getInstance(app.getAppId());
		GtsId gtsId = new GtsId(idService.nextId().toString(), app.name(), formatId);
		return gtsId;
	}
}
