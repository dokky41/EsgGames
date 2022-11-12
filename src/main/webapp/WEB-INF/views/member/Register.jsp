<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ESG GAMES</title>
<link href="${pageContext.request.contextPath }/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/subpage.css" rel="stylesheet" type="text/css">

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/joinjs.js"></script>
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
<article>

<h1>Register</h1>
<form action="${pageContext.request.contextPath}/member/insertMember" id="join" method="post">
<fieldset>
<legend>회원가입</legend>
<div class="form-group has-feedback text-gap">
<label class="col-sm-2 control-label" for="reg_mb_id"><b>아이디</b></label>
<div class="col-sm-3">
<input type="text" name="userid" value id="reg_mb_id" required class="form-control input-sm" minlength="3" maxlength="20">
</div>
</div>
<input type="text" name="userid" class="id" id="userid" oninput="checkId()">

<span class="id_ok" style="display: none;">사용 가능한 아이디입니다.</span>
<span class="id_already" style="display: none;">이미 사용중인 아이디입니다.</span>


<input type="button" value="dup. check" class="dup"><br>
<div class="form-group has-feedback">
<label class="col-sm-2 control-label" for="reg_mb_password"><b>비밀번호</b>
</label>
<div class="col-sm-3">
<input type="password" name="userpw" id="reg_mb_password" required class="form-control input-sm" minlength="3" maxlength="20">
</div>
</div>

<input type="password" name="userpw"><br>

<label>Name</label>
<input type="text" name="username"><br>
<label>E-Mail</label>
<input type="email" name="useremail"><br>
<label>Address</label>
<input type="text" name="address"><br>
</fieldset>


<div class="clear"></div>
<div id="buttons">
<input type="submit" value="Submit" class="submit">
<input type="button" value="Cancel" class="cancel">
</div>
</form>
</article>
<!-- ë³¸ë¬¸ë´ì© -->
<!-- ë³¸ë¬¸ë¤ì´ê°ë ê³³ -->

<div class="clear"></div>

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>