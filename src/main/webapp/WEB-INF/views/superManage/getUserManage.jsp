<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function() {

		var formObj = $("form[role='form']");

		console.log(formObj);

		$("#modifyBtn").on("click", function() {
			formObj.attr("action", "/super/userManage/update");
			formObj.attr("method", "get");
			formObj.submit();
		});

		$("#removeBtn").on("click", function() {
			formObj.attr("action", "/super/userManage/delete");
			formObj.submit();
		});

		$("#goListBtn ").on("click", function() {
			formObj.attr("method", "get");
			formObj.attr("action", "/super/userManage/list");
			formObj.submit();
		});

	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form role="form" action="/super/userManage/update" method="post">

		<input type='hidden' name='userNo' value="${userVO.userNo}">
 		<input type='hidden' name='page' value="${cri.page}"> <input
			type='hidden' name='perPageNum' value="${cri.perPageNum}"> <input
			type='hidden' name='searchType' value="${cri.searchType}"> <input
			type='hidden' name='keyword' value="${cri.keyword}">
 
	</form>
	<div>
		<div class="form-group">
			<label>UserNo</label> <input type="text" name="userNo"
				value="${userVO.userNo}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>Role</label> <input type="text" name="role"
				value="${userVO.role}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>UserId</label> <input type="text" name="userId"
				value="${userVO.userId}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>nickname</label> <input type="text" name="nickname"
				value="${userVO.nickname}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>name</label> <input type="text" name="name"
				value="${userVO.name}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>email</label> <input type="text" name="email"
				value="${userVO.email}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>address</label> <input type="text" name="userNo"
				value="${userVO.address}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>phoneNo</label> <input type="text" name="userNo"
				value="${userVO.phoneNo}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>gender</label> <input type="text" name="gender"
				value="${userVO.gender}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>age</label> <input type="text" name="age"
				value="${userVO.age}" readonly="readonly">
		</div>
	</div>

	<div class="box-footer">
		<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
		<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
		<button type="submit" class="btn btn-primary" id="goListBtn">GO
			LIST</button>
	</div>
</body>
</html>