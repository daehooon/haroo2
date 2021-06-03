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
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

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
  display: block;
  text-align: center;
  padding-top: 8px;
  font-size: 13px;
  color: #333;
}

.nav-tabs>li {
  width:183px;
  text-align: center;
}

.tab-content {
  width:1100px;
  padding-top: 25px;
}

#har-tutor-box {
  width:530px;
  margin: 0 auto; 
}

#har-tutor-pro {
  width: 110px;
  height: 110px;
  overflow: hidden;
  border-radius: 60px;
  float: left;
}

#har-tutor-pro img {
  width: 110px;
}

#har-tutor-info {
  float: left;
  margin-left: 50px;
}

#har-tutor-info p {
  display: inline-block;
  font-size: 17px;
}

#har-tutor-info p span {
  /* font-size: 13px;
  color: #999; */
  margin-right: 20px;
}

#har-tutor-name {
  /* font-size: 18px; */
  margin-bottom: 30px;
}

.har-tutor-title {
  font-size: 13px;
  color: #999;
}

.har-tutor-score {
  /* margin-top: 10px; */
  font-size:16px;
  position: relative;
  top:10px;
}

#har-tutor-info pre {
  border: 0;
  background-color: #fff;
  padding: 0;
  margin: 20px 0 20px 0px;
  width: 370px;
}

.btn-primary {
  width: 72px;
  height: 27px;
  border-radius: 10px;
  float: right;
  font-size: 12px;
  padding-top: 4px;
  position: relative;
  top: -13px;
  margin-left: 15px;
  background-color: #0566A3;
}

.har-follow-btn {
  width: 220px;
  height: 30px;
  border-radius: 12px;
  background-color: #0566A3;
  border: 0;
  color: #fff;
}

.tab-pane {
  position: relative;
}

.addBtn {
  margin-bottom: 20px;
}
</style>

</head>
<body>

<jsp:include page="/jsp/header/header.jsp"/>

	<c:if test="${not empty tutor.profilePicture}">
		<c:set var="profilePictureUrl">../../upload/${loginUser.profilePicture}_110x110.jpg</c:set>
	</c:if>
	<c:if test="${empty tutor.profilePicture}">
		<c:set var="profilePictureUrl">../../images/person.png</c:set>
	</c:if>

	<section>
	   <div >
			<div id="har-tutor-box">
				<div id="har-tutor-pro">
					<img src="${profilePictureUrl}">
				</div>

				<div id="har-tutor-info">
					<p id="har-tutor-name">
						<b>${tutor.name}</b>
					</p>
					<br>
					<p>
						<span class="har-tutor-title">클래스 즐겨찾기</span><br> <span
							class="har-tutor-score">1,563</span>
					</p>
					<p>
						<span class="har-tutor-title">팔로워</span><br> <span
							class="har-tutor-score">759</span>
					</p>
					<br>
					<pre>${tutor.intro}</pre>
					<br>

					<button type="button" class="har-follow-btn">
						<b>+팔로우</b>
					</button>
				</div>
			</div>
			</div>

		<div style="margin-top: 20px; display:inline-block; border-top:1px solid #0566A3">
			<!-- tab 영역이다. -->
			<!-- <ul class="nav nav-tabs">
				data-load를 넣어서 이미 로드를 했는지 않했는지의 판단 값을 넣는다.
				true면 이미 content영역에 load가 끝나서 더이상 load가 필요없다는 뜻이다.
				<li class="active"><a href="#story" data-toggle="tab"
					data-load="true">스토리</a></li>
				false라면 data-url영역의 url주소로 데이터를 가져와서 tab-content에 표시한다.
				<li><a href="#oneday" data-toggle="tab" data-load="false">클래스</a></li>
				<li><a href="#product" data-toggle="tab" data-load="false">판매상품</a></li>
				<li><a href="#review" data-toggle="tab" data-load="false">리뷰</a></li>
				<li><a href="#question" data-toggle="tab" data-load="false">문의</a></li>
				<li><a href="#toTutor" data-toggle="tab" data-load="false">튜터에게
						물어봐</a></li>
			</ul> -->
			<!-- tab-content 영역이다. -->
			<div class="tab-content">
				<div class="tab-pane fade in active" id="story">
				  <c:if test="${not empty loginUser and loginUser.no == tutor.no}">
					<a href='form' class="addBtn">스토리 등록</a>
					</c:if>


					<c:forEach items="${feeds}" var="feed">
						<fmt:formatDate value="${feed.writingDate}"
							pattern="yyyy년 MM월 dd일" var="writingDate" />
						<c:if test="${not empty feed.attachedFiles.get(0)}">
							<c:set var="photoUrl">../../upload/${feed.attachedFiles.get(0).name}_330x220.jpg</c:set>
						</c:if>

						<div class="card">
							<div class="har-feed-info">
								<div class="har-feed-pro">
									<c:if test="${not empty feed.writer.profilePicture}">
										<c:set var="profilePictureUrl">../../upload/${feed.writer.profilePicture}_110x110.jpg</c:set>
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
				</div>
				<div class="tab-pane fade" id="oneday">클래스를 보여줘</div>
				<div class="tab-pane fade" id="product">상품을 보여줘</div>
				<div class="tab-pane fade" id="review">리뷰를 보여줘</div>
				<div class="tab-pane fade" id="question">뮨의를 보여줘</div>
				<div class="tab-pane fade" id="toTutor">튜터에게 물어봐를 보여줘</div>
			</div>
		</div>



	</section>
	
	<jsp:include page="/jsp/footer/footer.jsp"/>



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
