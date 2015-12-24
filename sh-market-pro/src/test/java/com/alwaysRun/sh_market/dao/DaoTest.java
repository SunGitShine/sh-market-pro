package com.alwaysRun.sh_market.dao;

import org.junit.BeforeClass;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DaoTest {
	
	protected static ClassPathXmlApplicationContext appContext;
	protected static UserInfoDao userDao;
	protected static AdminInfoDao adminInfoDao;
	protected static GoodsInfoDao goodsInfoDao;
	
	@BeforeClass
	public static void init(){
		appContext=new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
		userDao=(UserInfoDao) appContext.getBean("userInfoDao");
		adminInfoDao=(AdminInfoDao) appContext.getBean("adminInfoDao");
		goodsInfoDao=(GoodsInfoDao) appContext.getBean("goodsInfoDao");
	}

}
