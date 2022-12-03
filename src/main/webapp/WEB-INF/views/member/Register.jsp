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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1b9c0085e46235e63cafae9e646dcf26&libraries=services"></script>
<script src="${pageContext.request.contextPath}/resources/js/yd/joinjs.js"></script>

</head>

<body>
<div id="wrap">

<jsp:include page="../include/header.jsp"></jsp:include>

<div id="sub_img_member"></div>
<!-- ë³¸ë¬¸ë©ì¸ì´ë¯¸ì§ -->
<!-- ì¼ìª½ë©ë´ -->
<nav id="sub_menu">
</nav>
<!-- ì¼ìª½ë©ë´ -->
<!-- ë³¸ë¬¸ë´ì© -->
<article >

<article style="padding-left: 40%;">
<br>
<img src="${pageContext.request.contextPath }/resources/img/logo2.jpg" style=" width: 33%;">
<br>

<form action="${pageContext.request.contextPath}/member/insertMember" id="join" method="post" onsubmit="return checkForm()">
<fieldset>

<div class="form-group has-feedback text-gap">
<br>
<label class="col-sm-2 control-label" for="reg_mb_id">
<b>아이디</b>
</label>
<div class="col-sm-3">
<input type="text" name="userid"  id="id"  placeholder="아이디 입력" onblur = "checkId()" 
required class="form-control input-sm" minlength="4" maxlength="10" oninput="checkId()" style="width: 150%;">
</div>
<span id="checkId1" style="display: none; padding-left: 2%">&nbsp;</span>
</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>비밀번호</b>
</label>
<div class="col-sm-3">
<input type="password" name="userpw" id="pw" placeholder="비밀번호 입력" onblur="checkPwd()"
required class="form-control input-sm" minlength="4" maxlength="20" style="width: 150%;">
<span class="pw_ok1" id="checkPwd1" style="display: none;"> &nbsp;</span>
</div>
</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>비밀번호 확인</b>
</label>
<div class="col-sm-3">
<input type="password"  id="pw2" placeholder="비밀번호 확인 입력" onblur="checkPwd2()"
required class="form-control input-sm" minlength="4" maxlength="20" style="width: 150%;">
<span class="pw_ok2" id="checkPwd2" style="display: none;"> &nbsp;</span>
</div>
</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>이름</b>
</label>
<div class="col-sm-3">
<input type="text" name="username" id="name"  placeholder="이름 입력" onblur="checkName()"
required class="form-control input-sm" minlength="2" maxlength="20" style="width: 150%;">
<span class="name_ok" id="checkName" style="display: none;">&nbsp;</span>
</div>
</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>주민번호</b>
</label>
<div class="col-sm-3">
<input type="text" name="dayBirth1" id="dayBirth1"  placeholder="ex)앞자리6자리" onblur="checkJumin1()"
required class="form-control input-sm" minlength="6" maxlength="6" style="width: 150%;">
<input type="password" name="dayBirth2" id="dayBirth2"  placeholder="ex)뒷자리7자리" onblur="checkJumin2()"
required class="form-control input-sm" minlength="7" maxlength="7" style="width: 150%;">
</div>
</div>


<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>이메일</b>
</label>
<div class="col-sm-3">
<input type="email" name="useremail" id="email" placeholder="이메일 입력"
required class="form-control input-sm" minlength="4" maxlength="20" style="width: 150%;">
</div>
</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>주소</b>
</label>
<div class="col-sm-3">

<input type="text" id="sample6_postcode" placeholder="우편번호" name="address1" required class="form-control input-sm" style="width: 150%;">
<input type="text" id="sample6_address" placeholder="주소"  name="address2" required class="form-control input-sm" style="width: 150%;">
<input type="text" id="sample6_extraAddress" placeholder="참고항목" name="address3" required class="form-control input-sm" style="width: 150%;">
<input type="text" id="sample6_detailAddress" placeholder="상세주소" name="address4"  required class="form-control input-sm" style="width: 150%;">
<input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
</div>
</div>
<br>



<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>전화번호</b></label>
<div class="col-sm-3">
<input type="text" name="phNum" id="phNum" placeholder="번호를 입력해주세요" 
required class="form-control input-sm" style="width: 150%;">
<input type="button" onclick="aatest()" value="본인인증">
</div>
</div>

<br>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>인증번호입력  </b> </label>&nbsp; <a id="demo" style="color: red;"></a>
<div class="col-sm-3">
<input type="text" name="injungN" id="injungN" placeholder="인증번호를 입력해주세요"
required class="form-control input-sm" style="width: 150%;">

<input type='hidden' name='ppnum' id='ppnum'>
</div>
</div>







</fieldset>

<br>
<div class="clear"></div>
<div id="buttons" style="padding-left: 2%">
<input type="submit" value="회원가입" class="submit" style="width: 16%;">
<input type="button" value="취소" onclick="location.href='/index'" style="width: 16%;">
</div>
</form>
<br>
</article>

</article>

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>