package com.xa.gtsorderserver.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.xa.gtsorderserver.domain.Order;

@Mapper
public interface OrderMapper {

	@Select("select * from bizorder where id = #{id}")
	Order getById(@Param("id") int id);
	
	@Insert("insert into bizorder values(#{id},#{orderMoney},#{orderUserId},#{projectId});")
	int insertOrder(Order order);
}
