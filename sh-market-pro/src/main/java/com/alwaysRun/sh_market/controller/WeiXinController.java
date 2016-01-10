package com.alwaysRun.sh_market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alwaysRun.sh_market.bean.UserInfo;
import com.alwaysRun.sh_market.dao.UserInfoDao;
import com.alwaysRun.sh_market.service.UserInfoService;
import com.alwaysRun.sh_market.service.WeiXinService;
import com.alwaysRun.sh_market.util.MessageUtil;
import com.alwaysRun.sh_market.util.WeiXinUtil;

@Controller
public class WeiXinController {
	
	@Autowired
	private WeiXinService weiXinService;
	@Autowired
	private UserInfoService userInfoService; 

	private WeiXinUtil weiXinUtil = new WeiXinUtil();

	@RequestMapping(value = "/wx", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String weixin(HttpServletRequest req, HttpServletResponse resp, ModelMap model ,HttpSession session) throws IOException {
		String method = req.getMethod();
		if (method.equals("GET")) { // get方式访问
			String signature = req.getParameter("signature");
			String timestamp = req.getParameter("timestamp");
			String nonce = req.getParameter("nonce");
			String echostr = req.getParameter("echostr");
			PrintWriter out = resp.getWriter();

			if (weiXinUtil.chack(signature, timestamp, nonce)) {
				out.print(echostr);
			}
		} else { // post方式访问

			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			PrintWriter out = resp.getWriter();
			try {
				Map<String, String> map = weiXinUtil.XMLToMap(req);
				String fromUserName = map.get("FromUserName");
				String toUserName = map.get("ToUserName");
				String msgType = map.get("MsgType");
				String content = map.get("Content");

				String msg = null;

				if (msgType.equals(MessageUtil.MESSAGE_EVENT)) {
					String envenType = map.get("Event");
					if (envenType.equals(MessageUtil.MESSAGE_SUBSCRIBE)) { // 用户关注，添加信息到用户表
						
						UserInfo user=weiXinService.getUser(fromUserName);
						userInfoService.addUser(user);
						msg = weiXinService.mainMenu(fromUserName, toUserName);
					} else if (envenType.equals(MessageUtil.MESSAGE_UNSUBSCRIBE)) { // 用户取消关注，删除用户表中的信息
						userInfoService.delete(fromUserName);
					} else if(envenType.equals(MessageUtil.MESSAGE_CLICK)){
						System.out.println("发布点击");
					}else if (envenType.equals(MessageUtil.MESSAGE_VIEW)) { // 用户点击view事件
//						String url=map.get("EventKey");
//						if(url.equals("http://wxdv.berbon.com/sh-market-web/addGoods.html")){
////							int userId=userInfoService.getUserIdByOpenId(fromUserName);
////							System.out.println(userId);
////							session.setAttribute("userId", userId);
//							return "redirect:http://www.baidu.com";
//						}
					} else { // 用户点击第二个页面

					}
				}

				if (msg != null) {
					System.out.println(msg);

					out.print(msg);
				}

			} catch (DocumentException e) {
				e.printStackTrace();
			} finally {
				out.close();
			}
		}
		return null;
	}
	
	@RequestMapping(value = "/menu", method = { RequestMethod.GET,
			RequestMethod.POST })
	public void makeMenu(HttpServletRequest req, HttpServletResponse resp,ModelMap model){
		weiXinService.makeMenu();
	}
}
