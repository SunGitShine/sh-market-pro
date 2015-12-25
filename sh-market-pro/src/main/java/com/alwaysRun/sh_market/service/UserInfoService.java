package com.alwaysRun.sh_market.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alwaysRun.sh_market.bean.UserInfo;
import com.alwaysRun.sh_market.dao.UserInfoDao;
import com.alwaysRun.sh_market.util.CommonData;
import com.alwaysRun.sh_market.util.PageModel;

@Component
public class UserInfoService {

	@Autowired
	private UserInfoDao userDao;
	
	public void addUser(UserInfo user){
		
	}
	
	public PageModel<UserInfo> findByPage(int pageNo){
		
		PageModel<UserInfo> pageModel=new PageModel<UserInfo>();
		List<UserInfo> userList=userDao.findByPage(pageNo-1, CommonData.PC_PAGESIZE);
		
		int totalNum=userDao.findTotalNum();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(CommonData.PC_PAGESIZE);
		pageModel.setTotalRecords(totalNum);
		pageModel.setRecords(userList);
		return pageModel;
	}
}

