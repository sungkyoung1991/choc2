<%@ page contentType="text/html; charset=euc-kr"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html lang="ko">

<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>


<script type="text/javascript">
	
	function fncGetList(currentPage) {
		
		
		$("#currentPage").val(currentPage)
		
		console.log(currentPage);
		
		/* $("form").attr("method" , "POST").attr("action" , "/product/listProduct?menu=${param.menu}").submit(); */
		$("form").attr("method" , "POST").attr("action" , "/product/listProduct").submit();
	}
	
	$(function() {

			$(".getDB").on("click", function() {

		var productNo = $("p", this).text();

		self.location = "/product/getProduct?prodNo=" + productNo;
	});
});
		
		
</script>
</head>

<body>
	
	
	전체 ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage} 페이지



	<form class="form-inline" name="detailForm">



		<c:set var="i" value="0" />
		<c:forEach var="product" items="${list }">
			<c:set var="i" value="${i+1 }" />
		
		<div class="getDB">	
			<p>${ product.productNo}</p>
		</div>
			
	
		</c:forEach>


		<!-- PageNavigation Start... -->
		
		<input type="hidden" id="currentPage" name="currentPage" value="" />

		<jsp:include page="../common/pageNavigator_new.jsp" />

	</form>

</body>
</html>
