package com.alwaysRun.sh_market.dao;

import java.util.List;

import org.junit.Test;

import com.alwaysRun.sh_market.bean.UserInfo;

public class UserInfoDaoTest extends DaoTest{
	
	@Test
	public void add(){
		UserInfo user=new UserInfo();
		user.setNickname("xq");
		userDao.add(user);
	}
	
	@Test
	public void delete(){
		userDao.delete("1");
	}
	
	@Test
	public void findByOpenId(){
		UserInfo user=userDao.findByOpenId("2");
		System.out.println(user.toString());
	}
	
	@Test
	public void update(){
		userDao.updateByOpenId("1");
	}
	
	@Test
	public void findByPage(){
		List<UserInfo> userList=userDao.findByPage(0, 2);
		System.out.println(userList.size());
	}
	
	@Test
	public void findTotalNum(){
		System.out.println(userDao.findTotalNum());
	}
}
