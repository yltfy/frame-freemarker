package com.tz.bean;

import java.util.Date;

/**
 * 
 * User 创建人:cool 时间：2018年1月18日-下午5:38:27
 * 
 * @version 1.0.0
 * 
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private Date createTime;
	private Date updateTime;
	private String forbiden;
	private String isDelete;
	private String male;
	private String age;
	private Date birthday;
	private String address;
	private String email;
	private String telephone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getForbiden() {
		return forbiden;
	}

	public void setForbiden(String forbiden) {
		this.forbiden = forbiden;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getMale() {
		return male;
	}

	public void setMale(String male) {
		this.male = male;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

}
