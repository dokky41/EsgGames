<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="row">
<div class="col-md-4 col-md-offset col-sm-6 col-sm-offset-3">
<div class="form-box">
<div class="form-header">
<h2>
<b>
<i class="fa fa-smile-o"></i>
"Have a Nice Day!"
</b>
</h2>
</div>
<div class="form-body">
<form class="form" role="form" action="${pageContext.request.contextPath}/member/login" id= "join" method="post">

<div class="form-group has-feedback">
<label for="login_id">
<b>아이디</b>
</label>
<input type="text" title="아이디 입력" maxlength="20" id="userid" name="userid" class="inputidpw" placeholder="아이디">
<span class="fa fa-user form-control-feedback">
</span>
</div>

</form>

</div>

<div id="loginWrap" class="loginWrap">
				<div class="loginUserInfo">
					<p class="idWrap">
						
					</p>
					<p class="pwWrap">
						<input type="password" title="비밀번호 입력" value="" id="userpw" name="userpw" class="inputidpw" placeholder="비밀번호">
					</p>
					<div id="notice" role="tooltip"></div>
					<input type="hidden" value="68597a4f6ca586b0ba5f9cfecb80d4" id="stoken" name="stoken">
                                        <input type="hidden" value="" id="comm" name="comm">
                                        <input type="hidden" value="" id="sid" name="sid">
					<p id="content"><button id="loginBtn" class="btn btn-primary btn-large" type="submit"><span><i class="fa fa-sign-in"></i> 로그인</span></button></p>
				</div>
				<div class="saveid">
					<div class="btn-group">
					<label class="txt btn btn-info"><input id="save_login" class="saveLogin" name="save_login" type="checkbox"> <i class="icon-user icon-white"></i>
					로그인 상태 유지</label>
					<label class="txt btn btn-info"><input id="save_id" class="saveId" name="save_id" type="checkbox"> <i class="icon-user icon-white"></i>
					아이디 저장</label>
					</div>
				</div>

			</div>
		
		</div>
		</div>
		</div>


<div class="clear"></div>
<!-- í¸í°ë¤ì´ê°ë ê³³ -->

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>