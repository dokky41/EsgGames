<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 헤더부분 -->
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
					<a style="color: white !important;" href="https://m-lostark.game.onstove.com${list.RoaLink}">${list.RoaNews}</a> 
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
					<div class="col-md-6">
						<h3 class="community-top-title">All List(344)</h3>
					</div>
					<div class="col-md-6 text-lg-right">
					
						<form class="community-filter"
						 action="${PageContext.request.contextPath}/ydTrBoard/trLostWrite" method="get">
							
							<label for="fdf5">
							<input type="submit" value="판매등록">
							</label>
							
							<select id="fdf5">
								<option value="#">최신순</option>
								<option value="#">인기순</option>
								<option value="#">조회순</option>
								<option value="#">댓글순</option>
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
								<h5>${list.userid}<span>${list.date}</span></h5>
								<div class="post-date">${list.subject }</div>
								<p>
								${list.content }
								
								</p>
							</div>
						</div>
					</li>
						 
					
					</c:forEach>
					
					
				</ul>
				
				
				<div class="site-pagination sp-style-2">
					<span class="active">01.</span>
					<a href="#">02.</a>
					<a href="#">03.</a>
				</div>
			</div>
		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->