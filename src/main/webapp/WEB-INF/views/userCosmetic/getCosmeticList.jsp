<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>화장품 리스트 받아오기</title>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<!-- <style type="text/css">
a:link {text-decoration: none; color: blue;}
a:visited {text-decoration: none; color: green;}
a:active {text-decoration: none; color: grey;}
a:hover {text-decoration: underline; color: red;}
</style> -->
<script type="text/javascript">

$(document).ready(function(){
	/* $('#Search').click(function(){
		self.location = "/user/getCosmeticList"
						+'${pageMaker.makeQuery(1)}'
						+"&searchType="
						+$("select option:selected").val()
						+"&keyword="
						+$('#keywordInput').val();
			}); */
	$('#Create').click(function(){
		self.location = "/user/createCosmeticPage";
	});
})

 
function fncGetList(currentPage) {
	$("#currentPage").val(currentPage)
	$("form").attr("method" , "POST").attr("action" , "/user/getCosmeticList").submit();
}
	$(function(){
		 $( "button:contains('검색')" ).on("click" , function() {
			fncGetList(1);
		});
 });

</script>

<%@include file="../include/header.jsp"%>
</head>
<body>

	
	전체  ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage}  페이지
		<form name="detailForm">
	
	<select name="searchCondition">
		<option value="brand" ${ ! empty search.searchCondition && search.searchCondition=="brand"?"selected" : ""}>브랜드</option>
		<option value="product" ${ ! empty search.searchCondition && search.searchCondition=="product"?"selected" : ""}>모델</option>

	</select>
	
	<input type="text" id="searchKeyword" name="searchKeyword"  placeholder="검색어"
				    			 value="${! empty search.searchKeyword ? search.searchKeyword : '' }"  >
	
	<button type="button">검색</button>
	
	 <button type="button" id='Create'>화장품 정보입력</button> 
	<br/><br/>
		
		<c:set var="i" value="0" />
		<c:forEach var="cosmetic" items="${list}" >
			<c:set var="i" value="{i+1}" />
			
			
			<a href='/user/getCosmetic?cosmeticNo=${cosmetic.cosmeticNo}'><img alt="picture" src="${cosmetic.image}" height="100px" width="100px"></a>
			<a href='/user/getCosmetic?cosmeticNo=${cosmetic.cosmeticNo}'><font color="gray">${cosmetic.brand}</font></a>
			<a href='/user/getCosmetic?cosmeticNo=${cosmetic.cosmeticNo}'>${cosmetic.product}</a>
			<br>
			
		</c:forEach>
			

			<hr>
	<input type="hidden" id="currentPage" name="currentPage" value="" />


<jsp:include page="../common/pageNavigator_new.jsp"/>
</form>
</body>
</html>