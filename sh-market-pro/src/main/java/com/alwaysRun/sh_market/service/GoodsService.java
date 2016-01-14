package com.alwaysRun.sh_market.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alwaysRun.sh_market.bean.GoodsInfo;
import com.alwaysRun.sh_market.dao.GoodsInfoDao;
import com.alwaysRun.sh_market.util.CommonData;
import com.alwaysRun.sh_market.util.PageModel;
import com.alwaysRun.sh_market.util.SignUtil;

@Component
public class GoodsService {

	@Autowired
	private GoodsInfoDao goodsDao;
	@Autowired
	private WeiXinService weiXinService;
	
	public List<GoodsInfo> findAll(String classify){
		List<GoodsInfo> goodsList=goodsDao.findAll(classify);
		return goodsList;
	}
	
	public void delete(int goodsId){
		goodsDao.delete(goodsId);
	}
	
	public GoodsInfo findById(int goodsId){
		return goodsDao.findById(goodsId);
	}
	 
	public PageModel<GoodsInfo> findByPage(int pageNo,String classify,int userId){
		PageModel<GoodsInfo> pageModel=new PageModel<GoodsInfo>();
		List<GoodsInfo> goodsList=goodsDao.findByPage(classify, (pageNo-1)*CommonData.MOBILE_PAGESIZE, pageNo*CommonData.MOBILE_PAGESIZE, userId);
		int totalNum=goodsDao.findToTalNum(classify, userId);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(CommonData.MOBILE_PAGESIZE);
		pageModel.setRecords(goodsList);
		pageModel.setTotalRecords(totalNum);
		return pageModel;
	}
	
	public Map<String, String> getParams(String url){
		Map<String, String> map=new HashMap<String, String>();
		SignUtil util=new SignUtil();
		String jsapiTicket=weiXinService.getJsapiTicket();
		map=util.makeParams(jsapiTicket,url);
		map.put("appId", CommonData.APPID);
		return map;
	}
	
	public boolean addGoods(GoodsInfo goods,String mediaIds,String location){
		String[] mediaIDArr=mediaIds.split(",");
		int num=goodsDao.findToTalNum("", 0)+1;
		String picture="";
		for(int i=0;i<mediaIDArr.length;i++){
			String fileName=num+"-"+i+".jpg";
			weiXinService.uploadImg(mediaIDArr[i], location, fileName);
			picture=picture+","+fileName;
		}
		goods.setPicture(picture.substring(1, picture.length()));
		goodsDao.add(goods);
		return true;
	}
	
	public void usable(int goodsId){
		goodsDao.usabel(goodsId);
	}
	
	public void unUsable(int goodsId){
		goodsDao.unUsabel(goodsId);
	}
	
	public void update(GoodsInfo goods){
		goodsDao.update(goods);
	}
}
