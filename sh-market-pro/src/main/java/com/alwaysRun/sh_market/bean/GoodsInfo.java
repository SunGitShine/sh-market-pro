package com.alwaysRun.sh_market.bean;

import java.io.Serializable;

public class GoodsInfo implements Serializable{

	private int goodsId;
	private int userId;
	private String title;
	private int price;
	private String classify;
	private String publishTime;
	private String contacts;
	private String phone;
	private String QQ;
	private String describe;
	private String picture;
	private String status;
	private String memo;
	public int getGoodsId() {
		return goodsId;
	}
	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	public String getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}
	public String getContacts() {
		return contacts;
	}
	public void setContacts(String contacts) {
		this.contacts = contacts;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
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
	@Override
	public String toString() {
		return "GoodsInfo [goodsId=" + goodsId + ", userId=" + userId
				+ ", title=" + title + ", price=" + price + ", classify="
				+ classify + ", publishTime=" + publishTime + ", contacts="
				+ contacts + ", phone=" + phone + ", QQ=" + QQ + ", describe="
				+ describe + ", picture=" + picture + ", status=" + status
				+ ", memo=" + memo + "]";
	}
}
