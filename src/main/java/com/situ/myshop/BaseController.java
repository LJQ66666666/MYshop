package com.situ.myshop;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.situ.myshop.catalogue.service.CatalogueService;
@Controller

//此Controller完成基本的前台页面跳转
public class BaseController implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String PAGE_LOGIN="shop/login";
	private static final String PAGE_REGISTER="shop/register";
	private static final String PAGE_CART="shop/gouwuche";
	private static final String PAGE_ORDER="shop/dingdanzhongxin";
	private static final String PAGE_LIST="shop/liebiao";
	private static final String PAGE_SELFINFO="shop/self_info";
	private static final String PAGE_DETAILS="shop/xiangqing";
	private static final String PAGE_INDEX="shop/index";
	private static final String PAGE_ADMINLOGIN="shop/adminlogin";
	private static final String PAGE_INDEX2="shop/index2";
	private static final String PAGE_SHOPPING_INDEX="goods/shopping_index";
	private static final String PAGE_PERSONAL="shop/personalcenter";
	@Autowired
	private CatalogueService catalogueService;

	@RequestMapping("/login")
	//从主页跳转进入登录页面
	public ModelAndView goLogin(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_LOGIN);
		return modelAndView;
	}
	@RequestMapping("/adminlogin")
	//从主页跳转进入管理员登录页面
	public ModelAndView goAdminLogin(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_ADMINLOGIN);
		return modelAndView;
	}
	@RequestMapping("/index2")
	//通过管理员登录进入后台管理
	public ModelAndView goIndex2(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_INDEX2);
		return modelAndView;
	}
	@RequestMapping("/register")
	//从主页跳转进入注册页面
	public ModelAndView goRegister(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_REGISTER);
		return modelAndView;
	}
	@RequestMapping("/gouwuche")
	//从主页跳转进入购物车
	public ModelAndView goCart(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_CART);
		return modelAndView;
	}
	@RequestMapping("/dingdanzhongxin")
	//从主页跳转进入登录页面
	public ModelAndView goOrder(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_ORDER);
		return modelAndView;
	}
	@RequestMapping("/liebiao")
	//从主页跳转进入展示页面
	public ModelAndView goList(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_LIST);
		return modelAndView;
	}
	@RequestMapping("/self_info")
	//从主页跳转进入个人信息页面
	public ModelAndView goSelfinfo(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_SELFINFO);
		return modelAndView;
	}
	@RequestMapping("/xiangqing")
	//从主页跳转进入商品详情页面
	public ModelAndView goDetails(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_DETAILS);
		return modelAndView;
	}
	@RequestMapping(path= {"/","/index"})
	//跳转到主页
	public ModelAndView goIndex(ModelAndView modelAndView) {
		modelAndView.addObject("catalogueList",catalogueService.findCatelogue());
		modelAndView.setViewName(PAGE_INDEX);
		return modelAndView;
	}
	@RequestMapping("/shopping_index")
	//跳转到商品展示页面
	public ModelAndView goShoppingIndex(ModelAndView modelAndView) {
		modelAndView.addObject("catalogueList",catalogueService.findCatelogue());
		modelAndView.setViewName(PAGE_SHOPPING_INDEX);
		return modelAndView;
	}
	@RequestMapping("/personalcenter")
	//跳转到个人中心页面
	public ModelAndView goPersonal(ModelAndView modelAndView) {
		modelAndView.setViewName(PAGE_PERSONAL);
		return modelAndView;
	}
}
