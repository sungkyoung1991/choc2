<%@ page contentType="text/html; charset=euc-kr" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <%
	Product product = (Product)request.getAttribute("product");
%> --%>

<!DOCTYPE html>

<html lang="ko">

<head>

	<meta charset="EUC-KR">
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--   jQuery , Bootstrap CDN  -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="../javascript/calendar.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	<link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css" rel="stylesheet" /> <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script> <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>  
	<!-- Bootstrap Dropdown Hover CSS -->
   <link href="/css/animate.min.css" rel="stylesheet">
   <link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">
   
    <!-- Bootstrap Dropdown Hover JS -->
   <script src="/javascript/bootstrap-dropdownhover.min.js"></script>
	
	<!--  CSS �߰� : ���ٿ� ȭ�� ������ ���� �ذ� :  �ּ�ó�� ��, �� Ȯ��-->
	<style>
        body {
            padding-top : 70px;
             background-image: url('../images/uploadFiles/9.jpg');
        }
   	</style>


<script type="text/javascript">
function fncAddProduct(){
	//Form ��ȿ�� ����
 	/* var name = document.detailForm.prodName.value;
	var detail = document.detailForm.prodDetail.value;
	var manuDate = document.detailForm.manuDate.value;
	var price = document.detailForm.price.value; */ 
	
	var name = $("input[name='prodName']").val();
	var detail = $("input[name='prodDetail']").val();
	var manuDate= $("input[name='manuDate']").val();
	var price = $("input[name='price']").val();

	if(name == null || name.length<1){
		alert("��ǰ���� �ݵ�� �Է��Ͽ��� �մϴ�.");
		return;
	}
	if(detail == null || detail.length<1){
		alert("��ǰ�������� �ݵ�� �Է��Ͽ��� �մϴ�.");
		return;
	}
	 if(manuDate == null || manuDate.length<1){
		alert("�������ڴ� �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	} 
	if(price == null || price.length<1){
		alert("������ �ݵ�� �Է��ϼž� �մϴ�.");
		return;
	}
		
	/* document.detailForm.action='/product/updateProduct';
	document.detailForm.submit(); */
	/* $("form").attr("method" , "POST").attr("action" , "/product/updateProduct").submit(); */
	$("form").attr("method" , "POST").attr("action" , "/product/updateProduct").attr("enctype","multipart/form-data").submit();

}

$(function(){
	$("button:contains('����')").on("click",function(){
		fncAddProduct();
	});
});

$(function(){
	$("button:contains('���')").on("click",function(){
		javascript:history.go(-1);
	});
});


  $(function(){
	$("img[src='../images/ct_icon_date.gif']").on("click",function(){
		show_calendar('document.detailForm.manuDate', document.detailForm.manuDate.value),
				"popWin";
		});
	});
  
  $(function(){
	   $('#manuDate').datepicker({ 
		   
		   dateFormat: "yy-mm-dd",
		   showMonthAfterYear: true,
		   dayNamesMin: ['��', '��', 'ȭ', '��', '��', '��', '��'], 
		   monthNames : ['1��', '2��', '3��', '4��', '5��', '6��', '7��', '8��', '9��', '10��', '11��', '12��']
	        });
	  });


</script>
</head>

<body>


<form name="detailForm" class="form-horizontal">
	

<input type="hidden" name="prodNo" value= "${product.prodNo }"/>
<input type="hidden" name="menu" value= "${param.menu }"/>
<input type="hidden" name="fileName" value= "${product.fileName }"/>



		<!-- <div class="container"> -->

		<div class="form-group">
		    <label for="prodName" class="col-sm-offset-1 col-sm-3 control-label">��ǰ��</label>
		<div class="col-sm-4">
		      <input type="text" class="form-control" id="prodName" name="prodName" value="${product.prodName }">
		 </div>
		 </div>
		 
		 <div class="form-group">
		    <label for="prodDetail" class="col-sm-offset-1 col-sm-3 control-label">������</label>
		<div class="col-sm-4">
		      <input type="text" class="form-control" id="prodDetail" name="prodDetail" value="${product.prodDetail }">
		 </div>
		 </div>
		 
		 <div class="form-group">
	 		<label for="manuDate" class="col-sm-offset-1 col-sm-3 control-label">��������</label>
	 		<div class="col-sm-4">
	 		<input type="text" id="manuDate" name="manuDate" class="form-control" value="${product.manuDate }">
	 		</div>
            </div>
            
            <div class="form-group">
	 		<label for="price" class="col-sm-offset-1 col-sm-3 control-label">����</label>
	 		<div class="col-sm-4">
	 		<input type="text" id="price" name="price" class="form-control" value="${product.price }">
	 		</div>
            </div>
            
             <div class="form-group">
	 		<label for="file" class="col-sm-offset-1 col-sm-3 control-label">�̹���</label>
	 		<div class="col-sm-4">
	 		<input type="file" id="fileName" name="file" class="form-control" value="${product.fileName }">
	 		<img
					src="../images/uploadFiles/${product.fileName }" width=315 height = 150 />
	 		</div>
            </div>
            
            
            
            
             <div class="form-group">
		    <div class="col-sm-offset-4  col-sm-4 text-center">
		      <button type="button" class="btn btn-primary"  >����</button>
			  <a class="btn btn-primary btn" href="#" role="button">���</a>
		    </div>
		  </div>
		  
		</form>
		
 	</div>


</body>
</html>