<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ page import="java.lang.String.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
/* $(document).ready(function(){
	
	var ingre= 
	
});
 */

</script>
</head>
<body>
<strong>[성분 구성]</strong> <br /><br />
 <%-- <%
		/* List<ToxicVO> list	= request.getAttribute("toxicinfo");	  */ 
		String st2 = (String)request.getAttribute("ingreinfo"); 
		 String [] sArray2 = st2.split("\\s*,\\s*");
		 for(int i=0; i<sArray2.length;i++){
			
			 out.println(i+1+"&nbsp;");
			 out.println("<a href=#>"+sArray2[i]+"</a>");
		/* 
					if(sArray2[i].equals("트리클로산")||sArray2[i].equals("디엠디엠하이단토인") || sArray2[i].equals("벤조페논-3;옥시벤존")||sArray2[i].equals("비에이치에이 부틸하이드록시아니솔")||sArray2[i].equals("이미다졸리디닐우레아")||
					   sArray2[i].equals("향료")||sArray2[i].equals("이소프로필알코올")||sArray2[i].equals("미네랄오일")||sArray2[i].equals("부틸메톡시디벤조일메탄;아보벤존;파르솔1789")||sArray2[i].equals("소듐라우릴설페이트;소듐라우릴황산염")||
					   sArray2[i].equals("o-사이멘;5-올;이소프로필메칠페놀;이소프로필...")||sArray2[i].equals("트리에탄올아민") || sArray2[i].equals("폴리에틸렌글라이콜(PEG)")||sArray2[i].equals("합성착색료")||sArray2[i].equals("소르빅애씨드;소르빈산")||
					   sArray2[i].equals("파라벤")||sArray2[i].equals("트리이소프로파놀아민")||sArray2[i].equals("페녹시 에탄올")||sArray2[i].equals("티몰")||sArray2[i].equals("소듐라우레스설페이트;소듐라우레스황산염")||sArray2[i].equals("소듐라우레스설페이트;소듐라우레스황산염")) */
					
					switch(sArray2[i]){
					case "트리클로산": out.println("<font color ='red'>*20가지 주의성분*</font>"); break;
					case "디엠디엠하이단토인"	: out.println("<font color ='red'>*20가지 주의성분*</font>"); break;
					}
					{
					out.println("<font color ='red'>*20가지 주의성분*</font>");
					System.out.println(sArray2[i]);
					/* System.out.println(sArray1[i]); */
				 }
			 out.println("<br />");
			 
		} 
		 
		 
%>
			 --%>
		 	 
		 	<%--  <table>
			 <c:forEach items="${ingreinfo}" var="ingr" varStatus="status">
			 <tr>
			 <td>${ingr}
			 <c:if test="${ingr=='트리클로산'||ingr=='디엠디엠하이단토인'||ingr=='벤조페논-3;옥시벤존'||ingr=='비에이치에이 부틸하이드록시아니솔'||ingr=='이미다졸리디닐우레아'||ingr=='향료'||ingr=='이소프로필알코올'||ingr=='미네랄오일'||ingr=='부틸메톡시디벤조일메탄;아보벤존;파르솔1789'||ingr=='소듐라우릴설페이트;소듐라우릴황산염'
			  ||ingr=='o-사이멘;5-올;이소프로필메칠페놀;이소프로필...'||ingr=='트리에탄올아민'||ingr=='폴리에틸렌글라이콜(PEG)'||ingr=='합성착색료'||ingr=='소르빅애씨드;소르빈산'||ingr=='파라벤'||ingr=='트리이소프로파놀아민'||ingr=='페녹시 에탄올'||ingr=='티몰'||ingr=='소듐라우레스설페이트;소듐라우레스황산염'||ingr=='소듐라우레스설페이트;소듐라우레스황산염'}">
			  <font color="red">*20가지 주의성분*</font></c:if> </td>
			 
			 </tr>
			 </c:forEach>
			 </table> 
		 
			  <hr> --%>

			
			 <table>
			 <c:forEach items="${ingreinfo}" var="ingr" >
			 <tr>
			 <td>${ingr}
			 <c:forEach var="toxi" items="${toxicinfo}">
			 <c:if test="${ingr==toxi.toxicKoreanName}"><font color="red">*20가지 주의성분*</font></td></c:if>
			 </c:forEach>
			 </td>
			 </tr>
			 </c:forEach>
			 </table> 
			
		
			 
</body>
</html>