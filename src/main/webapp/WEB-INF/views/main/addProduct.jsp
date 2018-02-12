<%@ page contentType="text/html; charset=utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ko">

<head>


<script type="text/javascript">

$(function(){
	$("button:contains('확인')").on("click",function(){
			self.location="/product/listProduct";
		});
});

</script>

</head>
 
<body>


<div class="container">
	
	
		<div class="row">
	  		<div class="col-xs-4 col-md-2"><strong>상품번호</strong></div>
			<div class="col-xs-8 col-md-4">${product.productNo}</div>
		</div>
		
		<hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>상품명</strong></div>
			<div class="col-xs-8 col-md-4">${product.productModel}</div>
		</div>
		
		<hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>제조일자</strong></div>
			<div class="col-xs-8 col-md-4">${product.productImage}</div>
		</div>
		
		<hr/>
		
		<hr/>
		
		<hr/>
		
		
		<div class="row">
	  		<div class="col-md-12 text-center ">
	  			<button type="button" class="btn btn-primary">확인</button>
	
	  			<button type="button" class="btn btn-primary">추가등록</button>
	  		</div>
		</div>
		
		<br/>
		
 	</div>

</body>
</html>
