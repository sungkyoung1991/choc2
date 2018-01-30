<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Home</title>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">


$( function() {
	
	$("#userId").focus();
	
	$("#loginButton").on("click" , function() {
		var id=$("input:text").val();
		var pw=$("input:password").val();
		
		console.log("check......!!")
		
		if(id == null || id.length <1) {
			alert('ID 를 입력하지 않으셨습니다.');
			$("#userId").focus();
			return;
		}
		
		if(pw == null || pw.length <1) {
			alert('패스워드를 입력하지 않으셨습니다.');
			$("#password").focus();
			return;
		}
		
		$("form").attr("method","POST").attr("action","/user/login").submit();
	});
});	

</script>

	
</head>
<body>

<c:choose>
<!--로그인 했을때-->
<c:when test="${sessionScope.user.userId!=null }">
	<h2>You have been successfully logged in</h2>
	<strong>${sessionScope.user.userId}</strong>님, you are very welcome 반가워요!!
	 <input type="button" value="logout" onclick="location.replace('/user/logout');"/>
	<!-- <a href="/user/logout" >logout</a> -->
</c:when>
<!--로그아웃 했을때-->
<c:otherwise>
 	<h2>You have been successfully logged out..</h2>
	 <form>
		<input type="text" name="userId" id="userId" />
		<input type="password" name="password" id="password" />
		<input type="button" id="loginButton" value="login"/>
	</form>
</c:otherwise>
</c:choose>

</body>
</html>
