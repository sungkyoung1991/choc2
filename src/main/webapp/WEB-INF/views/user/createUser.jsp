<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script> src="https://code.jquery.com/jquery-3.1.1.min.js"</script>
<script type="text/javascript">
/*  $(document).ready(function(){
	$("#idCheck").click(function(){
		if(document.sform.userId.value==""){
			alert("아이디를 입력하세요");
			document.sform.userId.focus();
			return false;
		}else{
			var userId = document.sform.userId.value;
			var data ={
					'id':userId
			};
			var setting ={
					url:'/idchk',
					data:data,
					dataType:'json',
					success:function(data){
						if(data){
							
						}else{
							
						}
					},
					error:function(){
						alert("error");
					}
					
			};
			$.ajax(setting);
		}
	});
	
	$("#nicheck").click(function(){
		if(document.sform.nickName.value==""){
			alert("닉네임을 입력해주세요");
			document.sform.nickName.focus();
		}else{
			
			
		}
	});
	
});
 */
</script>
</head>

	<h2>회원가입 페이지</h2>
	<form action="/user/createUser" method="post" name="sform">
	<table>
		<tr>
			<th>아이디</th>
			<td><input type="text" name="userId" id="userId" /></td>
			<td><input type="button" value="아이디체크" id="idCheck" /></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" id="password" /></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nickName" placeholder="닉네임" id="nickName" /></td>
			<td><input type="button" value="닉네임체크" id="nickCheck" /></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" /></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" /></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" /></td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td><input type="text" name="phoneNumber" id="phoneNumber" /></td>
		</tr>
		<tr>
			<th>성별</th>
			<td>
				<input type="radio" name="gender" value="여자"checked>여자
				<input type="radio" name="gender" value="남자">남자
			</td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age"></td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td><input type="text" name="jumin1" id="jumin1">-<input type="text" name="jumnin2" id="jumin2"></td>
		</tr>
		<tr>
			<td>
			<input type="radio" name="role" value="개인" checked>개인
			<input type="radio" name="role" value="사업자"/>사업자
			<input type="radio" name="role" value="관리자"/>관리자
			</td>
		</tr>
	</table>
		<button type="submit">확인</button>
	</form>
</body>
</html>
