<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리뷰작성하기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript">

$(document).ready(function(){
 	$("#Star1").on("click",function(){
 		 $("#Star1").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star4").attr("class","glyphicon glyphicon-star-empty");
		 $("#Star5").attr("class","glyphicon glyphicon-star-empty");
 		
 		 $("#Star1").attr("class","glyphicon glyphicon-star"); 
	 });
 	$("#Star2").on("click",function(){
 		 $("#Star1").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star4").attr("class","glyphicon glyphicon-star-empty");
		 $("#Star5").attr("class","glyphicon glyphicon-star-empty");
 		
		 $("#Star1").attr("class","glyphicon glyphicon-star"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star"); 
 	 });
 	$("#Star3").on("click",function(){
 		 $("#Star1").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star4").attr("class","glyphicon glyphicon-star-empty");
		 $("#Star5").attr("class","glyphicon glyphicon-star-empty");
 		
		 $("#Star1").attr("class","glyphicon glyphicon-star"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star"); 
	 });
 	$("#Star4").on("click",function(){
 		 $("#Star1").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star4").attr("class","glyphicon glyphicon-star-empty");
		 $("#Star5").attr("class","glyphicon glyphicon-star-empty");
 		
 		 $("#Star1").attr("class","glyphicon glyphicon-star"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star"); 
		 $("#Star4").attr("class","glyphicon glyphicon-star");
	 });
	$("#Star5").on("click",function(){
		 $("#Star1").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star-empty"); 
		 $("#Star4").attr("class","glyphicon glyphicon-star-empty");
		 $("#Star5").attr("class","glyphicon glyphicon-star-empty");
		
		 $("#Star1").attr("class","glyphicon glyphicon-star"); 
		 $("#Star2").attr("class","glyphicon glyphicon-star"); 
		 $("#Star3").attr("class","glyphicon glyphicon-star"); 
		 $("#Star4").attr("class","glyphicon glyphicon-star");
		 $("#Star5").attr("class","glyphicon glyphicon-star");
	 });
	
	$("#Create").on("click",function(){
		if($("#strength").val().length<20)
			alert("좋았던점을 20자 이상 입력해주세요");
		else if($("#weakness").val().length<20)
			alert("아쉬웠던점을 20자 이상 입력해주세요");
		else
			//confirm기능
			$("form").attr("action","/user/createReview").attr("method","POST").submit();
	});
	
 	
});

</script>
</head>
<body>
<img alt="cosmetic" src="${cosmetic.image}" height="150px" width="150px"><br/>
<input type="text" name="brand" value="${cosmetic.brand}" readonly="readonly" /><br/>
<input type="text" name="product" value="${cosmetic.product}"readonly="readonly" />
<hr/>
<form>
<input type="hidden" name="cosmeticNo" value=${cosmetic.cosmeticNo}>
<h4>*평점</h4>

<span class="glyphicon glyphicon-star-empty" aria-hidden="true" id="Star1"></span>
<span class="glyphicon glyphicon-star-empty" aria-hidden="true" id="Star2"></span>
<span class="glyphicon glyphicon-star-empty" aria-hidden="true" id="Star3"></span>
<span class="glyphicon glyphicon-star-empty" aria-hidden="true" id="Star4"></span>
<span class="glyphicon glyphicon-star-empty" aria-hidden="true" id="Star5"></span>
<h4>*사용기간</h4> 
<select name="period">
<option value="one week">1주</option>
<option value="two week">2주</option>
<option value="three week">3주</option>
<option value="one month">1개월</option>
<option value="two month">2개월</option>
<option value="two month">3개월</option>
<option value="two month">6개월</option>
<option value="two month">12개월이상</option>
</select>

<h4>*해당제품을 제구매 하셨나요?</h4>
<input type="radio" name="repurchase" value="yes" />예
<input type="radio" name="repurchase" value="no" />아니오

<h4>*좋았던점(최소 20자이상)</h4> <textarea name="strength" rows="10" cols="50" placeholder="*사용하신 제품의 자세한 리뷰를 남겨주세요. 발림성,흡수력,보습력 등의 사용감을 작성해주세요. 추천하는 피부타입, 구매하신 가격, 용량을 작성해주세요:-)" id="strength"></textarea>
	<!-- <span id="counter">###</span> -->
<h4>*아쉬웠던점(최소 20자이상)</h4> <textarea name="weakness" rows="10" cols="50"  placeholder="*사용하신 제품의 자세한 리뷰를 남겨주세요. 트러블 유무, 추천하지 않는 피부타입을 말씀해주세요:-)" id="weakness"></textarea>
<h4>*꿀팁 (선택사항)</h4> <textarea name="tip" rows="10" cols="50" placeholder="나만의 사용방법, 제품에대한 알짜정보 등 도움이 되는 정보들을 풍성하게 남겨주세요:-)" id="tip"></textarea> 

<br>

<input type="file" name="picture" accept="image/gif , image/jpg, image/jpeg, image/png" /><br/>
<button type="button" id="Create">등록</button>
</form>
</body>
</html>