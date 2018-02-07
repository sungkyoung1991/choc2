<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/nav.jsp"%>
	<form name="cform" action="/user/createCosmetic" method="get">
		<table>
			<tr>
				<th>브랜드</th>
				<td><input type="text" name="brand" value="${cinfo.brand}"
					readonly="readonly" /></td>
			</tr>
			<tr>
				<th>모델명</th>
				<td><input type="text" name="model" value="${cinfo.model}" readonly="readonly" /></td>
			</tr>
			<tr>
				<th>제품명</th>
				<td><input type="text" name="product" value="${cinfo.product}"readonly="readonly"/></td>
			</tr>
			<tr>
				<th>용량</th>
				<td><input type="text" name="amount" value="${cinfo.amount}" readonly="readonly"/></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price" value="${cinfo.price}" readonly="readonly"/>원</td>
			</tr>
			<tr>
				<th>성분</th>
				<td><input type="text" name="ingredient"
					value="${cinfo.ingredient}" readonly="readonly"/> 
					<!-- 	<input type="button" name="addButton" style="cursor:hand" value="추가" onclick="insRow()" />
	<font color="blue">더 추가하려면 추가 버튼을 클릭해보세요!</font> --></td>
			</tr>
			<tr>
				<td><input type="submit" value="확인" /></td>
			</tr>
		</table>
	</form>
</body>
<%@include file="../include/footer.jsp"%>
</html>