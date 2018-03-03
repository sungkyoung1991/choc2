<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html>
<html>
<head>
<title>Home</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
console.log("1,2,3".split(","));
console.log("helloworld".charAt(0));
console.log(isNan(123));
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
			<h2>You have been successfully logged in</h2>
			<strong>${sessionScope.user.userId}</strong>님, you are very welcome 반가워요!!
			<button id="myPage" onclick="location.href='/user/getMypage?userId=${sessionScope.user.userId}'">마이페이지</button> 
			<a href="/user/getMypage?userId=${sessionScope.user.userId}">마이페이지</a>
	 		<input type="button" value="logout"
				onclick="location.replace('/user/logout');" />
			<!-- <a href="/user/logout" >logout</a> -->
		</c:when>
		<c:otherwise>
			<!-- 로그아웃 했을때 -->
			<h2>You have been successfully logged out..</h2>
			<form>
				<input type="text" name="userId" id="userId" /> <input
					type="password" name="password" id="password" /> <input
					type="button" id="Login" value="login" />
			</form>
		</c:otherwise>
	</c:choose>



</body>
</html>
