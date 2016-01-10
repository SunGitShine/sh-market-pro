package com.alwaysRun.sh_market.weixin.bean;

import java.io.Serializable;

import com.alwaysRun.sh_market.json.WxMpGsonBuilder;

public class OpenIdBean implements Serializable{

	private String openid;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	@Override
	public String toString() {
		return "OpenIdBean [openid=" + openid + "]";
	}
	
	public static OpenIdBean fromJson(String json) {
		return WxMpGsonBuilder.create().fromJson(json, OpenIdBean.class);
	}
}
