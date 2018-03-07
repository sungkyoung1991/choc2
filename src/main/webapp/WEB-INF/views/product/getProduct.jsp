<%@ page contentType="text/html; charset=euc-kr"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html lang="ko">

<head>


</head>

<body>
	
	
	<form name="detailForm" class="form-horizontal">

		
    <div class="col-sm-10">
      <p class="form-control-static" >${product.productNo }</p>
    </div>
    <div class="col-sm-10">
      <p class="form-control-static" >${product.productModel }</p>
    </div>
    
    <div class="col-sm-10">
      <p class="form-control-static">${product.productImage }</p>
    </div>

    <div class="col-sm-10">
      <p class="form-control-static" >${product.writer.userId }</p>
    </div>
    
    </form>

	
	

</body>
</html>


		
		
		