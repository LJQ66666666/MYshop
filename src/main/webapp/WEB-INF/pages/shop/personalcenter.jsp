<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>MYSHOP- 首页</title>
<jsp:include page="/base.jsp"></jsp:include>
<!-- http://www.jq22.com/demo/jquery-treetable201707260025/  -->
<link href="assets/vendor/jquery-treetable/css/jquery.treetable.css" rel="stylesheet" type="text/css" />
<link href="assets/vendor/jquery-treetable/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css" />
<!-- http://www.jq22.com/demo/jquery-treetable201707260025/  -->
<!-- Custom fonts for this template-->
<link href="assert/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<!-- Page level plugin CSS-->
<link href="assert/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
<!-- jquery.validationEngine CSS Begin -->
<link href="assert/vendor/jquery-validation/validationEngine.jquery.css" rel="stylesheet">
<!-- jquery.validationEngine CSS End -->
<!-- Custom styles for this template-->
<link href="assert/css/sb-admin.css" rel="stylesheet">
</head>
<body id="page-top">
	<nav class="navbar navbar-expand navbar-dark bg-dark static-top">
		<a class="navbar-brand mr-1" href="index.jsp">MYSHOP</a>
		<button class="btn btn-link btn-sm text-white order-1 order-sm-0" id="sidebarToggle" href="#">
			<i class="fas fa-bars"></i>
		</button>

		<!-- Navbar Search -->
		<form class="d-none d-md-inline-block form-inline ml-auto mr-0 mr-md-3 my-2 my-md-0">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Search for..." aria-label="Search" aria-describedby="basic-addon2">
				<div class="input-group-append">
					<button class="btn btn-primary" type="button">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>

		<!-- Navbar -->
		<ul class="navbar-nav ml-auto ml-md-0">
			<li class="nav-item dropdown no-arrow mx-1"><a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <span class="badge badge-danger">9+</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="alertsDropdown">
					<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow mx-1"><a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <span class="badge badge-danger">7</span>
			</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="messagesDropdown">
					<a class="dropdown-item" href="#">Action</a> <a class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <i class="fas fa-user-circle fa-fw"></i>
			</a>
				<div class="dropdown-menu dropdown-menu-right" aria-labelledby="userDropdown">
					<a class="dropdown-item" href="#">Settings</a> <a class="dropdown-item" href="#">Activity Log</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">Logout</a>
				</div></li>
		</ul>

	</nav>

	<div id="wrapper">
		<!-- 左侧 菜单开始  -->
		<!-- Sidebar -->
		<ul class="sidebar navbar-nav" id="left_menu">
			<li class="nav-item"><a class="nav-link" href="order/index"> <i class="fas fa-fw fa-table"></i> <span>我的订单</span></a></li>
			<li class="nav-item"><a class="nav-link" href="area/province"> <i class="fas fa-fw fa-table"></i> <span>收货地址</span></a></li>
			<li class="nav-item"><a class="nav-link" href="infomation/index"> <i class="fas fa-fw fa-table"></i> <span>信息修改</span></a></li>
		</ul>
		<!-- 左侧 菜单结束  -->
		<!-- 主页面开始  -->
		<div id="content-wrapper">
			<div class="container-fluid" id="container-admin">
				<!-- Sticky Footer -->
				<footer class="sticky-footer">
					<div class="container my-auto">
						<div class="copyright text-center my-auto">
							<span>Copyright © Your Website 2019</span>
						</div>
					</div>
				</footer>

			</div>
			<!-- /.content-wrapper -->
			<!-- 主页面结束  -->
		</div>
		<!-- /#wrapper -->

		<!-- Scroll to Top Button-->
		<a class="scroll-to-top rounded" href="#page-top"> <i class="fas fa-angle-up"></i>
		</a>

		<!-- Bootstrap core JavaScript-->
		<script src="assert/vendor/jquery/jquery.min.js"></script>
		<script src="assert/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
		<script src="assert/vendor/jquery.blockui.min.js"></script>
		<!-- Core plugin JavaScript-->
		<script src="assert/vendor/jquery-easing/jquery.easing.min.js"></script>

		<!-- Page level plugin JavaScript-->
		<script src="assert/vendor/chart.js/Chart.min.js"></script>
		<script src="assert/vendor/datatables/jquery.dataTables.js"></script>
		<script src="assert/vendor/datatables/dataTables.bootstrap4.js"></script>
		<!-- jquery.validationEngine JS Begin -->
		<script src="assert/vendor/jquery-validation/jquery.validationEngine-zh_CN.js"></script>
		<script src="assert/vendor/jquery-validation/jquery.validationEngine.js"></script>
		<!-- jquery.validationEngine JS End -->
		<!-- Custom scripts for all pages-->
		<script src="assert/js/sb-admin.min.js"></script>
		<script type="text/javascript" src="assert/js/eoa-index.js"></script>
		<!-- Demo scripts for this page-->
		<script src="assert/js/demo/datatables-demo.js"></script>
		<script src="assert/js/demo/chart-area-demo.js"></script>
		<script type="text/javascript" src="assets/vendor/jquery-treetable/js/jquery.treetable.js"></script>
</body>
</html>
