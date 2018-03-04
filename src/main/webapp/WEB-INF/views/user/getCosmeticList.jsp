<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- <style type="text/css">
a:link {text-decoration: none; color: blue;}
a:visited {text-decoration: none; color: green;}
a:active {text-decoration: none; color: grey;}
a:hover {text-decoration: underline; color: red;}

</style> -->

<script type="text/javascript">

$(document).ready(function(){
	$('#searchBtn').click(function(){
				self.location = "/user/getCosmeticList"
						+'${pageMaker.makeQuery(1)}'
						+"&searchType="
						+$("select option:selected").val()
						+"&keyword="
						+$('#keywordInput').val();
			});
	$('#newBtn').click(function(){
		self.location = "/user/createCosmeticP";
	});
})
</script>
<%@include file="../include/header.jsp"%>
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
	<input type="text" name='keyword' id="keywordInput" value='${cri.keyword }'>
	
	<button id='searchBtn'>Search</button>
	<button id='newBtn'>New Board</button>
	<br/><br/>
	<table>
		<!-- <tr>
			<th>&nbsp;PICTURE &nbsp;</th>
			<th>CNO</th>
			<th>&nbsp;BRAND &nbsp;</th>
			<th>&nbsp;MODEL &nbsp;</th>
			<th>&nbsp;PRODUCT</th>
		 	<th>PRICE</th>
			<th>INGREDIENT</th> 
		</tr> -->
		<c:forEach items="${clist}" var="cosmetic">
			
			<tr>
				<td><a href='/user/getCosmetic?${pageMaker.makeSearch(pageMaker.cri.page) }&cosmeticNo=${cosmetic.cosmeticNo}'><img alt="picture" src="${cosmetic.image}" height="100px" width="100px"></a></td>
			<%-- <td>${cosmetic.cosmeticNo}</td> --%>
				<td><a href='/user/getCosmetic?${pageMaker.makeSearch(pageMaker.cri.page) }&cosmeticNo=${cosmetic.cosmeticNo}'><font color="gray">${cosmetic.brand}</font></a><br>
			<%-- <td>${cosmetic.model}</td> --%>
				 <a href='/user/getCosmetic?${pageMaker.makeSearch(pageMaker.cri.page) }&cosmeticNo=${cosmetic.cosmeticNo}'>${cosmetic.product}</a></td>
				<%-- <td>${cosmetic.image}</td> --%>
			<%-- <td>${cosmetic.cosmeticNo}</td> --%>
				<%-- <td>${cosmetic.brand}</td> --%>
			<%-- 	<td><a href='/user/getCosmetic${pageMaker.makeSearch(pageMaker.cri.page) }&cosmeticNo=${cosmetic.cosmeticNo}'>
						${cosmetic.model}</a></td> --%>
				<%--  <td>${cosmetic.product}</td>  --%>
				<%-- <td>${cosmetic.price}</td>
				<td>${cosmetic.ingredient}</td>  --%>
			</tr>
			
		</c:forEach>
			
	</table>
			<hr>

	<ul class="pagination">

		<c:if test="${pageMaker.prev}">
			<li><a href="getCosmeticList${pageMaker.makeSearch(pageMaker.startPage - 1)}">&laquo;</a></li>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }"
			var="idx">
			<li <c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
				<a href="getCosmeticList${pageMaker.makeSearch(idx)}">${idx}</a>
			</li>
		</c:forEach>

		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<li><a href="getCosmeticList${pageMaker.makeSearch(pageMaker.endPage +1)}">&raquo;</a></li>
		</c:if>

	</ul>

</body>
<%@include file="../include/footer.jsp"%>
</html>