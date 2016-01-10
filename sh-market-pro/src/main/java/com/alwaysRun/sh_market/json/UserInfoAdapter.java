package com.alwaysRun.sh_market.json;

import java.lang.reflect.Type;

import com.alwaysRun.sh_market.bean.UserInfo;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class UserInfoAdapter implements JsonDeserializer<UserInfo>{

	@Override
	public UserInfo deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		UserInfo user=new UserInfo();
		JsonObject jObject = json.getAsJsonObject();
		
		if (jObject.get("subscribe") != null
				&& !jObject.get("subscribe").isJsonNull()) {
			user.setSubscribe(GsonHelper.getAsString(jObject.get("subscribe")));
		}
		
		if (jObject.get("openid") != null
				&& !jObject.get("openid").isJsonNull()) {
			user.setOpenid(GsonHelper.getAsString(jObject.get("openid")));
		}
		if (jObject.get("nickname") != null
				&& !jObject.get("nickname").isJsonNull()) {
			user.setNickname(GsonHelper.getAsString(jObject.get("nickname")));
		}
		if (jObject.get("sex") != null
				&& !jObject.get("sex").isJsonNull()) {
			user.setSex(GsonHelper.getAsString(jObject.get("sex")));
		}
		if (jObject.get("city") != null
				&& !jObject.get("city").isJsonNull()) {
			user.setCity(GsonHelper.getAsString(jObject.get("city")));
		}
		if (jObject.get("province") != null
				&& !jObject.get("province").isJsonNull()) {
			user.setProvince(GsonHelper.getAsString(jObject.get("province")));
		}
		if (jObject.get("country") != null
				&& !jObject.get("country").isJsonNull()) {
			user.setCountry(GsonHelper.getAsString(jObject.get("country")));
		}
		if (jObject.get("subscribe_time") != null
				&& !jObject.get("subscribe_time").isJsonNull()) {
			user.setSubscribe_time(GsonHelper.getAsString(jObject.get("subscribe_time")));
		}
		if (jObject.get("remark") != null
				&& !jObject.get("remark").isJsonNull()) {
			user.setRemark(GsonHelper.getAsString(jObject.get("remark")));
		}
		if (jObject.get("groupid") != null
				&& !jObject.get("groupid").isJsonNull()) {
			user.setGroupid(GsonHelper.getAsString(jObject.get("groupid")));
		}
		if (jObject.get("headimgurl") != null
				&& !jObject.get("headimgurl").isJsonNull()) {
			user.setHeadimgurl(GsonHelper.getAsString(jObject.get("headimgurl")));
		}
		return user;
	}

}
