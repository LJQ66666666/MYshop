<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>我的购物车-小米商城</title>
<jsp:include page="/base.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<!-- start header -->
	<!--end header -->

	<!-- start banner_x -->
	<div class="banner_x center">
		<a href="index" target="_blank"><div class="logo fl"></div></a>

		<div class="wdgwc fl ml40">我的购物车</div>
		<div class="wxts fl ml20">温馨提示：产品是否购买成功，以最终下单为准哦，请尽快结算</div>
		<%
			if (session.getAttribute("userLogin") == null) {
		%>
		<div class="dlzc fr">
			<ul>
				<li><a href="login" target="_blank">登录</a></li>
				<li>|</li>
				<li><a href="register" target="_blank">注册</a></li>
			</ul>
		</div>
		<%
			}
		%>
		<%
			if (session.getAttribute("userLogin") != null) {
		%>
		<div class="dlzc fr">
			<ul>
				<li><a target="_blank">${userLogin.userName}欢迎光临</a></li>
				<li>|</li>
				<li><a href="" id="exit">[退出]</a></li>
			</ul>
		</div>
		<%
			}
		%>
		<div class="clear"></div>
	</div>
	<div class="xiantiao"></div>
	<div class="gwcxqbj">


		<form action="confirmOrder" method="post" id="form_cart">
			<div class="gwcxd center" id="mod_body_cart_list">
				<div class="top2 center">
					<div class="sub_top fl">
						<input type="checkbox" value="quanxuan" class="quanxuan" checked="checked"/>全选
					</div>

					<div class="sub_top fl">商品名称</div>
					<div class="sub_top fl">单价</div>
					<div class="sub_top fl">数量</div>
					<div class="sub_top fl">小计</div>
					<div class="sub_top fr">操作</div>
					<div class="clear"></div>
				</div>

				<c:if test="${!empty cartList}">
					<c:forEach items="${cartList}" var="cart">

						<div class="content2 center">
							<div class="sub_content fl ">
							<!-- 这个地方没了span脚本就不起作用了是怎么回事？ -->
								<span><input type="checkbox" value="quanxuan" class="quanxuan" data-count="${cart.buyCount}" data-price="${cart.goodsPrice}" id="priceRefresh(${cart.goodsId})" onclick="updateCheckStatus(${cart.goodsId});" name="cartArray" value="${cart.goodsId}" checked="checked" /></span>
							</div>
							<div class="sub_content fl">
								<img width=60px； src="${cart.goodsImg}">
							</div>
							<div class="sub_content fl ft20">${cart.goodsName}</div>
							<div class="sub_content fl ">￥${cart.goodsPrice}</div>
							<div class="sub_content fl">
								<input class="shuliang" type="number" id="buyCount" value="${cart.buyCount}">
							</div>
							<div class="sub_content fl">￥${cart.goodsPrice*cart.buyCount}</div>
							<div class="sub_content fl">
								<a href="javascript:deleteCart(${cart.goodsId});">×</a>
							</div>
							<div class="clear"></div>
						</div>
					</c:forEach>
				</c:if>

			</div>
		</form>



		<!-- 结算 -->
		<div class="jiesuandan mt20 center">
			<div class="tishi fl ml20">
				<ul>
					<li><a href="liebiao">继续购物</a></li>
					<li>|</li>
					<li>已选择<span id="count">0</span>件商品
					</li>
					<div class="clear"></div>
				</ul>
			</div>
			<div class="jiesuan fr">
				<div class="jiesuanjiage fl">
					合计（不含运费）：<span id="totalPrice">0.0</span>元
				</div>
				<div class="jsanniu fr">
					<input class="jsan" type="submit" name="jiesuan" value="去结算" />
				</div>
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>

	</div>

</body>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/register_login.js"></script>
<script type="text/javascript" src="assert/page/myshop-cart.js"></script>
<script type="text/javascript" src="js/shopping_list.js"></script>
</html>
