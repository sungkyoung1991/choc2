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
					<input type='text' name='keyword' id='keywordInput'
					value="${cri.keyword}">
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
						
						<c:if test="${pageMaker.prev }">
							<li>
								<a href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a>
							</li>
						</c:if>
						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" 
						var=	"idx">
						<li
							<c:out value="${pageMaker.cri.page==idx?'class =active':'' }"/>>
							<a href ="list${pageMaker.makeSearch(idx)}">${idx}</a> 
							
						</li>
						</c:forEach>
						
						<c:if test="${pageMaker.next && pageMaker.endPage>0 }">
							<li>
							<a href="list${pageMaker.makesearch(pageMaker.endPage + 1)}">&raquo;</a>
							</li>
						</c:if>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
		<script>
			var result = '${msg}';
			if(result == 'SUCCESS'){
				alter('처리가 완료되었습니다.')
			}
		</script>
		
		<script>
		$(document).ready(function(){
			$('#searchBtn').on('click',function(){
				self.location ="list"
								+ "${pageMaker.makeQuery(1)}"
								+ "&searchType="
								+$("select option:selected").val()
								+"&keyword="
								+$("#keywordInput").val();
			});
			
			$('#newBtn').on("click",function(){
				self.location = "create";
			});
		});
		
		
		
		
		</script>
</body>
<%@include file="../include/footer.jsp"%>
</html>