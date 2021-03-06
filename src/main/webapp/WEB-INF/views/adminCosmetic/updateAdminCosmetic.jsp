<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/header.jsp"%>
<script>
					$(document).ready(function() {
						var formObj = $("form[role='form']");
						console.log(formObj);
						$(".btn-warning").on("click", function() {
							formObj.attr("method", "get");
							formObj.attr("action", "/admin/cosmetic/list");
							formObj.submit();
						});
						
						
						$(".btn-primary").on("click", function() {
							formObj.submit();
						});
					});
				</script>
</head>
<body>
	<%@include file="../include/nav.jsp"%>
	<!-- Main content -->
	<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">MODIFY BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="update" method="post">

					<input type='hidden' id='cosmeticNo' name='cosmeticNo' value="${cosmeticVO.cosmeticNo}">
					<input type='hidden' id='currentPage'name='currentPage' value="${search.currentPage}"> 
					<input type='hidden' id='searchCondition'name='searchCondition' value="${search.searchCondition}">
					<input type='hidden' id='searchKeyword'name='searchKeyword' value="${search.searchKeyword}">

					<div class="box-body">

						<div class="box-body">
						<div class="form-group">
							<label for="exampleInputEmail1">Brand</label> <input type="text"
								name='brand' class="form-control" value="${cosmeticVO.brand}"
								placeholder="Enter Brand">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Model</label> <input type="text"
								name='model' class="form-control" value="${cosmeticVO.model}"
								placeholder="Enter Model">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Product</label> <input
								type="text" name='product' class="form-control"
								value="${cosmeticVO.product}" placeholder="Enter Product">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Amount</label> <input type="text"
								name='amount' class="form-control" value="${cosmeticVO.amount}"
								placeholder="Enter Amount">
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">Price</label> <input type="text"
								name='price' class="form-control" value="${cosmeticVO.price}"
								placeholder="Enter Price">
						</div>
						<div class="form-group" id="pre_set">
							<label for="exampleInputEmail1">Ingredient</label> <input
								type="text" name='ingredient' class="form-control"
								value="${cosmeticVO.ingredient}" placeholder="Enter Ingredient">
						</div>
					</div>
					</div>
					<!-- /.box-body -->
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row --> </section>
	<!-- /.content -->
	
</body>
<%@include file="../include/footer.jsp"%>
</html>