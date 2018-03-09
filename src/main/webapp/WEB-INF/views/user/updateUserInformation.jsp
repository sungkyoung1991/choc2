<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>개인회원정보 수정</title>
 <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		$("#Update").on("click",function(){
			if(confirm("수정하시겠습니까?")){
			$("form").attr("method","POST").attr("action","/user/updateUserInformation").submit();
			alert("수정되었습니다.");	
			}
			
		});
	
	
	});


</script>
</head>
<body>
	
	<form>
	<table>
		<input type="hidden" name="userNo" value="${User.userNo}"/>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId" id="idCheck" value="${User.userId}" /></td>
		</tr>
	<%-- 	<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" id="password" value="${User.password}"/></td>
		</tr> --%>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick" id="nick" value = "${User.nickname}"/>
		</tr>
		
			<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" value="${User.email}"/></td>
		</tr>
		
		<!-- <tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" placeholder="주소" /></td>
		</tr> -->
		<tr>
			<th>핸드폰</th>
			<td><input type="text" name="phoneNo" value="${User.phoneNo}"/></td>
		</tr>
		
		<tr>
			<th>성별</th>
			<td><input type="radio" name="gender" value="여자" id="gender1" <c:if test="${User.gender=='여자'}">checked</c:if> />여자 
				<input type="radio" name="gender" value="남자" id="gender2" <c:if test="${User.gender=='남자'}">checked</c:if> />남자</td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age" value="${User.age}"></td>
		</tr>
		<!-- <tr>
			<th>주민번호</th>
			<td><input type="text" name="jumin1" id="jumin1">-<input
				type="text" name="jumnin2" id="jumin2"></td>
		</tr> -->
<!-- 		<tr>
			<th></th>
			<td><input type="radio" name="role" value="개인" id="role1">개인
				<input type="radio" name="role" value="사업자" id="role2"/>사업자 <input
				type="radio" name="role" value="관리자" id="role3"/>관리자</td>
		</tr> -->
	</table>
	
			<button type="button" id="Update">저장</button>
	</form>

</body>
</html>