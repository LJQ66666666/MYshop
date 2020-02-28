package com.situ.myshop.user.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.situ.myshop.user.domain.User;
import com.situ.myshop.user.service.UserService;
import com.situ.myshop.util.PageUtils;

@Controller
@RequestMapping("/user")
public class UserController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_USER_INDEX="user/user_index";
	private static final String PAGE_USER_LIST="user/user_list";
	@Autowired 
	private UserService userService;
	
	@RequestMapping("/index")
	//跳转到用户管理首页
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_USER_INDEX);
		return modelAndView;
	}
	
	
			
//买家注册新用户			
	@ResponseBody
	@RequestMapping("/add")
	public Long doAddUser(User user) {
		return userService.saveUser(user);
	}
	@ResponseBody
	@RequestMapping("/login")
	//从主页跳转进入登录页面
	public Long goLogin(String userCode, String userPass,HttpServletRequest request,HttpServletResponse response) {
		return userService.userLogin(userCode,userPass,request,response);
	}
	//用户退出登录
	@ResponseBody
	@RequestMapping("/exit")
	public void Exit(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
	}
	//管理员登录
	@ResponseBody
	@RequestMapping("/adminlogin")
	public User adminLogin(String adminCode,String adminPass) {
		return userService.adminLogin(adminCode,adminPass);
	}
	
	
	/*
	 * @ResponseBody
	 * 
	 * @RequestMapping("/gologin/{rowId}") public User
	 * goLogin(@PathVariable("rowId") Long rowId) { return
	 * this.userService.findUserById(rowId); }
	 */
	//上头这个方法好像没管用
	//查询出所有的数据，暂时屏掉看看！！！
	/*
	 * @RequestMapping("/find") public ModelAndView findAllUser(ModelAndView
	 * modelAndView) { modelAndView.addObject("userList", userService.find());
	 * modelAndView.setViewName(PAGE_USER_LIST); return modelAndView; }
	 */
	/**
	 * 查询所有的记录
	 * @param pageNo
	 * @param searchUser
	 * @param modelAndView
	 * @return
	 */
	@RequestMapping("/find/{pageNo}")
	public ModelAndView findAllUser(@PathVariable Integer pageNo, User searchUser, ModelAndView modelAndView) {
		//通过工具类将查询条件中的""设置为null
		searchUser=PageUtils.buildSearchParam(searchUser);
		// 要展示的列表数据
		modelAndView.addObject("userList", userService.findByPage(pageNo,searchUser));
		// 分页信息
		modelAndView.addObject("pageData", userService.buildPageData(pageNo,searchUser));
		modelAndView.setViewName(PAGE_USER_LIST);
		return modelAndView;
	}
	//管理员新增用户
	@ResponseBody
	@RequestMapping("/add1")
	public Long doAddUser1(User user) {
		return userService.saveUser1(user);
	}
	//找到需要修改信息的用户实例
	@ResponseBody
	@RequestMapping("/updatefind/{rowId}")
	public User doUpdate(@PathVariable("rowId") Long rowId) {
		return this.userService.findUserById(rowId);
	}
	//执行修改
	@ResponseBody
	@RequestMapping("/update")
	public Long doUpdateUser(User user) {
		return userService.updateUser(user);
	}
	//执行删除
	@ResponseBody
	@RequestMapping("/dodelete/{rowId}")
	public Long doDelete(@PathVariable Long rowId) {
		return this.userService.doDeleteUser(rowId);
	}
	@ResponseBody
	@RequestMapping("/checkUserName")
	public String checkUserName(String fieldId, String fieldValue) {
		// 通过服务层判断此名称是否可以使用。true：可以使用，false：不可以使用
		Boolean bool = userService.checkUserName(fieldValue);
		// [String,Boolean] ["userName",true]
		// 通过使用ObjectMapper开始封装需要返回的校验结果
		ObjectMapper objectMapper = new ObjectMapper();
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		list.add(bool);
		try {
			// 将封装好的校验结果转换成json格式的字符串并响应回去
			return objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	@ResponseBody
	@RequestMapping("/checkUserCode")
	public String checkUserCode(String fieldId, String fieldValue) {
		// 通过服务层判断此名称是否可以使用。true：可以使用，false：不可以使用
		Boolean bool = userService.checkUserCode(fieldValue);
		// [String,Boolean] ["userName",true]
		// 通过使用ObjectMapper开始封装需要返回的校验结果
		ObjectMapper objectMapper = new ObjectMapper();
		List<Object> list = new ArrayList<Object>();
		list.add(fieldId);
		list.add(bool);
		try {
			// 将封装好的校验结果转换成json格式的字符串并响应回去
			return objectMapper.writeValueAsString(list);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
