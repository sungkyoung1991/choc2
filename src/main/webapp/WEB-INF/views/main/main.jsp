<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${ productList eq null }">
 	<jsp:forward page="/main/mainModule"/>
</c:if>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	$(function() {

		$("#userId").focus();

		$("#Login").on(
				"click",
				function() {
					var id = $("input:text").val();
					var pw = $("input:password").val();

					console.log("check......!!")

					if (id == null || id.length < 1) {
						alert('ID 를 입력하지 않으셨습니다.');
						$("#userId").focus();
						return;
					}

					if (pw == null || pw.length < 1) {
						alert('패스워드를 입력하지 않으셨습니다.');
						$("#password").focus();
						return;
					}

					$("form").attr("method", "POST").attr("action",
							"/user/login").submit();
				});
	});

	$(function() {
		$("input:password").on('keydown', function(event) {

			if (event.keyCode == 13) {
				event.preventDefault();
				$("#Login").click();
			}

		})

	})
	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "GET").attr("action" , "/main/mainModule").submit();
	}
</script>


</head>

<body>

<%-- <jsp:include page="/WEB-INF/views/user/index.jsp"></jsp:include> --%>



<br/><br/><br/><br/>

	<form>
	
	ID<input type="text" name="userId" id="userId" />
	PW<input type="password" name="password" id="password" />
	<input type="button" id="Login" value="로그인"/>
	<!-- <a href="/user/createUserp">회원가입</a>  -->
	<input type="button" value="회원가입" onclick="location.href='user/createUserP'">
	<br/><br/><br/><br/>
	
		전체 게시물 수 : ${resultPage.totalCount }
		<br/>
		<br/>
		게시하고있는 페이지 : ${resultPage.currentPage } 
		<br/>
		
		<h2><strong>신상품</strong></h2>
		
	
	
	<table>
			<tr>
				<th>제품번호</th>
				<th>제품명</th>
				<th>제품이미지</th>
			</tr>
		
		<c:set var="i" value="0" />
		<c:forEach var="product" items="${productList }" begin="0">
		<c:set var="i" value="${i+1 }"/>
			<tr>
				<td>${product.productNo }</td>
				<td>${product.productModel }</td>
				<td>
					<img src="/resources/imageRepository/${product.productImage }.png" width="50" height="50"/>
				</td>
		</c:forEach>

		</table>
		
	<!-- <input type="hidden" id="currentPage" name="currentPage" value=""/> -->
		
	</form>
	
	<%-- <jsp:include page="./pageNavigator.jsp" /> --%>

</body>


</html>