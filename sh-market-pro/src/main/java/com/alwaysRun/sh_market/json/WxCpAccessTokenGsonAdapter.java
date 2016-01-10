package com.alwaysRun.sh_market.json;

import java.lang.reflect.Type;

import com.alwaysRun.sh_market.weixin.bean.AccessToken;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class WxCpAccessTokenGsonAdapter implements JsonDeserializer<AccessToken> {

	@Override
	public AccessToken deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		AccessToken token = new AccessToken();
		JsonObject jObject = json.getAsJsonObject();
		if (jObject.get("access_token") != null && !jObject.get("access_token").isJsonNull()) {
			token.setAccess_token(GsonHelper.getAsString(jObject.get("access_token")));
		}
		
		if (jObject.get("expires_in") != null && !jObject.get("expires_in").isJsonNull()) {
			token.setExpires_in(GsonHelper.getAsPrimitiveLong(jObject.get("expires_in")));
		}
		
		return token;
	}

	
	
}
