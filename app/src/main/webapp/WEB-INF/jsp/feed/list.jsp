<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>스토리 목록</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>

<link href="../../css/har_feed_list.css" rel="stylesheet">

</head>
<body>
	<h1>스토리 목록(JSTL)</h1>

	<p>
		<a href='form'>스토리 등록</a>
	</p>

	<c:forEach items="${feeds}" var="feed">
		<fmt:formatDate value="${feed.writingDate}" pattern="yyyy년 MM월 dd일"
			var="writingDate" />
		<c:if test="${not empty feed.attachedFiles.get(0)}">
			<c:set var="photoUrl">../../upload/${feed.attachedFiles.get(0).name}_330x220.jpg</c:set>
		</c:if>

		<div class="card">
			<div class="har-feed-info">
				<div class="har-feed-pro">
					<c:if test="${not empty feed.writer.profilePicture}">
						<c:set var="profilePictureUrl">../../upload/${feed.writer.profilePicture}_30x30.jpg</c:set>
					</c:if>
					<c:if test="${empty feed.writer.profilePicture}">
						<c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
					</c:if>
					<img src="${profilePictureUrl}">
					<!-- <img src="/Users/kimseongeun/Desktop/test.png"> -->
				</div>

				<p class="fw-bold har-feed-font">${feed.writer.name}</p>
				<p class="fw-light har-feed-font2">${writingDate}</p>
			</div>
			<a href='detail?no=${feed.no}'><img src='${photoUrl}'
				class="card-img-top"></a>
			<div class="card-body">
				<div class="like"></div>
				<p class="fst-normal har-feed-font3">${feed.likeCount}</p>
				<div class="comment"></div>
				<p class="fst-normal har-feed-font3">${feed.commentCount}</p>
			</div>
		</div>
	</c:forEach>

</body>
</html>
