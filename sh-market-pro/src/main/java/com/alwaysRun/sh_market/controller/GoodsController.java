package com.alwaysRun.sh_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alwaysRun.sh_market.bean.GoodsInfo;
import com.alwaysRun.sh_market.service.GoodsService;
import com.alwaysRun.sh_market.service.UserInfoService;
import com.alwaysRun.sh_market.service.WeiXinService;
import com.alwaysRun.sh_market.util.PageModel;
import com.alwaysRun.sh_market.util.SignUtil;

@Controller
@RequestMapping(value="/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private WeiXinService weiXinService;
	@Autowired
	private UserInfoService userInfoService;

	@RequestMapping(value="/findAll", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	public String findAll(HttpServletRequest request,Model model){
		String classify=request.getParameter("classify");
		List<GoodsInfo> goodsList=goodsService.findAll(classify);
		model.addAttribute("goodsList", goodsList);
		model.addAttribute("name", "xq");
		return "/goodsList";
	}
	
	@RequestMapping(value="/delete", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	public String delete(HttpServletRequest request){
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		goodsService.delete(goodsId);
		return "redirect:/goods/findAll.htm";
	}
	
	@RequestMapping(value="/findById", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	public String findById(HttpServletRequest request,Model model){
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		GoodsInfo goods=goodsService.findById(goodsId);
		model.addAttribute("goods", goods);
		return "/goods";
	}
	
	@RequestMapping(value="/findByPage", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelMap findByPage(HttpServletRequest request,Model model){
		ModelMap map=new ModelMap();
		String classify=request.getParameter("classify");
		int pageNo=Integer.parseInt(request.getParameter("pageNo"));
		int userId=0;
		if(!StringUtils.isEmpty(request.getParameter("userId"))){
			userId=Integer.parseInt(request.getParameter("userId"));
		}
		PageModel<GoodsInfo> pageModel=goodsService.findByPage(pageNo, classify, userId);
		map.put("data", pageModel);
		return map;
	}
	
	@RequestMapping(value="/findGoods", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelMap findGoods(HttpServletRequest request,Model model){
		ModelMap map=new ModelMap();
		int goodsId=Integer.parseInt(request.getParameter("goodsId"));
		GoodsInfo goods=goodsService.findById(goodsId);
		map.put("goods", goods);
		return map;
	}
	
	@RequestMapping(value="/params", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelMap getParams(HttpServletRequest request,Model model){
		ModelMap map=new ModelMap();
		String url=request.getHeader("Referer");
		System.out.println(url);
		map.putAll(goodsService.getParams(url));
		return map;
	}
	
	@RequestMapping(value="/addGoods", method = { RequestMethod.GET, RequestMethod.POST }, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ModelMap addGoods(HttpServletRequest request,Model model ,HttpSession session){
		ModelMap map=new ModelMap();
		GoodsInfo goods=new GoodsInfo();
		String location="";
		String path = request.getRealPath("/");
		System.out.println(path);
		String[] str=path.split("\\\\");
		for(int i=0;i<str.length-1;i++){
			location=location+str[i]+"\\";
		}
		location=location+"pic\\";
		System.out.println(location);
		String code=request.getParameter("code");
		System.out.println("code:"+code);
		String openId=weiXinService.getOpenId(code);
		int userId=userInfoService.getUserIdByOpenId(openId);
		System.out.println("userid:"+userId);
		int price=Integer.parseInt(request.getParameter("price"));
		String title=request.getParameter("title");
		String classify=request.getParameter("classify");
		String contacts=request.getParameter("contacts");
		String phone=request.getParameter("phone");
		String QQ=request.getParameter("QQ");
		String describe=request.getParameter("describe");
		String serverIds=request.getParameter("serverIds");
		goods.setClassify(classify);
		goods.setContacts(contacts);
		goods.setDescribe(describe);
		goods.setPhone(phone);
		goods.setPrice(price);
		goods.setQQ(QQ);
		goods.setTitle(title);
		goods.setUserId(userId);
		goodsService.addGoods(goods, serverIds, location);
		map.put("result", "ok");
		return map;
	}
}
