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
<script src="${pageContext.request.contextPath}/resources/js/yd/joinjs.js"></script>
</head>

<script type="text/javascript">

var result = '${param.cc}';
if(result == "error"){
	alert('아이디 중복입니다.');
	location.href='/member/Register';
}

</script>

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
<article style="padding-left: 40%;">
<br>
<img src="${pageContext.request.contextPath }/resources/img/logo2.jpg" style=" width: 33%;">
<br>

<form action="${pageContext.request.contextPath}/member/insertMember" id="join" method="post">
<fieldset>

<div class="form-group has-feedback text-gap">
<br>
<label class="col-sm-2 control-label" for="reg_mb_id">
<b>아이디</b>
</label>
<div class="col-sm-3">
<input type="text" name="userid"  id="reg_mb_id" 
required class="form-control input-sm" minlength="4" maxlength="10" oninput="checkId()" style="width: 150%;">
</div>
<span class="id_ok" style="display: none; padding-left: 2%; color: green;">
사용 가능한 아이디입니다.
</span>
<span class="id_already" style="display: none; padding-left: 2%; color: red;">
이미 사용중인 아이디입니다.
</span>

</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>비밀번호</b>
</label>
<div class="col-sm-3">
<input type="password" name="userpw" id="reg_mb_password" 
required class="form-control input-sm" minlength="4" maxlength="20" style="width: 150%;">
</div>
</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>이름</b>
</label>
<div class="col-sm-3">
<input type="text" name="username" id="reg_mb_password" 
required class="form-control input-sm" minlength="2" maxlength="20" style="width: 150%;">
</div>
</div>

<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>이메일</b>
</label>
<div class="col-sm-3">
<input type="email" name="useremail" id="reg_mb_email" 
required class="form-control input-sm" minlength="4" maxlength="20" style="width: 150%;">
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
<!-- ë³¸ë¬¸ë´ì© -->
<!-- ë³¸ë¬¸ë¤ì´ê°ë ê³³ -->

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>