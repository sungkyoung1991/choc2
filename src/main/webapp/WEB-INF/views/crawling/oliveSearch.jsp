<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
/* $(function(){
	$("button").on("click",function(){
		
			console.log("ss");
			
			$('form').attr("method","POST").attr("action","/crawling/oliveSearch").submit();
		});
		
	}); */
</script>
<!-- 				<script>
 				$(document)
					.ready(
						function() {
							var formObj = $("form[role='form']");
							console.log(formObj);
							
								$(".btn-primary").on("click",function() {
								formObj.submit();
									});
								});
/* 			
				</script>  -->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <div>
 		<form action="/crawling/oliveSearch" method="POST"> -->
		
			<div>
				<label>모델,브랜드명을 입력해주세요 : </label>
					<input type="text" name="index">
			</div>

			<button type="button" class="btn-primary">검색</button>
		</form>

	 </div> 
</body>
</html>