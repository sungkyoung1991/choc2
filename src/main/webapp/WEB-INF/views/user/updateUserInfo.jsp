<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId" id="idCheck" value="${user.id}" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" id="password" value="${user.password}"/></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick" id="nick" value = "${user.nickname}"/>
		</tr>
		
			<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" value="${user.email}"/></td>
		</tr>
		
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" placeholder="주소" /></td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td><input type="text" name="phoneNo" id="phoneNo"/></td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td><input type="radio" name="gender" value="여자" id="gender1" <c:if test="${value=='여자'}">checked</c:if> />여자 
				<input type="radio" name="gender" value="남자" id="gender2" <c:if test="${value=='남자'}">checked</c:if> />남자</td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age" placeholder="나이"></td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td><input type="text" name="jumin1" id="jumin1">-<input
				type="text" name="jumnin2" id="jumin2"></td>
		</tr>
		<tr>
			<th></th>
			<td><input type="radio" name="role" value="개인" id="role1">개인
				<input type="radio" name="role" value="사업자" id="role2"/>사업자 <input
				type="radio" name="role" value="관리자" id="role3"/>관리자</td>
		</tr>
	</table>
	



</body>
</html>