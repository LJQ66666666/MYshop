<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">收货地址ID</th>
					<th scope="col">收货人姓名</th>
					<th scope="col">省信息</th>
					<th scope="col">市信息</th>
					<th scope="col">县/区信息</th>
					<th scope="col">详细地址</th>
					<th scope="col">邮编</th>
					<th scope="col">收货人电话</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${!empty addressList}">
					<c:forEach items="${addressList}" var="address">
						<tr>
							<th scope="row">${address.addressId}</th>
							<td>${address.conSignee}</td>
							<td>${address.province}</td>
							<td>${address.city}</td>
							<td>${address.county}</td>
							<td>${address.detailed}</td>
							<td>${address.postCode}</td>
							<td>${address.consigneePhone}</td>
							<td><a class="btn btn-primary btn-sm" href="javascript:goupdate(${address.rowId});">修改</a>
							    <a class="btn btn-primary btn-sm" href="javascript:;" data-rowId="${address.rowId}" id="deleteA">删除</a></td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</div>
<div class="row">
	<div class="col-sm-12 col-md-5">
		<div class="dataTables_info" id="dataTable_info" role="status" aria-live="polite">显示 ${pageData.beginIndex} 到 ${pageData.endIndex} 共 ${pageData.countIndex} 记录</div>
	</div>
	<div class="col-sm-12 col-md-7 float-right">
		<ul class="pagination float-right">
			<li class="page-item"><a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
			</a></li>
			<c:if test="${!empty pageData.pageList }">
				<c:forEach items="${pageData.pageList}" var="page">
					<li class="page-item"><a class="page-link" href="javascript:initTalbeData(${page});">${page}</a></li>
				</c:forEach>
			</c:if>
			<li class="page-item"><a class="page-link" href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
			</a></li>
		</ul>
	</div>
</div>