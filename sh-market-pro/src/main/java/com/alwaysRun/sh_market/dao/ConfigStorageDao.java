package com.alwaysRun.sh_market.dao;

import org.springframework.stereotype.Component;

@Component
public interface ConfigStorageDao {
	
	 public String getAppId();

	 public String getSecret();

	 public String getToken();
	 
	 public String getVerifyTicket();
	 
	 public String getAccessToken();
	 
	 public void setAppId(String appId);
	 
	 public void setSecret(String secret);
	 
	 public void setToken(String token);
	 
	 public void setVerifyTicket(String verifyTicket,long timeout);
	 
	 public void setAccessToken(String accessToken,long timeout);
}
