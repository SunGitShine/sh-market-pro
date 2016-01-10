package com.alwaysRun.sh_market.json;

import java.lang.reflect.Type;

import com.alwaysRun.sh_market.weixin.bean.JsapiTicket;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class JsapiTicketAdapter implements JsonDeserializer<JsapiTicket> {

	@Override
	public JsapiTicket deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {
		JsapiTicket ticket = new JsapiTicket();
		JsonObject jObject = json.getAsJsonObject();
		if (jObject.get("ticket") != null
				&& !jObject.get("ticket").isJsonNull()) {
			ticket.setTicket(GsonHelper.getAsString(jObject.get("ticket")));
		}

		if (jObject.get("expires_in") != null
				&& !jObject.get("expires_in").isJsonNull()) {
			ticket.setExpiresIn(GsonHelper.getAsPrimitiveLong(jObject
					.get("expires_in")));
		}
		return ticket;
	}

}
