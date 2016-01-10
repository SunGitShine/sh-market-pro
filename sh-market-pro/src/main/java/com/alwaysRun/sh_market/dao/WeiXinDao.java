package com.alwaysRun.sh_market.dao;

import org.springframework.stereotype.Component;


@Component
public interface WeiXinDao {
	
	public String getAccessToken();
	
	public String getJsapiTicket();
	
}
