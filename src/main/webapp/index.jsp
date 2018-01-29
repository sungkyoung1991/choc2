<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>
<h2>test</h2>

<c:if test="${sessionScope.user.userId!=null }">
	login..
</c:if>



<P>  The time on the server is ${serverTime}. </P>

<!-- <input type="button" value="logout" onclick="location.replace('/user/logout');"/> -->
</body>
</html>
