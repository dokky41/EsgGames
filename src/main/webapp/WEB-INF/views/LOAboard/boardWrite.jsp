<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 헤더부분 -->
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->

	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">Latest News</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item"><span class="new">new</span>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </div>
				<div class="nt-item"><span class="strategy">strategy</span>Isum dolor sit amet, consectetur adipiscing elit. </div>
				<div class="nt-item"><span class="racing">racing</span>Isum dolor sit amet, consectetur adipiscing elit. </div>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->


	<!-- Page info section -->
	<section class="page-info-section set-bg" data-setbg="https://talk.op.gg/images/game/bg_LOA.jpg">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
						<h2>리그오브레전드</h2>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page info section -->


	<!-- Page section -->
	<section class="page-section community-page set-bg">
		<div class="community-warp spad">
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h3 class="community-top-title">게시판 글쓰기</h3>
					</div>
				</div>
				
		<form action='<c:url value='/LOAboard/boardWrite'/>' method="post" enctype="multipart/form-data">
        	<div class="form-group">
            	<label for="exampleFormControlInput1">제목</label>
            	<input type="text" class="form-control" id="exampleFormControlInput1" name="TITLE" placeholder="제목을 작성해주세요.">
			</div>
        	<div class="form-group">
            	<label for="exampleFormControlInput1">작성자</label>
            	<input type="text" class="form-control" id="exampleFormControlInput1" name="CREA_ID" placeholder="이름을 적어주세요.">
          	</div>
          	<div class="form-group">
	            <label for="exampleFormControlTextarea1">내용</label>
            	<textarea class="form-control" id="exampleFormControlTextarea1" name="CONTENTS" rows="10"></textarea>
          	</div>
          
          	<div class="form-group" id="file-list">
		        <a href="#this" onclick="addFile()">파일추가</a>
	        	<div class="file-group">
            		<input type="file" name="file"><a href='#this' name='file-delete'>삭제</a>
        		</div>
		    </div>
    
        	<button type="submit" class="btn btn-info">등록하기</button>
       	 	<button type="button" class="btn btn-secondary" onclick="location.href='boardList' ">목록으로</button>
    	</form>
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
    
			</div>
		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->