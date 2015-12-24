package com.alwaysRun.sh_market.bean;

import java.io.Serializable;

public class AdminInfo implements Serializable{
	
	private int adminId;
	private String userName;
	private String passWord;
	private String memo;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "AdminInfo [adminId=" + adminId + ", userName=" + userName
				+ ", passWord=" + passWord + ", memo=" + memo + "]";
	}
}
