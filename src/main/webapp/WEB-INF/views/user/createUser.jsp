<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
 $(document).ready(function(){
	$("#idCheck").click(function(){
		if(document.sform.id.value==""){
			alert("아이디를 입력하세요");
			document.sform.id.focus();
			return false;
		}else{
			var id = document.sform.id.value;
			var data ={
					'id':id
			};
			var setting ={
					url:'/user/idCheck',
					data:data,
					dataType:'json',
					success:function(data){
						if(data.result=="사용가능한 아이디입니다."){
							$('#idResult').html("<font color='blue'>"+data.result+"</font>");
							document.sform.userId.value=id;
						}else{
							$('#idResult').html("<font color='red'>"+data.result+"</font>");
							document.sform.id.focus();
						}
					},
					error:function(){
						alert("error");
					}
			};
			$.ajax(setting);
		}
	});
	
	$("#nickCheck").click(function(){
		if(document.sform.nick.value==""){
			alert("닉네임을 입력하세요");
			document.sform.nick.focus();
			return false;
		}else{
			var nick = document.sform.nick.value;
			var data ={
					'nick':nick
			};
			var setting ={
					url:'/user/nickCheck',
					data:data,
					dataType:'json',
					success:function(data){
						if(data.result=="사용가능한 닉네임입니다."){
							$('#nickResult').html("<font color='blue'>"+data.result+"</font>");
							document.sform.nickName.value=nick;
						}else{
							$('#nickResult').html("<font color='red'>"+data.result+"</font>");
							document.sform.nick.focus();
						}
					},
					error:function(){
						alert("error");
					}
			};
			$.ajax(setting);
		}
	});

}); 
</script>
</head>

	<h2>&nbsp;회원가입 페이지</h2>
	<form action="/user/createUser" method="post" name="sform">
	<table>
		<tr>
			<th>아이디</th>
			<td>
			<input type="text" name="id" id="id" placeholder="아이디"/>
			<input type="hidden" name="userId" />
			<input type="button" value="아이디 중복확인" id="idCheck" />
			<div id="idResult"></div>
			</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" id="password" placeholder="비밀번호"/></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick" id="nick" placeholder="닉네임" />
			<input type="hidden" name="nickName" />
			<input type="button" value="닉네임 중복확인" id="nickCheck" />
			<div id="nickResult"></div>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" placeholder="이름"/></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" placeholder="이메일"/></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" placeholder="주소" /></td>
		</tr>
		<tr>
			<th>핸드폰</th>
			<td><input type="text" name="phoneNumber" id="phoneNumber" placeholder="폰번호-없이 입력해주세요"/></td>
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
			<td><input type="text" name="age" id="age" placeholder="나이"></td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td><input type="text" name="jumin1" id="jumin1">-<input type="text" name="jumnin2" id="jumin2"></td>
		</tr>
		<tr>
			<th></th>
			<td>
			<input type="radio" name="role" value="개인" checked>개인
			<input type="radio" name="role" value="사업자"/>사업자
			<input type="radio" name="role" value="관리자"/>관리자
			</td>
		</tr>
	</table>
		<button type="submit" onclick="confirm();">확인</button>
	</form>
</body>
</html>
