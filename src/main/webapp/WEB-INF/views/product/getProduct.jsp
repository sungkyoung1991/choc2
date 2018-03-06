<%@ page contentType="text/html; charset=euc-kr"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="EUC-KR">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- <link rel="stylesheet" href="/css/admin.css" type="text/css"> -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>


<!-- Bootstrap Dropdown Hover CSS -->
   <link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
   
   
   <!-- jQuery UI toolTip 사용 CSS-->
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  
  <style>
	  body {
	padding-top: 70px;
	height: 100%;
	background-image: url('../images/uploadFiles/${product.fileName}');
	background-repeat: no-repeat;
	background-size: cover;
	
}

label{
	color: orange;
}

.form-control-static{
	color:orange;
}

/* img.bg {
	min-height: 100%;
	min-width: 1024px;
	width: 100%;
	height: auto;
	position: fixed;
	top: 0;
	left: 0;
}

@media screen and (max-width: 1024px) {
	img.bg {
		left: 50%;
		margin-left: -512px:
	}
}

div#container {
	position: relative;
} */
    </style>
  
  
<script type="text/javascript">

	function fncAddpurchase(){
		$('form').attr("method","post").attr("enctype","multipart/form-data").attr("action","/purchase/addPurchaseView?prodNo=${product.prodNo }").submit();
	}

		$(function(){
			$("button:contains('구매')").on("click",function(){
				fncAddpurchase();
			});
		});
		
		$(function(){
			$("button:contains('확인')").on("click",function(){
				self.location="/product/listProduct?menu=${param.menu}";
			});
		});
 
 $(function(){ 
	 $("button:contains('쓰기')").on("click",function(){ 
		console.log("쓰기.."+ $(this).html());
$.ajax(
	 
	 {
		 url : "/reply/json/insertReply",
		 method : "POST",
		headers : {
				"Accept" : "application/json",
				"Content-Type" : "application/json"
					},
		 data : JSON.stringify({
			reply :  [$("input[type='text']").val()] ,
			 prodNo : ${product.prodNo},
			 "userId" : "${user.userId}"
		 }),
		 dataType : "json",
		 success : function(JSONData, status){
			  alert(status);
			 alert(JSONData); 
		 
			 var display = 
				"<div id = 'append' align='center' style=color:orange>"+
				 JSONData.userId + ":" + JSONData.reply + "\n"+
				 "</div>";
				 
			var div = "<h1>" + JSONData.reply + "</h1>";
			
			 $(display).appendTo("body");
			 
		 }
	});

$("input[type='text']").val("");

});
}); 

	  

</script>


</head>

<body>
	
	
	<form name="detailForm" class="form-horizontal">

		
		<div class="form-group">
		<label for="prodNo" class="col-sm-2 control-label">상품번호</label>
    <div class="col-sm-10">
      <p class="form-control-static" name="prodNo">${product.prodNo }</p>
    </div>
    </div>

				<div class="form-group">
		<label for="prodName" class="col-sm-2 control-label">상품명</label>
    <div class="col-sm-10">
      <p class="form-control-static" name="prodName">${product.prodName }</p>
    </div>
    </div>
    

					<div class="form-group">
		<label for="prodDetail" class="col-sm-2 control-label">상세정보</label>
    <div class="col-sm-10">
      <p class="form-control-static" name="prodDetail">${product.prodDetail }</p>
    </div>
    </div>

						<div class="form-group">
		<label for="manuDate" class="col-sm-2 control-label">제조일자</label>
    <div class="col-sm-10">
      <p class="form-control-static" name="manuDate">${product.manuDate }</p>
    </div>
    </div>

			
						<div class="form-group">
		<label for="price" class="col-sm-2 control-label">가격</label>
    <div class="col-sm-10">
      <p class="form-control-static" name="price">${product.price }</p>
    </div>
    </div>

	<div class="row">
	  		<div class="col-md-12 text-center ">
	  			<button type="button" class="btn btn-primary">구매</button>
	  			<button type="button" class="btn btn-primary">확인</button>
	  		</div>
		</div>
		
		<br/>
		<br/>
		<br/>
		<br/>
		


<div class="form-group" align="left">
				<label for="reply" class="col-sm-offset-1 col-sm-3 control-label">상품평</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="reply"
						name="reply" placeholder="상품평을 입력하세요.">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-4  col-sm-4 text-center">
					<button type="button" class="btn btn-warning">쓰기</button>
				</div>
			</div>

		
<!-- 		<input type="text" name="reply" style="width: 800px; height: 30px"
			placeholder="댓글을입력해주세요."> <br /> <input type="button"
			value="쓰기" /><br />
		<hr />
		<br />
 -->
		<table>
			<tr>
				<c:forEach var="reply" items="${list }">
					<div id="reply" align="center" style="color:orange">
						<p>${reply.userId} : ${reply.reply }</p>
					</div>
				</c:forEach>
			</tr>
		</table>
	</form>
	
	

</body>
</html>


		
		
		
		
		
		<!-- //////////////////////////////////////////// -->

		<%-- <table width="100%" height="37" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="15" height="37"><img src="/images/ct_ttl_img01.gif"
					width="15" height="37"></td>
				<td background="/images/ct_ttl_img02.gif" width="100%"
					style="padding-left: 10px;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="93%" class="ct_ttl01">상품상세조회</td>
							<td width="20%" align="right">&nbsp;</td>
						</tr>
					</table>
				</td>
				<td width="12" height="37"><img src="/images/ct_ttl_img03.gif"
					width="12" height="37" /></td>
			</tr>
		</table>

		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="margin-top: 13px;">
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6"></td>
			</tr>
			<tr>
				<td width="104" class="ct_write">상품번호 <img
					src="/images/ct_icon_red.gif" width="3" height="3"
					align="absmiddle" />
				</td>
				<td bgcolor="D6D6D6" width="1"></td>
				<td class="ct_write01">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="105" id="prodNo">${product.prodNo}</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6"></td>
			</tr>
			<tr>
				<td width="104" class="ct_write">상품명 <img
					src="/images/ct_icon_red.gif" width="3" height="3"
					align="absmiddle" />
				</td>
				<td bgcolor="D6D6D6" width="1"></td>
				<td class="ct_write01">${product.prodName}</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6"></td>
			</tr>
			<tr>
				<td width="104" class="ct_write">상품이미지<img
					src="/images/ct_icon_red.gif" width="3" height="3"
					align="absmiddle" />
				</td>
				<td bgcolor="D6D6D6" width="1"></td>
				<td class="ct_write01"><img
					src="../images/uploadFiles/${product.fileName }" /></td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6">${product.fileName}</td>
			</tr>
			<tr>
				<td width="104" class="ct_write">상품상세정보 <img
					src="/images/ct_icon_red.gif" width="3" height="3"
					align="absmiddle" />
				</td>
				<td bgcolor="D6D6D6" width="1"></td>
				<td class="ct_write01">${product.prodDetail}</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6"></td>
			</tr>
			<tr>
				<td width="104" class="ct_write">제조일자</td>
				<td bgcolor="D6D6D6" width="1"></td>
				<td class="ct_write01">${product.manuDate}</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6"></td>
			</tr>
			<tr>
				<td width="104" class="ct_write">가격</td>
				<td bgcolor="D6D6D6" width="1"></td>
				<td class="ct_write01">${product.price}</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6"></td>
			</tr>
			<tr>
				<td width="104" class="ct_write">등록일자</td>
				<td bgcolor="D6D6D6" width="1"></td>
				<td class="ct_write01">${product.regDate}</td>
			</tr>
			<tr>
				<td height="1" colspan="3" bgcolor="D6D6D6"></td>
			</tr>
		</table>

		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			style="margin-top: 10px;">
			<tr>
				<td width="53%"></td>
				<td align="right">

					<table border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="17" height="23"><img src="/images/ct_btnbg01.gif"
								width="17" height="23" /></td>

							<td background="/images/ct_btnbg02.gif" class="ct_btn01"
								style="padding-top: 3px;">
								구매
							</td>

							<td width="14" height="23"><img src="/images/ct_btnbg03.gif"
								width="14" height="23" />
							<td background="/images/ct_btnbg02.gif" class="ct_btn01"
								style="padding-top: 3px;">
								확인
							</td>
							<td width="14" height="23"><img src="/images/ct_btnbg03.gif"
								width="14" height="23" /></td>
						</tr>
					</table>

				</td>
			</tr>
		</table>

		<table width="100%" height="37" border="0" cellpadding="0"
			cellspacing="0">
			<tr>
				<td width="15" height="37"><img src="/images/IMG_3713.PNG"
					width="15" height="37"></td>
				<td width="100%" style="padding-left: 10px;">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="93%" class="ct_ttl01">상품평</td>
							<td width="20%" align="right">&nbsp;</td>
						</tr>
					</table>
				</td>
				<td width="30" height="37"><img src="/images/ct_ttl_img03.gif"
					width="12" height="37" /></td>
			</tr> --%>
		