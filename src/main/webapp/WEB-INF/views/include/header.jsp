<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zxx">
<head>
	<title>EsgGames</title>
	<meta charset="UTF-8">
	<meta name="description" content="Game Warrior Template">
	<meta name="keywords" content="warrior, game, creative, html">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<!-- Favicon -->   
	<link href="${pageContext.request.contextPath }/resources/img/favicon.ico" rel="shortcut icon"/>

	<!-- Google Fonts -->
	<link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700,700i" rel="stylesheet">

	<!-- Stylesheets -->
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.min.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/font-awesome.min.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/owl.carousel.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/style.css"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/animate.css"/>

	<!--[if lt IE 9]>
	  <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
	  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<!-- Page Preloder -->
	<div id="preloder">
		<div class="loader"></div>
	</div>

	<!-- Header section -->
	<header class="header-section">
		<div class="container">
			<!-- logo -->
			<a class="site-logo" href="${pageContext.request.contextPath }/index">
				<img src="${pageContext.request.contextPath }/resources/img/logo.png" alt="">
			</a>
			<div class="user-panel">
				<a href="#">Login</a>  /  <a href="#">Register</a>
			</div>
			<!-- responsive -->
			<div class="nav-switch">
				<i class="fa fa-bars"></i>
			</div>
			<!-- site menu -->
			<nav class="main-menu">
				<ul>
					<li><a href="${pageContext.request.contextPath }/index">Home</a>
					
					<li class="GameList">
					<a  href="${pageContext.request.contextPath }/review">Games</a>
					
					<ul class="Gsubmenu" >
					
						<li>
					   <a href="${pageContext.request.contextPath }/review">리그오브레전드</a>
					   </li>
					   
					   <li>
					   <a href="${pageContext.request.contextPath }/review">메이플스토리</a>
					   </li>
					   
					   <li>
					   <a href="${pageContext.request.contextPath }/review">배틀그라운드</a>
					   </li>
					   
					    <li>
					   <a href="${pageContext.request.contextPath }/review">로스트아크</a>
					   </li>
					   
					</ul>
					
					
					</li>
					
					<li >
					 <a href="${pageContext.request.contextPath }/categories">Trade</a>
					</li>
					<li><a href="${pageContext.request.contextPath }/community">Forums</a></li>
					<li><a href="${pageContext.request.contextPath }/contact">회원가입</a></li>
				</ul>
			</nav>
		</div>
	</header>
	<!-- Header section end -->