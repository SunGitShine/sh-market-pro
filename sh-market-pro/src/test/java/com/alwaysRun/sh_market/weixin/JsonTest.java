package com.alwaysRun.sh_market.weixin;

import org.junit.Test;

import com.alwaysRun.sh_market.weixin.bean.AccessToken;
import com.alwaysRun.sh_market.weixin.bean.JsapiTicket;

public class JsonTest {
	
	@Test
	public void jsonToObject(){
		AccessToken accessToken=new AccessToken();
		String json="{\"access_token\":\"ACCESS_TOKEN\",\"expires_in\":7200}";
		accessToken=accessToken.fromJson(json);
		System.out.println(accessToken.toString());
	}
	
	@Test
	public void jsapiTicket(){
		JsapiTicket jsapiTicket=new JsapiTicket();
		String json="{\"errcode\":0,\"errmsg\":\"ok\",\"ticket\":\"bxLdikRXVbTPdHSM05e5u5sUoXNKd8-41ZO3MhKoyN5OfkWITDGgnr2fwJ0m9E8NYzWKVZvdVtaUgWvsdshFKA\",\"expires_in\":7200}";
		jsapiTicket=jsapiTicket.fromJson(json);
		System.out.println(jsapiTicket);
	}
	
	@Test
	public void subStr(){
		String path="D:\\Program Files\\apache-tomcat-7.0.25\\webapps\\TestSytem\\";
		String location="";
		String[] str=path.split("\\\\");
		for(int i=0;i<str.length-1;i++){
			location=location+str[i]+"\\";
		}
		System.out.println(location);
	}
}
