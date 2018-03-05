<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <font color="red">안좋은 성분</font>,
<font color="blue"> 좋은 성분</font><br><br>
<strong>[지성피부 관련성분]</strong><br><br>
			 <table>
			 <c:forEach items="${ingreinfo}" var="ingr" >
			 <c:forEach var="oily" items="${oilyingreinfo}">
			 <c:if test="${ingr==oily.goodIngredient}"><tr><td><font color="blue">${oily.goodIngredient}>>&nbsp;${oily.goodDescription}</font></td></tr></c:if>
			 <c:if test="${ingr==oily.badIngredient}"><tr><td><font color="red">${oily.badIngredient}>>&nbsp;${oily.badDescription}</font></td></tr></c:if>
			 </c:forEach>
			 </c:forEach>
			 </table> 
<hr>
<strong>[건성피부 관련성분]</strong><br><br>
			 <table>
			 <c:forEach items="${ingreinfo}" var="ingr" >
			 <c:forEach var="dry" items="${dryingreinfo}">
			 <c:if test="${ingr==dry.goodIngredient}"><tr><td><font color="blue">${dry.goodIngredient}>>&nbsp;${dry.goodDescription}</font></td></tr></c:if>
			 <c:if test="${ingr==dry.badIngredient}"><tr><td><font color="red">${dry.badIngredient}>>&nbsp;${dry.badDescription}</font></td></tr></c:if>
			 </c:forEach>
			 </c:forEach>
			 </table> 
			 
			 <hr>
<strong>[민감성피부 관련성분]</strong><br><br>
			 <table>
			 <c:forEach items="${ingreinfo}" var="ingr" >
			 <c:forEach var="sensitive" items="${sensitiveingreinfo}">
			 <c:if test="${ingr==sensitive.goodIngredient}"><tr><td><font color="blue">${sensitive.goodIngredient}>>&nbsp;${sensitive.goodDescription}</font></td></tr></c:if>
			 <c:if test="${ingr==sensitive.badIngredient}"><tr><td><font color="red">${sensitive.badIngredient}>>&nbsp;${sensitive.badDescription}</font></td></tr></c:if>
			 </c:forEach>
			 </c:forEach>
			 </table> 
			 			 
			 
</body>
</html>