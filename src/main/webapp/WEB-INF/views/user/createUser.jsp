<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

var regExp1 = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/; //아이디,비밀번호 영문,숫자혼합하여 6~20자

//아이디 중복확인
$(document).ready(function(){
	$("#idCheck").click(function(){
		if(document.sform.id.value==""){
			alert("아이디를 입력하세요");
			document.sform.id.focus();
			return false;
		}else if(document.sform.id.value.indexOf(" ") >= 0) {
            alert("아이디에 공백을 사용할 수 없습니다");
            document.sform.id.focus(); 
            return false;
		}else if(!regExp1.test(document.sform.id.value)){
			alert("아이디를 확인하세요 \n(영문,숫자를 혼합하여 6~20자 이내)");
             id.focus();
             return false;
		}else{
			var id = document.sform.id.value;
			var data ={
					'userId':id
			};
			var setting ={
					url:'/user/idCheck',
					data:data,
					dataType:'json',
					success:function(data){
						if(data.result=="사용가능한 아이디입니다"){
							$('#idResult').html("<font color='blue' size='2px'>"+data.result+"</font>");
							document.sform.userId.value=id;
						}else{
							$('#idResult').html("<font color='red' size='2px'>"+data.result+"</font>");
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
	
	//닉네임 중복확인
	$("#nickCheck").click(function(){
		if(document.sform.nick.value==""){
			alert("닉네임을 입력하세요");
			document.sform.nick.focus();
			return false;
		}else{
			var nick = document.sform.nick.value;
			var data ={
					'nickname':nick
			};
			var setting ={
					url:'/user/nickCheck',
					data:data,
					dataType:'json',
					success:function(data){
						if(data.result=="사용가능한 닉네임입니다"){
							$('#nickResult').html("<font color='blue' size='2px'>"+data.result+"</font>");
							document.sform.nickname.value=nick;
						}else{
							$('#nickResult').html("<font color='red' size='2px'>"+data.result+"</font>");
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
 
 function confirm(){
	 
	 var regex = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; //이메일 유효성 검사
		
	 if(id.value==""){
			alert("아이디를 입력하세요");
			 id.focus(); 
			/* document.getElementById("id").focus();  */
			 return false; 
		}else if(!regExp1.test(document.sform.id.value)){
            //아이디 6~20자의 영문, 숫자의 유효성이 안 맞을시 
			alert("아이디를 확인하세요 \n(영문,숫자를 혼합하여 6~20자 이내)");
             id.focus();
             return false;
        }else if(document.sform.id.value.indexOf(" ") >= 0) {
           	alert("아이디에 공백을 사용할 수 없습니다.");
            document.sform.id.focus(); 
            return false;
	    }else if(document.sform.userId.value==""){
			alert("아이디 중복체크하세요");
			document.getElementById("idCheck").focus();
			return false;
		}else if(password.value==""){
			alert("비밀번호를 입력하세요");
			document.sform.password.focus();
			return false;
		}else if(!regExp1.test(document.sform.password.value)){
            //비밀번호 6~20자의 영문, 숫자의 유효성이 안 맞을시 
			alert("비밀번호를 확인하세요 \n(영문,숫자를 혼합하여 6~20자 이내)");
             password.focus();
             return false;
		}else if(document.sform.nick.value==""){
			alert("닉네임을 확인하세요");
			document.sform.nick.focus();
			return false;
		}else if(document.sform.nickname.value==""){
			alert("닉네임을 중복체크하세요");
			document.getElementById("nickCheck").focus();
			return false;
		}else if(document.sform.name.value==""){
			alert("이름을 입력하세요");
			document.sform.name.focus();
			return false;
		}else if(document.sform.name.value.length<2){
            alert("이름을 2자 이상 입력해주십시오")
            document.sform.name.focus()
            return false;
        }else if(document.sform.email.value==""){
			alert("이메일을 입력하세요");
			document.sform.email.focus();
			return false;	
		}else if (regex.test(document.sform.email.value) === false) {
            alert("잘못된 이메일 형식입니다");
            document.sform.email.focus();
            return false;
        }else if(document.sform.address.value==""){
			alert("주소를 입력하세요");
			document.sform.address.focus();
			return false;
		}else if(document.sform.phoneNo.value==""){
			alert("핸드폰번호를 입력하세요");
			document.sform.phoneNo.focus();
			return false;
		}else if(isNaN(document.sform.phoneNo.value)){
			alert("-없이 숫자만 입력해주세요");
			document.sform.phoneNo.focus();
			return false;
 		}else if(document.getElementById("gender1").checked==false&&document.getElementById("gender2").checked==false){
			alert("성별을 체크해주세요");
			document.getElementById("gender1").focus();
			return false;
 		}else if(document.sform.age.value==""){
			alert("나이를 입력하세요");
			document.sform.age.focus();
			return false;	
		}else if(isNaN(document.sform.age.value)){
			alert("숫자만 입력해주세요");
			document.sform.age.focus();
			return false;
 		}else if(document.getElementById("role1").checked==false&&document.getElementById("role2").checked==false&&document.getElementById("role3").checked==false){
			alert("사용자를 체크해주세요");
			document.getElementById("role1").focus();
			return false;	 
 		}else{
 			document.sform.jumin.value=document.sform.jumin1.value+document.sform.jumin2.value;
 			return true;
 		}
 }
 
</script>
</head>

<h2>&nbsp;회원가입 페이지</h2>
<form action="/user/createUser" method="post" name="sform">
	<!-- <input type="hidden" name="userNo"> -->
	<table>
		
		<tr>
			<th>아이디</th>
			<td><input type="text" name="id" id="id" size="25" placeholder="영문,숫자 혼합 6~20자 이내" /> <input
				type="hidden" name="userId" /> <input type="button"
				value="아이디 중복확인" id="idCheck" />
				<div id="idResult"></div></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><input type="password" name="password" id="password" size="25"
				placeholder="영문,숫자 혼합 6~20자 이내" /></td>
		</tr>
		<tr>
			<th>닉네임</th>
			<td><input type="text" name="nick" id="nick" size="25"/>
				<input type="hidden" name="nickname" /> <input type="button"
				value="닉네임 중복확인" id="nickCheck" />
				<div id="nickResult"></div></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" name="name" id="name" size="25"/></td>
		</tr>
		
	<%-- 	<c:if test="${fuser!=null}">
			<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" value="${fuser.email}"/></td>
		</tr>
		</c:if> --%>
		
		<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" placeholder="abc123@gmail.com" size="25" /></td>
		</tr>
		<!-- <tr>
			<th>주소</th>
			<td><input type="text" name="address" id="address" placeholder="주소" /></td>
		</tr> -->
		<tr>
			<th>핸드폰</th>
			<td><input type="text" name="phoneNo" id="phoneNo"
				placeholder="폰번호-없이 입력해주세요" size="25"/></td>
		</tr>
	<%-- 	<c:if test="${fuser.gender==female}">
			<tr>
			<th>이메일</th>
			<td><input type="text" name="email" id="email" value="${fuser.email}"/></td>
		</tr>
		</c:if> --%>
		
		<tr>
			<th>성별</th>
			<td><input type="radio" name="gender" value="여자" id="gender1">여자
				<input type="radio" name="gender" value="남자" id="gender2">남자</td>
		</tr>
		<tr>
			<th>나이</th>
			<td><input type="text" name="age" id="age" placeholder="나이" size="25"></td>
		</tr>
		<!-- <tr>
			<th>주민번호</th>
			<td><input type="text" name="jumin1" id="jumin1">-<input
				type="text" name="jumnin2" id="jumin2"></td>
		</tr> -->
		<tr>
			<th></th>
			<td><input type="radio" name="role" value="USER" id="role1">개인
				<input type="radio" name="role" value="ADMIN" id="role2"/>사업자 <input
				type="radio" name="role" value="SUPER" id="role3"/>관리자</td>
		</tr>
		<!--  <input type="checkbox" name="check_info value="check1""/>체크1
		<input type="checkbox" name="check_info value="check2""/>체크2
		<input type="checkbox" name="check_info value="check3""/>체크3  -->
	</table>
	<button type="submit" onclick="return confirm();">확인</button>
</form>
</body>
</html>
