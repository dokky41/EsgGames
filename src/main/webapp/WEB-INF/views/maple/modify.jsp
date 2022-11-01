<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<h1>게시판 수정</h1>
<form action="" role="form" method="post">

<input type="hidden" value="${uvo.num}" name="num">

<table id="notice">

	<tr>
		<th class="ttitle" colspan="5">게시판 수정 </th>
	</tr>

    <tr>
    	<td>글번호 </td>
        <td>${uvo.num} </td>
    

 		<td>조회수 </td>
	    <td>${uvo.readcount}</td>
    </tr>
 
     <tr>
		<td>글쓴이 </td>
	    <td>${uvo.userid}</td>
	    
	    <td>작성일 </td>
	    <td>
	    	<fmt:formatDate value="${uvo.date}" pattern="yy-MM-dd"/>
	    </td>
    </tr>
    
    <tr>
    	<td>제목 </td>
    	<td colspan="4">
    	<input type="text" name="subject" value="${uvo.subject}">
    	</td>
    </tr>
    
    <tr>
    	<td>내용 </td>
    	<td colspan="4">
    	<input type="text" name="content" value="${uvo.content}">
    	</td>
    </tr>
 
 
</table>

<div id="table_search">

	<button type="submit" class="modify">수정 </button>
	
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