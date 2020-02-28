<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- http://www.jq22.com/demo/jquery-treetable201707260025/  -->
<div class="card mb-3">
	<div class="card-header">
		<i class="fas fa-table"></i>目录管理
		<button type="button" class="btn btn-info btn-sm float-right" id="button_add">新增</button>
	</div>
</div>
<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4"></div>
<div class="modal fade" id="modal_product_catalogue" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">
					目录<span id="span_action"></span>
				</h5>
				<button class="close" type="button" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<form id="form_catalogue_add_edit">
				<div class="modal-body">
					<div class="form-group row" id="parent_catalogue_div">
						<label class="col-sm-2 col-form-label">父级目录ID</label>
						<div class="col-sm-7">
							<input type="text" class="form-control " id="parentcatalogueId" name="parentcatalogueId">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label ">目录名称</label>
						<div class="col-sm-7">
							<input type="text" class="form-control validate[required]" name="catalogueName" id="catalogueName">
						</div>
					</div>
					<div class="form-group row">
						<label class="col-sm-2 col-form-label ">目录简介</label>
						<div class="col-sm-7">
							<textarea class="form-control" name="catalogueInfo" id="catalogueInfo"></textarea>
						</div>
					</div>
					<input type="hidden" name="rowId" id="rowId">

				</div>
				<div class="modal-footer">
					<input class="btn btn-secondary" type="reset" data-dismiss="modal"> <a class="btn btn-primary" type="button" id="button_submit">提交</a>
				</div>
			</form>
		</div>
	</div>
</div>
<script>
	$("#example-basic-expandable").treetable({
		expandable : true
	});
</script>
<script src="assert/page/myshop-catalogue.js"></script>
