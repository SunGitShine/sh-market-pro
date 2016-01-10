package com.alwaysRun.sh_market.json;

import java.lang.reflect.Type;

import com.alwaysRun.sh_market.weixin.bean.OpenIdBean;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class OpenIdBeanAdapter implements JsonDeserializer<OpenIdBean>{

	@Override
	public OpenIdBean deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		OpenIdBean openId=new OpenIdBean();
		JsonObject jObject = json.getAsJsonObject();
		if (jObject.get("openid") != null
				&& !jObject.get("openid").isJsonNull()) {
			openId.setOpenid(GsonHelper.getAsString(jObject.get("openid")));
		}
		return openId;
	}

}
