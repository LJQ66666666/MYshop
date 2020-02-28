<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>管理员登录</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		
	</head>
	<body>
		<!-- login -->
		<div class="top center">
			<div class="logo center">
				<a href="index" target="_blank"><img src="image/mistore_logo.png" alt=""></a>
			</div>
		</div>
		<form id="form_adminLogin" class="form center">
		<div class="login">
			<div class="login_center">
				<div class="login_top">
				<div class="left fl">管理员登录</div>
				<div class="right fr"><a href="index" target="_self">小米商城</a></div>
					<div class="clear"></div>
					<div class="xian center"></div>
				</div>
				<div class="login_main center">
					<div class="username">管理员账号:&nbsp;<input class="shurukuang" type="text" name="adminCode" id="adminCode" placeholder="请输入管理员账号"/></div>
					<div class="username">管理员密码:&nbsp;<input class="shurukuang" type="password" name="adminPass" id="adminPass" placeholder="请输入管理员密码"/></div>
					<!-- <input type="hidden" name="rowId" id="rowId"/>隐藏域 -->
				</div>
				<div class="login_submit">
					<input class="submit" type="button" name="button3" id="button3" value="立即登录" >
				</div>
				
			</div>
		</div>
		</form>
		<footer>
			<div class="copyright">简体 | 繁体 | English | 常见问题</div>
			<div class="copyright">小米公司版权所有-京ICP备10046444-<img src="image/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</div>

		</footer>
	</body>
	<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="js/register_login.js"></script>
</html>