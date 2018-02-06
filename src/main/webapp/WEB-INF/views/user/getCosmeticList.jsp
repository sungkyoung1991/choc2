<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>



</head>
<body>

	<select name="searchType">
		<option value="brand"
			<c:out value="${cri.searchType eq 'brand'?'selected':''}"/>>
			brand</option>
		<option value="model"
			<c:out value="${cri.searchType eq 'model'?'selected':''}"/>>
			model</option>
		<option value="product"
			<c:out value="${cri.searchType eq 'product'?'selected':''}"/>>
			product</option>
		<option value="amount"
			<c:out value="${cri.searchType eq 'amount'?'selected':''}"/>>
			amount</option>
		<option value="price"
			<c:out value="${cri.searchType eq 'price'?'selected':''}"/>>
			price</option>
		<option value="ingredient"
			<c:out value="${cri.searchType eq 'ingredient'?'selected':''}"/>>
			ingredient</option>

	</select>

	<input type="text" name='keyword' id="keywordInput"
		value='${cri.keyword }'>


	<table>
		<tr>
			<th>CNO</th>
			<th>BRAND</th>
			<th>MODEL</th>
			<th>PRODUCT</th>
			<th>PRICE</th>
			<th>INGREDIENT</th>
		</tr>
		<c:forEach items="${clist}" var="cosmetic">
			<tr>
				<td>${cosmetic.cosmetic_no}</td>
				<td>${cosmetic.brand}</td>
				<td><a
					href='/user/getCosmeticList${pageMaker.makeSearch(pageMaker.cri.page) }&cosmetic_no=${cosmetic.cosmetic_no}'>
						${cosmetic.brand}</a></td>
				<td>${cosmetic.model}</td>
				<td>${cosmetic.price}</td>
				<td>${cosmetic.ingredient}</td>

			</tr>

		</c:forEach>

	</table>

	<ul class="pagination">

		<c:if test="${pageMaker.prev}">
			<li><a
				href="list${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="idx">
			<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
				<a href="list${pageMaker.makeSearch(idx)}">${idx}</a>
			</li>
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="list${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
		</c:if>

	</ul>



</body>
</html>