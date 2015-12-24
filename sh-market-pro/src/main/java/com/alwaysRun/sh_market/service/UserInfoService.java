package com.alwaysRun.sh_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alwaysRun.sh_market.bean.UserInfo;
import com.alwaysRun.sh_market.dao.UserInfoDao;

@Component
public class UserInfoService {

	@Autowired
	private UserInfoDao userDao;
	
	public void addUser(UserInfo user){
		
	}
}
