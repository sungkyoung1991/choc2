<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div>
		<table>
			<tr>
				<th>COMMON_NO</th>
				<th>ROLE</th>
				<th>UserID</th>
				<th>Name</th>
				<th>Nickname</th>
				<th>E-Mail</th>
				<th>Address</th>
				<th>Phon_no</th>
				<th>Gender</th>
				<th>AGE</th>
				<th>Update</th>
			</tr>
			<c:forEach items="${list}" var="userVO">
				<tr>
					<th>${userVO.common_no}</th>
					<th>${userVO.role}</th>
					<th>${userVO.userId}</th>
					<th>${userVO.nickName}</th>
					<th>${userVO.name}</th>
					<th>${userVO.email}</th>
					<th>${userVO.address}</th>
					<th>${userVO.phoneNo}</th>
					<th>${userVO.gender}</th>
					<th>${userVO.age}</th>
					<th><a href="/super/userManage/get?userNo="${userVO.userNo}> </a></th>
				</tr>
			</c:forEach>
		</table>	
	</div>
</body>
</html>