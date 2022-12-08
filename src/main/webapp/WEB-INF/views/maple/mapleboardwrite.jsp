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
						<p>메이플스토리 게시판 </p>
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
					<h4 class="comment-title">게시판 작성 </h4>
					
				</div>
				<div class="col-lg-8">
					<div class="contact-form-warp">
						<h4 class="comment-title">글쓰기 </h4>
						<form class="comment-form" action="${pageContext.request.contextPath}/maple/mapleboardwrite" method="post" enctype="multipart/form-data">
							<input type="hidden" value="textID" name="CREA_ID">
							<div class="row">
								<div class="col-md-6">
									<input type="text" placeholder="아이디를 입력하세요. " name="userid">
								</div>
								<div class="col-md-6">
									<input type="text" placeholder="비밀번호 입력하세요. " name="boardpw">
								</div>
								<div class="col-lg-12">
									<input type="text" placeholder="제목을 입력하세요.  " name="subject">
									
									<textarea placeholder="내용을 입력하세요.  " name="content"></textarea>
									
									<div class="form-group" id="file-list">
                						<a href="#this" onclick="addFile()">파일추가</a>
                						<div class="file-group">
                    					<input type="file" name="file"><a href='#this' name='file-delete'>삭제</a>
                					</div>
           							 </div>
									
									<button class="site-btn btn-sm">등록 </button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page section end -->
	<script type="text/javascript">
    $(document).ready(function() {
        $("a[name='file-delete']").on("click", function(e) {
            e.preventDefault();
            deleteFile($(this));
        });
    })
 
    function addFile() {
        var str = "<div class='file-group'><input type='file' name='file'><a href='#this' name='file-delete'>삭제</a></div>";
        $("#file-list").append(str);
        $("a[name='file-delete']").on("click", function(e) {
            e.preventDefault();
            deleteFile($(this));
        });
    }
 
    function deleteFile(obj) {
        obj.parent().remove();
    }
</script>



	
<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->
