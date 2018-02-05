<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-default">
 <div class="container">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
   </button>
   <div class="navbar-brand">Nainfox</div>
  </div>
  <div class="collapse navbar-collapse" id="myNavbar">
   <ul class="nav navbar-nav">
    <li><a href="/admin/adminHome">Home</a></li>
    <li><a href="#">상품 관리</a></li>
    <li><a href="#">화학 성분 관리</a></li>
    <li><a href="/admin/board/list">유저 게시판</a></li>
   </ul>
   <ul class="nav navbar-nav navbar-right">
 
       <li><a href="#">My Account</a></li>
       <li><a href="/logout">Logout</a></li>
   
     <li><a href="/users/new">Sign Up</a></li>
     <li><a href="/login">Login</a></li>

   </ul>
  </div>
 </div>
</nav>