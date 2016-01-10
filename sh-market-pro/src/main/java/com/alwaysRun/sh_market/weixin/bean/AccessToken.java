package com.alwaysRun.sh_market.weixin.bean;

import java.io.Serializable;

import com.alwaysRun.sh_market.json.WxMpGsonBuilder;

public class AccessToken  implements Serializable {
	/**access_token */
	private String access_token;
	/** 有效期 */
	private long expires_in;

	public String getAccess_token() {
		return access_token;
	}


	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}


	public long getExpires_in() {
		return expires_in;
	}


	public void setExpires_in(long expires_in) {
		this.expires_in = expires_in;
	}

	@Override
	public String toString() {
		return "AccessToken [access_token=" + access_token + ", expires_in="
				+ expires_in + "]";
	}


	public static AccessToken fromJson(String json) {
		return WxMpGsonBuilder.create().fromJson(json, AccessToken.class);
	}

}
