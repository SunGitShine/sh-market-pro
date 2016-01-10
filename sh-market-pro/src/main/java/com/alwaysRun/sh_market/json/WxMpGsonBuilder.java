package com.alwaysRun.sh_market.json;

import com.alwaysRun.sh_market.bean.UserInfo;
import com.alwaysRun.sh_market.weixin.bean.AccessToken;
import com.alwaysRun.sh_market.weixin.bean.JsapiTicket;
import com.alwaysRun.sh_market.weixin.bean.OpenIdBean;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class WxMpGsonBuilder {

  public static final GsonBuilder INSTANCE = new GsonBuilder();
  
  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(AccessToken.class, new WxCpAccessTokenGsonAdapter());
    INSTANCE.registerTypeAdapter(JsapiTicket.class, new JsapiTicketAdapter());
    INSTANCE.registerTypeAdapter(UserInfo.class, new UserInfoAdapter());
    INSTANCE.registerTypeAdapter(OpenIdBean.class, new OpenIdBeanAdapter());
  }
  
  public static Gson create() {
    return INSTANCE.create();
  }
  
}
