package com.alwaysRun.sh_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alwaysRun.sh_market.bean.GoodsInfo;
import com.alwaysRun.sh_market.dao.GoodsInfoDao;
import com.alwaysRun.sh_market.util.CommonData;
import com.alwaysRun.sh_market.util.PageModel;

@Component
public class GoodsService {

	@Autowired
	private GoodsInfoDao goodsDao;
	
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
		List<GoodsInfo> goodsList=goodsDao.findByPage(classify, pageNo-1, CommonData.MOBILE_PAGESIZE, userId);
		int totalNum=goodsDao.findToTalNum(classify, userId);
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(CommonData.MOBILE_PAGESIZE);
		pageModel.setRecords(goodsList);
		pageModel.setTotalRecords(totalNum);
		return pageModel;
	}
}
