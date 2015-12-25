package com.alwaysRun.sh_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alwaysRun.sh_market.bean.GoodsInfo;
import com.alwaysRun.sh_market.dao.GoodsInfoDao;
import com.alwaysRun.sh_market.util.CommonData;

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
}
