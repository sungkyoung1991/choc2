<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기능성 성분 불러오기</title>
</head>

<body>
<strong>[자외선차단 기능성분]</strong><br><br>
			 <table>
			 <c:forEach items="${ingreinfo}" var="ingr" >
			 
			 <c:forEach var="uv" items="${uvingreinfo}">
			 <c:if test="${ingr==uv.ingredient}"><tr><td>${ingr}</td>	</tr></c:if>
			 </c:forEach>
			 </c:forEach>
			 </table> 
<hr>
<strong>[미백 기능성분]</strong><br><br>
			 <table>
			 <c:forEach items="${ingreinfo}" var="ingr" >
			 <c:forEach var="whitening" items="${whiteningingreinfo}">
			 <c:if test="${ingr==whitening.ingredient}"><tr><td>${ingr}</td></tr></c:if>
			 </c:forEach>
			 </c:forEach>
			 </table> 
<hr>			 
<strong>[주름개선 기능성분]</strong><br><br>
			 <table>
			 <c:forEach items="${ingreinfo}" var="ingr" >
			 <c:forEach var="wrinkle" items="${wrinklengreinfo}">
			 <c:if test="${ingr==wrinkle.ingredient}"><tr><td>${ingr}</td></tr></c:if>
			 </c:forEach>
			 </c:forEach>
			 </table> 			 
						
			
</body>
</html>