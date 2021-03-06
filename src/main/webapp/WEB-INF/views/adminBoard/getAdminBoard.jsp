<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  


<!-- Main content -->
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="../include/header.jsp"%>
<title>Insert title here</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>



<script type="text/javascript">
 	Handlebars.registerHelper("prettifyDate", function(timeValue) {
		var dateObj = new Date(timeValue);
		var year = dateObj.getFullYear();
		var month = dateObj.getMonth() + 1;
		var date = dateObj.getDate();
		return year + "/" + month + "/" + date;
	});
	var printData = function(replyArr, target, templateObject) {
		var template = Handlebars.compile(templateObject.html());
		var html = template(replyArr);
		$(".replyLi").remove();
		target.after(html);
	}
	var boardNo = ${boardVO.boardNo};
	
	var replyPage = 1;
	function getPage(pageInfo) {
		$.getJSON(pageInfo, function(data) {
			printData(data.list, $("#repliesDiv"), $('#template'));
			printPaging(data.resultPage, $(".pagination"));
			$("#modifyModal").modal('hide');
		});
	}
	var printPaging = function(resultPage, target) {
		var str = "";
		/* if (resultPage.prev) { */
			str += "<li><a href='" + (resultPage.beginUnitPage-1)
					+ "'> << </a></li>";
		/* } */
		for (var i = resultPage.beginUnitPage, len = resultPage.endUnitPage; i <= len; i++) {
			var strClass = resultPage.currentPage == i ? 'class=active' : '';
			str += "<li "+strClass+"><a href='"+i+"'>" + i + "</a></li>";
		}
		/* if (resultPage.next) { */
			str += "<li><a href='" + (resultPage.endUnitPage + 1)
					+ "'> >> </a></li>";
		/* } */
		target.html(str);
	};
	(function($){
		$("span:contains('Replies List')").on("click", function() {
			if ($(".timeline li").size() > 1) {
				return;
			}
			getPage("/replyRest/" + boardNo + "/1");
		});
	})(jQuery);
	$(".pagination").on("click", "li a", function(event){
		
		event.preventDefault();
		
		replyPage = $(this).attr("href");
		
		getPage("/replyRest/"+boardNo+"/"+replyPage);
		
	});
	
	$(function(){
		$("button:contains('ADD REPLY')")
		.on("click",function(){
	
		 
		 var userIdObj = $("#newReplyUserId");
		 var replytextObj = $("#newReplyText");
		 var userId = userIdObj.val();
		 var replytext = replytextObj.val();
		console.log("asdf");
		  
 		  $.ajax({
				type:'post',
				url:'/replyRest/',
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "POST" },
				dataType:'text',
				data: JSON.stringify({boardNo:boardNo, userId:userId, replytext:replytext}),
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("등록 되었습니다.");
						replyPage = 1;
						getPage("/replyRest/"+boardNo+"/"+replyPage );
						userIdObj.val("");
						replytextObj.val("");
					}
			}}); 
		});
	});
	
	$(".timeline").on("click", ".replyLi", function(event){
		
		var reply = $(this);
		
		$("#replytext").val(reply.find('.timeline-body').text());
		$("h4[class=modal-title]").html(reply.attr("data-replyNo"));
		
	});
	
	$(function(){
		$("button:contains('ReplyModify')")
		.on("click",function(){
		  
		  var replyNo = $("h4[class=modal-title]").html();
		  var replytext = $("#replytext").val();
		  
		  $.ajax({
				type:'put',
				url:'/replyRest/'+replyNo,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "PUT" },
				data:JSON.stringify({replytext:replytext}), 
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("수정 되었습니다.");
						getPage("/replyRest/"+boardNo+"/"+replyPage );
					}
			}});
		});
	});


	$(function(){
		$("button:contains('DELETE')")
		.on("click",function(){

		  var replyNo = $("h4[class=modal-title]").html();
		  var replytext = $("#replytext").val();
		  
		  $.ajax({
				type:'delete',
				url:'/replyRest/'+replyNo,
				headers: { 
				      "Content-Type": "application/json",
				      "X-HTTP-Method-Override": "DELETE" },
				dataType:'text', 
				success:function(result){
					console.log("result: " + result);
					if(result == 'SUCCESS'){
						alert("삭제 되었습니다.");
						getPage("/replyRest/"+boardNo+"/"+replyPage );
					}
			}});
	});
	});
	 
</script>

	<script>
$(document).ready(function(){
	
	var formObj = $("form[role='form']");
	
	console.log(formObj);
	
	$("#modifyBtn").on("click", function(){
		formObj.attr("action", "/admin/board/update");
		formObj.attr("method", "get");		
		formObj.submit();
	});
	
	$("#removeBtn").on("click", function(){
		formObj.attr("action", "/admin/board/delete");
		formObj.submit();
	});
	
	$("#goListBtn ").on("click", function(){
		formObj.attr("method", "get");
		formObj.attr("action", "/admin/board/list");
		formObj.submit();
	});
	
});
</script>
<script id="template" type="text/x-handlebars-template">
{{#each .}}
<li class="replyLi" data-replyNo={{replyNo}}>
<i class="fa fa-comments bg-blue"></i>
 <div class="timeline-item" >
  <span class="time">
    <i class="fa fa-clock-o"></i>{{prettifyDate regdate}}
  </span>
  <h3 class="timeline-header"><strong>{{replyNo}}</strong> -{{userId}}</h3>
  <div class="timeline-body">{{replytext}} </div>
    <div class="timeline-footer">
     <a class="btn btn-primary btn-xs" 
	    data-toggle="modal" data-target="div[id=modifyModal]">Modify</a>
    </div>
  </div>			
</li>
{{/each}}
</script>
</head>
<body>
	<%@include file="../include/nav.jsp"%>
	<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->
			<div class="box box-primary">
				<div class="box-header">
					<h3 class="box-title">READ BOARD</h3>
				</div>
				<!-- /.box-header -->

				<form role="form" action="/admin/board/update" method="post">

					<input type='hidden' id='boardNo' name='boardNo' value="${boardVO.boardNo}">
					<input type='hidden' id='currentPage'name='currentPage' value="${search.currentPage}"> 
					<input type='hidden' id='searchCondition'name='searchCondition' value="${search.searchCondition}">
					<input type='hidden' id='searchKeyword'name='searchKeyword' value="${search.searchKeyword}">

				</form>

				<div class="box-body">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label> 
						<input type="text" name='title' class="form-control" value="${boardVO.title}"
							readonly="readonly">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Content</label>
						<textarea class="form-control" name="content" rows="3" readonly="readonly">${boardVO.content}</textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputEmail1">UserId</label> <input type="text"
							name="userId" class="form-control" value="${boardVO.userId}"
							readonly="readonly">
					</div>
				</div>
				<!-- /.box-body -->

				<div class="box-footer">
					<button type="submit" class="btn btn-warning" id="modifyBtn">Modify</button>
					<button type="submit" class="btn btn-danger" id="removeBtn">REMOVE</button>
					<button type="submit" class="btn btn-primary" id="goListBtn">GO
						LIST</button>
				</div>
			</div>
			<!-- /.box -->
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->



	 <div class="row">
		<div class="col-md-12">

			<div class="box box-success">
				<div class="box-header">
					<h3 class="box-title">ADD NEW REPLY</h3>
				</div>
				
				  <c:if test="${not empty user}">  
				<div class="box-body">
					<label for="exampleInputEmail1">UserId</label> 
					<input class="form-control" type="text" placeholder="USER ID" id="newReplyUserId"
					readonly="readonly" value="${user.userId}"> 
						<label for="exampleInputEmail1">Reply Text</label>
						 <input class="form-control" type="text" placeholder="REPLY TEXT" id="newReplyText">

				</div>
				<!-- /.box-body -->
				<div class="box-footer">
					<button type="button" class="btn btn-primary" id="replyAddBtn">ADD REPLY</button>
				</div>
				</c:if>
				
				<c:if test="${empty user}">
			    <div class="box-body">
			      <div><a href="/" >Login Please</a></div>
			    </div>
			  </c:if>
			</div>


			<!-- The time line -->
			<ul class="timeline">
				<!-- timeline time label -->
				<li class="time-label" id="repliesDiv"><span class="bg-green">Replies List </span></li>
			</ul>

			<div class='text-center'>
				<ul id="pagination" class="pagination pagination-sm no-margin ">

				</ul>
			</div>

		</div>
		<!-- /.col -->
	</div>
	<!-- /.row --> <!-- Modal -->
	<div id="modifyModal" class="modal modal-primary fade" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title" id="modal-title"></h4>
				</div>
				<div class="modal-body" data-replyNo>
					<p>
						<input type="text" id="replytext" class="form-control">
					</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-info" id="replyModBtn">ReplyModify</button>
					<button type="button" class="btn btn-danger" id="replyDelBtn">DELETE</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div> 
 

	</section>
	<!-- /.content -->

</body>
<%@include file="../include/footer.jsp"%>
</html>


