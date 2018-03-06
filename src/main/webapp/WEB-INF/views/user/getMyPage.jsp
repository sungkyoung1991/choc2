<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>마이페이지</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
	<form>
	<%-- <input type="text" name="userId" id="idCheck" value="${user.id}" />
	<input type="password" name="password" id="password" value="${user.password}"/>
	<input type="text" name="nick" id="nick" value = "${user.nickName}"/>
	<input type="text" name="email" id="email" value="${user.email}"/> --%>
	
	<table>
	<tr>
			<th>이메일</th>
			<td><input type="text" name="email" value="${mypage.email}" readonly="readonly"/> 
	</tr>
	
	<tr>
			<th>닉네임</th>
			<td><input type="text" name="nickname" value="${mypage.nickname}" readonly="readonly"/> 
	</tr>
		
	</table>	
		<input type="button" value="내정보수정"  />
	</form>
</body>
</html>