<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 헤더부분 -->
<jsp:include page="../include/header.jsp"/>
<script>
const selectElement = document.querySelector('.sort');

selectElement.addEventListener('change', (event) => {
  const result = document.querySelector('.result');
  result.textContent = `You like ${event.target.value}`;
});
</script>
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
              <tr><th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th><th>추천수</th></tr>
 						  <c:choose>
                      <c:when test="${fn:length(boardList) > 0 }">
                          <c:forEach items="${boardList }" var="bList">
                              <tr>
                              <td scope="row">${bList.IDX }</td>
                              <td><a href="/LOLboard/boardRead${pageMaker.makeQueryPage(bList.IDX, pageMaker.cri.page) }&searchType=${cri.searchType}&keyword=${cri.keyword}" class="text-dark">${bList.TITLE }</a></td>
                              <td>${bList.CREA_ID }</td>
                              <td><fmt:formatDate value="${bList.CREA_DATE }" pattern="yyyy-MM-dd hh-mm" /></td>
                              <td>${bList.HIT_CNT }</td>
							  <td>${bList.RECOMMEND }</td>
                            </tr>
                          </c:forEach>
                      </c:when>
                      <c:otherwise>
                          <tr>
                              <td colspan="6">조회된 결과가 없습니다.</td>
                          </tr>
                      </c:otherwise>
                  </c:choose> 
              </tbody>
            </table>

  
            <div class="row">
            	<div class="col-md-4">
            		<ul class="pagination">
  						<c:if test="${pageMaker.prev }">
  							<li class="page-item">
   								<a class="page-link" href='<c:url value="/LOLboard/boardList${pageMaker.makeSearch(pageMaker.startPage-1) }"/>'><i class="fa fa-chevron-left"></i></a>
 							 </li>
  						</c:if>
  						<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="pageNum">
 							<li class="page-item <c:if test='${pageMaker.cri.page eq pageNum }'>active</c:if>">
								<a class="page-link" href='<c:url value="/LOLboard/boardList${pageMaker.makeSearch(pageNum) }"/>'>${pageNum }</a>
 							</li>
						</c:forEach>
 						<c:if test="${pageMaker.next && pageMaker.endPage >0 }">
 							<li class="page-item">
								<a class="page-link" href='<c:url value="/LOLboard/boardList${pageMaker.makeSearch(pageMaker.endPage+1) }"/>'><i class="fa fa-chevron-right"></i></a>
							</li>
						</c:if>
					</ul>
				</div>
				            <form method="get">
            <div class="search  col-md text-center">

    <select name="searchType">
      <option value="n"<c:out value="${cri.searchType == null ? 'selected' : ''}"/>>-----</option>
      <option value="t"<c:out value="${cri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
      <option value="c"<c:out value="${cri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
      <option value="w"<c:out value="${cri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
      <option value="tc"<c:out value="${cri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
    </select>

    <input type="text" name="keyword" id="keywordInput" value="${cri.keyword}"/>
    <button id="searchBtn" type="button">검색</button>
    <script>
      $(function(){
        $('#searchBtn').click(function() {
        	  self.location = "/LOLboard/boardList" + '${pageMaker.makeQueryPage(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
        });
      });   
    </script>
  </div>
  </form>
				<div class="col-md-4 text-right">
					<form class="community-filter">
  
<button type="button" onclick="location.href='/LOLboard/boardList?page=${pageMaker.cri.page}&perPageNum=${pageMaker.cri.perPageNum}&sort=최신순'" class="btn btn-outline-secondary btn-sm">최신순</button>
<button type="button" onclick="location.href='/LOLboard/boardList?page=${pageMaker.cri.page}&perPageNum=${pageMaker.cri.perPageNum}&sort=조회순'" class="btn btn-outline-secondary btn-sm">조회순</button>
<button type="button" onclick="location.href='/LOLboard/boardList?page=${pageMaker.cri.page}&perPageNum=${pageMaker.cri.perPageNum}&sort=추천순'" class="btn btn-outline-secondary btn-sm">추천순</button>
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