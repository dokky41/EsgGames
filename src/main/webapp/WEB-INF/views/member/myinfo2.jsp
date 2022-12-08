<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESG GAMES</title>
<link href="${pageContext.request.contextPath }/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">

<jsp:include page="../include/header.jsp"></jsp:include>

<div id="sub_img_member"></div>
<nav id="sub_menu">
<ul>

</ul>
</nav>
<article style="padding-left: 40%;  height: 100%;">
<!-- <a href="/index" style="padding-left: 45%;"> -->
<br>
<img style="padding-left: 1%;" width="300"
 src="${pageContext.request.contextPath }/resources/img/logo2.jpg" style=" width: 33%;">
<br>
<br>
<h5 style="padding-left: 5%;"><b>${membervo.userid}님의 정보 페이지</b></h5>
<br>
<fieldset>

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
					
					
						<table border="1" style="text-align: center;">
							
							<tr>
							<td width="100" >아이디  </td>
							<td width="185"> ${membervo.userid }</td>
							</tr>
						
							<tr>
							<td>이름  </td>
							<td>${membervo.username }</td>
							</tr>
							
							<tr>
							<td>이메일  </td>
							<td> ${membervo.useremail}</td>
							</tr>
						
							<tr>
							<td>마일리지  </td>
							<td> ${membervo.userpoint}</td>
							</tr>
						
						</table>
							
							<br>
					
					
					<div id="notice" role="tooltip"></div>
					<p id="content">
					<button id="loginBtn" class="btn btn-primary btn-large"
					onclick="location.href='/member/pointCharge'; return false;" style="width: 140px;">
					<span>
					<i class="fa fa-sign-in">
					</i> 마일리지 충전</span></button>
					
					<button id="loginBtn" class="btn btn-primary btn-large" 
					onclick="location.href='/member/myChargeInfo?userid=${membervo.userid}'; return false;" style="width: 145px; background: red;">
					<span>
					<i class="fa fa-sign-in">
					</i> 내 충전내역</span></button>
					</p>
					
					
					
				</div>
				
				<button id="loginBtn" class="btn btn-primary btn-large" 
					onclick="location.href='/member/myTradeInfo?userid=${membervo.userid}'; return false;" style="width: 145px; background: #2c974b;">
					<span>
					<i class="fa fa-sign-in">
					</i>내 거래정보</span></button>
				
				<button id="loginBtn" class="btn btn-primary btn-large" 
					onclick="location.href='/member/myinfoUpdate?userid=${membervo.userid}'; return false;" style="width: 145px; background: black;">
					<span>
					<i class="fa fa-sign-in">
					</i>회원정보변경</span></button>
					
						<button id="loginBtn" class="btn btn-primary btn-large" 
					onclick="location.href='/member/myinfoUpdate?userid=${membervo.userid}'; return false;" style="width: 145px; background: black;">
					<span>
					<i class="fa fa-sign-in">
					</i>메세지함</span></button>
					
				<br>
				
				
			</div>
			</fieldset>
		
</article>

<div class="clear"></div>
<!-- í¸í°ë¤ì´ê°ë ê³³ -->

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>