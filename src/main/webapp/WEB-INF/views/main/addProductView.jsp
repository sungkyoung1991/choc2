<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!--   jQuery , Bootstrap CDN  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../javascript/calendar.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/css/bootstrap-datetimepicker.min.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.8.2/moment-with-locales.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datetimepicker/3.0.0/js/bootstrap-datetimepicker.min.js"></script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>




<!-- Bootstrap Dropdown Hover CSS -->
<link href="/css/animate.min.css" rel="stylesheet">
<link href="/css/bootstrap-dropdownhover.min.css" rel="stylesheet">

<!-- Bootstrap Dropdown Hover JS -->
<script src="/javascript/bootstrap-dropdownhover.min.js"></script>

<!--  CSS 추가 : 툴바에 화면 가리는 현상 해결 :  주석처리 전, 후 확인-->


<script type="text/javascript">
	function fncAddProduct() {

		$("form").attr("method", "POST").attr("action", "/product/addProduct").submit();
	}

	$(function() {
		$("button[type='button']").on("click", function() {

			fncAddProduct();
		});
	});

</script>
</head>

<body>


	<form name="detailForm" class="form-horizontal">

			<div class="form-group">
				<label for="productModel"
					class="col-sm-offset-1 col-sm-3 control-label">모델명</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="productModel"
						name="productModel" placeholder="모델명">
				</div>
			</div>

			<div class="form-group">
				<label for="productImage" class="col-sm-offset-1 col-sm-3 control-label">이미지</label>
				<div class="col-sm-4">
					<input type="text" id="productImage" name="productImage"
						class="form-control" placeholder="이미지">
				</div>
			</div>
			
				<div class="form-group">
				<div class="col-sm-offset-4  col-sm-4 text-center">
					<button type="button" class="btn btn-primary">등록</button>
					<a class="btn btn-primary btn" href="#" role="button">취소</a>
				</div>
			</div>
			
			</form>

</body>

</html>



