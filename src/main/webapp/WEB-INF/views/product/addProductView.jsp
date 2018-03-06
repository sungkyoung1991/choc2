<%@ page contentType="text/html; charset=euc-kr"%>

<!DOCTYPE html>

<html lang="ko">

<head>

<meta charset="EUC-KR">

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

<!--  CSS �߰� : ���ٿ� ȭ�� ������ ���� �ذ� :  �ּ�ó�� ��, �� Ȯ��-->
<style>
body {
	padding-top: 70px;
	height: 100%;
	background-color: black;
}

label {
	color: orange;
}

img.bg {
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
}
</style>


<script type="text/javascript">
	function fncAddProduct() {
		//Form ��ȿ�� ����
		/* var name = document.detailForm.prodName.value;
		var detail = document.detailForm.prodDetail.value;
		var manuDate = document.detailForm.manuDate.value;
		var price = document.detailForm.price.value; */

		var name = $("input[name='prodName']").val();
		var detail = $("input[name='prodDetail']").val();
		var manuDate = $("input[name='manuDate']").val();
		var price = $("input[name='price']").val();

		if (name == null || name.length < 1) {
			alert("��ǰ���� �ݵ�� �Է��Ͽ��� �մϴ�.");
			return;
		}
		if (detail == null || detail.length < 1) {
			alert("��ǰ�������� �ݵ�� �Է��Ͽ��� �մϴ�.");
			return;
		}
		if (manuDate == null || manuDate.length < 1) {
			alert("�������ڴ� �ݵ�� �Է��ϼž� �մϴ�.");
			return;
		}
		if (price == null || price.length < 1) {
			alert("������ �ݵ�� �Է��ϼž� �մϴ�.");
			return;
		}

		$("form").attr("method", "POST").attr("enctype", "multipart/form-data")
				.attr("action", "/product/addProduct").submit();
	}

	function resetData() {
		$("form")[0].reset();
	}

	$(function() {
		$("button[type='button']").on("click", function() {

			fncAddProduct();
		});
	});

	$(function() {
		$(".btn:contains('���')").on("click", function() {
			console.log("���" + $(this).html());
			resetData();
		});
	});

	$(function() {
		$('#manuDate').datepicker(
				{

					dateFormat : "yy-mm-dd",
					showMonthAfterYear : true,
					dayNamesMin : [ '��', '��', 'ȭ', '��', '��', '��', '��' ],
					monthNames : [ '1��', '2��', '3��', '4��', '5��', '6��', '7��',
							'8��', '9��', '10��', '11��', '12��' ]
				});
	});
</script>
</head>

<body>

	<img class="bg" src="/images/uploadFiles/17.jpg" />



	<form name="detailForm" class="form-horizontal">

			<!-- <div class="container"> -->

			<div class="form-group">
				<label for="prodName" class="col-sm-offset-1 col-sm-3 control-label">��ǰ��</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="prodName"
						name="prodName" placeholder="��ǰ��">
				</div>
			</div>

			<div class="form-group">
				<label for="prodDetail"
					class="col-sm-offset-1 col-sm-3 control-label">������</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="prodDetail"
						name="prodDetail" placeholder="������">
				</div>
			</div>

			<div class="form-group">
				<label for="manuDate" class="col-sm-offset-1 col-sm-3 control-label">��������</label>
				<div class="col-sm-4">
					<input type="text" id="manuDate" name="manuDate"
						class="form-control" placeholder="��������">
				</div>
			</div>

			<div class="form-group">
				<label for="price" class="col-sm-offset-1 col-sm-3 control-label">����</label>
				<div class="col-sm-4">
					<input type="text" id="price" name="price" class="form-control"
						placeholder="����">
				</div>
			</div>

			<div class="form-group">
				<label for="file" class="col-sm-offset-1 col-sm-3 control-label">�̹���</label>
				<div class="col-sm-4">
					<input type="file" id="fileName" name="file" class="form-control"
						placeholder="����">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4  col-sm-4 text-center">
					<button type="button" class="btn btn-primary">���</button>
					<a class="btn btn-primary btn" href="#" role="button">���</a>
				</div>
			</div>

		</form>

		</div>
</body>

</html>



