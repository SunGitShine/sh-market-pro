package com.alwaysRun.sh_market.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alwaysRun.sh_market.dao.AdminInfoDao;

@Component
public class AdminService {

	@Autowired
	private AdminInfoDao adminDao;

	public boolean login(String userName, String psw) {
		if (StringUtils.isEmpty(userName) || StringUtils.isEmpty(psw))
			return false;
		if (adminDao.find(userName, psw) > 0) {
			return true;
		}
		return false;
	}
}
