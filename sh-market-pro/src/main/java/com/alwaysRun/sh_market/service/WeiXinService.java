package com.alwaysRun.sh_market.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alwaysRun.sh_market.bean.UserInfo;
import com.alwaysRun.sh_market.dao.WeiXinDao;
import com.alwaysRun.sh_market.util.CommonData;
import com.alwaysRun.sh_market.util.HttpUtil;
import com.alwaysRun.sh_market.util.MessageUtil;
import com.alwaysRun.sh_market.weixin.bean.AccessToken;
import com.alwaysRun.sh_market.weixin.bean.JsapiTicket;
import com.alwaysRun.sh_market.weixin.bean.OpenIdBean;

@Component
public class WeiXinService implements WeiXinDao {

	@Autowired
	private ConfigStorageService configStorageService;
	
	private HttpUtil weiXinUtil=new HttpUtil();
	private MessageUtil messageUtil=new MessageUtil();
	
	public static final String GET_ACCESS_TOKEN="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
	public static final String GET_JSAPI_TICKET="https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";
	public static final String GET_MEDIA="https://api.weixin.qq.com/cgi-bin/media/get?access_token=%s&media_id=%s";
	public static final String GET_USER="https://api.weixin.qq.com/cgi-bin/user/info?access_token=%s&openid=%s&lang=zh_CN";
	public static final String MAKE_MENU="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=%s";
	public static final String GET_OPENID="https://api.weixin.qq.com/sns/oauth2/access_token?appid=%s&secret=%s&code=%s&grant_type=authorization_code";

	@Override
	public String getAccessToken() {
		String accessTokenStr=configStorageService.getAccessToken();
		if(accessTokenStr != null){
			return accessTokenStr;
		}
		String appId=configStorageService.getAppId();
		String secret=configStorageService.getSecret();
		AccessToken accessToken=getAccessToken(appId, secret);
		if(accessToken!=null){
			accessTokenStr=accessToken.getAccess_token();
			long timeout=accessToken.getExpires_in();
			configStorageService.setAccessToken(accessTokenStr, timeout);
		}
		return accessTokenStr;
	}

	public AccessToken getAccessToken(String appId,String secret) {
		String url=String.format(GET_ACCESS_TOKEN, appId,secret);
		String responseContent = weiXinUtil.doGetStr(url);
		return AccessToken.fromJson(responseContent);
	}

	@Override
	public String getJsapiTicket() {
		String ticketStr=configStorageService.getJsapiTicket();
		if(ticketStr!=null){
			return ticketStr;
		}
		String accessToken=getAccessToken();
		JsapiTicket ticket=getJsapiTicket(accessToken);
		if(ticket!=null){
			ticketStr=ticket.getTicket();
			long timeout=ticket.getExpiresIn();
			configStorageService.setJsapiTicket(ticketStr, timeout);
		}
		return ticketStr;
	}
	
	public JsapiTicket getJsapiTicket(String accessToken) {
		String url=String.format(GET_JSAPI_TICKET, accessToken);
		String responseContent = weiXinUtil.doGetStr(url);
		return JsapiTicket.fromJson(responseContent);
	}
	
	public void uploadImg(String mediaId,String location,String fileName){
		String url=String.format(GET_MEDIA, getAccessToken(),mediaId);
		try {
			weiXinUtil.downLoadFromUrl(url, fileName, location);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public UserInfo getUser(String openId){
		String url=String.format(GET_USER, getAccessToken(),openId);
		String result=weiXinUtil.doGetStr(url);
		return UserInfo.fromJson(result);
	}
	
	public String mainMenu(String fromUserName, String toUserName){
		return messageUtil.mainMenu(fromUserName, toUserName);
	}
	
	public void makeMenu(){
		String url=String.format(MAKE_MENU, getAccessToken());
		String outStr;
		try {
			outStr = messageUtil.initMenu();
			weiXinUtil.doPostStr(url, outStr);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getOpenId(String code){
		String url=String.format(GET_OPENID, CommonData.APPID,CommonData.SECRET,code);
		String result=weiXinUtil.doGetStr(url);
		return OpenIdBean.fromJson(result).getOpenid();
	}
}
