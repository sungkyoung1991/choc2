<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:if test="${ mainList eq null }">
 	<jsp:forward page="/main/mainModule"/>
</c:if> --%>


<!DOCTYPE html>
<html>
<head>
<title>Facebook Login JavaScript Example</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<script type="text/javascript">
	$(function() {

		$("#userId").focus();

		$("#Login").on(
				"click",
				function() {
					var id = $("input:text").val();
					var pw = $("input:password").val();

					console.log("check......!!")

					if (id == null || id.length < 1) {
						alert('ID 를 입력하지 않으셨습니다.');
						$("#userId").focus();
						return;
					}

					if (pw == null || pw.length < 1) {
						alert('패스워드를 입력하지 않으셨습니다.');
						$("#password").focus();
						return;
					}

					$("form").attr("method", "POST").attr("action",
							"/user/login").submit();
				});
		
		
	});

	$(function() {
		$("input:password").on('keydown', function(event) {

			if (event.keyCode == 13) {
				event.preventDefault();
				$("#Login").click();
			}

		})

	})
	
	function fncGetList(currentPage) {
		$("#currentPage").val(currentPage)
		$("form").attr("method" , "GET").attr("action" , "/main/mainModule").submit();
	}
	
	
	$(function(){
		
	$("#Create").on("click",function(){
		self.location="/user/createUserPage";	
	})
	})
	
</script>

</head>

<body>
<!-- <a herf="/admin/board/list"><h3>admin board manage</h3></a>
<a herf="/admin/cosmetic/list"><h3>admin cosmetic manage</h3></a>
<a herf="/super/userManage/list"><h3>super user manage</h3></a> -->

<a href="/user/getCosmeticList">user cosmetic manage</a><br /><br />

<%-- <jsp:include page="/WEB-INF/views/user/index.jsp"></jsp:include> --%>

<!-- JavaScript SDK를 사용하여 Facebook 로그인을 구현 -->
<!-- <script>
  // This is called with the results from from FB.getLoginStatus().
   function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
	//response 객체는 현재 로그인 상태를 나타내는 정보를 보여준다.
	//현재 로그인의 상태에 따라 동작하면 된다.
    // Full docs on the response object can be found in the documentation
    // for FB.getLoginStatus().
    if (response.status === 'connected') {
      //페이스북을 통해서 로그인이 되었다.
      $("#status").append("status:connected");
    } else {
      // 페이스북에 로그인이 되어있지 않다. 
    	  $("#status").append(response);
    }
  } 

	//이 함수는 누군가가 로그인 버튼에 대한 처리가 끝났을 때 호출된다. 
	// onlogin 핸들러를 아래와 같이 첨부하면 된다.


  function checkLoginState() {
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });
  }

  window.fbAsyncInit = function() {
    FB.init({
      appId      : '2043489025940197', //app ID
      cookie     : true,  // 쿠키가 세션을 참조할 수 있도록 허용
      xfbml      : true,  // 소셜 플러그인이 있으면 처리
      version    : 'v2.8' // 버전 2.8사 
    });

 // 자바스크립트 SDK를 초기화 했으니, FB.getLoginStatus()를 호출한다. 
 // 이 함수는 이 페이지의 사용자가 현재 로그인 되어있는 상태 3가지 중 하나를 콜백에 리턴한다. 
 // 그 3가지 상태는 아래와 같다. 
 // 1. 앱과 페이스북에 로그인 되어있다. ('connected') 
 // 2. 페이스북에 로그인되어있으나, 앱에는 로그인이 되어있지 않다. ('not_authorized') 
 // 3. 페이스북에 로그인이 되어있지 않아서 앱에 로그인이 되었는지 불확실하다. 
 // 
 // 위에서 구현한 콜백 함수는 이 3가지를 다루도록 되어있다.


    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
    });

  };

  // SDK를 비동기적으로 호출
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); 
    js.id = id;
    js.src = "https://connect.facebook.net/en_US/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));

	
  // 로그인이 성공한 다음에는 간단한 그래프API를 호출한다. 
  // 이 호출은 statusChangeCallback()에서 이루어진다.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + '!';
    });
  } 
  
  function fbLoginAction() {
	    console.log('Welcome!  Fetching your information.... ');
	    FB.api('/me', function(response) {
	      console.log('Successful login for: ' + response.name);
	      document.getElementById('status').innerHTML =
	        'Thanks for logging in, ' + response.name + '!';
	    });
	  }
  
</script>
 -->

<!-- <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
</fb:login-button>
 -->

 <!-- 
 	<button type="button" class="button facebook" onclick="fbLoginAction();">Login with Facebook</button>
	<div id="status"></div> -->

<!-- <button type="button" class="button facebook" id="loginBtn">페이스북 계정으로 로그인</button> -->
 
          	  <!-- <div id="access_token"></div>
            	  <div id="user_id"></div>
              <div id="name"></div>
              <div id="email"></div>
              <div id="gender"></div>
              <div id="birthday"></div>
              <div id="id"></div> -->
            
             <form name=f>
            <!--  <input type="hidden" name="access_token" id="access_token">
             <input type="hidden" name="user_id" id="user_id"> 
             <input type="hidden" name="nickName" id="nickName">  -->
             <input type="hidden" name="email" id="email">
         	 <input type="hidden" name="gender" id="gender">
            <!--  <input type="hidden" name="birthday" id="birthday">
              <input type="hidden" name="id" id="id">  -->
             </form> 
<!-- <script>
function getUserData() {
    /* FB.api('/me', function(response) {
        document.getElementById('response').innerHTML = 'Hello ' + response.name;
        console.log(response);
    }); */
    FB.api('/me', {fields: 'name,email,gender,birthday'}, function(response) {
        console.log(JSON.stringify(response));
        document.f.email.value = response.email;
        console.log(eamil.value);
       // $("#name").text("이름 : "+response.name);
        //$("#email").text("이메일 : "+response.email);
        document.f.gender.value = response.gender;
      	//  $("#birthday").text("생년월일 : "+response.birthday);
       	// $("#id").text("아이디 : "+response.id);
    });
}
  
window.fbAsyncInit = function() {
    //SDK loaded, initialize it
    FB.init({
        appId      : '2043489025940197', //App ID
        cookie     : true,  // enable cookies to allow the server to access the session
        xfbml      : true,  // parse social plugins on this page
        version    : 'v2.8' // use graph api version 2.8
    });
  
    //check user session and refresh it
    FB.getLoginStatus(function(response) {
        if (response.status === 'connected') {
            //user is authorized
            //document.getElementById('loginBtn').style.display = 'none';
            getUserData();
        } else {
            //user is not authorized
        }
    });
};
  
//load the JavaScript SDK
(function(d, s, id){
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) {return;}
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.com/ko_KR/sdk.js";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));
  
//add event listener to login button
document.getElementById('loginBtn').addEventListener('click', function() {
    //do the login
    FB.login(function(response) {
        if (response.authResponse) {
            access_token = response.authResponse.accessToken; //get access token
            user_id = response.authResponse.userID; //get FB UID
            //console.log('access_token = '+access_token);
            //console.log('user_id = '+user_id);
            $("#access_token").text("접근 토큰 : "+access_token);
            $("#user_id").text("FB UID : "+user_id);
            //user just authorized your app
            document.getElementById('loginBtn').style.display = 'none';
            getUserData();
            $("form").attr("method","GET").attr("action","/user/createUserP").submit();
            
        }
    }, {scope: 'email,public_profile,user_birthday', //permission
        return_scopes: true});
}, false);

</script> -->
 

<br/><br/><br/><br/>
 
	 <form>
	
	ID<input type="text" name="userId" id="userId" />
	PW<input type="password" name="password" id="password" />
	<input type="button" id="Login" value="로그인"/>
	<!-- <a href="/user/createUserp">회원가입</a>  -->
	<input type="button" value="회원가입" id="Create" /> 
	<br/><br/><br/><br/>
	
		
	</form> 
	

</body>


</html>