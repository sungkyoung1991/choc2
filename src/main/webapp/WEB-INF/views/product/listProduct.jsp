<%@ page contentType="text/html; charset=euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html lang="ko">

<head>
	<meta charset="UTF-8">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	<!-- Bootstrap Dropdown Hover CSS -->
   <link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
   
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
	
	<!--  CSS 추가 : 툴바에 화면 가리는 현상 해결 :  주석처리 전, 후 확인-->
	<style>
        body {
            padding-top : 70px;
            background-image: url('../images/uploadFiles/10.jpg');
            min-height:100%;
        min-width:1024px;
        width:100%;
        height:auto;
        position:fixed;
        top:0;
        left:0;
        position:relative;
        }
        
             img.bg{
        min-height:100%;
        min-width:1024px;
        width:100%;
        height:auto;
        position:fixed;
        top:0;
        left:0;
        }
        
        @media screen and (max-width: 1024px){
        	img.bg{
        		left:50%;
        		margin-left: -512px:
        	}
        }
        
        div#container{
        	position:relative;
        }
        
        div > *{
        color: orange;
        }
        
   	</style>

<script type="text/javascript">
	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "POST").attr("action" , "/product/listProduct?menu=${param.menu}").submit();
	}
	 $(function(){
			 $( "button:contains('검색')" ).on("click" , function() {
				fncGetList(1);
			});
	 });
	 
			 $(function(){
			 
				 $( ".ct_list_pop td:nth-child(2)" ).on("click" , function() {
					 
					 		var prodNo=$("p",this).text().trim();
					 		
					 		value="";
					 		
					 		if(${param.menu=="manage"}){
								value="상품수정";
							}else{
								value="상세보기";
							}
					 		
						$.ajax( 
								{
									url : "/product/json/getProduct/"+prodNo+"/${param.menu}",
									method : "GET" ,
									dataType : "json" ,
									headers : {
										"Accept" : "application/json",
										"Content-Type" : "application/json"
									},
									
									success : function(JSONData , status) {
										if(JSONData.fileName==null){
											 JSONData.fileName="no.png";
											 
										 }
		
										var displayValue = 
																	"<h3>"
																	+"<img src="+"../images/uploadFiles/"+JSONData.fileName+" width="+"200"+" height="+"200"+"/>"+"<br/>"
																	+"상품번호 : "+JSONData.prodNo+"<br/>"
																	+"상품명 : "+JSONData.prodName+"<br/>"
																	+"상세정보 : "+JSONData.prodDetail+"<br/>"
																	+"제조일자 : "+JSONData.manuDate+"<br/>"
																	+"가격 : "+JSONData.price+"<br/>"
																	+"등록일자 : "+JSONData.regDate+"<br/>"
																	+"<input type='button' value='"+value+"' id='del'/>"+"<br/>"  
																	+"</h3>";
									
									
										$("h3").remove();
										 $("#"+prodNo+"").html(displayValue);
										 
										 if(JSONData.fileName==null){
											 JSONData.fileName="no.png";
										 }
										 
										 
											$(function(){
												$("#del").on("click",function(){
													//console.log("구매붤튼... : " +$(this).html() );
													self.location="/product/getProduct?prodNo="+prodNo+"&menu=${param.menu}";
													
												});
											});
										 
									
									}
							});
				 });
				 
					/* $( ".ct_list_pop td:nth-child(3)" ).css("color" , "red");
					$("span").css("color" , "red"); */
					$(".ct_list_pop:nth-child(4n+6)" ).css("background-color" , "whitesmoke");
				 });
			  
		 
	 $(function(){
	 	 $(".ct_list_pop:contains('상품배송하기')").on("click",function(){
	 		 self.location="/purchase/updateTranCode"+$('#tran',this).text().trim();
		}); 
	 });
	 
	 
	
	     
</script>
</head>

<body>
<!-- <img class="bg" src="/images/uploadFiles/8.jpg"/> -->



<form name="detailForm">
 
 <c:if test="${param.menu=='manage'}">
				<div class="container">
					<div class="page-header text-info">
	      		 <h3>상품 관리</h3>
	      		 </div>
				</c:if>
				
			<c:if test="${param.menu=='search'}">
				<div class="container">
					<div class="page-header text-info">
	      		 <h3>상품목록조회</h3>
	      		 </div>
				</c:if>
			

 <div class="row">
	    
		    <div class="col-md-6 text-left">
		    	<p class="text-primary">
		    		전체  ${resultPage.totalCount } 건수, 현재 ${resultPage.currentPage}  페이지
		    	</p>
		    </div>
		    
				
				<div class="col-md-6 text-right">
			    <form class="form-inline" name="detailForm">
			    
				  <div class="form-group">
				    <select class="form-control" name="searchCondition" >
					<option value="0" ${ ! empty search.searchCondition && search.searchCondition==0 ? "selected" : "" }>상품번호</option>
					<option value="1" ${ ! empty search.searchCondition && search.searchCondition==1 ? "selected" : "" }>>상품명</option>
					<option value="2" ${ ! empty search.searchCondition && search.searchCondition==2 ? "selected" : "" }>>상품가격</option>
				</select>
				</div>
				
				 <div class="form-group">
				    <label class="sr-only" for="searchKeyword">검색어</label>
				    <input type="text" class="form-control" id="searchKeyword" name="searchKeyword"  placeholder="검색어"
				    			 value="${! empty search.searchKeyword ? search.searchKeyword : '' }"  >
				  </div>

		<button type="button" class="btn btn-default">검색</button>
		
		 <input type="hidden" id="currentPage" name="currentPage" value=""/>
				  
				</form>
	    	</div>
	    	
		</div>


	
	<c:set var="i" value="0" />
	<c:forEach var="product" items="${list }">
		<c:set var="i" value="${i+1 }"/>
		
		
			${ product.productNo}
			<br/>
			${ product.productImage}
			<br/>
			${ product.productModel}
			
	
		</c:forEach>


<!-- PageNavigation Start... -->
			<jsp:include page="../common/pageNavigator_new.jsp"/>
		
</body>
</html> 