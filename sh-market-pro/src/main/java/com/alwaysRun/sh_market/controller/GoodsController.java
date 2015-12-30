package com.alwaysRun.sh_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.alwaysRun.sh_market.util.PageModel;

@Controller
@RequestMapping(value="/goods")
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;

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
}
