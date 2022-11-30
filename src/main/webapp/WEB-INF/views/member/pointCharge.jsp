<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESG GAMES</title>
<link href="${pageContext.request.contextPath }/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/subpage.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>

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
<h5 class="login__fb-title"><b>포인트 충전소</b></h5>
<br>
<form>
<fieldset>

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
	<input type="hidden"  value="${membervo.userid }" id="puserid">
	<input type="hidden"  value="${membervo.useremail }" id="puseremail">
	<input type="hidden"  value="${membervo.username }" id="pusername">
	<input type="hidden"  value="${membervo.address }" id="paddress">
	<input type="hidden"  value="${chargeNum}" id="chargeNum">
				
					결제수단 : 
					
					<select id="payment-select" class="select_type_1"
											style="border-radius: 10px;" >
												<option value="kakaopay">카카오페이</option>
												<option value="tosspay">토스</option>
												<option value="html5_inicis" >신용/체크카드</option>
												<option value="payco">PAYCO</option>
												<option value="danal_tpay">휴대폰결제</option>
										</select>
					
					<br><br>
					충전금액 : <input type="number" name="pnumber" id="pnumber">
								
								<br><br>
								<button type="button" onclick="requestPay()">결제</button>
								<button type="button" onclick="cancelPay()">취소</button>
				<br><br><br>
			</div>
			</fieldset>
		</form>
</article>

<div class="clear"></div>
<!-- í¸í°ë¤ì´ê°ë ê³³ -->
<script src="${pageContext.request.contextPath}/resources/js/yd/pointChJr.js"></script>
<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>