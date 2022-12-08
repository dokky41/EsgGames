<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 헤더부분 -->
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->

	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">BattleGrounds ISSUE</div>
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
	<section class="page-info-section set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/battlegrounds/1.jpeg">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
					
						<h2>BattleGrounds</h2>
						<p>배틀그라운드 게시판 </p>
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
						<form class="comment-form" action="${pageContext.request.contextPath}/battlegrounds/BGmodify" method="get" >
						<input type="hidden" value="${BGboard.num }" name="num">
							<div class="row">
								<div class="col-md-6">
									<input type="text" placeholder="아이디를 입력하세요. "  value="${BGboard.userid }" readOnly>
								</div>
								<div class="col-md-6">
									<input type="text" placeholder="비밀번호 입력하세요. "  value="${BGboard.boardpw }" readOnly>
								</div>
								<div class="col-lg-12">
									<input type="text" placeholder="제목을 입력하세요.  "  value="${BGboard.subject }">
									<textarea placeholder="내용을 입력하세요.  "  >${BGboard.content }</textarea>
									
									<input type="submit" value="수정 " class="site-btn btn-sm">
									<input type="button" value="삭제 " class="site-btn btn-sm" 
									onclick="location.href='/battlegrounds/BGdelete?num=${BGboard.num}'">
								</div>
							</div>
						</form>
					</div>
					<c:forEach items="${file }" var="file">
					
					
						<img src="http://localhost:8088/tomcatImg/${file.SAVE_FILE_NAME}" width="" height="20%">
					
					</c:forEach>
				</div> 
			</div>
		</div>
	</section>
	<!-- Page section end -->



	
<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->