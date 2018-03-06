<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인 됬을때 화면</title>
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
		
		$("#Logout").on("click",function(){
			self.location="/user/logout";
			
		});
		
	});
</script>

</head>
<body>
	<c:choose>
		<c:when test="${sessionScope.user.userId!=null }">
			<!-- 로그인 했을때 --> 
			<ul class="nav navbar-nav">
		    <li><a href="/">home</a></li>
		    <li><a href="/admin/cosmetic/list">상품 관리</a></li>
		    <li><a href="/admin/board/list">게시판 관리</a></li>
		    <li><a href="/super/userManage/list">회원 관리</a></li>
		    <li><a href="/user/getCosmeticList">유저 상품 게시판</a></li>
		    
		   </ul>
		   
			<h3>You have been successfully logged in!</h3>
			<strong>${sessionScope.user.userId}</strong>님, you are very welcome 반가워요:)
			 <a href="/user/getMyPage?userId=${sessionScope.user.userId}">마이페이지</a> 
	 	<!-- 	<input type="button" onclick="location.replace('/user/logout');" /> -->
				<button type="button" id="Logout">Logout</button>
		</c:when>
	</c:choose>



</body>
</html>
