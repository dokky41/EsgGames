<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<!-- 헤더부분 -->
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->
<script>

if("${membervo.userid}"=='')
{
alert('로그인이 필요합니다');
location.href="${pageContext.request.contextPath}/member/login";
}


$(document).ready(function() {
	$('.fbutton').click(function(){
		$('#containera').prepend('<input type="file" name="files"  accept="image/*">');
	});
	
});
</script>

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
				<ul class="community-post-list">
					
					<li>
						<!-- Page section -->
	<section class="page-section spad contact-page" style="padding-top: 10px">
	
				<div class="col-lg-8" style="margin: auto;">
					<div class="contact-form-warp">
						<form class="comment-form" 
						action="${PageContext.request.contextPath}/ydTrBoard/trLoaWrite" method="post" enctype="multipart/form-data">
						<h4 class="comment-title" style="color: white;">판매등록 <input type="submit" class="site-btn btn-sm" style="float: right;" value="등록"></h4>
						
							
							<input type="hidden" value="${membervo.userid}" name="userid">
							
							<div class="row">
								<div class="col-md-6">
								
									<input type="text" placeholder="상품이름" name="subject">
								</div>
								<div class="col-md-6">
									<input type="text" placeholder="상품개수" name="goodsCount">
								</div>
								
								<div class="col-md-6">
									<input type="text" placeholder="캐릭터명" name="chname">
								</div>
								
								<div class="col-md-6">
									<input type="text" placeholder="판매금액" name="price">
								</div>
								
								<div class="col-lg-12">
<!-- 									<input type="text" placeholder="판매금액"> -->
									
									<textarea placeholder="상세설명" name="content"></textarea>
								
								<div class="filebox">
								<div id="containera">
									 <label for="ex_filename" style="color: white;">업로드</label> 
									<input type='file' name='files'  id="ex_filename" accept='image/*'>
								</div>
								
									<input type='button' value="사진추가" class="fbutton">
								
								</div>
								</div>
								
								
								
							</div>
						</form>
					</div>
				</div>
			
	</section>
	<!-- Page section end -->
					</li>
				</ul>
			</div>
		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->