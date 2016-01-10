package com.alwaysRun.sh_market.weixin;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alwaysRun.sh_market.service.WeiXinService;


public class WeiXinServiceTest {
	
	protected static ClassPathXmlApplicationContext appContext;
	protected static WeiXinService weiXinService;
	
	@BeforeClass
	public static void init(){
		appContext=new ClassPathXmlApplicationContext("classpath*:META-INF/spring/*.xml");
		weiXinService=(WeiXinService) appContext.getBean("weiXinService");
	}
	
	@Test
	public void getAccessToken(){
		System.out.println(weiXinService.getAccessToken());
	}
	
	@Test
	public void getTicket(){
		System.out.println(weiXinService.getJsapiTicket());
	}
}
