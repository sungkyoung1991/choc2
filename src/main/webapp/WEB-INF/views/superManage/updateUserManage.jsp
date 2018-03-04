<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
				<script>
					$(document)
							.ready(
									function() {
										var formObj = $("form[role='form']");
										console.log(formObj);
										$(".btn-warning").on("click",function() {
											formObj.attr("method", "get");
											formObj.attr("action", "/super/userManage/list");
											formObj.submit();
															/* self.location = "/admin/board/list"; */
														});
										/* ?page=${cri.page}&perPageNum=${cri.perPageNum}"
										+ "$searchType=${cri.searchType}&keyword=${cri.keyword}" */
										$(".btn-primary").on("click",
												function() {
													formObj.submit();
												});
									});
				</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form role="form" action="update" method="post">

			<input type='hidden' name='page' value="${cri.page}"> <input
				type='hidden' name='perPageNum' value="${cri.perPageNum}"> <input
				type='hidden' name='searchType' value="${cri.searchType}"> <input
				type='hidden' name='keyword' value="${cri.keyword}"> 

			<div>
		<div class="form-group">
			<label>UserNo</label> <input type="text" name="userNo"
				value="${userVO.userNo}" readonly="readonly">
		</div>
		<div class="form-group">
			<label>Role</label> <input type="text" name="role"
				value="${userVO.role}" >
		</div>
		<div class="form-group">
			<label>UserId</label> <input type="text" name="userId"
				value="${userVO.userId}" >
		</div>
		<div class="form-group">
			<label>nickname</label> <input type="text" name="nickname"
				value="${userVO.nickname}" >
		</div>
		<div class="form-group">
			<label>name</label> <input type="text" name="name"
				value="${userVO.name}" >
		</div>
		<div class="form-group">
			<label>email</label> <input type="text" name="email"
				value="${userVO.email}" >
		</div>
		<div class="form-group">
			<label>address</label> <input type="text" name="userNo"
				value="${userVO.address}" >
		</div>
		<div class="form-group">
			<label>phoneNo</label> <input type="text" name="phoneNo"
				value="${userVO.phoneNo}" >
		</div>
		<div class="form-group">
			<label>gender</label> <input type="text" name="gender"
				value="${userVO.gender}" >
		</div>
		<div class="form-group">
			<label>age</label> <input type="text" name="age"
				value="${userVO.age}" >
		</div>
	</div>
			<!-- /.box-body -->
		</form>
		<div class="box-footer">
			<button type="submit" class="btn btn-primary">SAVE</button>
			<button type="submit" class="btn btn-warning">CANCEL</button>
		</div>
	</div>
</body>
</html>