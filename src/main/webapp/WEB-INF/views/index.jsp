<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h1>
	Hello world!  
</h1>
<h2>test</h2>

<c:choose>
<c:when test="${sessionScope.user.userId!=null }">
	<strong>${sessionScope.user.userId}</strong>님 반갑습니다.
	<input type="button" value="logout" onclick="location.replace('/user/logout');"/>
	<a href="/user/logout" >logout</a>
</c:when>
<c:otherwise>
	<form action="/user/login" method="post">
		<input type="text" name="userId" id="userId" />
		<input type="password" name="password" id="password" />
		<input type="button" id="loginButton" value="login"/>
	</form>
</c:otherwise>


<%-- <P>  The time on the server is ${serverTime}. </P> --%>

</c:choose>
</body>
</html>
