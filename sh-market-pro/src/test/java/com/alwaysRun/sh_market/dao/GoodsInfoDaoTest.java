package com.alwaysRun.sh_market.dao;

import java.util.List;

import org.junit.Test;

import com.alwaysRun.sh_market.bean.GoodsInfo;

public class GoodsInfoDaoTest extends DaoTest{

	@Test
	public void add(){
		GoodsInfo goods=new GoodsInfo();
		goods.setUserId(1);
		goods.setClassify("1");
		goods.setTitle("test");
		goodsInfoDao.add(goods);
	}
	
	@Test
	public void update(){
		GoodsInfo goods=new GoodsInfo();
		goods.setGoodsId(1);
		goods.setUserId(1);
		goods.setClassify("1");
		goods.setTitle("test");
		goodsInfoDao.update(goods);
	}
	
	@Test
	public void delete(){
		int goodsId=1;
		goodsInfoDao.delete(goodsId);
	}
	
	@Test
	public void findById(){
		int goodsId=1;
		GoodsInfo goods=goodsInfoDao.findById(goodsId);
		System.out.println(goods.toString());
	}
	
	@Test
	public void findByPage(){
		int userId=1;
		String classify="1";
		List<GoodsInfo> goodsList=goodsInfoDao.findByPage("1", 0, 2, 0);
		for(GoodsInfo goods:goodsList){
			System.out.println(goods.toString());
		}
	}
	
	@Test
	public void findTotalNum(){
		int num=goodsInfoDao.findToTalNum("1", 1);
		System.out.println(num);
	}
	
	@Test
	public void findAll(){
		List<GoodsInfo> goodsList=goodsInfoDao.findAll("1");
		for(GoodsInfo goods:goodsList){
			System.out.println(goods.toString());
		}
	}
}
