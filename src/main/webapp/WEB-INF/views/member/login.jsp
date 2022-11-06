<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/resources/css/default.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/subpage.css" rel="stylesheet" type="text/css">
</head>
<body>
<div id="wrap">

<jsp:include page="../include/header.jsp"></jsp:include>

<div id="sub_img_member"></div>
<nav id="sub_menu">
<ul>
<li><a href="#">Join us</a></li>
<li><a href="#">Privacy policy</a></li>
</ul>
</nav>
<article>
<h1>로그인</h1>

<form action="${pageContext.request.contextPath}/board/member/login" id= "join" method="post">
<fieldset>

<legend>로그인 페이지</legend>
<label>User ID</label>
<input type="text" name="userid"><br>
<label>Password</label>
<input type="password" name="userpw"><br>
</fieldset>
<div class="clear"></div>
<div id="buttons">

<input type="submit" value="로그인" class="submit">
<input type="button" value="Cancel" class="cancel">
</div>
</form>
</article>

<div class="clear"></div>
<!-- í¸í°ë¤ì´ê°ë ê³³ -->

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>