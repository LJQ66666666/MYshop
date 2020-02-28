$(document).ready(function(){

	
});
//计算出总共有多少件商品和总价格的方法
function updateCheckStatus(goodsId) {
	var zCount = 0;
	var zPrice = 0;
	$("#mod_body_cart_list").find(":checkbox:checked").each(function(index,obj){
		var count = $(obj).attr('data-count');
		var price = $(obj).attr('data-price');
		var allPrice = count*price;
		zCount =Number(zCount) + Number(count);
		zPrice = Number(zPrice)+ Number(allPrice);
		$("#count").html(zCount);
		$("#totalPrice").html(zPrice);
	});
}
