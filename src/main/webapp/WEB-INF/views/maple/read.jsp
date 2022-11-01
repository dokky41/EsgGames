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
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		// 목록 버튼 클릭시
		$('.list').click(function(){
			alert(' 목록 버튼 클릭! ');
			location.href='/board/center/notice';
		});
		
		// 폼태그(객체) 정보
		var formObj = $('form[role="form"]');
		//alert(formObj);
		console.log(formObj);
		
		
		// 수정 버튼 클릭시 => 폼태그(num) 사용해서 페이지 이동
		$('.modify').click(function(){
			alert(' 수정 버튼 클릭 ! ');
			
			// 폼태그 정보 => submit()
			// 주소 (/board/modify)
			formObj.attr("action","/board/center/modify");
			// GET방식
			formObj.attr("method","get");
			
			formObj.submit();			
		});
		
		//삭제 버튼
		$('.delete').click(function(){
			
			alert(' 삭제 버튼 클릭! ');
			
			formObj.attr("action","/board/center/delete?num=${vo.num}");
			
			formObj.attr("method","post");
			
			formObj.submit();
			
		});
		
		
		
	}); //jquery
	
</script>

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

<form action="" role="form">
<input type="hidden" value="${vo.num }" name="num">				
</form>	

<table id="notice">

	<tr>
		<th class="ttitle" colspan="5">게시판 본문내용 </th>
	</tr>

    <tr>
    	<td>글번호</td>
        <td>${vo.num }</td>
    
    	<td>조회수</td>
        <td>${vo.readcount }</td>
    </tr>
    
    <tr>
    	<td>글쓴이</td>
        <td>${vo.userid }</td>
    	<td>작성일</td>
    	<td>
    		<fmt:formatDate value="${vo.date }" pattern="yy-MM-dd"/>
    	</td>
    </tr>
 
 	<tr>
 		<td>제목</td>
 			<td colspan="4">${vo.subject }</td>
 	</tr>
 
 	<tr>
 		<td>내용</td>
 			<td colspan="4">${vo.content} </td>
 	</tr>
 
 
</table>



<div id="table_search">

<c:if test="${vo.userid==membervo.userid || membervo.userid == 'admin' }">
	<button type="submit" class="modify">수정</button>
	<button type="submit" class="delete">삭제</button>
</c:if>
						
	<button type="submit" class="list">목록</button>
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
<!-- ê²ìí -->
<!-- ë³¸ë¬¸ë¤ì´ê°ë ê³³ -->
<div class="clear"></div>

<jsp:include page="../include/footer.jsp"></jsp:include>

</div>
</body>
</html>