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

<c:if test="${sessionScope.user.userId!=null }">
	로그인 되었습니다.
</c:if>



<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
