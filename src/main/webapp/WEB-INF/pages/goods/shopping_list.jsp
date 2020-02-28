<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 商品图片展示 -->
<div class="main center">
	<c:if test="${!empty goodsList}">
		<c:forEach items="${goodsList}" var="goods">
			<div class="mingxing fl">
				<div class="fl">

					<div class="sub_mingxing" id="goodsImg">
						<a href=""><img src="${goods.goodsImg}" alt=""></a>
					</div>
					<div class="pinpai" id="goodsName">
						<a href="">${goods.goodsName}</a>
					</div>
					<div class="youhui" id="goodsInfo">${goods.goodsInfo}</div>
					<div class="jiage" id="goodsPrice">￥${goods.goodsPrice}</div>
					<div class="jiage">
						<%
							if (session.getAttribute("userLogin") != null) {
						%>
						<a href="javascript:addcart(${goods.rowId});">加入购物车</a>
						<%
							}
						%>
					</div>

				</div>

			</div>
		</c:forEach>
	</c:if>
</div>