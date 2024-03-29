<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="css/app.css">
<link rel="stylesheet" href="css/home.css">
<link rel="stylesheet" href="css/register.css">
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/succes.css">
<link rel="stylesheet" href="css/timeline.css">
<link rel="stylesheet" href="css/profile.css">
<link rel="stylesheet" href="css/settings.css">
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="shortcut icon" type="image/x-icon" href="imgs/ano_white.png">
<title>Home - Hackeet</title>
</head>
<body>
	<div class="container">
		<header>
			<div class="left no-select">
				<img src="imgs/ano.png" alt="icon">
				<p>Hackeet</p>
			</div>
			<div class="center"></div>
			<div class="right">
	
			</div>
		</header>
		<div class="mainCont">
		<jsp:include page="${page}.jsp" />
		</div>
	</div>
	<script src="js/register.js"></script>
	<script src="js/time.js"></script>
	<script src="js/login.js"></script>
	<script src="js/profile.js"></script>
	<script src="js/settings.js"></script>
	<script src="js/app.js"></script>
</body>
</html>