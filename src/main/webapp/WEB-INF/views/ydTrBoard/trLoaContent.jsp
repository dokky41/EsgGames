<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script type="text/javascript">

$(document).ready(function(){
 		
	var formObj = $('form[role="form"]');

		$('#loadelete').click(function(){
			
			 if (!confirm("정말로 삭제 하시겠습니까?")) {
			        // 취소(아니오) 버튼 클릭 시 이벤트
			       
				 formObj.attr("onsubmit","return false");
				 
			    } else {
			        // 확인(예) 버튼 클릭 시 이벤트
			    	formObj.attr("action","/ydTrBoard/trLoadelete?num=${trLoa.num}");
					
					formObj.attr("method","post");
					
					formObj.submit();
			    }
			
			
		});
	
});




</script>
<!-- 헤더부분 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/yd/contentModel.css"/>
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->


	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">로아 뉴스</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item">
				
				<!-- 로아뉴스 for문 -->
				<c:forEach var="list" items="${LoaNews}" >
				
					<span class="new">news</span>
					<a style="color: white !important;" 
						href="https://m-lostark.game.onstove.com${list.RoaLink}">
					${list.RoaNews}
					</a> 
					&nbsp; &nbsp;&nbsp;
				
				</c:forEach>
				<!-- 로아뉴스 for문 -->
				
				</div>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->


	<!-- Page info section -->
	<section class="page-info-section set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/sliderlostark.jpg">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
						<h2>로아 거래소</h2>
						<p> &nbsp; 게임머니 및 아이템 거래</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page info section -->


	<!-- Page section -->
	<section class="page-section spad contact-page" style="padding-bottom: 0px;">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 mb-5 mb-lg-0">
					
					
					
					<div class="row">
						<div class="col-md-9">
							<ul class="contact-info-list" style="padding-top: 0px;">
							
							
							
					<c:if test="${trLoa.file1 != null}">
					<img src="http://localhost:8088/tomcatImg/${trLoa.file1 }" class="img" width="300px" height="150px" >
					</c:if>
					<c:if test="${trLoa.file1 == null}">
					<img src="${pageContext.request.contextPath }/resources/img/yd/noimg.jpg" class="img" width="300px" height="150px">
					</c:if>
					
					<div class="modal">
  						<span class="close">&times;</span>
						  <img class="modal_content">
					</div>
					
							<br><br>
								<li><div class="cf-left">상품이름</div><div class="cf-right">${trLoa.subject}</div></li>
<%-- 								<li><div class="cf-left">내용</div><div class="cf-right">${trLoa.content}</div></li> --%>
								<li><div class="cf-left">가격</div><div class="cf-right">${trLoa.price}원</div></li>
								<li><div class="cf-left">개수</div><div class="cf-right">${trLoa.goodsCount}</div></li>
								<li><div class="cf-left">작성자</div><div class="cf-right">${trLoa.userid}</div></li>
								<li><div class="cf-left">거래번호</div><div class="cf-right">#${trLoa.num}</div></li>
								<li><div class="cf-left">등록일</div><div class="cf-right">#${trLoa.date}</div></li>
							</ul>
	
							<br><br><br><br><br>
							
							<h4 style="margin-top: 8px; ">상세내용</h4>
							<br>
							<table border="1" width="200" height="100">
							<tr><textarea rows="17" cols="42" readonly="readonly" style="resize: none;">${trLoa.content}</textarea></tr>
							
							</table>
															
						</div>
					</div>
					
				</div>
				
				
				
				<div class="col-lg-8">
					<div class="contact-form-warp">
						<h4 class="comment-title">요청사항  <button class="site-btn btn-sm" style="float: right;"
									onclick="location.href='/ydTrBoard/trLostArk?sort=def' ;return false;">
									목록</button></h4>
						 
						
									
						<form class="comment-form" role="form">
							<div class="row">
								<div class="col-md-6">
									<input type="text" placeholder="닉네임" name="name">
								</div>
								<div class="col-md-6">
									<input type="text" placeholder="물품개수">
								</div>
								<div class="col-lg-12">
									<input type="text" placeholder="제목">
									<textarea placeholder="내용"></textarea>
									
									<button class="site-btn btn-sm">구매신청</button>
									
									</form>
									
									
								<c:if test="${trLoa.userid==membervo.userid || membervo.userid == 'admin' }">
								
								<button class="site-btn btn-sm" id="loadelete" onclick="javascript:loadelete()" style="float: right;">
									삭제</button>
								
								
									<button class="site-btn btn-sm"
									onclick="location.href='/ydTrBoard/trLostModify?num=${trLoa.num}&sort=def'; 
									return false;" style="float: right;">수정</button>
									
									
									
								</c:if>
									
									
									
								</div>
							</div>
						
					</div>
					
	<!-- 상세내용 -->
	<br> <br> <br> <br> 
	  <h4>물품사진</h4>
	<br>
	<!-- 사진들 4개 -->
	<!-- 사진들 4개 -->
	<div class="social-links">
					<c:if test="${trLoa.file1 != null}">
					<img src="http://localhost:8088/tomcatImg/${trLoa.file1 }" class="img" style="width: 300px; height: 200px;" onclick="window.open(this.src)">
					</c:if>
					<c:if test="${trLoa.file1 == null}">
					<img src="${pageContext.request.contextPath }/resources/img/yd/noimg.jpg" class="img" style="width: 360px; height: 200px">
					</c:if>
	
					<c:if test="${trLoa.file2 != null}">
					<img src="http://localhost:8088/tomcatImg/${trLoa.file2 }" class="img" style="width: 300px; height: 200px;" onclick="window.open(this.src)">
					</c:if>
					<c:if test="${trLoa.file2 == null}">
					<img src="${pageContext.request.contextPath }/resources/img/yd/noimg.jpg" class="img" style="width: 360px; height: 200px">
					</c:if>
					
					<c:if test="${trLoa.file3 != null}">
					<img src="http://localhost:8088/tomcatImg/${trLoa.file3 }" class="img" style="width: 300px; height: 200px;" onclick="window.open(this.src)">
					</c:if>
					<c:if test="${trLoa.file3 == null}">
					<img src="${pageContext.request.contextPath }/resources/img/yd/noimg.jpg" class="img" style="width: 360px; height: 200px">
					</c:if>
					
					<c:if test="${trLoa.file4 != null}">
					<img src="http://localhost:8088/tomcatImg/${trLoa.file4 }" class="img" style="width: 300px; height: 200px;" onclick="window.open(this.src)">
					</c:if>
					<c:if test="${trLoa.file4 == null}">
					<img src="${pageContext.request.contextPath }/resources/img/yd/noimg.jpg" class="img" style="width: 360px; height: 200px">
					</c:if>
	</div>
	
<!-- 상세내용 -->
					<br>
				</div>
				
			</div>
			
		</div>
		
		
		
		
	</section>
	<!-- Page section end -->

	<!-- 댓글 -->

	<!-- 댓글 -->
	
<!-- 푸터부분 -->
<script src="${pageContext.request.contextPath }/resources/js/yd/contentModel.js"></script>
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->