package com.alwaysRun.sh_market.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import net.sf.json.JSONObject;

import com.alwaysRun.sh_market.weixin.bean.Button;
import com.alwaysRun.sh_market.weixin.bean.Menu;
import com.alwaysRun.sh_market.weixin.bean.TextMessage;
import com.alwaysRun.sh_market.weixin.bean.ViewButton;

public class MessageUtil {

	public static final String MESSAGE_TEXT="text";    //文本消息类型
	public static final String MESSAGE_IMAGE="image";  //图片消息类型 
	public static final String MESSAGE_VOICE="voice";  //语音消息类型
	public static final String MESSAGE_VIDEO="video";  //视频消息类型
	public static final String MESSAGE_SHORTVIDEO="shortvideo";   //短视频消息类型
	public static final String MESSAGE_LOCATION="location";       //地理位置消息类型
	public static final String MESSAGE_LINK="link";               //链接消息类型  
	public static final String MESSAGE_EVENT="event";   //属性Event:subscribe(订阅)、unsubscribe(取消订阅)、CLICK（菜单点击）
	public static final String MESSAGE_SUBSCRIBE="subscribe";   //属性Event:subscribe(订阅)、unsubscribe(取消订阅)、CLICK（菜单点击）
	public static final String MESSAGE_UNSUBSCRIBE="unsubscribe";   //属性Event:subscribe(订阅)、unsubscribe(取消订阅)、CLICK（菜单点击）
	public static final String MESSAGE_CLICK="CLICK";   //属性Event:subscribe(订阅)、unsubscribe(取消订阅)、CLICK（菜单点击）
	public static final String MESSAGE_VIEW="VIEW";   //属性Event:subscribe(订阅)、unsubscribe(取消订阅)、CLICK（菜单点击）
	public static final String MSEEAGE_NEWS="news";
	
	private WeiXinUtil weiXinUtil=new WeiXinUtil();
	
	public String mainMenu(String fromUserName, String toUserName) {
		StringBuffer content = new StringBuffer();
		content.append("欢迎关注易小二二手交易商城\n\n");
		content.append("点击“发布”菜单将闲置的物品发布到平台上\n");
		content.append("点击“首页”菜单去寻找想要的二手物品\n");
		content.append("点击“我的”菜单管理发布的二手物品\n\n");
		content.append("易小二您身边的二手专家\n");
//		content.append("4、看看页面点击情况\n");
//		content.append("回复“？”主功能导航");
		
		TextMessage msg=new TextMessage();
		msg.setFromUserName(toUserName);
		msg.setToUserName(fromUserName);
		msg.setCreateTime(new Date().getTime());
		msg.setMsgType(MESSAGE_TEXT);
		msg.setContent(content.toString());
		return weiXinUtil.textToXml(msg);
	}
	
	public String initMenu() throws UnsupportedEncodingException{
		Menu menu=new Menu();
		ViewButton button1=new ViewButton();
		button1.setName("首页");
		button1.setType("view");
		button1.setUrl("http://wxdv.berbon.com/sh-market-web/hh.html");
		
		ViewButton button2=new ViewButton();
		button2.setName("发布");
		button2.setType("view");//https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx520c15f417810387&redirect_uri=http://wxdv.berbon.com/sh-market-web/addGoods.html&response_type=code&scope=snsapi_base&state=123#wechat_redirect
		button2.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0b188a4414d9a5fc&redirect_uri=http://wxdv.berbon.com/sh-market-web/addGoods.html&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
		
		ViewButton button3=new ViewButton();
		button3.setName("我的");
		button3.setType("view");
		button3.setUrl("https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx0b188a4414d9a5fc&redirect_uri=http://wxdv.berbon.com/sh-market-web/user.html&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect");
		
		menu.setButton(new Button[]{button1,button2,button3});
		
		JSONObject json=JSONObject.fromObject(menu);
		
//		AccessToken token=WeiXinUtil.getAccessToken();
//		String url=WeiXinUtil.CREAT_MENU_URL.replace("ACCESS_TOKEN", token.getAccess_token());
//		JSONObject result=WeiXinUtil.doPostStr(url,json.toString());
		return json.toString();
	}
}
