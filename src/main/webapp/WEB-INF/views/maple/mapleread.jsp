<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<section class="page-section spad contact-page">
		<div class="container">
			
			<div class="row">
				<div class="col-lg-4 mb-5 mb-lg-0">
					<h4 class="comment-title">게시판 수정  </h4>
<%-- 				el표현식 사용 ${ } --%>
				</div>
				<div class="col-lg-8">
					<div class="contact-form-warp">
						<h4 class="comment-title">글쓰기 </h4>
						<form class="comment-form" action="${pageContext.request.contextPath}/maple/maplemodify" method="get" >
						<input type="hidden" value="${mapleboard.num }" name="num">
							<div class="row">
								<div class="col-md-6">
									<input type="text" placeholder="아이디를 입력하세요. "  value="${mapleboard.userid }" readOnly>
								</div>
								<div class="col-md-6">
									<input type="text" placeholder="비밀번호 입력하세요. "  value="${mapleboard.boardpw }" readOnly>
								</div>
								<div class="col-lg-12">
									<input type="text" placeholder="제목을 입력하세요.  "  value="${mapleboard.subject }">
									<textarea placeholder="내용을 입력하세요.  "  >${mapleboard.content }</textarea>
									
									<input type="submit" value="수정 " class="site-btn btn-sm">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page section end -->



	
<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->