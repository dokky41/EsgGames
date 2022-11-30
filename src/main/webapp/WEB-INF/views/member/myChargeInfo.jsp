<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h5 style="padding-left: 5%;"><b>${membervo.userid}님의 충전내역</b></h5>
<br>
<fieldset>

<!-- 오늘날짜 -->
<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
<!-- 오늘날짜 -->

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
					
						
						
							<c:forEach var="MMList" items="${MMInfo }">
							
							<table border="1" style="text-align: center;">
								<tr>
								<th colspan="2">
								영수증
								</th>
								</tr>
							
								<tr>
								<td>충전번호</td> 
								<td> ${MMList.chargeNum }</td> 
								</tr>
								
								<tr>
								<td>충전방식</td> 
								<td> ${MMList.chargeSort }</td> 
								</tr>
								
								<tr>
								<td>충전금액</td> 
								<td> ${MMList.userpoint}</td> 
								</tr>
								
								<tr>
								<td>충전날짜</td> 
								<td>
								<fmt:formatDate value="${MMList.date }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td> 
								</tr>
								
								
								
							</table>
							
							
							
							<br><br>
							</c:forEach>
							<br>
					
					
					
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