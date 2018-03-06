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
<script type="text/javascript">

    function add_item(){
        // pre_set 에 있는 내용을 읽어와서 처리..
        var div = document.createElement('div');
        div.innerHTML = document.getElementById('pre_set').innerHTML;
        document.getElementById('field').appendChild(div);
    }
 
    function remove_item(obj){
        // obj.parentNode 를 이용하여 삭제
        document.getElementById('field').removeChild(obj.parentNode);
    }

</script>
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
						<label for="exampleInputEmail1">Ingredient</label>
						<div class="form-group" id="pre_set">
							<input type="text" name='ingredient' class="form-control"
								value="${cosmeticVO.ingredient}" placeholder="Enter Ingredient" style="width:200px"><input type="button" value="삭제" onclick="remove_item(this)">
						</div>
						<div id="field"></div>
						<input type="button" value=" 추가 " onclick="add_item()"><br>
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