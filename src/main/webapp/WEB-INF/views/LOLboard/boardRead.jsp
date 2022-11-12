<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<section class="page-info-section set-bg" data-setbg="https://talk.op.gg/images/game/bg_lol.jpg">
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
						<h3 class="community-top-title">게시판 상세정보</h3>
					</div>
				</div>
				
				<div class="container col-md-6">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title mb-3">${vo.TITLE }</h4>
            <h6 class="card-subtitle text-muted mb-4">
                <i class="far fa-user"></i> ${vo.CREA_ID }
                ·
                <i class="far fa-clock"></i> ${vo.CREA_DATE }
                ·
                <i class="fas fa-align-justify"></i> ${vo.HIT_CNT }
            </h6>
            <p class="card-text">${vo.CONTENTS }</p>
            
            <c:choose>
    <c:when test="${fn:length(file) > 0 }">
    <div class="blog-file">
        <ul>
        <c:forEach items="${file }" var="file">
            <li> 
                <span class="file-img"></span>
                <div class="file-info">
                    <a href='#'><i class="fa fa-camera"></i>${file.ORG_FILE_NAME }</a>
                    <span>${file.FILE_SIZE }kb</span>
                </div>
                <img src="http://localhost:8088/tomcatImg/${file.SAVE_FILE_NAME}">
            </li>
        </c:forEach>
        </ul>
    </div>
    </c:when>
</c:choose>
        </div>
        <div class="card-body">
            <a href='<c:url value='/LOLboard/boardUpdate?IDX=${vo.IDX }'/>' class="btn btn-outline-secondary btn-sm" role="button">수정</a>
            <a href='<c:url value='/LOLboard/boardDelete?IDX=${vo.IDX }'/>'  class="btn btn-outline-secondary btn-sm " role="button">삭제</a>
        </div>
        <div class="card-body">
            <a href='<c:url value='/LOLboard/boardList'/>' class="btn btn-info" role="button">목록으로</a>
        </div>
    </div>
</div>


					
			</div>
		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->