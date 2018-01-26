<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

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
<form>

login page



<input type="text" name="userId" id="userId" />
<input type="password" name="password" id="password" />

<input type="button" id="loginButton" value="로그인"/>


deploy test...


</form>
</body>


</html>