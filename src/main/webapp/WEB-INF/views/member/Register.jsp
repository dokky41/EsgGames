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
<ul>
<li><a href="#">Join us</a></li>
<li><a href="#">Privacy policy</a></li>
</ul>
</nav>
<!-- ì¼ìª½ë©ë´ -->
<!-- ë³¸ë¬¸ë´ì© -->
<article>

<h1>Register</h1>
<form action="${pageContext.request.contextPath}/board/member/insertMember" id="join" method="post">
<fieldset>
<legend>회원가입</legend>
<label>User ID</label>
<input type="text" name="userid" class="id" id="userid" oninput="checkId()">

<span class="id_ok" style="display: none;">사용 가능한 아이디입니다.</span>
<span class="id_already" style="display: none;">이미 사용중인 아이디입니다.</span>


<input type="button" value="dup. check" class="dup"><br>
<label>Password</label>
<input type="password" name="userpw"><br>

<label>Name</label>
<input type="text" name="username"><br>
<label>E-Mail</label>
<input type="email" name="useremail"><br>

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