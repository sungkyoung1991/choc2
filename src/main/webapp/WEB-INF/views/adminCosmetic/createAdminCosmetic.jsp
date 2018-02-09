<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/nav.jsp"%>
	<!-- Main content -->
	<div class="content">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">REGISTER COSMETIC</h3>
				</div>
				<!-- ./box-header -->

				<form method="post" role="form">
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
						<div class="form-group">
							<label for="exampleInputEmail1">Ingredient</label> <input
								type="text" name='ingredient' class="form-control"
								value="${cosmeticVO.ingredient}" placeholder="Enter Ingredient">
						</div>
					</div>
					
					<div class="box-footer">
						<button type="submit" class="btn btn-primary">Submit</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
<%@include file="../include/footer.jsp"%>
</html>