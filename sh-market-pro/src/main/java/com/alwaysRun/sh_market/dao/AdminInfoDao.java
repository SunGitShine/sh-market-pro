package com.alwaysRun.sh_market.dao;

import org.apache.ibatis.annotations.Param;


public interface AdminInfoDao {

	int find(@Param("userName") String userName,@Param("psw") String psw);
}
