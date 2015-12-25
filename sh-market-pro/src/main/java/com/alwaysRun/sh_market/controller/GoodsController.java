package com.alwaysRun.sh_market.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alwaysRun.sh_market.bean.GoodsInfo;
import com.alwaysRun.sh_market.service.GoodsService;

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
}
