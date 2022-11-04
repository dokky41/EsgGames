<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 헤더부분 -->
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->


	<!-- Latest news section -->
	<div class="latest-news-section">
		<a href="https://m-lostark.game.onstove.com/News/Notice/List" target='_blank'>
		<div class="ln-title">
		로아 뉴스
		</div>
		</a>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item">
				
				<!-- 로아뉴스 for문 -->
				<c:forEach var="list" items="${LoaNews}" >
				
					<span class="new">news</span>
					<a style="color: white !important;" 
					href="https://m-lostark.game.onstove.com${list.RoaLink}"  target='_blank'>${list.RoaNews}</a> 
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
	<section class="page-section community-page set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/community-bg.jpg">
		<div class="community-warp spad">
			<div class="container">
				<div class="row">
					<div class="col-md-6" >
						<h3 class="community-top-title" >
						<a style="color: red;" href="${PageContext.request.contextPath}/ydTrBoard/trLostArk">
						All List ( ${ listSize} )
						</a></h3>
					</div>
					<div class="col-md-6 text-lg-right">
					
		<form class="community-filter" action="${PageContext.request.contextPath}/ydTrBoard/trLostWrite" method="get">
							<label for="fdf5">
							<input type="submit" value="판매등록" style="height: 43px;">
							</label>
							
							<select id="fdf5">
								<option value="#">게임머니</option>
								<option value="#">아이템</option>
								<option value="#">기타</option>
							</select>
							
							</form>
				
							
						
					</div>
				</div>
				
				<ul class="community-post-list">
					
					<c:forEach var="list" items="${trLoaList}">
						
					<li>
						<div class="community-post">
							<div class="author-avator set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/authors/1.jpg"></div>
							<div class="post-content">
								<h5>판매자 : ${list.userid}<span>날짜 : ${list.date}</span> &nbsp;&nbsp;&nbsp;<span>가격 : ${list.price }p</span> </h5> 
								<div class="post-date" style="text-overflow: ellipsis;">
								<a href="${pageContext.request.contextPath }/ydTrBoard/trLoaContent?num=${list.num}" >
								<h4 style="color: white;">제품명 : ${list.subject }</h4>
								</a></div>
								<p>
								내용 : ${list.content }
								</p>
							</div>
						</div>
					</li>
						 
					
					</c:forEach>
					
					
				</ul>
				
				<form class="community-filter"
						 action="${PageContext.request.contextPath}/ydTrBoard/trLostArk" method="post">
				
				<input type="submit" value="전체" style="float: left;">
				<input type="submit" value="검색" style="float: right;">
				<input type="text" name="searchName" style="float: right;">
				
				</form>
				
				<div class="site-pagination sp-style-2" style="padding-left: 45% !important;">
					
<!-- 			<span class="active">01.</span> -->
					
					<c:if test="${pm.prev }">
				<a href="trLostArk?page=${pm.startPage - 1 }">&laquo;</a>
			</c:if>
			
			<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
				
					<a href="trLostArk?page=${idx }">${idx }</a>
			</c:forEach>			
			
			<c:if test="${pm.next && pm.endPage >0 }">
				<a href="trLostArk?page=${pm.endPage + 1 }">&raquo;</a>
			</c:if>
					
					
				</div>
				
			
				
				
				
			</div>
		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->