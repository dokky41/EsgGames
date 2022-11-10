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
						<h3 class="community-top-title">전체</h3>
					</div>
					<div class="col-md-6 text-lg-right">
						<form class="community-filter">
							<a href='<c:url value='/LOLboard/boardWrite'/>' role="button" class="btn btn-outline-info">글쓰기</a>
						</form>
					</div>
				</div>
				<table class="table">
              <tbody>
              <th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
 						  <c:choose>
                      <c:when test="${fn:length(boardList) > 0 }">
                          <c:forEach items="${boardList }" var="bList">
                              <tr>
                              <th scope="row">${bList.IDX }</th>
                              <td><a href="/LOLboard/boardRead?IDX=${bList.IDX}" class="text-dark">${bList.TITLE }</a></td>
                              <td>${bList.CREA_ID }</td>
                              <td>${bList.CREA_DATE }</td>
                              <td>${bList.HIT_CNT }</td>
                            </tr>
                          </c:forEach>
                      </c:when>
                      <c:otherwise>
                          <tr>
                              <td colspan="5">조회된 결과가 없습니다.</td>
                          </tr>
                      </c:otherwise>
                  </c:choose>
                  
                  
                  
                <tr class="btn-group pagination">
    <c:if test="${pageMaker.prev }">
    <li>
        <a href='<c:url value="/LOLboard/boardRead?page=${pageMaker.startPage-1 }"/>'><i class="fa fa-chevron-left"></i></a>
    </li>
    </c:if>
    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
    <li>
        <a href='<c:url value="/LOLboard/boardRead?page=${pageNum }"/>'><i class="fa">${pageNum }</i></a>
    </li>
    </c:forEach>
    <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
    <li>
        <a href='<c:url value="/LOLboard/boardRead?page=${pageMaker.endPage+1 }"/>'><i class="fa fa-chevron-right"></i></a>
    </li>
    </c:if>
</tr>
                
                
                
              </tbody>
            </table>
			</div>

		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->