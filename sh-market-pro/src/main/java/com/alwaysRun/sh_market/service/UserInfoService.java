package com.alwaysRun.sh_market.service;

import java.text.SimpleDateFormat;
import java.util.Date;
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

	public void addUser(UserInfo user) {
		UserInfo userInfo = userDao.findByOpenId(user.getOpenid());
		if (userInfo == null) {
			userDao.add(user);
		} else {
			userDao.updateByOpenId(user.getOpenid());
		}
	}

	public PageModel<UserInfo> findByPage(int pageNo) {

		PageModel<UserInfo> pageModel = new PageModel<UserInfo>();
		List<UserInfo> userList = userDao.findByPage(pageNo - 1,
				CommonData.PC_PAGESIZE);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = "";
		for(UserInfo user:userList){
			if(user.getSex().equals("1")){
				user.setSex("男");
			}else if(user.getSex().equals("2")){
				user.setSex("女");
			}else{
				user.setSex("未知");
			}
			user.setSubscribe_time( sdf.format(new Date(Long.valueOf(user.getSubscribe_time())*1000L)));
		}

		int totalNum = userDao.findTotalNum();
		pageModel.setPageNo(pageNo);
		pageModel.setPageSize(CommonData.PC_PAGESIZE);
		pageModel.setTotalRecords(totalNum);
		pageModel.setRecords(userList);
		return pageModel;
	}

	public void deFriend(int userId) {
		userDao.deFriend(userId);
	}

	public void isFriend(int userId) {
		userDao.isFriend(userId);
	}

	public void delete(String openId) {
		userDao.delete(openId);
	}

	public int getUserIdByOpenId(String openId) {
		UserInfo user = userDao.findByOpenId(openId);
		return user.getUserId();
	}
	
	public boolean judgeFriend(String openId){
		UserInfo user=userDao.findByOpenId(openId);
		if(user.getIsFriend()==1){
			return true;
		}
		return false;
	}
	
	public UserInfo findByOpenId(String openId){
		return userDao.findByOpenId(openId);
	}
	
	public UserInfo findByUserId(int userId){
		return userDao.findByUserId(userId);
	}
}
