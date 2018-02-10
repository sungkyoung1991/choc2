<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../include/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">






</script>
</head>
<body>
	<%@include file="../include/nav.jsp"%>
		 
		 <form action="/user/updateCosmeticP" method="post">
			<input type="hidden" name="cosmetic_no" value = "${cinfo.cosmetic_no}"/>
			<input type='hidden' name='page' value="${cri.page}"> 
			<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
			<input type='hidden' name='searchType' value="${cri.searchType}">
			<input type='hidden' name='keyword' value="${cri.keyword}">
		<table>
			<tr>
				<th>브랜드</th>
				<td><input type="text" name="brand" value="${cinfo.brand}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th>모델명</th>
				<td><input type="text" name="model" value="${cinfo.model}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th>제품명</th>
				<td><input type="text" name="product" value="${cinfo.product}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th>용량</th>
				<td><input type="text" name="amount" value="${cinfo.amount}"
					readonly="readonly" />ml</td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price" value="${cinfo.price}"
					readonly="readonly" />원</td>
			</tr>
			<tr>
				<th>성분</th>
				<td><input type="text" name="ingredient"
					value="${cinfo.ingredient}" readonly="readonly" /> <!-- 	<input type="button" name="addButton" style="cursor:hand" value="추가" onclick="insRow()" />
	<font color="blue">더 추가하려면 추가 버튼을 클릭해보세요!</font> --></td>
			</tr>
		</table>
			<input type="submit" value="글수정" style="float:left" /> 
			<input type="button" value="글삭제" style="float:left" onclick="delete('${cinfo.cosmetic_no}')" />
		</form>
		<br />
		<hr>

	 <table>
		
		<tr>
			<td>${user.nickName}</td>
		</tr>
		<tr>
			<td>
			<input type="text" id="replyContent" size="100" >
			<input type="button" value="댓글쓰기" onclick="createCmt('${user.nickName}','${cinfo.cosmetic_no}')"/></td>
		</tr>			
	</table>
	
	<table id="commentArea">
	<c:forEach items="${list}" var="data">
	<tr class={data.idx}>
	<td>${data.nickName}<c:if test="${data.nickName==user.nickName}"><span style="float:right"><button type="button" onclick="deleteccomment('${data.idx}');">댓글 삭제</button></span> </c:if> </td>			
	</tr>
	</c:forEach>
	</table> 
	
		 <div><!--댓글  -->
		
		<c:if test="${user!=null}">
		<span style="color: black; font-weight: bold;">${user.nickName}</span> : <input type="text" id="comment" size="100" /><button type="button" onclick="comment('${user.nickName}','${data.idx}');"> 댓글쓰기</button>
		<hr>
		</c:if>
		<div id="commentArea">
		<c:forEach items="${data}" var="data">
		<div id='${data.idx}'>
		<span style="color: black;font-weight: bold;">${data.nickName }</span>&nbsp;<c:if test="${data.nickName==user.nickName }"><a href="javascript:deletecomment('${data.idx}');" style="color: tomato; text-decoration: none;">삭제</a></c:if>
		<br/>		
		<span style="color: black;">${data.contents}</span><br/>
		<span style="color: gray;"><fmt:formatDate value="${data.cdate}" pattern="yyyy-MM-dd HH:MM"/></span>
		<hr>		
		</div>
		</c:forEach>		
		</div>
		</div>
	
  <%-- 	    <input type="hidden" name="cosmetic_no" value="${cinfo.model_no}"/>
			<input type="hidden" name="brand" value="${cinfo.brand}" />
			<input type="hidden" name="model" value="${cinfo.model}"  />
			<input type="hidden" name="product" value="${cinfo.product}"  />
			<input type="hidden" name="amount" value="${cinfo.amount}" />
			<input type="hidden" name="price" value="${cinfo.price}"  />
			<input type="hidden" name="ingredient" value="${cinfo.ingredient}"  />
 --%>
			
		 
	<%-- <c:if test="${data.nickName == user.nickName}"> --%>
	<%-- </c:if>	 --%>
</body>


</html>