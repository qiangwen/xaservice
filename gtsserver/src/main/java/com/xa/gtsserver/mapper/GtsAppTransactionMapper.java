package com.xa.gtsserver.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xa.gtsserver.domain.GtsAppTransaction;

@Mapper
public interface GtsAppTransactionMapper {

	@Insert("INSERT INTO gts_app_transaction(globalTransactionId,appId,appXid,xaStatus,versionNo,createTime) VALUES (#{globalTransactionId},#{appId},#{appXid},#{xaStatus},1,now())")
	int insert(GtsAppTransaction gtsAppTransaction);
	
	@Select("SELECT * FROM gts_app_transaction WHERE globalTransactionId = #{globalTransactionId}")
	List<GtsAppTransaction> findByGlobalTransactionId(@Param("globalTransactionId") int globalTransactionId);
}
