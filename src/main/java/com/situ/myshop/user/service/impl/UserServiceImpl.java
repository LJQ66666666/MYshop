package com.situ.myshop.user.service.impl;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.situ.myshop.base.domain.PageData;
import com.situ.myshop.user.dao.UserDao;
import com.situ.myshop.user.domain.User;
import com.situ.myshop.user.service.UserService;
import com.situ.myshop.util.PageUtils;

@Service
public class UserServiceImpl implements UserService, Serializable {
	private static final long serialVersionUID = 1L;
	@Autowired
	private UserDao userDao;

	@Override
	public Long saveUser(User user) {
		user.setActiveFlag(1);
		user.setCreateBy("admin");
		user.setCreateDate(new Date());
		user.setUserKind(2);
		user.setUserLock(0);
		return userDao.save(user);
	}

	@Override
	public User findUserById(Long rowId) {
		return userDao.get(rowId);
	}

	@Override
	public List<User> find() {
		return userDao.find();
	}

	@Override
	public Long saveUser1(User user) {
		user.setActiveFlag(1);
		user.setCreateBy("admin");
		user.setCreateDate(new Date());
		return userDao.save(user);
	}

	@Override
	public Long updateUser(User user) {
		user.setUpdateBy("admin1");
		user.setUpdateDate(new Date());
		userDao.update(user);
		return user.getRowId();

	}

	@Override
	public Long doDeleteUser(Long rowId) {
		userDao.delete(rowId);
		return rowId;
	}

	@Override
	public List<User> findByPage(Integer pageNo, User searchUser) {
		// limit查询数据开始的下标
		Integer firstResult = (pageNo - 1) * PageUtils.PAGE_ROWS;
		// limit查询数据 要显示的条数
		Integer maxResults = PageUtils.PAGE_ROWS;
		return userDao.findByPage(searchUser, firstResult, maxResults);
	}

	@Override
	public PageData buildPageData(Integer pageNo, User searchUser) {
		// 查询出数据总数
		Integer dataCount = userDao.getCount(searchUser);
		return PageUtils.buildPageData(dataCount, pageNo);
	}

	@Override
	public Boolean checkUserName(String userName) {
		// 根据用户名称查询实例
		User user = userDao.getByName(userName);
		// 三元表达式，如果有返回false，如果没有返回true
		Boolean bool = user != null ? false : true;
		return bool;
	}

	@Override
	public Boolean checkUserCode(String userCode) {
		// 根据用户账号查询实例
		User user = userDao.getByCode(userCode);
		// 三元表达式，如果有返回false，如果没有返回true
		Boolean bool = user != null ? false : true;
		return bool;
	}

	@Override
	public Long userLogin(String userCode, String userPass,HttpServletRequest request,HttpServletResponse response) {
		HttpSession session=request.getSession();
		Long result=null;
		User user=userDao.userLogin(userCode,userPass);
		if(user!=null) {
			session.setAttribute("userLogin", user);
			result=1L;
		}else {
			result=0L;
		}
		return result;
	}

	@Override
	public User adminLogin(String adminCode, String adminPass) {
		return userDao.adminLogin(adminCode,adminPass);
	}

}
