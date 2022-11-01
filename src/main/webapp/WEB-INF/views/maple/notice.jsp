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
<h1>게시판</h1>
<table id="notice">
<tr><th class="tno">No.</th>
    <th class="twrite">Title</th>
    <th class="twrite">Writer</th>
    <th class="tdate">Date</th>
    <th class="tread">Read</th></tr>
    
<%-- <tr><td>${boardList}</td><td class="left">${boardList[0]}</td> --%>
<%--     <td>${boardList[0].getContent()}</td><td>${boardList[0].getNum()}</td><td>15</td></tr> --%>
 
 
 <c:forEach var="board" items="${boardList }">
 
 <tr>
 	<td>${board.num}</td>

 	<td>
<%--  		<input type="hidden" value="${board.num }" name="num"> --%>
 		<a href="${pageContext.request.contextPath }/board/center/read?num=${board.num}">${board.subject}</a>
 	</td>
 
 	<td>${board.userid}</td>

 	<td>${board.date}</td>

 	<td>${board.readcount}</td>
 	
  </tr>
 
 </c:forEach>
 
 
 
 

</table>
<div id="table_search">

<a href="${pageContext.request.contextPath}/board/center/write" class="btn" >글쓰기</a>

<input type="text" name="search" class="input_box">
<input type="button" value="search" class="btn">


</div>
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
<div class="clear"></div>

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>