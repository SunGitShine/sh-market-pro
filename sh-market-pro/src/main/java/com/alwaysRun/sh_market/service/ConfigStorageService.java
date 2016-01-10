package com.alwaysRun.sh_market.service;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.alwaysRun.sh_market.dao.ConfigStorageDao;
import com.alwaysRun.sh_market.util.CommonData;

@Component
public class ConfigStorageService implements ConfigStorageDao,InitializingBean{
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;// redis操作模板
	
	 public static String KEY_PREFIX           						       = "SH_WX_";
	 public static String KEY_SUFFIX_APPID                 				   = "appid";
	 public static String KEY_SUFFIX_SECRET               				   = "secret";
	 public static String KEY_SUFFIX_TOKEN                       		   = "token";
	 public static String KEY_SUFFIX_ACCESS_TOKEN          				   = "accesstoken";
	 public static String KEY_SUFFIX_JSAPI_TICKET          			   = "verifyticket";

	@Override
	public void afterPropertiesSet() throws Exception {
		
		setAppId(CommonData.APPID);
		setSecret(CommonData.SECRET);
		setToken(CommonData.TOKEN);
	}
	
	 public String getKey(String suffix){
		  return KEY_PREFIX+suffix;
	  }

	@Override
	public String getAppId() {
		String key=getKey(KEY_SUFFIX_APPID);
		Object obj = redisTemplate.opsForValue().get(key);
		if (obj != null) {
			return obj.toString();
		}
		return null;
	}

	@Override
	public String getSecret() {
		String key=getKey(KEY_SUFFIX_SECRET);
		Object obj = redisTemplate.opsForValue().get(key);
		if (obj != null) {
			return obj.toString();
		}
		return null;
	}

	@Override
	public String getToken() {
		String key=getKey(KEY_SUFFIX_TOKEN);
		Object obj = redisTemplate.opsForValue().get(key);
		if (obj != null) {
			return obj.toString();
		}
		return null;
	}

	@Override
	public String getJsapiTicket() {
		String key=getKey(KEY_SUFFIX_JSAPI_TICKET);
		Object obj = redisTemplate.opsForValue().get(key);
		if (obj != null) {
			return obj.toString();
		}
		return null;
	}

	@Override
	public String getAccessToken() {
		String key=getKey(KEY_SUFFIX_ACCESS_TOKEN);
		Object obj = redisTemplate.opsForValue().get(key);
		if (obj != null) {
			return obj.toString();
		}
		return null;
	}

	@Override
	public void setAppId(String appId) {
		String key = getKey(KEY_SUFFIX_APPID);
		redisTemplate.opsForValue().set(key, appId);
	}

	@Override
	public void setSecret(String secret) {
		String key = getKey(KEY_SUFFIX_SECRET);
		redisTemplate.opsForValue().set(key, secret);
	}

	@Override
	public void setToken(String token) {
		String key = getKey(KEY_SUFFIX_TOKEN);
		redisTemplate.opsForValue().set(key, token);
	}

	@Override
	public void setJsapiTicket(String jsapiTicket, long timeout) {
		String key = getKey(KEY_SUFFIX_JSAPI_TICKET);
		redisTemplate.opsForValue().set(key, jsapiTicket,timeout, TimeUnit.SECONDS);
	}

	@Override
	public void setAccessToken(String accessToken, long timeout) {
		String key = getKey(KEY_SUFFIX_ACCESS_TOKEN);
		redisTemplate.opsForValue().set(key, accessToken,timeout, TimeUnit.SECONDS);
	}

}
