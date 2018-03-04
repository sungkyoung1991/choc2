<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/header.jsp"%>
<title>Insert title here</title>
</head>
<body>
<%@include file="../include/nav.jsp"%>
	<!-- Main content -->
	<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">MODIFY BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="update" method="post">

					<input type='hidden' name='page' value="${cri.page}"> 
					<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
					<input type='hidden' name='searchType' value="${cri.searchType}">
					<input type='hidden' name='keyword' value="${cri.keyword}">

					<div class="box-body">

						<div class="form-group">
							<label for="exampleInputEmail1">BNO</label> <input type="text"
								name='boardNo' class="form-control" value="${boardVO.boardNo}"
								readonly="readonly">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Title</label> <input type="text"
								name='title' class="form-control" value="${boardVO.title}">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Content</label>
							<textarea class="form-control" name="content" rows="3">${boardVO.content}</textarea>
						</div>
						<div class="form-group">
							<label for="exampleInputEmail1">UserId</label> <input type="text"
								name="userId" class="form-control" value="${boardVO.userId}"readonly="readonly">
						</div>
					</div>
					<!-- /.box-body -->
				</form>
				<div class="box-footer">
					<button type="submit" class="btn btn-primary">SAVE</button>
					<button type="submit" class="btn btn-warning">CANCEL</button>
				</div>
				
				
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
				<script>
					$(document)
							.ready(
									function() {
										var formObj = $("form[role='form']");
										console.log(formObj);
										$(".btn-warning").on("click",function() {
											formObj.attr("method", "get");
											formObj.attr("action", "/admin/board/list");
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




			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row --> </section>
	<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->

</body>
<%@include file="../include/footer.jsp"%>
</html>