<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<%-- <c:if test="${ mainModule eq null }">
 	<jsp:forward page="/main/mainModule"/>
</c:if> --%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">


$( function() {
	
	$("#userId").focus();
	
	$("#Login").on("click" , function() {
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



$(function(){
			$("input:password").on('keydown',function(event){
	
			if(event.keyCode ==13){
				event.preventDefault();
 				$( "#Login" ).click();
		}
		
	})
	
})

</script>


</head>

<body>
<form>



ID<input type="text" name="userId" id="userId" />
PW<input type="password" name="password" id="password" />
<input type="button" id="Login" value="로그인"/>
<!-- <a href="/user/createUserp">회원가입</a>  -->
<input type="button" value="회원가입" onclick="location.href='user/createUserP'">
<br/><br/><br/><br/>

1.deploy test...
<br/>
2.sk _ enterkey event append
<br/>
3.sk _ loginInterceptor append
<br/>

</form>
</body>


</html>