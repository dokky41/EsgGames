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
<img src="${pageContext.request.contextPath }/resources/img/logo2.jpg" style=" width: 33%;">
<br>
<br>
<h5 class="login__fb-title"><b>로그인 후 이용하실 수 있습니다.</b></h5>
<br>
<form action="${pageContext.request.contextPath}/member/login" id= "join" method="post">
<fieldset>

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
					<p class="idWrap">
						<input type="text" title="아이디 입력" value="" maxlength="50" 
						id="userid" name="userid" class="inputidpw" placeholder="아이디" style="width: 288px;">
						
					</p>
					<p class="pwWrap">
						<input type="password" title="비밀번호 입력" value=""
						id="userpw" name="userpw" class="inputidpw" placeholder="비밀번호" style="width: 288px;">
					</p>
					<div id="notice" role="tooltip"></div>
					<input type="hidden" value="68597a4f6ca586b0ba5f9cfecb80d4" id="stoken" name="stoken">
                                        <input type="hidden" value="" id="comm" name="comm">
                                        <input type="hidden" value="" id="sid" name="sid">
					<p id="content"><button id="loginBtn" class="btn btn-primary btn-large"
					type="submit" style="width: 140px;">
					<span>
					<i class="fa fa-sign-in">
					</i> 로그인</span></button>
					<button id="loginBtn" class="btn btn-primary btn-large" 
					onclick="location.href='/member/Register'; return false;" style="width: 145px; background: #2c974b;">
					<span>
					<i class="fa fa-sign-in">
					</i> 회원가입</span></button>
					</p>
				</div>
				<div class="saveid">
					<div class="btn-group" >
					<label class="txt btn btn-info" style="width: 145px;">
					<a href="/member/idSearchForm" style="color: white;">아이디 찾기</a>
					</label>
					<label class="txt btn btn-info" style="width: 145px;">
					<a href="/member/pwSearchForm" style="color: white;">비밀번호 찾기</a>
					</label>
					</div>
				</div>
				
				
				<br>
			</form>
			</div>
			</fieldset>
		
</article>

<div class="clear"></div>
<!-- í¸í°ë¤ì´ê°ë ê³³ -->

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>