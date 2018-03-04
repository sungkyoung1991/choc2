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

function deleteCosmetic(no){
	if(confirm("게시글을 삭제하시겠습니까?")==true){
	alert("삭제되었습니다");
	location.href="/user/deleteCosmetic?cosmeticNo="+no;
	}
}

function createCmt(nick,no){
	var content = $("#comment").val();
	var data= {
			'nickName' = nick,
			'cosmeticNo' = no,
			'content' = content		
	};
	var setting = {
			"url" : "/user/createComment",
			"type" : "post",
			"dataType" : "json",
			"data" : data,
			"success" : function(data){
				var d = new Date();
				var t = d.getFullYear()+"-"+(d.getMonth() + 1)+"-"+d.getDate()+"&nbsp;"+d.getHours()+":"+d.getMinutes();
				var idx = data.idx;
				$('#comment').val('');
				$('#commentArea').append('<div id="'+comment_no+'" ><span style="color: black;font-weight: bold;">'+nickName+'</span>&nbsp;<a href="javascript:deletecomment(\''+comment_no+'\');" style="color: tomato; text-decoration: none;">삭제</a><br/><span style="color: black;">'+content+'</span><br/><span style="color: gray;">'+t +'</span><hr></div>');
				alert('작성완료');
				
			},
			"error" : function(){}
	};
	
	$.ajax(setting);
}
	
}

</script>
</head>
<body>
	<%@include file="../include/nav.jsp"%>
		 
		 <form action="/user/updateCosmeticP" method="get">
			<input type="hidden" name="cosmeticNo" value = "${cinfo.cosmeticNo}"/>
			<input type='hidden' name='page' value="${cri.page}"> 
			<input type='hidden' name='perPageNum' value="${cri.perPageNum}">
			<input type='hidden' name='searchType' value="${cri.searchType}">
			<input type='hidden' name='keyword' value="${cri.keyword}">
		<table>
			<tr>
				<td><img alt="cosmetic" src="${cinfo.image}" height="150px" width="150px"></td>
			</tr>
			<tr>
				<td>브랜드 &nbsp;
				<input type="text" name="brand" value="${cinfo.brand}"
					readonly="readonly" /></td>
			</tr>
			<%-- <tr>
				<th>모델명</th>
				<td><input type="text" name="model" value="${cinfo.model}"
					readonly="readonly" /></td>
			</tr> --%>
			<tr>
				<td>모델명 &nbsp;
				<input type="text" name="product" value="${cinfo.product}"
					readonly="readonly" /></td>
			</tr>
			
			<tr>
				<td>용량 &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="amount" value="${cinfo.amount}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<td>정가 &nbsp;&nbsp;&nbsp;&nbsp;
				<input type="text" name="price" value="${cinfo.price}"
					readonly="readonly" />원</td>
			</tr>
		
			<%-- <tr>
				<td>성분구성
				<input type="text" name="ingredient"
					value="${cinfo.ingredient}" readonly="readonly" /> <!-- 	<input type="button" name="addButton" style="cursor:hand" value="추가" onclick="insRow()" />
			<font color="blue">더 추가하려면 추가 버튼을 클릭해보세요!</font> --></td>
			</tr> --%>
		
		</table>
<<<<<<< HEAD
		<br />
		<hr>
		
		<a href="/user/getIngredientList?cosmeticNo=${cinfo.cosmeticNo}">성분구성</a><br />
		<a href="/user/getSkinTypeIngredientList?cosmeticNo=${cinfo.cosmeticNo}">피부타입별 성분</a><br />
		<a href="/user/getFunctionalIngredientList?cosmeticNo=${cinfo.cosmeticNo}">기능성 성분</a>
		<br />
		<hr>
		
		<%-- 	<input type="submit" value="글수정" style="float:left" /> 
			<input type="button" value="글삭제" style="float:left" onclick="deleteCosmetic('${cinfo.cosmetic_no}')" /> --%>
			<input type="submit" value="글수정" style="float:left" /> 
			<input type="button" value="글삭제" style="float:left" onclick="deleteCosmetic('${cinfo.cosmeticNo}')" />
		</form>
		<br />
		<hr>

<%-- <table>
		
		<tr>
			<td>${user.nickName}</td>
		</tr>
		<tr>
			<td>
			<input type="text" id="comment" size="100" >
			<input type="button" value="댓글쓰기" onclick="createCmt('${user.nickName}','${cinfo.cosmeticNo}')"/></td>
		</tr>			
	</table>
	
 	<table id="commentArea">
	<c:forEach items="${list}" var="data">
	<tr class={data.idx}>
	<td>${data.nickName}<c:if test="${data.nickName==user.nickName}"><span style="float:right"><button type="button" onclick="deleteccomment('${data.idx}');">댓글 삭제</button></span> </c:if> </td>			
	</tr>
	</c:forEach>
	</table> 
		 --%>
		<div><!--댓글  -->
		<hr>
		<%-- <c:if test="${user!=null }"> --%>
		<span style="color: black; font-weight: bold;">${user.nick }</span> : <input type="text" id="comment" /><button type="button" onclick="comment('${user.nick }','${cinfo.cosmeticNo}');">댓글쓰기</button>
		<hr>
		<%-- </c:if> --%>
		<div id="commentArea">
		<c:forEach items="${comment}" var="data">
		<div id='${data.comment_no}'>
		<span style="color: black;font-weight: bold;">${data.nickName}</span>&nbsp;<c:if test="${data.nick==user.nick }"><a href="javascript:deletecomment('${data.comment_no}');" style="color: tomato; text-decoration: none;">삭제</a></c:if>
		<br/>		
		<span style="color: black;">${data.content}</span><br/>
		<span style="color: gray;"><fmt:formatDate value="${data.cdate}" pattern="yyyy-MM-dd HH:MM"/></span><c:if test="${data.nick!=user.nick }">&nbsp;<a href="javascript:openReport('${data.nickName }','${user.nickName }','${data.idx}');" style="color: tomato; text-decoration: none;">신고</a></c:if>
		<hr>		
		</div>
		</c:forEach>		
		</div>
		</div>

</body>


</html>