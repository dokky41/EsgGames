<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
	<section class="page-info-section set-bg" data-setbg="${pageContext.request.contextPath}/resources/img/로아배경.png">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
						<h2>로스트아크</h2>
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
                ·
                <a href="/LOAboard/boardRecommend${pageMaker.makeQueryPage(vo.IDX, pageMaker.cri.page) }" class="btn btn-outline-secondary btn-sm">추천 : ${vo.RECOMMEND }</a>
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
            <a href='<c:url value='/LOAboard/boardUpdate${pageMaker.makeQueryPage(vo.IDX, page) }'/>' class="btn btn-outline-secondary btn-sm" role="button">수정</a>
            <a href='<c:url value='/LOAboard/boardDelete${pageMaker.makeQueryPage(vo.IDX, page) }'/>'  class="btn btn-outline-secondary btn-sm " role="button">삭제</a>
        </div>
        <div class="card-body">
            <a href='<c:url value='/LOAboard/boardList${pageMaker.makeQueryPage(page)}&searchType=${cri.searchType}&keyword=${cri.keyword}'/>' class="btn btn-info" role="button">목록으로</a>
        </div>
        
<!-- 댓글 조회 -->
<div class="card-body">
<div id="reply">
  <ol class="replyList">
  
    <c:forEach items="${reply}" var="reply">
    <c:if test="${reply.PARENT eq 0}">
      <li class="col-md-12">
        <p>
        작성자 : ${reply.WRITER}
         <a href="/LOAreply/replyRecommend${pageMaker.makeQueryPage(reply.IDX, pageMaker.cri.page) }&RNO=${reply.RNO}" class="btn btn-outline-secondary btn-sm float-right">추천 : ${reply.RECOMMEND }</a>
        <br />
        작성 날짜 :  <fmt:formatDate value="${reply.REGDATE}" pattern="yyyy-MM-dd hh-mm" />
        </p>

        <p>${reply.CONTENT}</p>
        <p>
        	<a href="../LOAreply/RreplyWrite${pageMaker.makeQueryPage(vo.IDX, page) }&RNO=${reply.RNO}" class="btn btn-outline-secondary btn-sm" role="button">답글</a>
		  	<a href="../LOAreply/replyUpdate${pageMaker.makeQueryPage(vo.IDX, page) }&RNO=${reply.RNO}" class="btn btn-outline-secondary btn-sm" role="button">수정</a>
  			<a href="../LOAreply/replyDelete${pageMaker.makeQueryPage(vo.IDX, page) }&RNO=${reply.RNO}" class="btn btn-outline-secondary btn-sm" role="button">삭제</a>
		</p>
		<hr>
	</li>
	</c:if>
	
	
    <c:forEach items="${qreply}" var="qreply">
	 <c:if test="${reply.RNO eq qreply.PARENT}">
	 <div class="row">
	 <div class="col-md-1"></div>
	 <ul class="col-md-11">
      <li>
        <p>
        RE : 작성자 : ${qreply.WRITER}
        <br />
        작성 날짜 :  <fmt:formatDate value="${qreply.REGDATE}" pattern="yyyy-MM-dd hh-mm" />
        </p>

        <p>${qreply.CONTENT}</p>
        <p>
		  	<a href="../LOAreply/replyUpdate${pageMaker.makeQueryPage(vo.IDX, page) }&RNO=${qreply.RNO}" class="btn btn-outline-secondary btn-sm" role="button">수정</a>
  			<a href="../LOAreply/replyDelete${pageMaker.makeQueryPage(vo.IDX, page) }&RNO=${qreply.RNO}" class="btn btn-outline-secondary btn-sm" role="button">삭제</a>
		</p>
		<hr>
	</li>
	</ul>
	</div>
	 </c:if>
	 </c:forEach>
	 
    </c:forEach>
       
  </ol>
</div>
</div>
<!-- 댓글 작성 -->
<div class="card-body">

	<form name="replyForm" method="post" action="../LOAreply/replyWrite">
  <input type="hidden" id="IDX" name="IDX" value="${vo.IDX}" />
  <input type="hidden" id="page" name="page" value="${pageMaker.cri.page}"> 
  <input type="hidden" id="perPageNum" name="perPageNum" value="${pageMaker.cri.perPageNum}">
  <input type="hidden" id="searchType" name="searchType" value="${cri.searchType}"> 
  <input type="hidden" id="keyword" name="keyword" value="${cri.keyword}"> 
  <div>
    <label for="writer">댓글 작성자</label><input type="text" id="WRITER" name="WRITER" />
    <br/>
    <label for="content">댓글 내용</label><input type="text" id="CONTENT" name="CONTENT" />
  </div>
  <div>
 	 <button type="submit" class="replyWriteBtn">작성</button>
  </div>
</form>
	
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