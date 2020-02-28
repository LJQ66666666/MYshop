$(document).ready(function(){
	//对表单绑定校验。
	$('#form_goods_add_edit').validationEngine('attach', {
		onValidationComplete : function(form, status) {
			//如果校验通过
			if(status){
				//执行 新增或修改
				saveOrUpdate();
			}
		}
	});
	//查询所有数据
	initTableDate(1);
	//绑定新增按钮
	$('#button_add').off('click').on('click',function(){
		$('#form_goods_add_edit')[0].reset();
		$('#modal_goods').modal('show');
		//尝试清空所有的校验信息
		$('.formError').remove();
		//尝试移除data-skip这个属性（为了唯一性校验）
		$('#goodsName').removeAttr('data-skip');
		$('#goodsCode').removeAttr('data-skip');
		//$('#modal_goods').modal('show');//注意这里是modal而不是madal！！！
		//$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
	});
	//绑定提交按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_goods_add_edit').submit();
		//saveOrUpdate();
	});
	//绑定修改超链接事件
	$('#dataTable_wrapper').off('click','#update').on('click','#update',function(){
		var rowId=$(this).attr('data-rowId');//this指的是当前这条修改的超链接语句
		$.ajax({
			url:'goods/updatefind/'+rowId,//这条记录的主键
			dataType:'json',
			success:function(goods){
				if(goods){
					//将modal表单显示
					$('#modal_goods').modal('show');
					//尝试清空所有的校验信息
					$('.formError').remove();
					var goodsName = goods.goodsName;
					var goodsCode = goods.goodsCode;
					//在需要进行唯一性校验的field里面增加 data-skip这个属性并赋值。
					$('#goodsName').val(goodsName).attr('data-skip',goodsName);
					$('#goodsCode').val(goodsCode).attr('data-skip',goodsCode);
					$('#goodsUpAndDown').val(goods.goodsUpAndDown);
					$('#goodsName').val(goods.goodsName);
					$('#goodsCode').val(goods.goodsCode);
					$('#goodsPhotoFile').val(goods.goodsPhotoFile);//这句好像没有用了
					$('#goodsPrice').val(goods.goodsPrice);
					$('#goodsNum').val(goods.goodsNum);
					$('#goodsInfo').val(goods.goodsInfo);
					$('#rowId').val(goods.rowId);
					$('#action_info').html('修改');
				}
			}
		});
		
	});
	//绑定删除超链接事件
	$('#dataTable_wrapper').off('click','#deleteA').on('click','#deleteA',function(){
		var rowId=$(this).attr('data-rowId');//拿到当前数据的主键
		if(confirm("您确定要删除吗？")){
			$.ajax({
				url:'goods/dodelete/'+rowId,
				success:function(result){
					if(result){
						initTableDate(1);
					}
				}
			});
		}
		
	});
	//绑定搜索按钮
	$('#button_search').on('click',function(){
		//查询所有的数据
		initTableDate(1);
	});
	
});

//下边的是写的方法，上面的是绑定的事件
//这是查询所有数据方法
/*function initTableDate(){
	$.ajax({
		url:'goods/find',
		success:function(htmlData){
			$('#dataTable_wrapper').html(htmlData);
		}
	});
}*/
//init table data
function initTableDate(pageNo){
	 $.ajax({
		 type:'post',
		 url:'goods/find/'+pageNo,
		 data:$('#form_search').serialize(),
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
}
//执行新增或者修改
function saveOrUpdate(){
	var rowId=$('#rowId').val();//取到隐藏域rowId的值
	if(rowId){//如果主键有信息，则判断执行的是修改
		var formObj = $('#form_goods_add_edit')[0];
		var formData = new FormData(formObj);
		$.ajax({
			type:'post',
			url:'goods/update',
			data:formData,
			cache: false, //不缓存
			processData : false, // 告诉jQuery不要去处理发送的数据
			contentType : false,// 告诉jQuery不要去设置Content-Type请求头
			dataType:'json',
			success:function(a){//这就是个返回值，写啥都行
				if(a){
					$('#modal_goods').modal('hide');
					initTableDate(1);
				}
			}
		});
		
	}else{//主键没有信息，则判断执行的是新增
		var formObj = $('#form_goods_add_edit')[0];
		var formData = new FormData(formObj);
		$.ajax({
			type:'post',
			url:'goods/add',
			data:formData,
			cache: false, //不缓存
			processData : false, // 告诉jQuery不要去处理发送的数据
			contentType : false,// 告诉jQuery不要去设置Content-Type请求头
			dataType:'json',
			success:function(b){
				if(b){
					$('#modal_goods').modal('hide');
					initTableDate(1);
				}
			}
		});
	}
}
//响应分页
function page_select(pageNo){
	initTableDate(pageNo);
}
//上一页
function page_prev(){
	var current_page = $('#ul_pagination').find('.active').find('span').text();
	//console.log(current_page);
	initTableDate(current_page-1);
}
//下一页
function page_next(){
	 var current_page = $('#ul_pagination').find('.active').find('span').text();
	 initTableDate(parseInt(current_page)+1);
}