package com.alwaysRun.sh_market.dao;

import org.junit.Test;

public class AdminDaoTest extends DaoTest{
	
	@Test
	public void find(){
		System.out.println(adminInfoDao.find("xq", "12"));
	}
}
