<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<title>스토리 목록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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

<style>
section {
  width:1100px;
  margin:0 auto;
}

.addBtn {
  width: 80px;
  height: 30px;
  border: 1px solid rgba(0, 0, 0, .125);
  border-radius: 10px;
  margin-top: 20px;
  display: block;
  text-align: center;
  padding-top: 8px;
  font-size: 13px;
  color: #333;
}
</style>

</head>
<body>
	<h1>스토리 목록(JSTL)</h1>


<section>
	
		<a href='form' class="addBtn">스토리 등록</a>
	
	
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
				<div class="like" har-like-no="${feed.no}"></div>
				<p class="fst-normal har-feed-font3">${feed.likeCount}</p>
				<div class="comment"></div>
				<p class="fst-normal har-feed-font3">${feed.commentCount}</p>
			</div>
		</div>
	</c:forEach>
	</section>
	
	<script>
	"use strict"
	
	  var likeBtns = document.querySelectorAll(".like");

	  for (var l of likeBtns) {
	    var no = l.getAttribute("har-like-no");
	    var lType = 1;

	    $.ajax("likeCheck", {
	      method: "POST",
	      data: "no=" + no + "&lType=" + lType,
	      async: false,
	      success: function(data) {
	        console.log(no, data, "피드라이크!");

	        if (data == "no") {
	          /* var feedLike = document.querySelector(".like");*/
	        } else if (data == "yes") {
	            l.style.backgroundPosition = "-38px -9px";
	          /* var feedLike = document.querySelector(".like");*/

	        }
	      },
	      error: function(data) {
	        console.log(data);
	      }
	    });
	  }
	  
	  
	  var loginMsg = '${loginMsg}';
	  if(loginMsg.length > 0){
	    alert(loginMsg);
	  }

	</script>

</body>
</html>
