package com.alwaysRun.sh_market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alwaysRun.sh_market.bean.UserInfo;
import com.alwaysRun.sh_market.service.UserInfoService;
import com.alwaysRun.sh_market.util.PageModel;

@Controller
@RequestMapping(value="/user")
public class UserConTroller {
	
	@Autowired
	private UserInfoService userService;
	
	@RequestMapping(value="/findAll", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	public String findAll(HttpServletRequest request,Model model){
//		ModelMap map=new ModelMap();
		PageModel<UserInfo> pageModel=new PageModel<UserInfo>();
		int pageNo=1;
		if(!StringUtils.isEmpty(request.getParameter("pageNo"))){
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
 		pageModel=userService.findByPage(pageNo);
 		model.addAttribute("data", pageModel);
		return "userList";
	}
	
	@RequestMapping(value="/deFriend", method={RequestMethod.GET,RequestMethod.POST})
	public String deFriend(HttpServletRequest request){
		int userId=Integer.parseInt(request.getParameter("userId"));
		userService.deFriend(userId);
		return "redirect:/user/findAll.htm";
	}
	
	@RequestMapping(value="/isFriend",method={RequestMethod.GET,RequestMethod.POST})
	public String isFriend(HttpServletRequest request){
		
		int userId=Integer.parseInt(request.getParameter("userId"));
		userService.isFriend(userId);
		return "redirect:/user/findAll.htm";
	}
}
