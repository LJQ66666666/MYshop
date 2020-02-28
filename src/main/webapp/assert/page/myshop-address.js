$(document).ready(function(){
	//对表单绑定校验。
	$('#form_address_add_edit').validationEngine('attach', {
		onValidationComplete : function(form, status) {
			//如果校验通过
			if(status){
				//执行 新增或修改
				saveOrUpdate();
			}
		}
	});
	//查询所有的数据
	initTableData();
	//绑定新增按钮
	$('#button_add').off('click').on('click',function(){
		$('#form_address_add_edit')[0].reset();
		$('#modal_address').modal('show');
		//尝试清空所有的校验信息
		$('.formError').remove();
		//尝试移除data-skip这个属性（为了唯一性校验）
		$('#addressId').removeAttr('data-skip');
		//$('#rowId').val('');
		$('#rowId').removeAttr('value');
		$('#action_info').html('新增');
	});
	//绑定 省 change
	$('#province').on('change',function(){
		var parentCode = $(this).val();
		initAreaData(parentCode,'city');
		var areaName = $(this).find(':selected').text();
		var linkArea ='';
		if(areaName !='省信息'){
			linkArea = areaName;
		}
		//alert(linkArea);
		$('#linkArea').val(linkArea);
	});
	//绑定 市 change
	$('#city').on('change',function(){
		var parentCode = $(this).val();
		initAreaData(parentCode,'county');
		var areaName = $(this).find(':selected').text();
		var linkArea =$('#linkArea').val();
		if(areaName !='市信息' && areaName!='县' && areaName!='市辖区'){
			linkArea = linkArea+areaName;
		}
		//alert(linkArea);
		$('#linkArea').val(linkArea);
	});
	//
	$('#county').on('change',function(){
		var areaName = $(this).find(':selected').text();
		var linkArea =$('#linkArea').val();
		if(areaName !='区信息'){
			linkArea = linkArea+areaName;
		}
		$('#linkArea').val(linkArea);
	});
	//绑定Submit按钮
	$('#button_submit').off('click').on('click',function(){
		//让当前的表单执行提交动作
		//表单提交动作会触发表单的校验。
		$('#form_address_add_edit').submit();
	});
	//执行 新增或修改
	function saveOrUpdate(){
		var rowId = $('#rowId').val();
		if(rowId){//如果主键有信息，则判断进行的是修改
			$.ajax({
				type:'post',
				url:'address/update',
				data:$('#form_address_add_edit').serialize(),
				dataType:'json',
				success:function(result){
					if(result){
						$('#modal_address').modal('hide');
						initTableData();
					}
				}
			});
		}else{//则判断执行的是新增
			$.ajax({
				type:'post',
				url:'address/add',
				data:$('#form_address_add_edit').serialize(),
				dataType:'json',
				success:function(result){
					if(result){
						$('#modal_address').modal('hide');
						initTableData();
					}
				}
			});
		}
	}
	//绑定 删除超连接事件 
	$('#dataTable_wrapper').off('click','#deleteA').on('click','#deleteA',function(){
		var rowId = $(this).attr("data-rowId");
		if(confirm("您确定要删除吗？")){
			$.ajax({
				url:'address/delete/'+rowId,
				success:function(result){
					if(result){
						initTableData();
					}
				}
			});
		}
	});
});
//go update
function goupdate(rowId){
	$.ajax({
		url:'address/findById/'+rowId,
		dataType:'json',
		success:function(address){
			//if(true) js false()
			if(address){
				//将modal表单显示
				$('#modal_address').modal('show');
				//尝试清空所有的校验信息
				$('.formError').remove();
				var addressId = address.addressId;
				//在需要进行唯一性校验的field里面增加 data-skip这个属性并赋值。
				$('#action_info').html('修改');
				$('#addressId').val(addressId).attr('data-skip',addressId);
				$('#conSignee').val(address.conSignee);
				$('#province').val(address.province);
				$('#city').val(address.city);
				$('#county').val(address.county);
				$('#detailed').val(address.detailed);
				$('#postCode').val(address.postCode);
				$('#consigneePhone').val(address.consigneePhone);
				$('#rowId').val(address.rowId);
			}
		}
	});
}
function initAreaData(parentCode,id){
	var options ='<option value=>市信息</option>';
	if(id=='county'){
		options ='<option value=>县/区信息</option>';
	}
	$('#'+id).html(options);
	$.ajax({
		url:'area/list/'+parentCode,
		success:function(areaList){
			console.log(areaList);
			if(areaList){
				$.each(areaList,function(index,area){
					var areaCode = area.areaCode;
					var areaName = area.areaName;
					var option ='<option value="'+areaCode+'">'+areaName+'</option>';
					options +=option;
				});
				$('#'+id).html(options);
			}
		}
	});
}
//init table data
 function initTableData(){
	 $.ajax({
		 url:'address/find',
		 success:function(htmlData){
			 $('#dataTable_wrapper').html(htmlData);
		 }
	 });
 }