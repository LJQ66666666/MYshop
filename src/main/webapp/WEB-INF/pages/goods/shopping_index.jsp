<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品展示</title>
<jsp:include page="/base.jsp"></jsp:include>
<!-- <link rel="stylesheet" type="text/css" href="assert/css/sb-admin.css"> -->
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
	<!-- start header -->
	<header>
		<div class="top center">
			<div class="left fl">
				<ul>
					<li><a href="index">小米商城</a></li>
					<li>|</li>
					<li><a href="liebiao">MIUI</a></li>
					<li>|</li>
					<li><a href="liebiao">米聊</a></li>
					<li>|</li>
					<li><a href="liebiao">游戏</a></li>
					<li>|</li>
					<li><a href="liebiao">多看阅读</a></li>
					<li>|</li>
					<li><a href="liebiao">云服务</a></li>
					<li>|</li>
					<li><a href="liebiao">金融</a></li>
					<li>|</li>
					<li><a href="liebiao">小米商城移动版</a></li>
					<li>|</li>
					<li><a href="">问题反馈</a></li>
					<li>|</li>
					<div class="clear"></div>
				</ul>
			</div>
			<!-- 关于登录的书写开始 -->
			<div class="right fr">
				<div class="gouwuche fr">
					<a href="personalcenter">个人中心</a>
				</div>
				<div class="gouwuche fr">
					<a href="cart/find">购物车</a>
				</div>
				<%
					if (session.getAttribute("userLogin") == null) {
				%>
				<div class="fr">
					<ul>
						<li><a href="login">登录</a></li>
						<li>|</li>
						<li><a href="register">注册</a></li>
						<li>|</li>
					</ul>
				</div>
				<%
					}
				%>
				<%
					if (session.getAttribute("userLogin") != null) {
				%>
				<div class="fr">
					<ul>
						<li><a>${userLogin.userName}欢迎光临</a></li>
						<li>|</li>
						<li><a href="" id="exit">[退出]</a></li>
					</ul>
				</div>
				<%
					}
				%>
				<!-- 关于登录的书写 结束 -->
				<div class="clear"></div>
			</div>
			<div class="clear"></div>
		</div>
	</header>
	<!--end header -->

	<!-- start banner_x -->
	<div class="banner_x center">
		<a href="index"><div class="logo fl"></div></a> <a href=""><div class="ad_top fl"></div></a>
		<div class="nav fl">
			<ul>
				<li><a href="liebiao">小米手机</a></li>
				<li><a href="">红米</a></li>
				<li><a href="">平板·笔记本</a></li>
				<li><a href="">电视</a></li>
				<li><a href="">盒子·影音</a></li>
				<li><a href="">路由器</a></li>
				<li><a href="">智能硬件</a></li>
				<li><a href="">服务</a></li>
				<li><a href="">社区</a></li>
			</ul>
		</div>
		<div class="search fr">
			<form action="" method="post">
				<div class="text fl">
					<input type="text" class="shuru" placeholder="小米6&nbsp;小米MIX现货">
				</div>
				<div class="submit fl">
					<input type="submit" class="sousuo" value="搜索" />
				</div>
				<div class="clear"></div>
			</form>
			<div class="clear"></div>
		</div>
	</div>
	<!-- end banner_x -->

	<!-- start banner_y -->
	<div class="banner_y center">
		<div class="nav">
			<ul>
				<li><a href="shopping_index">所有商品</a></li>
				<c:if test="${!empty catalogueList}">
					<c:forEach items="${catalogueList}" var="catalogue">
						<li><a href="">${catalogue.catalogueName}</a></li>
					</c:forEach>
				</c:if>
			</ul>
		</div>

	</div>

	<div class="sub_banner center">
		<div class="sidebar fl">
			<div class="fl">
				<a href=""><img src="image/hjh_01.gif"></a>
			</div>
			<div class="fl">
				<a href=""><img src="image/hjh_02.gif"></a>
			</div>
			<div class="fl">
				<a href=""><img src="image/hjh_03.gif"></a>
			</div>
			<div class="fl">
				<a href=""><img src="image/hjh_04.gif"></a>
			</div>
			<div class="fl">
				<a href=""><img src="image/hjh_05.gif"></a>
			</div>
			<div class="fl">
				<a href=""><img src="image/hjh_06.gif"></a>
			</div>
			<div class="clear"></div>
		</div>
		<div class="datu fl">
			<a href=""><img src="image/hongmi4x.png" alt=""></a>
		</div>
		<div class="datu fl">
			<a href=""><img src="image/xiaomi5.jpg" alt=""></a>
		</div>
		<div class="datu fr">
			<a href=""><img src="image/pinghengche.jpg" alt=""></a>
		</div>
		<div class="clear"></div>


	</div>
	<!-- end banner -->

	<!-- start danpin -->
	<!-- 商品图片排列展示开始 -->
	<div class="danpin center">
		<div class="biaoti center">小米明星单品</div>
		<div class="">
			<div class="main center ">
				<!-- 商品列表start -->
				<div class="table-responsive fl">
					<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4"></div>
				</div>
				<!-- 商品列表end -->
				<div class="clear"></div>
			</div>
		</div>
	</div>
	<!-- 商品图片排列展示结束 -->
	<footer style="display: inline-block;">
		<div>class="mt20">小米商城|MIUI|米聊|多看书城|小米路由器|视频电话|小米天猫店|小米淘宝直营店|小米网盟|小米移动|隐私政策|Select Region</div>
		<div>©mi.com 京ICP证110507号 京ICP备10046444号 京公网安备11010802020134号 京网文[2014]0059-0009号</div>
		<div>违法和不良信息举报电话：185-0130-1238，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</div>
	</footer>

</body>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="js/register_login.js"></script>
<script type="text/javascript" src="js/shopping_list.js"></script>


</html>