package com.xa.gtsserver.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xa.gtsserver.domain.GtsGlobalTransaction;

@Mapper
public interface GtsGlobalTransactionMapper {
	
	@Insert("INSERT INTO gts_global_transaction(gtsId,gtsAppId,gtsStatus,versionNo,createTime) VALUES(#{gtsId},#{gtsAppId},#{gtsStatus},1,now())")
	int insert(GtsGlobalTransaction entity);
	
	@Select("SELECT * FROM gts_global_transaction WHERE gtsId = #{gtsId}")
	GtsGlobalTransaction getByGtsId(@Param("gtsId") String gtsId);
	
	@Update("UPDATE gts_global_transaction SET gtsStatus = #{gtsStatus},versionNo = versionNo + 1 WHERE id = #{id} AND versionNo = #{versionNo}")
	int updateXaStatus(GtsGlobalTransaction globalTrans);

}
