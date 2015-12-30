package com.alwaysRun.sh_market.bean;

import java.io.Serializable;

public class UserInfo implements Serializable{

	private int userId;
	private String subscribe;
	private String openid;
	private String nickname;
	private String sex;
	private String city;
	private String country;
	private String province;
	private String language;
	private String headimgurl;
	private String subscribe_time;
	private String remark;
	private String groupid;
	private String status;
	private int isFriend;
	private String memo;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSubscribe() {
		return subscribe;
	}
	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getSubscribe_time() {
		return subscribe_time;
	}
	public void setSubscribe_time(String subscribe_time) {
		this.subscribe_time = subscribe_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public int getIsFriend() {
		return isFriend;
	}
	public void setIsFriend(int isFriend) {
		this.isFriend = isFriend;
	}
	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", subscribe=" + subscribe
				+ ", openid=" + openid + ", nickname=" + nickname + ", sex="
				+ sex + ", city=" + city + ", country=" + country
				+ ", province=" + province + ", language=" + language
				+ ", headimgurl=" + headimgurl + ", subscribe_time="
				+ subscribe_time + ", remark=" + remark + ", groupid="
				+ groupid + ", status=" + status + ", isFriend=" + isFriend
				+ ", memo=" + memo + "]";
	}
}
