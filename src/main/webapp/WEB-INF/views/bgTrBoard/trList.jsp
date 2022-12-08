<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- 헤더부분 -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/resources/css/yd/trLoArk.css" />
<jsp:include page="../include/header.jsp" />
<!-- 헤더부분 -->


<!-- Latest news section -->
<div class="latest-news-section">
	<a href="https://m-lostark.game.onstove.com/News/Notice/List"
		target='_blank'>
		<div class="ln-title"><b>메이플 뉴스</b></div>
	</a>
	<div class="news-ticker">
		<div class="news-ticker-contant">
			<div class="nt-item">

				<!-- 로아뉴스 for문 -->
				<c:forEach var="list" items="${bgNews}">

					<span class="new">news</span>
					<a style="color: white !important;"
						href="https://m-lostark.game.onstove.com${list.bgLink}"
						target='_blank'>${list.bgNews}</a> 
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
					<h2>mp 거래소</h2>
					<p>&nbsp; 게임머니 및 아이템 거래</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- Page info section -->


<!-- Page section -->
<section class="page-section community-page set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/yd/trloabg.jpg">
	<div class="community-warp spad">
		<div class="container" >
			<div class="row">
				<div class="col-md-6">
					<h3 class="community-top-title">
						<a href="${PageContext.request.contextPath}/bgTrBoard/trList" class="text-subject">
							<b style="font-family: 'Malgun Gothic', dotum, sans-serif;">
								물품리스트 (${ listSize})</b>
						</a>
					</h3>

					
					
					
					
				</div>


				<div class="col-md-6 text-lg-right">

					
						<label for="fdf5"> <input type="button" value="판매등록" 
						onclick="location.href='${PageContext.request.contextPath}/bgTrBoard/trWrite'"
							style="height: 43px; cursor: pointer;" class="text-subject2">
						</label>
					
				</div>
			</div>

			<table class="table" style="font-size: 20px;">
				<thead style="text-align: center;">
					<tr style="background: #1e282c; color: white;">
						<th>번호</th>
						<th>물품제목</th>
						<th>가격</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody style="text-align: center;">
					<c:choose>
						<c:when test="${fn:length(trBgList) > 0 }">
							<c:forEach var="list" items="${trBgList}"  >
								
								<tr style="color: white;">
									<th scope="row">${list.num }</th>
									<td >
									<a href="${pageContext.request.contextPath }/bgTrBoard/trContent?num=${list.num}&page=<%=request.getParameter("page") %>"
										class="text-subject">${list.subject }</a></td>
									<td>${list.price }p</td>

									<td>${list.userid }</td>

									<td>
									<fmt:formatDate value="${list.date }" pattern="yyyy-MM-dd HH:mm:ss" />
									</td>
									
									<td>${list.readcount }</td>
								</tr>
								
							</c:forEach>
							
							
						</c:when>
						<c:otherwise>
							<tr>
								<td colspan="5" style="color: white;">조회된 결과가 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>

				</tbody>
				
				<tr>
				
				<div style="float: left;">
						<button class="text-subject2"
							onclick="location.href='/bgTrBoard/trList?sort=def&page=1' ;return false;"
							style="cursor: pointer; "><b>최신순</b></button>

						<button class="text-subject2"
							onclick="location.href='/bgTrBoard/trList?sort=sel&page=1' ;return false;"
							style="cursor: pointer; "><b>조회순</b></button>
 
						<button class="text-subject2"
							onclick="location.href='/bgTrBoard/trList?sort=pri&page=1' ;return false;"
							style="cursor: pointer;  "><b>가격순↓</b></button>

						<button class="text-subject2"
							onclick="location.href='/bgTrBoard/trList?sort=pri2&page=1' ;return false;"
							style="cursor: pointer;  "><b>가격순↑</b></button>

						


					</div>
				
				
				
				<form class="community-filter"
				action="${PageContext.request.contextPath}/bgTrBoard/trList?sort=def"
				method="post">

				<input type="submit" value="검색"
					style="float: right; cursor: pointer; " class="text-subject2">
				<input type="text" name="searchName" style="float: right;">

			</form>
				</tr>
				
				
			</table>
	<div class="site-pagination sp-style-2"
				style="padding-left: 40% !important; padding-top: 0px;" >


				<c:if test="${pm.prev }">
					<a class="text-subject" href="trList?sort=<%=request.getParameter("sort") %>&page=${pm.startPage - 1 }">&laquo;</a>
				</c:if>

				<c:forEach var="idx" begin="${pm.startPage }" end="${pm.endPage }">

					<a  class="text-subject" href="trList?sort=<%=request.getParameter("sort") %>&page=${idx }">${idx }</a>
				</c:forEach>

				<c:if test="${pm.next && pm.endPage >0 }">
					<a class="text-subject"
						href="trList?sort=<%=request.getParameter("sort") %>&page=${pm.endPage + 1 }">&raquo;</a>
				</c:if>


			
			</div>

			





		</div>
	</div>
</section>
<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp" />
<!-- 푸터부분 -->