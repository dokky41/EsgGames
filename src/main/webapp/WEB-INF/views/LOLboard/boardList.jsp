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
						<h3 class="community-top-title">전체 ${pageMaker.getTotalCount()}</h3>
					</div>
					<div class="col-md-6 text-lg-right">
						<form class="community-filter">
							<a href='<c:url value='/LOLboard/boardWrite'/>' role="button" class="btn btn-outline-info">글쓰기</a>
						</form>
					</div>
				</div>
				<table class="table">
              <tbody>
              <th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th><th>추천수</th>
 						  <c:choose>
                      <c:when test="${fn:length(boardList) > 0 }">
                          <c:forEach items="${boardList }" var="bList">
                              <tr>
                              <th scope="row">${bList.IDX }</th>
                              <td><a href="/LOLboard/boardRead${pageMaker.makeQueryPage(bList.IDX, pageMaker.cri.page) }" class="text-dark">${bList.TITLE }</a></td>
                              <td>${bList.CREA_ID }</td>
                              <td><fmt:formatDate value="${bList.CREA_DATE }" pattern="yyyy-MM-dd hh-mm" /></td>
                              <td>${bList.HIT_CNT }</td>
							  <td><a href="/LOLboard/boardRecommend${pageMaker.makeQueryPage(bList.IDX, pageMaker.cri.page) }" class="text-dark">${bList.RECOMMEND }</a></td>
                            </tr>
                          </c:forEach>
                      </c:when>
                      <c:otherwise>
                          <tr>
                              <td colspan="5">조회된 결과가 없습니다.</td>
                          </tr>
                      </c:otherwise>
                  </c:choose> 
              </tbody>
            </table>
            <ul class="pagination">
  <c:if test="${pageMaker.prev }">
  <li class="page-item">
      <a class="page-link" href='<c:url value="/LOLboard/boardList${pageMaker.makeQueryPage(pageMaker.startPage-1) }"/>'><i class="fa fa-chevron-left"></i></a>
  </li>
  </c:if>
  <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
  <li class="page-item <c:if test='${pageMaker.cri.page eq pageNum }'>active</c:if>">
      <a class="page-link" href='<c:url value="/LOLboard/boardList${pageMaker.makeQueryPage(pageNum) }"/>'>${pageNum }</a>
  </li>
  </c:forEach>
  <c:if test="${pageMaker.next && pageMaker.endPage >0 }">
  <li class="page-item">
      <a class="page-link" href='<c:url value="/LOLboard/boardList${pageMaker.makeQueryPage(pageMaker.endPage+1) }"/>'><i class="fa fa-chevron-right"></i></a>
  </li>
  </c:if>
</ul>
</div>

		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->