<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 헤더부분 -->
<jsp:include page="include/header.jsp"/>
<!-- 헤더부분 -->
	<!-- Hero section -->
	<section class="hero-section">
		<div class="hero-slider owl-carousel">
			<div class="hs-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/sliderlol.jpg">
				<div class="hs-text">
					<div class="container">
						<h2>리그 오브 레전드 </h2>
						<p> 라이엇 게임즈에서 개발 및 서비스하는 
						<br>멀티플레이어 온라인 배틀 아레나 게임입니다. 
						<br>게임정보를 공유하고 실력을 향상 시켜보세요!</p>
						<a href="${pageContext.request.contextPath }/LOLboard/boardList" class="site-btn">GO!</a>
					</div>
				</div>
			</div>

			
			<div class="hs-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/slidermaple.jpg">
				<div class="hs-text">
					<div class="container">
						<h2>메이플스토리</h2>
						<p> 다채로운 필드에서의 여행과 모험을 할수있는
						<br>국내 TOP10 MMORPG게임입니다. 
						<br>게임정보를 공유하고 쉽게 육성해보세요!</p>
						<a href="${pageContext.request.contextPath }/maple/mapleboardlist" class="site-btn">GO!</a>
					</div>
				</div>
			</div>
			
						<div class="hs-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/sliderbag.jpg">
				<div class="hs-text">
					<div class="container">
						<h2>배틀 그라운드 </h2>
						<p> 다양한 전장에서 최후의 1인이 되기 위한 
						<br>생존사투를 벌이는 FPS게임입니다.
						<br>게임정보를 공유하고 치킨을 획득해보세요!</p>
						<a href="#" class="site-btn">GO!</a>
					</div>
				</div>
			</div>
			
			<div class="hs-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/sliderlostark.jpg">
				<div class="hs-text">
					<div class="container">
						<h2> 로스트 아크 </h2>
						<p> 다채로운 필드에서의 여행과 모험을 할수있는
						<br>국내 TOP10 MMORPG게임입니다. 
						<br>게임정보를 공유하고 쉽게 육성해보세요!</p>
						<a href="#" class="site-btn">GO!</a>
					</div>
				</div>
			</div>
			
		</div>
	</section>
	<!-- Hero section end -->


	<!-- Latest news section -->
	<div class="latest-news-section">
		<div class="ln-title">TOP 10</div>
		<div class="news-ticker">
			<div class="news-ticker-contant">
			<c:set var="c" value="0"></c:set>
			
			<c:forEach var="list" items="${gameMeca}" >
				
				<div class="nt-item">
				<span class="new">${c=c+1}</span>
				<a style="color: white !important;" 
					  target='_blank'>${list.rank}</a> 
					&nbsp; &nbsp;&nbsp;
				
				 </div>
			
			</c:forEach>
			
			</div>
		</div>
	</div>
	<!-- Latest news section end -->

	<!-- Tournaments section -->
	<section class="tournaments-section spad" 
	style="background-image: url(${pageContext.request.contextPath }/resources/img/testbg.jpg);">
		<div class="container">
			<div class="tournament-title">주요기능</div>
			<div class="row">
				<div class="col-md-6">
					<div class="tournament-item mb-4 mb-lg-0">
						<div class="ti-notic">게임정보공유</div>
						<div class="ti-content">
							<div class="ti-thumb set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/main/ques.jpg"></div>
							<div class="ti-text">
								<h4>게임 정보 게시판</h4>
								<p><span>최근 업데이트</span> </p>
								<ul>
									<li><span>feat : </span> 게시판 추가</li>
									<li><span>design :</span> 메인페이지 상단배경 변경</li>
									<li><span>date :</span> July 01, 2018</li>
									<li><span>developer:</span> HYD</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="tournament-item">
						<div class="ti-notic">게임거래</div>
						<div class="ti-content">
							<div class="ti-thumb set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/main/pp.jpg"></div>
							<div class="ti-text">
								<h4>아이템 및 게임머니 거래</h4>
								<p><span>최근 업데이트</span> </p>
								<ul>
									<li><span>feat : </span> 거래,마일리지 추가</li>
									<li><span>design :</span> 메인페이지 상단배경 변경</li>
									<li><span>date :</span> July 01, 2018</li>
									<li><span>developer:</span> HYD</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Tournaments section bg -->

	<!-- Feature section -->
	<section class="feature-section spad"
	 style="background-image: url(${pageContext.request.contextPath }/resources/img/main/firstbg.jpg); 
	 border-top: 0.5px solid white;">
		<div class="container">
			<div style="text-align: center;">
			<h2 style="color: white"><b>다양한 정보를 공유해보세요</b></h2>
			<br>
			</div>
			<div class="row" style="overflow: hidden; " >
			
				<div class="col-lg-3 col-md-6 p-0" onclick="location.href='#'" style="cursor: pointer;">
					<div class="feature-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/features/1.jpg">
						<span class="cata new" >lol</span>
						<div class="fi-content text-white">
							<h5>Suspendisse ut justo tem por, rutrum</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
							<a class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
				
				
				<div class="col-lg-3 col-md-6 p-0" onclick="location.href='#'" style="cursor: pointer;">
					<div class="feature-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/features/2.jpg">
						<span class="cata strategy">Maple</span>
						<div class="fi-content text-white">
							<h5><a href="#">Justo tempor, rutrum erat id, molestie</a></h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
							<a href="#" class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 p-0" onclick="location.href='#'" style="cursor: pointer;">
					<div class="feature-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/features/3.jpg">
						<span class="cata new" style="background: blue;">battleGround</span>
						<div class="fi-content text-white">
							<h5><a href="#">Nullam lacinia ex eleifend orci porttitor</a></h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
							<a href="#" class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 p-0" onclick="location.href='#'" style="cursor: pointer;">
					<div class="feature-item set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/features/4.jpg">
						<span class="cata racing">lostArk</span>
						<div class="fi-content text-white">
							<h5><a href="#">Lacinia ex eleifend orci suscipit</a></h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </p>
							<a href="#" class="fi-comment">3 Comments</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Feature section end -->


	<!-- Recent game section  -->
	<section class="recent-game-section spad set-bg" 
	data-setbg="${pageContext.request.contextPath }/resources/img/main/secondbg.jpg">
		<div class="container">
			<div class="section-title">
				<div class="cata new">new</div>
				<h2 style="color: white;"><b>아이템을 거래해보세요</b></h2>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6">
					<div class="recent-game-item">
						<div class="rgi-thumb set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/recent-game/1.jpg">
							<div class="cata new">new</div>
						</div>
						<div class="rgi-content">
							<h5>Suspendisse ut justo tem por, rutrum</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit amet, consectetur elit. </p>
							<a href="#" class="comment">3 Comments</a>
							<div class="rgi-extra">
								<div class="rgi-star"><img src="${pageContext.request.contextPath }/resources/img/icons/star.png" alt=""></div>
								<div class="rgi-heart"><img src="${pageContext.request.contextPath }/resources/img/icons/heart.png" alt=""></div>
							</div>
						</div>
					</div>	
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="recent-game-item">
						<div class="rgi-thumb set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/recent-game/2.jpg">
							<div class="cata racing">racing</div>
						</div>
						<div class="rgi-content">
							<h5>Susce pulvinar metus nulla, vel  facilisis sem </h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit amet, consectetur elit. </p>
							<a href="#" class="comment">3 Comments</a>
							<div class="rgi-extra">
								<div class="rgi-star"><img src="${pageContext.request.contextPath }/resources/img/icons/star.png" alt=""></div>
								<div class="rgi-heart"><img src="${pageContext.request.contextPath }/resources/img/icons/heart.png" alt=""></div>
							</div>
						</div>
					</div>	
				</div>
				<div class="col-lg-4 col-md-6">
					<div class="recent-game-item">
						<div class="rgi-thumb set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/recent-game/3.jpg">
							<div class="cata adventure">Adventure</div>
						</div>
						<div class="rgi-content">
							<h5>Suspendisse ut justo tem por, rutrum</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit amet, consectetur elit. </p>
							<a href="#" class="comment">3 Comments</a>
							<div class="rgi-extra">
								<div class="rgi-star"><img src="${pageContext.request.contextPath }/resources/img/icons/star.png" alt=""></div>
								<div class="rgi-heart"><img src="${pageContext.request.contextPath }/resources/img/icons/heart.png" alt=""></div>
							</div>
						</div>
					</div>	
				</div>
			</div>
		</div>
	</section>
	<!-- Recent game section end -->


	


	<!-- Review section -->
	<section class="review-section spad set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/main/thirdbg.jpg">
		<div class="container">
			<div class="section-title">
				<div class="cata new">new</div>
				<h2 style="color: white;"><b>고객센터</b></h2>
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-6">
					<div class="review-item">
						<div class="review-cover set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/review/1.jpg">
							<div class="score yellow">9.3</div>
						</div>
						<div class="review-text">
							<h5 style="color: white;">게시판 신고</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit ame.</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="review-item">
						<div class="review-cover set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/review/2.jpg">
							<div class="score purple">9.5</div>
						</div>
						<div class="review-text">
							<h5 style="color: white;">거래 사기</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit ame.</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="review-item">
						<div class="review-cover set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/review/3.jpg">
							<div class="score green">9.1</div>
						</div>
						<div class="review-text">
							<h5 style="color: white;">QNA</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit ame.</p>
						</div>
					</div>
				</div>
				<div class="col-lg-3 col-md-6">
					<div class="review-item">
						<div class="review-cover set-bg" data-setbg="${pageContext.request.contextPath }/resources/img/review/4.jpg">
							<div class="score pink">9.7</div>
						</div>
						<div class="review-text">
							<h5 style="color: white;">마일리지 환불</h5>
							<p>Lorem ipsum dolor sit amet, consectetur adipisc ing ipsum dolor sit ame.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- Review section end -->

<!-- 푸터 부분 -->
<jsp:include page="include/footer.jsp"/>
<!-- 푸터 부분 -->
	