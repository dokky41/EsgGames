<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 헤더부분 -->
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->


	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">Maple ISSUE</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item"><span class="new">HOT</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </div>
				<div class="nt-item"><span class="strategy">NOTICE</span>Isum dolor sit amet, consectetur adipiscing elit. </div>
				<div class="nt-item"><span class="racing">EVENT</span>Isum dolor sit amet, consectetur adipiscing elit. </div>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->


	<!-- Page info section -->
	<section class="page-info-section set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/maple/1.jpeg">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
						<h2>MapleStory</h2>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec malesuada lorem maximus mauris scelerisque, at rutrum nulla dictum.</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page info section -->


	<!-- Page section -->
	<section class="page-section community-page set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/maple/2.jpg">
		<div class="community-warp spad">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h3 class="community-top-title">COMMUNITY </h3>
					</div>
					<div class="col-md-6 text-lg-right">
						<form class="community-filter" action ="${pageContext.request.contextPath}/maple/contact" method="get">
							<label for="fdf5"><input type="submit" value="글쓰기" class="btn"></label>
							<select id="fdf5">
								<option value="#">All</option>
								<option value="#">Everything</option>
							</select>
						</form>
					</div>
				</div>
				<ul class="community-post-list">
				
				<c:forEach var="list" items="${maplelist}">
				
				
				
					<li>
						<div class="community-post">
							<div class="author-avator set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/authors/7.jpg"></div>
							<div class="post-content">
								<h5>${list.userid}<span>${list.subject}</span></h5>
								<div class="post-date">June 21, 2018</div>
								<p>Lorem ipsum dolor sit amet, cdictum nisl onsectetur adipisc ing ipsum dolor sit ame. Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit ame.Donec venenatis at eros sit amet aliquam. Donec vel orci efficitur, dictum nisl vitae, scelerisque nibh. Curabitur eget ipsum pulvinar nunc gravida interdum. </p>
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