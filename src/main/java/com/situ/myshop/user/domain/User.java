package com.situ.myshop.user.domain;

import java.io.Serializable;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.situ.myshop.base.domain.BaseClass;
@Alias("User")
public class User extends BaseClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer userKind;// 用户类型1商家2买家
	private String userName;// 用户名称
	private String userCode;// 用户账号
	private String userPass;// 用户密码
	private String userMobile;// 用户手机
	private Integer userLock;// 是否锁定1锁0解锁
	private String userLastLoginIP;// 最后的登录IP
	private Date userLastLoginTime;// 最后的登陆时间

	public Integer getUserKind() {
		return userKind;
	}

	public void setUserKind(Integer userKind) {
		this.userKind = userKind;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public Integer getUserLock() {
		return userLock;
	}

	public void setUserLock(Integer userLock) {
		this.userLock = userLock;
	}

	public String getUserLastLoginIP() {
		return userLastLoginIP;
	}

	public void setUserLastLoginIP(String userLastLoginIP) {
		this.userLastLoginIP = userLastLoginIP;
	}

	public Date getUserLastLoginTime() {
		return userLastLoginTime;
	}

	public void setUserLastLoginTime(Date userLastLoginTime) {
		this.userLastLoginTime = userLastLoginTime;
	}

}
