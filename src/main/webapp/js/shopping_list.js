$(document).ready(function(){
	initTableData();
});
//查询所有商品信息数据
function initTableData(){
	 $.ajax({
		 url:'goods/findShopping',
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
}
//添加到购物车
function addcart(rowId){
	$.ajax({
		url:'cart/addcart/'+rowId,
		success:function(result){
			if(result){
				alert("购物车加入成功");
			}
		}
	});
}
//从购物车中删除这条记录
function deleteCart(goodsId){
	if(confirm("您确定要删除吗？")){
		$.ajax({
			url:'cart/deletecart/'+goodsId,
			success:function(){
				location.href="cart/find "
			}
		});
	}
}