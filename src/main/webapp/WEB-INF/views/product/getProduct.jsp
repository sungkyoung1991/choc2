<%@ page contentType="text/html; charset=euc-kr"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>




<!DOCTYPE html>

<html lang="ko">

<head>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>

<script type="text/javascript">
$(function(){
	$("button:contains('확인')").on("click",function(){
		self.location="/product/updateProduct";
	});
});
</script>

</head>

<body>
	<form name="detailForm" class="form-horizontal">
		
    <div class="col-sm-10">
      <p class="form-control-static"  >${product.productNo }</p>
    </div>
    <div class="col-sm-10">
      <p class="form-control-static" name="productModel" >${product.productModel }</p>
    </div>
    
    <div class="col-sm-10">
      <p class="form-control-static" name="productImage">${product.productImage }</p>
    </div>
    
    <button type="button">확인</button>
    
    </form>
</body>
</html>


		
		
		