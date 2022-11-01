<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }" rel="stylesheet" type="text/css">
</head>

<body>
<div id="wrap">

<jsp:include page="../include/header.jsp"></jsp:include>

<div id="sub_img_center"></div>
<!-- ë©ì¸ì´ë¯¸ì§ -->

<!-- ì¼ìª½ë©ë´ -->
<nav id="sub_menu">
<ul>
<li><a href="#">Notice</a></li>
<li><a href="#">Public News</a></li>
<li><a href="#">Driver Download</a></li>
<li><a href="#">Service Policy</a></li>
</ul>
</nav>
<!-- ì¼ìª½ë©ë´ -->

<!-- ê²ìí -->
<article>
<h1>게시판 작성 </h1>
<form action="${pageContext.request.contextPath}/board/center/write" method="post">
<input type="hidden" value="${membervo.userid}" name="userid">
<table id="notice">

	<tr>
		<th class="ttitle" colspan="5">게시판 작성 </th>
	</tr>

    <tr>
    	<td>제목</td>
        <td><input type="text" size="25" name="subject"> </td>
    </tr>

	<tr>
 		<td>내용</td>
	    <td><textarea rows="15" cols="27" name="content"></textarea> </td>
    </tr>
 
     <tr>
		<td>비밀번호</td>
	    <td><input type="password" size="25" name="boardpw"></td>
    </tr>
 
 
</table>

<div id="table_search">
<input type="submit" value="글쓰기" class="btn">
</div>


</form>






<div class="clear"></div>
<div id="page_control">
<a href="#">Prev</a>
<a href="#">1</a><a href="#">2</a><a href="#">3</a>
<a href="#">4</a><a href="#">5</a><a href="#">6</a>
<a href="#">7</a><a href="#">8</a><a href="#">9</a>
<a href="#">10</a>
<a href="#">Next</a>
</div>
</article>
<!-- ê²ìí -->
<!-- ë³¸ë¬¸ë¤ì´ê°ë ê³³ -->
<div class="clear"></div>

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>