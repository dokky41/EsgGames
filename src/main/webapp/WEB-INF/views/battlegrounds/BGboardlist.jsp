<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!-- 헤더부분 -->
<jsp:include page="../include/header.jsp"/>
<!-- 헤더부분 -->


	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">BattleGrounds ISSUE</div>
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
	<section class="page-info-section set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/battlegrounds/1.jpeg">
		<div class="pi-content">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-6 text-white">
						<h2>BattleGrounds</h2>
					
					    <p>배틀그라운드 게시판 </p>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Page info section -->


	<!-- Page section -->
	<section class="page-section community-page set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/battlegrounds/2.jpeg">
		<div class="community-warp spad" >
			<div class="container">
				<div class="row">
					<div class="col-md-6">
						<h3 class="community-top-title" style="color: white">BattleGrounds COMMUNITY </h3>
						<form action="${pageContext.request.contextPath }/battlegrounds/BGboardlist" method="POST">
						<input type="text" name="searchName">
						<input type="submit" value="검색 " style="color: black; background: white; cursor: pointer; border-radius:7px 7px 7px 7px; ">
						</form>
					</div>
					<div class="col-md-6 text-lg-right">
						<form class="community-filter" action ="${pageContext.request.contextPath}/battlegrounds/BGboardwrite" method="get">
							<label for="fdf5"><input type="submit" value="글쓰기" style="height:40px;
							background: white; color: black; border-radius:7px 7px 7px 7px; cursor: pointer;">
							</label>
							
						</form>
					</div>
				</div>
				
				<table class="table" style="font-size: 17px;">
                         
              <thead style="text-align: center;">
              <tr style="background: white; color: black;">
              <th>번호</th><th>제목</th><th>내용 </th><th>작성자</th><th>작성일</th><th>조회수</th>
              </tr>
              </thead>
              <tbody style="text-align: center; color: white;">
 											                     
                          <c:forEach var="list" items="${BGlist}">
                              <tr >
                              <th scope="row">${list.num }</th>
                              <td>
                              <a href="${pageContext.request.contextPath }/battlegrounds/BGread?num=${list.num}" 
                               class="text-subject" >${list.subject }</a>
                              </td>
                              <td>
                              ${list.content }
                              </td>
                              
                              <td>${list.userid }</td>
                              
                              <td>
                              <fmt:formatDate value="${list.date }" pattern="yyyy-MM-dd HH:mm:ss"/>
                              </td>
                              <td>${list.readcount }</td>
                            </tr>
                          </c:forEach>
                         

              </tbody>
            </table>
				
				
				<div class="site-pagination sp-style-2" style="padding-left: 45%; ">
	
	<c:if test="${pm.prev}">
		<a href="BGboardlist?page=${pm.startPage -1}"> &laquo; </a>
	</c:if>
	
	<c:forEach var="idx" begin="${pm.startPage}" end="${pm.endPage }">
	
		<a href="BGboardlist?page=${idx }" style= "color : black; background:#dcdcdc ">${idx }</a>
		
	</c:forEach>
	
	<c:if test="${pm.next && pm.endPage > 0 }">
		<a href="BGboardlist?page=${pm.endPage+1}"> &raquo; </a>
		
	</c:if>
</div>
				
			</div>
		</div>
	</section>
	<!-- Page section end -->


<!-- 푸터부분 -->
<jsp:include page="../include/footer.jsp"/>
<!-- 푸터부분 -->