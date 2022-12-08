<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    $("a[name='file-delete']").on("click", function(e) {
        e.preventDefault();
        deleteFile($(this));
    });
})

function addFile() {
    var str = "<div class='file-group'><input type='file' name='files' accept='image/*'><a href='#this' name='file-delete'>삭제</a></div>";
    
    var aa = document.getElementsByClassName('file-group').length;
    
    if(aa<4){
	    $("#file-list").append(str);
    }
    
    $("a[name='file-delete']").on("click", function(e) {
        e.preventDefault();
        deleteFile($(this));
    });
}

function deleteFile(obj) {
    obj.parent().remove();
}
</script>

	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">메이플 뉴스</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item">
				
				<!-- 롤 뉴스 for문 -->
				<c:forEach var="list" items="${bgNews}" >
				
					<span class="new">news</span>
					<a style="color: white !important;" href="https://m-lostark.game.onstove.com${list.bgLink}">${list.bgNews}</a> 
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
						<h2>메이플 거래소</h2>
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
	
				<div class="col-lg-8" >
					<div class="contact-form-warp">
						<h4 class="comment-title" style="color: white;">판매글수정</h4>
						<form class="comment-form" 
						action="${PageContext.request.contextPath}/bgTrBoard/trBgModify" method="post" enctype="multipart/form-data">

							<input type="hidden" value="${trBg.num}" name="num">
							
							<div class="row">
								<div class="col-md-6">
									<input type="text" placeholder="상품이름" name="subject" value="${trBg.subject }">
								</div>
								<div class="col-md-6">
									<input type="text" placeholder="상품개수" name="goodsCount" value="${trBg.goodsCount }">
								</div>
								
								<div class="col-md-6">
									<input type="text" placeholder="캐릭터명" name="chname" value="${trBg.chname }">
								</div>
								
								<div class="col-md-6">
									<input type="text" placeholder="판매금액" name="price" value="${trBg.price }">
								</div>
								
								<div class="col-lg-12">
<!-- 									<input type="text" placeholder="판매금액"> -->
									
									<textarea placeholder="상세설명" name="content" >${trBg.content }</textarea>
									
									
									<div class="form-group" id="file-list">
								        <a href="#this" onclick="addFile()">파일추가</a>
							        	<div class="file-group">
							        	<a style="color: white;">* 맨 위 메인이미지</a> <br>
						            		<input type="file" name="files" accept="image/*"><a href='#this' name='file-deleteno' >삭제</a>
						        		</div>
								    </div>
									
									<input type="submit" class="site-btn btn-sm" style="float: right;" value="재등록">
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