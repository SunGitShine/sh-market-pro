package com.alwaysRun.sh_market.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.alwaysRun.sh_market.bean.UserInfo;

public interface UserInfoDao {
	/**
	 * 当用户关注公众号时保存用户信息
	 * @param user
	 */
	void add(UserInfo user);
	
	/**
	 * 当用户取消关注是修改用户状态为0
	 * @param openId
	 */
	void delete(String openId);
	
	/**
	 * 通过openId查找用户信息(发布信息，个人中心，用户第二次关注均有用)
	 * @param openId
	 * @return
	 */
	UserInfo findByOpenId(String openId);
	
	/**
	 * 当用户第二次关注公众号时，修改用户状态为1
	 * @param openId
	 */
	void updateByOpenId(String openId);
	
	/**
	 * 分页查询用户
	 * @param pageNo 当前页数
	 * @param pageSize 每页显示记录数
	 * @return
	 */
	List<UserInfo> findByPage(@Param("pageNo") int pageNo,@Param("pageSize") int pageSize);
	
	/**
	 * 查询用户表总记录数
	 * @return
	 */
	int findTotalNum();
	
	/**
	 * 拉黑用户（拉黑后，用户不能发布商品信息，该用户以前发布的商品信息不被列出）
	 * @param userId
	 */
	void deFriend(@Param("userId") int userId);
	
	/**
	 * 取消用户拉黑
	 * @param userId
	 */
	void isFriend(@Param("userId") int userId);
}
