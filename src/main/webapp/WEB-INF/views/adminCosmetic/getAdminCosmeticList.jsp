<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/header.jsp"%>
		<script>
		var result = '${msg}';
		if (result == 'SUCCESS') {
			alter("처리가 완료되었습니다.");
		}
		</script>
		<script>
			var result = '${msg}';
			if (result == 'SUCCESS') {
				alter("처리가 완료되었습니다.");
			}
		
			function fncGetList(currentPage) {
				$("#currentPage").val(currentPage)
				$("form").attr("method", "POST").attr("action", "/admin/cosmetic/list")
						.submit();
			}
			$(function() {
				$("button:contains('검색')").on("click", function() {
					fncGetList(1);
				});
			});
		</script>	
		<script>
		$(document).ready(
				function() {
			$('#newBtn').on("click",function(){
				self.location = "create";
			});
		});
		</script>
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
			<form class="form-inline" name="detailForm">
							<input type="hidden" id = "currentPage" name="currentPage" value="" /> 
							<div class="form-group">
								<select class="form-control" name="searchCondition">
									<option value="0"
										${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>>Brand</option>
									<option value="1"
										${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>>Product</option>
								</select>
							</div>


							<div class="form-group">
								<label class="sr-only" for="searchKeyword">검색어</label> 
								<input type="text" class="form-control" id="searchKeyword"
									name="searchKeyword" placeholder="검색어"
									value="${! empty search.searchKeyword ? search.searchKeyword : '' }">
							</div>
							<button type="button" class="btn btn-default">검색</button>


						</form>
						<button id='newBtn'>New Board</button>
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
							<td>${cosmeticVO.cosmeticNo}</td>
							<td>${cosmeticVO.brand}</td>
							<td>${cosmeticVO.model}</td>		
							<td><a href='/admin/cosmetic/get?currentPage=${search.currentPage}&searchKeyword=${search.searchKeyword}&searchCondition=${search.searchCondition}
							&cosmeticNo=${cosmeticVO.cosmeticNo}'>${cosmeticVO.product}</a></td>
							<td>${cosmeticVO.amount}</td>
							<td>${cosmeticVO.price}</td>
							<td>${cosmeticVO.ingredient}</td>	
						</tr>
						</c:forEach>
					</table>
				</div>
				
				<div class="box-footer">
					<!-- PageNavigation Start... -->
					<jsp:include page="../common/pageNavigator_new.jsp" />
				</div>
			</div>
		</div>
	</div>

</body>
<%@include file="../include/footer.jsp"%>
</html>