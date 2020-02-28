package com.situ.myshop.user.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.situ.myshop.base.domain.PageData;
import com.situ.myshop.user.domain.User;

public interface UserService {
	Long saveUser(User user);//用户注册

	User findUserById(Long rowId);

	List<User> find();

	Long saveUser1(User user);

	Long updateUser(User user);

	Long doDeleteUser(Long rowId);

	List<User> findByPage(Integer pageNo, User searchUser);

	PageData buildPageData(Integer pageNo, User searchUser);

	Boolean checkUserName(String userName);

	Boolean checkUserCode(String userCode);

	Long userLogin(String userCode, String userPass,HttpServletRequest request,HttpServletResponse response);//用户登录

	User adminLogin(String adminCode, String adminPass);//管理员登录

	/*
	 * List<User> findByPage(Integer pageNo, User searchUser);
	 * 
	 * PageData buildPageData(Integer pageNo, User searchUser);
	 * 
	 * Boolean checkUserName(String userName);
	 */

	


}
