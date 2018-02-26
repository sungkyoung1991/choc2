<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
	<%-- <input type="text" name="userId" id="idCheck" value="${user.id}" />
	<input type="password" name="password" id="password" value="${user.password}"/>
	<input type="text" name="nick" id="nick" value = "${user.nickName}"/>
	<input type="text" name="email" id="email" value="${user.email}"/> --%>
	
	<table>
	
	<tr>
			<th>닉네임</th>
			<td><input type="text" name="nickName" value="${mypage.nickName}"/> 
	</tr>
		
	</table>	
		<input type="button" value="내정보수정"  />
	</form>
</body>
</html>