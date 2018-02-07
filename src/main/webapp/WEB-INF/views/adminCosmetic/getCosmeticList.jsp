<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/nav.jsp"%>

	<!-- Main content -->

	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">Cosmetic List</h3>
				</div>
				<div class="box-body">
					<select name="seachType">
						<option value="n"
							<c:out value="${cri.searchType == null?'selected' : ''}"/>>
							---</option>
						<option value="t"
							<c:out value="${cri.searchType eq 't'?'selected' : '' }"/>>
							Title</option>
						<option value="c"
							<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
							Content</option>
						<option value="w"
							<c:out value="${cri.searchType eq 'w'?'selected':''}"/>>
							Writer</option>
						<option value="tc"
							<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
							Title OR Content</option>
						<option value="cw"
							<c:out value="${cri.searchType eq 'cw'?'selected':''}"/>>
							Content OR Writer</option>
						<option value="tcw"
							<c:out value="${cri.searchType eq 'tcw'?'selected':''}"/>>
							Title OR Content OR Writer</option>
					</select>
					<input type='text' name='keyword' id='keywordInput'
					value="${cri.keyowrd}">
					<button id ='searchBtn'>Search</button>
					<button id ='NewBtn'>New Cosmetic</button>
				</div>
			</div>
			
			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST PAGING</h3>
				</div>
				<div class="box-body">
					<table class="table table-bordered">
						<tr>
							<th style="width: 10px">CNO</th>
							<th>BRAND</th>
							<th>MODEL</th>
							<th>PRODUCT</th>
							<th>AMOUNT</th>
							<th>PRICE</th>
							<th>INGREDIENT</th>
						</tr>
						<c:forEach items="${list}" var="cosmeticVO">
						<tr>
							<td>${cosmeticVO.cosmetic_no}</td>
							<td>${cosmeticVO.brand}</td>
							<td><a href='/admin/cosmetic/get${pageMaker.makeSearch(pageMaker.cri.page) }
							&cosmetic_no=${cosmeticVO.cosmetic_no}'>${cosmeticVO.model}</a></td>		
							<td>${cosmeticVO.product}</td>
							<td>${cosmeticVO.amount}</td>
							<td>${cosmeticVO.price}</td>
							<td>${cosmeticVO.ingredient}</td>	
						</tr>
						</c:forEach>
					</table>
				</div>
				
				<div class="box-footer">
					<div class="text-center">
						<ul class="pagination">
						
						
						
						
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
<%@include file="../include/footer.jsp"%>
</html>