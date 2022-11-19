<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<h5 style="padding-left: 5%;"><b>${membervo.userid}님의 거래내역</b></h5>
<br>
<fieldset>

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
					
						
							<c:forEach var="MMList" items="${MMInfo }">
							
								충전방식 : ${MMList.chargeSort } <br>
							
							
							</c:forEach>
							
							<br>
					
					
					<div id="notice" role="tooltip"></div>
					<p id="content">
					<button id="loginBtn" class="btn btn-primary btn-large"
					onclick="location.href='/member/pointCharge'; return false;" style="width: 140px;">
					<span>
					<i class="fa fa-sign-in">
					</i> 마일리지 충전</span></button>
					
					<button id="loginBtn" class="btn btn-primary btn-large" 
					onclick="location.href='/member/myTradeInfo'; return false;" style="width: 145px; background: #2c974b;">
					<span>
					<i class="fa fa-sign-in">
					</i> 내 거래정보</span></button>
					</p>
				</div>
				
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