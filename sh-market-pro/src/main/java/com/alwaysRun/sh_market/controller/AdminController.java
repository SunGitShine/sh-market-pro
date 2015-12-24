package com.alwaysRun.sh_market.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alwaysRun.sh_market.service.AdminService;


@Controller
@RequestMapping(value="admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/login",method = { RequestMethod.GET, RequestMethod.POST },produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelMap login(HttpServletRequest request){
//		ModelAndView modelAndView=new ModelAndView();
		ModelMap map=new ModelMap();
		String userName=request.getParameter("userName");
		String psw=request.getParameter("psw");
		if(adminService.login(userName, psw)){
//			modelAndView.setViewName("index");
			map.put("msg", "");
		}else{
//			modelAndView.setViewName("login");
//			modelAndView.addObject("msg", "登录失败");
			map.put("msg", "登录失败");
		}
		return map;
	}
}
