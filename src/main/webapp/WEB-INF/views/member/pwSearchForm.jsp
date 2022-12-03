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
<h5 class="login__fb-title" ><b>비밀번호 찾기</b></h5>
<br>

<form action="${pageContext.request.contextPath}/member/pwSearchForm" id= "join" method="post">
<fieldset>

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
					<p class="idWrap">
						<a style="color: black;"><b>아이디</b></a><br>
						<input type="text" maxlength="50" 
						id="userid" name="userid" class="inputidpw" placeholder="이름" style="width: 288px;">
						
					</p>
					
					<p class="pwWrap">
						<a style="color: black;"><b>생년월일</b></a><br>
						<input type="text" id="dayBirth1" name="dayBirth1" 
						class="inputidpw" placeholder="ex)980132" style="width: 288px;">
					</p>
					
					<p class="pwWrap">
						<a style="color: black;"><b>전화번호</b></a><br>
						<input type="text" id="phNum" name="phNum" 
						class="inputidpw" placeholder="ex)01012345678" style="width: 288px;">
					</p>
					
					<div id="notice" role="tooltip"></div>
					<p id="content">
					
					<button id="loginBtn" class="btn btn-primary btn-large"
					type="submit" style="width: 288px;">
					
					<span>
					<i class="fa fa-sign-in">
					</i> 비밀번호 재발급</span></button>
					
					
					</p>
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