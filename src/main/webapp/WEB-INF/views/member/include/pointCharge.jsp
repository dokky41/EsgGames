<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
<br>
<br>
<h2><b>마일리지 충전소</b></h2>
<br>
<form>

	<input type="hidden"  value="${membervo.userid }" id="puserid">
	<input type="hidden"  value="${membervo.useremail }" id="puseremail">
	<input type="hidden"  value="${membervo.username }" id="pusername">
	<input type="hidden"  value="${membervo.address }" id="paddress">
	<input type="hidden"  value="${chargeNum}" id="chargeNum">
				
				
				<img alt="" src="${pageContext.request.contextPath }/resources/img/yd/kakaoCharge.png" width="100px" height="70px">
				<img alt="" src="${pageContext.request.contextPath }/resources/img/yd/tossCharge.png" width="100px" height="70px">
				<img alt="" src="${pageContext.request.contextPath }/resources/img/yd/cardCharge.png" width="100px" height="70px">
				<img alt="" src="${pageContext.request.contextPath }/resources/img/yd/paycoCharge.png" width="100px" height="70px">
				<img alt="" src="${pageContext.request.contextPath }/resources/img/yd/phoneCharge.png" width="100px" height="70px">
				
				<br><br><br> 

				<h3 style="color: red;"><b>* 결제방식을 선택해주세요</b></h3>				
				
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
		</form>

<div class="clear"></div>
<!-- í¸í°ë¤ì´ê°ë ê³³ -->
<script src="${pageContext.request.contextPath}/resources/js/yd/pointChJr.js"></script>