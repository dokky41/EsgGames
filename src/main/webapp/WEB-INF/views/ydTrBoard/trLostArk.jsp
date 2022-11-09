<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!-- 헤더부분 -->
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/yd/trLoArk.css"/>
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->


	<!-- Latest news section -->
	<div class="latest-news-section">
		<a href="https://m-lostark.game.onstove.com/News/Notice/List" target='_blank'>
		<div class="ln-title">
		로아 뉴스
		</div>
		</a>
		<div class="news-ticker">
			<div class="news-ticker-contant">
				<div class="nt-item">
				
				<!-- 로아뉴스 for문 -->
				<c:forEach var="list" items="${LoaNews}" >
				
					<span class="new">news</span>
					<a style="color: white !important; " 
					href="https://m-lostark.game.onstove.com${list.RoaLink}"  target='_blank'>${list.RoaNews}</a> 
					&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;
				</c:forEach>
				<!-- 로아뉴스 for문 -->
				
				
				 </div>
			</div>
		</div>
	</div>
	<!-- Latest news section end -->


	<!-- Page info section -->
	<section class="page-info-section set-bg" 
	data-setbg="${pageContext.request.contextPath }/resources/img/sliderlostark.jpg">
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
	<section class="page-section community-page set-bg"
	 data-setbg=""
	 style="background: #ecf0f5; ">
		<div class="community-warp spad" style="background: rgba(255,255,255, 0.8);" >
			<div class="container">
				<div class="row" >
					<div class="col-md-6" >
						<h3 class="community-top-title" >
						<a style="color: black;" href="${PageContext.request.contextPath}/ydTrBoard/trLostArk">
						<b style="font-family: 'Malgun Gothic', dotum, sans-serif;">
						물품 리스트 ( ${ listSize} )</b>
						</a></h3>
						
						<div style="float: left;">
						<button onclick="location.href='/ydTrBoard/trLostArk' ;return false;">전체</button>
						</div>
					</div>
					
					
					<div class="col-md-6 text-lg-right">
					
		<form class="community-filter" action="${PageContext.request.contextPath}/ydTrBoard/trLostWrite" method="get">
							<label for="fdf5">
							<input type="submit" value="판매등록" style="height: 43px; background: white;">
							</label>
							</form>
				
							
						
					</div>
				</div>
				
				
					
				<table class="table" style="font-size: 20px;">
           
              
              <thead style="text-align: center;">
              <tr>
              <th>번호</th><th>제목</th><th>작성자</th><th>작성일</th><th>조회수</th>
              </tr>
              </thead>
              <tbody style="text-align: center;">
 						  <c:choose>
                      <c:when test="${fn:length(trLoaList) > 0 }">
                          <c:forEach var="list" items="${trLoaList}">
                              <tr >
                              <th scope="row">${list.num }</th>
                              <td>
                              <a href="${pageContext.request.contextPath }/ydTrBoard/trLoaContent?num=${list.num}" 
                               class="text-subject">${list.subject }</a>
                              </td>
                              <td>${list.userid }</td>
                              
                              <td>
                              <fmt:formatDate value="${list.date }" pattern="yyyy-MM-dd HH:mm:ss"/>
                              </td>
                              <td>${list.readcount }</td>
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
					
					
					
					
					
			
				
				<br>
				<form class="community-filter"
						 action="${PageContext.request.contextPath}/ydTrBoard/trLostArk" method="post">
				
				<input type="submit" value="검색" style="float: right; ">
				<input type="text" name="searchName" style="float: right;">
				
				</form>
				
				<div class="site-pagination sp-style-2" style="padding-left: 45% !important;">
					
<!-- 			<span class="active">01.</span> -->
					
					<c:if test="${pm.prev }">
				<a href="trLostArk?page=${pm.startPage - 1 }">&laquo;</a>
			</c:if>
			
			<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">
				
					<a href="trLostArk?page=${idx }">${idx }</a>
			</c:forEach>			
			
			<c:if test="${pm.next && pm.endPage >0 }">
				<a href="trLostArk?page=${pm.endPage + 1 }">&raquo;</a>
			</c:if>
					
					
				</div>
				
			
				
				
				
			</div>
		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->