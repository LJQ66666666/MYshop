<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div class="col-sm-12">

		<table class="table table-bordered" id="example-basic-expandable">
			<thead>
				<tr>
					<th scope="col">目录名称</th>
					<th scope="col">目录介绍</th>
					<th scope="col">操作</th>
				</tr>
			</thead>

			<c:if test="${!empty catalogueList}">
				<c:forEach items="${catalogueList}" var="catalogue">
					<tr data-tt-id="${catalogue.rowId}" data-tt-parent-id="${catalogue.parentCatalogueId==-1?'':catalogue.parentCatalogueId}">
						<td>${catalogue.catalogueName}</td>
						<td>${catalogue.catalogueInfo}</td>
						<td><a href="javascript:;" data-rowId="${catalogue.rowId}" id="update">修改</a> <!-- data-XXX H5以后允许自定义元素的属性 --> 
						<a href="javascript:;" data-rowId="${catalogue.rowId}" id="delete">删除</a> 
						<a href="javascript:;" data-parentCatalogId="${catalogue.rowId}" id="add_new">增加子目录</a>
						</td>
					</tr>
				</c:forEach>
			</c:if>

		</table>
	</div>
</div>
<script>
	$("#example-basic-expandable").treetable({
		expandable : true,
		stringExpand : "展开",
		stringCollapse : "收起"
	});
</script>
