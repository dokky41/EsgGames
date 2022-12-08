<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>EsgGames</title>
<meta charset="UTF-8">
<meta name="description" content="Game Warrior Template">
<meta name="keywords" content="warrior, game, creative, html">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/yd/myInfoC.css">
<script>
	if ("${membervo.userid}" == '') {
		alert('로그인이 필요합니다');
		location.href = "${pageContext.request.contextPath}/member/login";
	}
</script>
</head>
<body id="body-pd">
	<div class="l-navbar" id="navbar">
		<nav class="nav">
			<div>
				<div class="nav__brand">
					<ion-icon name="menu-outline" class="nav__toggle" id="nav-toggle"></ion-icon>
					<a href="${pageContext.request.contextPath }/index" class="nav__logo">메인페이지</a>
				</div>
				<div class="nav__list">
					<a href="${pageContext.request.contextPath }/member/myinfo?sort=1&userid=${membervo.userid}"
						class="nav__link active"> <ion-icon name="home-outline"
							class="nav__icon"></ion-icon> <span class="nav_name">정보페이지</span>
					</a>

					<div href="#" class="nav__link collapse">
						<ion-icon name="chatbubbles-outline" class="nav__icon"></ion-icon>
						<span class="nav_name">메세지함</span>

						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>

						<ul class="collapse__menu">
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=submit&userid=${membervo.userid}"" class="collapse__sublink">submit</a>
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=mailFrom&userid=${membervo.userid}" class="collapse__sublink">from</a>
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=mailTo&userid=${membervo.userid}" class="collapse__sublink">to</a>
						</ul>

					</div>

					<div href="#" class="nav__link collapse">
						<ion-icon name="diamond-outline" class="nav__icon"></ion-icon>
						<span class="nav_name">마일리지</span>

						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>

						<ul class="collapse__menu">
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=charge&userid=${membervo.userid}" class="collapse__sublink">Charge</a>
<%-- 							<a href="${pageContext.request.contextPath }/member/myinfo?sort=exChange" class="collapse__sublink">exChange</a> --%>
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=chargeList&userid=${membervo.userid}" class="collapse__sublink">mileList</a>
						</ul>
					</div>

					<div href="#" class="nav__link collapse">
						<ion-icon name="pie-chart-outline" class="nav__icon"></ion-icon>
						<span class="nav_name">거래관련</span>

						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>

						<ul class="collapse__menu">
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=trList&userid=${membervo.userid}"
							 class="collapse__sublink">list</a>
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=trFromList&userid=${membervo.userid}"
							 class="collapse__sublink">from</a>
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=trToList&userid=${membervo.userid}" 
							class="collapse__sublink">to</a>
						</ul>

					</div>

					<div href="#" class="nav__link collapse">
						<ion-icon name="people-outline" class="nav__icon"></ion-icon>
						<span class="nav_name">내 정보</span>

						<ion-icon name="chevron-down-outline" class="collapse__link"></ion-icon>

						<ul class="collapse__menu">
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=myInfoView&userid=${membervo.userid}" class="collapse__sublink">select</a>
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=myinfoUpdate&userid=${membervo.userid}" class="collapse__sublink">update</a>
							<a href="${pageContext.request.contextPath }/member/myinfo?sort=myinfoDelete&userid=${membervo.userid}" class="collapse__sublink">delete</a>
						</ul>

					</div>

					<a href="#" class="nav__link"> <ion-icon
							name="settings-outline" class="nav__icon"></ion-icon> <span
						class="nav_name">Settings</span>
					</a>
				</div>
				<a href="${pageContext.request.contextPath }/member/logout"
					class="nav__link"> <ion-icon name="log-out-outline"
						class="nav__icon"></ion-icon> <span class="nav_name">Log
						out</span>
				</a>
			</div>
		</nav>
	</div>

	<c:if test="${param.sort=='1' }">
	<jsp:include page="include/base.jsp" />
	</c:if>
	
	<!-- 메세지 -->
	<c:if test="${param.sort=='submit'}">
	<jsp:include page="include/mSubmit.jsp" />
	</c:if>
	
	<c:if test="${param.sort=='mailFrom'}">
	<jsp:include page="include/mailFrom.jsp" />
	</c:if>
	
	<c:if test="${param.sort =='mailTo'}">
	<jsp:include page="include/mailTo.jsp" />
	</c:if>
	<!-- 메세지 -->
	
	<!-- 마일리지 -->
	<c:if test="${param.sort=='charge'}">
	<jsp:include page="include/pointCharge.jsp" />
	</c:if>
	
	<c:if test="${param.sort=='exChange'}">
	<jsp:include page="include/exChangeList.jsp" />
	</c:if>
	
	<c:if test="${param.sort =='chargeList'}">
	<jsp:include page="include/chargeList.jsp" />
	</c:if>
	<!-- 마일리지 -->


	<!-- 내 정보 -->
	<c:if test="${param.sort =='myInfoView'}">
	<jsp:include page="include/myInfoView.jsp" />
	</c:if>
	
	<c:if test="${param.sort =='myinfoUpdate'}">
	<jsp:include page="include/myinfoUpdate.jsp" />
	</c:if>
	
	<c:if test="${param.sort =='myinfoDelete'}">
	<jsp:include page="include/myinfoDelete.jsp" />
	</c:if>

	<!-- 내 정보 -->
	
	
	<!-- 거래 -->
	<c:if test="${param.sort =='trList'}">
	<jsp:include page="include/trList.jsp" />
	</c:if>
	
	<c:if test="${param.sort =='trFromList'}">
	<jsp:include page="include/trFromList.jsp" />
	</c:if>
	
	<c:if test="${param.sort =='trToList'}">
	<jsp:include page="include/trToList.jsp" />
	</c:if>
	
	<!-- 거래 -->
	
	<!-- IONICONS -->
	<script src="https://unpkg.com/ionicons@5.5.2/dist/ionicons.js"></script>
	<!-- JS -->
	<script
		src="${pageContext.request.contextPath }/resources/js/yd/myInfoC.js"></script>
</body>
</html>