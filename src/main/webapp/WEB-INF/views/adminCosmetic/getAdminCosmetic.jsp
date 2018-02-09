<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/header.jsp"%>
</head>
<body>
<%@include file="../include/nav.jsp"%>

<div class="row">
	<div class="col-md-12">
		<div class="box box-primary">
			<!-- /.box header -->
			<div class="box-header">
				<h3 class="box-title">READ COSMETIC</h3>
			</div>
			
			<!-- ./box body -->
			<div class="box-body">
				<div class="form-group">
				<label for="exampleInputEmail1">Brand</label> 
				<input type="text" name='brand' class="form-control" 
				value="${cosmeticVO.brand}" readonly="readonly">
				
				</div>
				<div class="form-group">
				
				</div>
				<div class="form-group">
				
				</div>
			</div>
		
		</div>
	</div>
</div>
</body>
<%@include file="../include/footer.jsp"%>
</html>