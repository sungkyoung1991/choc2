<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	
</script>
<%@include file="../include/header.jsp"%>
</head>
<body>
	<%@include file="../include/nav.jsp"%>
	<h2>화장품 정보입력</h2>
	<form name="cform" action="/user/createCosmetic" method="post">
		<table>
			<tr>
				<th>브랜드</th>
				<td><input type="text" name="brand" placeholder="입생로랑" /></td>
			</tr>
			<tr>
				<th>모델명</th>
				<td><input type="text" name="model" placeholder="abc1234" /></td>
			</tr>
			<tr>
				<th>제품명</th>
				<td><input type="text" name="product" placeholder="블라블라 파운데이션" /></td>
			</tr>
			<tr>
				<th>용량</th>
				<td><input type="text" name="amount" placeholder="130" />
				<!-- <select name="amount_count">
				<option value="ml">ml</option>
				<option value="g">g</option>
				</select> --></td>
					
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price" placeholder="77,000" />원</td>
			</tr>
			<tr>
				<th>성분</th>
				<td><input type="text" name="ingredient" placeholder="글리세린" />
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