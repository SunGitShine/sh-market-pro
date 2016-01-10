package com.alwaysRun.sh_market.weixin.bean;

import com.alwaysRun.sh_market.json.WxMpGsonBuilder;

public class JsapiTicket {
	
	private String ticket;
	private long expiresIn;
	
	public String getTicket() {
		return ticket;
	}
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}
	public long getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(long expiresIn) {
		this.expiresIn = expiresIn;
	}
	
	@Override
	public String toString() {
		return "JsapiTicket [ticket=" + ticket + ", expiresIn=" + expiresIn
				+ "]";
	}
	
	public static JsapiTicket fromJson(String json) {
		return WxMpGsonBuilder.create().fromJson(json, JsapiTicket.class);
	}
}
