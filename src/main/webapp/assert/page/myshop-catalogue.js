$(document).ready(function() {

	initTableData();
	
	$("#form_catalogue_add_edit").validationEngine('attach',{
		onValidationComplete:function(form,status){
			console.log(status);
			if(status){
				//如果校验成功  执行  修改或者增加
				saveOrupdate();
			}
		}	
		});
	$("#button_add").off('click').on('click', function() {
		$("#modal_product_catalogue").modal("show");
		$("#form_catalogue_add_edit")[0].reset();
		$("#parentcatalogueId").val("-1");
		$("#parent_catalogue_div").hide();
		$("#span_action").html("新增");
	});
	$("#button_submit").on('click', function() {
		$('#form_catalogue_add_edit').submit();
		
	});
	//绑定修改超链接
	$("#dataTable_wrapper").on('click', '#update', function() {
		var rowId = $(this).attr("data-rowId");
		$.ajax({
			url : "catalogue/update/" + rowId,
			dataType : "json",
			success : function(catalogue) {
					$("#parent_catalogue_div").hide();
					$("#span_action").html("修改");
					$("#modal_product_catalogue").modal("show");
					$("#catalogueName").val(catalogue.catalogueName);
					$("#catalogueInfo").val(catalogue.catalogueInfo);
					$("#rowId").val(catalogue.rowId);
				}
		});

	});
	$("#dataTable_wrapper").on('click', '#delete', function() {
		var rowId = $(this).attr("data-rowId");
		if (confirm("您确定要删除吗")) {
			$.ajax({
				url : "catalogue/delete/" + rowId,
				success : function(result) {
					if (result) {
						initTableData();
					}

				}

			});
		}
	});
	$("#dataTable_wrapper").on('click','#add_new',function(){
		$("#modal_product_catalogue").modal("show");
		$("#parent_catalogue_div").hide();
		var rowId = $(this).attr("data-parentCatalogId");
		$("#parentcatalogueId").val(rowId);
		
		
	});
});
//------------------------------------------------------------------------
function initTableData() {
	$.ajax({
		url : "catalogue/find",
		dataType : "html",
		success : function(htmlData) {
			$("#dataTable_wrapper").html(htmlData);

		}
	});


}
function saveOrupdate(){
	var rowId = $("#rowId").val();
	if(rowId){
		$.ajax({
			type:"post",
			url:"catalogue/doupdate",
			data:$("#form_catalogue_add_edit").serialize(),
			dataType:"json",
			success:function(result){
				if(result){
					$("#modal_product_catalogue").modal("hide");
					initTableData();
					
				}
				
			}
		});
		
	}
	else{
	$.ajax({
		type : "post",
		url : "catalogue/addParent",
		data : $("#form_catalogue_add_edit").serialize(),
		dataType : "json",
		success : function(result) {
			if (result) {
				$("#modal_product_catalogue").modal("hide");
				initTableData();

			}

		}
	});}
}
