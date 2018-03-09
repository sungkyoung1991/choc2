<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
 <script type="text/javascript">
 
 $(document).ready(function(){
 	$("#Update").on("click",function(){
	 /* self.location="/user/updateUserInformation"; */
	 $("form").attr("action","/user/updateUserInformationPage").attr("method","POST").submit();
 });
	 
 });
 
 </script>
</head>
<body>
	<form>
	<input type="hidden" name="userNo" value="${mypage.userNo}"/>
	<input type="hidden" name="userId" value="${mypage.userId}"/>
	<input type="hidden" name="email" value="${mypage.email}" />
	<input type="hidden" name="gender" value = "${mypage.gender}"/>
	<input type="hidden" name="phoneNo" value = "${mypage.phoneNo}"/>
	
	
	<table>
	
	<%-- <tr>
			<th>이메일</th>
			<td><input type="text" name="nickName" value="${mypage.email}" readonly="readonly"/> 
	</tr>
	 --%>
	<tr>
			<th>닉네임</th>
			<td><input type="text" name="nickname" value="${mypage.nickname}" readonly="readonly"/> 
	</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" value="${mypage.age}" readonly="readonly"/> 
	</tr>
		
	</table>	
		<input type="button" value="내정보수정" id="Update" />
	</form>

</body>
</html>
