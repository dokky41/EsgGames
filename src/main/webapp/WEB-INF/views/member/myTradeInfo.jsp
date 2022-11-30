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
<h5 style="padding-left: 5%;"><b>${membervo.userid}님의 거래내역페이지</b></h5>
<br>
<fieldset>

<!-- 오늘날짜 -->
<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy-MM-dd" /></c:set> 
<!-- 오늘날짜 -->

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
					
						
						
							<c:forEach var="trList" items="${trInfo }">
							
							<table border="1" style="text-align: center;">
								<tr>
								<th colspan="2">
								영수증
								</th>
								</tr>
							
								<tr>
								<td>거래번호</td> 
								<td> ${trList.trBnum }</td> 
								</tr>
								
								<tr>
								<td>판매자</td> 
								<td> ${trList.trReceiver }</td> 
								</tr>
								
								<tr>
								<td>거래자</td> 
								<td> ${trList.trSender}</td> 
								</tr>
								
								<tr>
								<td>거래글번호</td> 
								<td> ${trList.trConNum}</td> 
								</tr>
								
								
								
								<tr>
								<td>요청제목</td> 
								<td> ${trList.trSubject}</td> 
								</tr>
								<tr>
								<td>요청내용</td> 
								<td> ${trList.trContent}</td> 
								</tr>
								
								<tr>
								<td>등록날짜</td> 
								<td>
								<fmt:formatDate value="${trList.trDate }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td> 
								</tr>
								
								<tr>
								<td>거래상태</td> 
								<td>
								${trList.trState }
								</td> 
								</tr>
								
							</table>
							
							<c:if test="${membervo.userid==trList.trReceiver}">
							
							<form action="${pageContext.request.contextPath }/member/trAgree" method="post">
							<input type="hidden" name="userid" value="${membervo.userid }">
							<input type="hidden" name="bUserid" value="${trList.trSender }">
							<input type="hidden" name="trBnum" value="${trList.trBnum }">
							<input type="hidden" name="num" value="${trList.trConNum }">
							
							<button type="submit">승낙</button>
							<button type="button"  onclick="location.href='/ydTrBoard/trRefuse'">거부</button>
							</form>
							
							</c:if>
							
<%-- 							<c:if test="${trList.trState!='yes'}"> --%>
<!-- 							<button >취소</button> -->
<%-- 							</c:if> --%>
							
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