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
	$(document).ready(function(){
		
		var formObj = $("form[role='form']");
		
		console.log(formObj);
		
		$("#modifyBtn").on("click", function(){
			formObj.attr("action", "/admin/cosmetic/update");
			formObj.attr("method", "get");		
			formObj.submit();
		});
		
		$("#removeBtn").on("click", function(){
			formObj.attr("action", "/admin/cosmetic/delete");
			formObj.submit();
		});
		
		$("#goListBtn ").on("click", function(){
			formObj.attr("method", "get");
			formObj.attr("action", "/admin/cosmetic/list");
			formObj.submit();
		});
		
	});
</script>
</head>
<body>
	<%@include file="../include/nav.jsp"%>

	<div class="row">
		<div class="col-md-12">
			<div class="box box-primary">
				<!-- /.box header -->

				<form role="form" action="/admin/cosmetic/update" method="post">
					<input type='hidden' name='cosmeticNo' value="${cosmeticVO.cosmeticNo}"> 
					<input type='hidden' name='page' value="${cri.page}"> 
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">
				</form>
				<div class="box-header">
					<h3 class="box-title">READ COSMETIC</h3>
				</div>

				<!-- ./box body -->
				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Brand</label> <input type="text"
							name='brand' class="form-control" value="${cosmeticVO.brand}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Model</label> <input type="text"
							name='model' class="form-control" value="${cosmeticVO.model}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Product</label> <input type="text"
							name='product' class="form-control" value="${cosmeticVO.product}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Amount</label> <input type="text"
							name='amount' class="form-control" value="${cosmeticVO.amount}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Price</label> <input type="text"
							name='price' class="form-control" value="${cosmeticVO.price}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">Ingredient</label> <input
							type="text" name='ingredient' class="form-control"
							value="${cosmeticVO.ingredient}" readonly="readonly">
					</div>

					<div class="box-footer">
						<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
						<button type="submit" class="btn btn-danger" id="removeBtn">Remove</button>
						<button type="submit" class="btn btn-primary" id="goListBtn">GO LIST</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

<%@include file="../include/footer.jsp"%>
</html>