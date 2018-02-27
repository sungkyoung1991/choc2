<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@include file="../include/header.jsp"%>
<script>
	$(document).ready(
			function() {
				$('#searchBtn').on(
						"click",
						function(event) {
							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();
						});

			});

	/* 	$('#newBtn').on("click", function(evt) {
	self.location = "create";
	}); */
</script>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class='box-body'>

		<select name="searchType">
			<option value="n"
				<c:out value="${cri.searchType == null?'selected':''}"/>>
				---</option>
			<option value="r"
				<c:out value="${cri.searchType eq 'r'?'selected':''}"/>>
				Role</option>
			<option value="u"
				<c:out value="${cri.searchType eq 'u'?'selected':''}"/>>
				UserId</option>
			<option value="na"
				<c:out value="${cri.searchType eq 'na'?'selected':''}"/>>
				Name</option>
			<option value="g"
				<c:out value="${cri.searchType eq 'g'?'selected':''}"/>>
				Gender</option>

		</select> <input type="text" name='keyword' id="keywordInput"
			value='${cri.keyword }'>
		<button id='searchBtn'>Search</button>
		<!-- 		<button id='newBtn'>New Board</button> -->

	</div>
	<div>
		<div>
			<H3>UserManagement</H3>
		</div>
		<table>
			<tr>
				<th>commonNo</th>
				<th>ROLE</th>
				<th>UserID</th>
				<th>Name</th>
				<th>Nickname</th>
				<th>E-Mail</th>
				<th>Address</th>
				<th>Phon_no</th>
				<th>Gender</th>
				<th>AGE</th>
			</tr>
			<c:forEach items="${list}" var="userVO">
				<tr>
					<th>${userVO.commonNo}</th>
					<th>${userVO.role}</th>
					<th><a
						href="/super/userManage/get${pageMaker.makeSearch(pageMaker.cri.page) }&userNo=${userVO.userNo}">${userVO.userId}</a></th>
					<th>${userVO.nickname}</th>
					<th>${userVO.name}</th>
					<th>${userVO.email}</th>
					<th>${userVO.address}</th>
					<th>${userVO.phoneNo}</th>
					<th>${userVO.gender}</th>
					<th>${userVO.age}</th>

				</tr>
			</c:forEach>
		</table>
		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
				</c:if>

			</ul>
		</div>
	</div>
</body>
</html>