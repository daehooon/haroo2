<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>피드 상세</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../../css/har_feed_detail.css" rel="stylesheet" />
<!-- <script type="text/javascript" src="../../js/har_feed_detail.js"></script> -->

</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>
	<section>
		<c:if test="${not empty feed}">
			<fmt:formatDate value="${feed.writingDate}" pattern="yyyy년 MM월 dd일" var="writingDate" />
			<div class="card">
				<form action='updateForm' method='post'>
					<input type="hidden" name='no' value='${feed.no}' readonly>
					<div class="har-feed-info">
						<div class="har-feed-pro">
							<c:if test="${not empty feed.writer.profilePicture}">
								<c:set var="profilePictureUrl">../../upload/${feed.writer.profilePicture}_110x110.jpg</c:set>
							</c:if>
							<c:if test="${empty feed.writer.profilePicture}">
								<c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
							</c:if>
							<img src="${profilePictureUrl}">
						</div>

						<p class="fw-bold har-feed-font">${feed.writer.name}</p>
						<p class="fw-light har-feed-font2">${writingDate}</p>

						<c:if test="${loginUser.no != feed.writer.no}">
							<button type="button" class="btn btn-primary">
								<b>+팔로우</b>
							</button>
						</c:if>

						<c:if
							test="${not empty loginUser and loginUser.no == feed.writer.no}">
							<button type="submit" class="btn har-feed-btn">수정</button>
							<button type="button" onclick="deleteCheck('delete?no=${feed.no}')" class="btn har-feed-btn" >삭제</button>
							<%-- <a href="delete?no=${feed.no}">삭제</a> --%>
						</c:if>
						<p class="fw-light har-feed-view">${feed.viewCount}view</p>
					</div>

					<div id="har-feed-file">
						<c:forEach items="${feed.attachedFiles}" var="file">
							<c:if test="${not empty file.name}">
								<c:set var="photoUrl">../../upload/${file.name}_500x500.jpg</c:set>
							</c:if>

							<img src='${photoUrl}' class="card-img-top" har-file-no="${file.no}">
						</c:forEach>
            <%-- <c:if test="${feed.attachedFiles > 1}"> --%>
						<button type="button" class="har-feed-btn har-feed-pre har-feed-fileBtn" onclick="preBtn(event)">❮</button>
						<button type="button" class="har-feed-btn har-feed-next har-feed-fileBtn" onclick="nextBtn(event)">❯</button>
						<%-- </c:if> --%>
					</div>

					<div class="card-body">
						<!-- <div class="like"></div> -->
						<pre class="fst-normal har-feed-font3">${feed.content}</pre>
						<br> <br> <br> <br> <br> <br> <br>
						<!-- <div class="comment"></div> -->
						<!-- <p class="fst-normal har-feed-font3">583</p> -->
					</div>
				</form>
			</div>


			<div class="card card2">
				<div class="card card3">
					<!-- <div class="like"></div> -->
					<button type="button" class="har-like " id="like"
						har-like-no="${feed.no}" har-like-type="1"
						onclick="likeCheck(event)"></button>
					<p class="fst-normal har-feed-font3">${feed.likeCount}</p>
					<div class="comment"></div>
					<p class="fst-normal har-feed-font3">${feed.commentCount}</p>
				</div>


				<div class="card4">
					<c:forEach items="${comments}" var="comment">
						<div har-cmt-no="${comment.no}" har-feed-no="${feed.no}"
							har-cmt-type="1" class="har-comment1">
							<c:if test="${comment.state == true}">
								<div class="har-writer-pro">
									<c:if test="${not empty comment.writer.profilePicture}">
										<c:set var="profilePictureUrl">../../upload/${comment.writer.profilePicture}_30x30.jpg</c:set>
									</c:if>
									<c:if test="${empty comment.writer.profilePicture}">
										<c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
									</c:if>
									<img src="${profilePictureUrl}" />
								</div>
								<b class="har-feed-font4">${comment.writer.name}</b>
								<span class="har-cmt-content">${comment.content}</span>
								<input type="text" class="har-cmt-input"
									value="${comment.content}">
								<%-- <span>좋아요 ${comment.likeCount}개</span> --%>
								<div class="har-like-box">
									<button type="button" class="har-like har-like2"
										har-like-no="${comment.no}" har-like-type="2"
										onclick="likeCheck(event)">좋아요 ${comment.likeCount}개</button>
									<button type="button"
										onclick="reCommentAdd(${comment.no},${comment.writer.no},${feed.no})">답글달기</button>


									<c:if
										test="${not empty loginUser and loginUser.no == comment.writer.no}">
										<button type="button" onclick="cmtUpdate(event)"
											class="har-cmt-update">수정</button>
										<button type="button" onclick="cmtConfirm(event)"
											class="har-cmt-confirm">확인</button>
										<button onclick="deleteCheck('comment/delete?no=${comment.no}&feedNo=${feed.no}')" 
											class="har-cmt-delete-bnt" >댓글삭제</button>
									</c:if>
								</div>
							</c:if>

							<c:if test="${comment.state == false}">
								<div class="har-comment-delete">
									<span>삭제 된 댓글입니다.</span>
								</div>
							</c:if>
						</div>

						<c:forEach items="${comment.reComments}" var="reComment">
							<c:if test="${reComment.state == true}">
								<div class="har-comment1 har-comment2">
									<div har-cmt-no="${reComment.no}" har-feed-no="${feed.no}"
										har-cmt-type="2">
										<div class="har-writer-pro">
											<c:if test="${not empty reComment.reWriter.profilePicture}">
												<c:set var="profilePictureUrl">../../upload/${reComment.reWriter.profilePicture}_30x30.jpg</c:set>
											</c:if>
											<c:if test="${empty reComment.reWriter.profilePicture}">
												<c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
											</c:if>
											<img src="${profilePictureUrl}" class="har-feed-wr-pro3" />
										</div>
										<b class="har-feed-font4">${reComment.reWriter.name}</b><br>
										<span class="har-cmt-content har-rcmt-content"><span class="har-reComment-tag">@${reComment.taggedMember.name}</span>
											${reComment.content}</span>
										<div class="har-like-box har-like-box2">
											<input type="text" class="har-cmt-input har-rcmt-input"
												value="${reComment.content}">
											<button type="button" class="har-like"
												har-like-no="${reComment.no}" har-like-type="3"
												onclick="likeCheck(event)">좋아요
												${reComment.likeCount}개</button>
											<button type="button"
												onclick="reCommentAdd(${comment.no},${reComment.reWriter.no},${feed.no})">답글달기</button>

											<c:if
												test="${not empty loginUser and loginUser.no == reComment.reWriter.no}">
												<button type="button" onclick="cmtUpdate(event)"
													class="har-cmt-update">수정</button>
												<button type="button" onclick="cmtConfirm(event)"
													class="har-cmt-confirm">확인</button>
												<button
													onclick="deleteCheck('reComment/delete?no=${reComment.no}&feedNo=${feed.no}')" >대댓글삭제</button>
											</c:if>
										</div>
									</div>
								</div>
							</c:if>
						</c:forEach>
					</c:forEach>
				</div>

				<div class="har-comment-input">
					<form action='comment/add' method='post' id="har-comment-add">
						<input type="hidden" name="feedNo" value="${feed.no}" />
						<input type="text" name="content" placeholder="댓글을 달아주세요." class="har-comment-text" />
						<c:if test="${empty loginUser}">
						  <c:set var="login">N</c:set>
						</c:if>
						<input type="hidden" value="${login}" class="har-feed-login">
						<input type='submit' value='등록' class="har-comment-btn" onclick="loginCheck('${login}')">
					</form>
				</div>
			</div>

		</c:if>

		<c:if test="${empty feed}">
			<p>없는 피드입니다.</p>
		</c:if>

		<a href='list?no=${feed.writer.no}' class="listBtn">목록</a>
	</section>
	
	<jsp:include page="/jsp/footer/footer.jsp"/>
	
	
	
	<script>
	"use strict"


	var likeBtns = document.querySelectorAll(".har-like");
	var feedLike = document.getElementById('like');


	for (var l of likeBtns) {
	  var no = l.getAttribute("har-like-no");
	  var lType = l.getAttribute("har-like-type");

	  $.ajax("likeCheck", {
	    method: "POST",
	    data: "no=" + no + "&lType=" + lType,
	    async: false,
	    success: function(data) {

	      if (data == "no") {
	        if (lType == 1) {
	        } else {
	          l.style.color = "#666";
	        }
	      } else if (data == "yes") {
	        if (lType == 1) {
	          feedLike.style.backgroundPosition = "-38px -9px";
	        } else {
	          l.style.color = "blue";
	        }

	      }
	    },
	    error: function(data) {
	      console.log(data);
	    }
	  });
	}


	function likeCheck(e) {
	  var likeBtn = e.target;
	  var no = likeBtn.getAttribute("har-like-no");
	  var url = '';

	  if (likeBtn.getAttribute("har-like-type") == 1) {
	    url = "like";
	  } else if (likeBtn.getAttribute("har-like-type") == 2) {
	    url = "comment/like";
	  } else if (likeBtn.getAttribute("har-like-type") == 3) {
	    url = "reComment/like";
	  }

	  $.ajax(url, {
	    method: "POST",
	    data: "no=" + no,
	    success: function(data) {
	      if (data == "yes") {
	        likeBtn.style.color = "blue";
	      } else if (data == "no") {
	        likeBtn.style.color = "#666";
	      }
	    },
	    error: function(data) {
	    	alert("로그인 후 진행해주세요.");
	    	window.location.href="../login_form";
	    }
	  });

	  location.reload();
	}




	function reCommentAdd(cmtNo, tgNo, fdNo) {
	  var cmtForm = document.getElementById("har-comment-add");
	  var login = cmtForm.querySelector(".har-feed-login").value;

	  cmtForm["action"] = "reComment/add";

	  cmtForm.innerHTML = "<input type='hidden' name='commentNo' value='" + cmtNo + "'/>"
	    + "<input type='hidden' name='taggedMember.no' value='" + tgNo + "'/>"
	    + "<input type='hidden' name='feedNo' value='" + fdNo + "' />"
	    + "<input type='text' name='content' placeholder='답글을 달아주세요.'  class='har-comment-text'/>"
	    + "<input type='submit' value='등록' class='har-comment-btn' onclick='loginCheck()'>";
	    
	    document.querySelector(".har-comment-text").focus();
	}


	var reCmtInputList = document.querySelectorAll(".har-cmt-input");
	var reCmtConfirm = document.querySelectorAll(".har-cmt-confirm");

	for (var e of reCmtInputList) {
	  e.style.display = "none";
	}

	for (var e of reCmtConfirm) {
	  e.style.display = "none";
	}

	function cmtUpdate(e) {
	  var recommentDiv = e.target.parentElement;
	  recommentDiv = recommentDiv.parentElement;

	  recommentDiv.querySelector(".har-cmt-input").style.display = "";
	  recommentDiv.querySelector(".har-cmt-confirm").style.display = "";
	  recommentDiv.querySelector(".har-cmt-content").style.display = "none";
	  recommentDiv.querySelector(".har-cmt-update").style.display = "none";
	}

	function cmtConfirm(e) {
	  var recommentDiv = e.target.parentElement;
	  recommentDiv = recommentDiv.parentElement;
	  var content = recommentDiv.querySelector(".har-cmt-input").value;
	  var no = recommentDiv.getAttribute("har-cmt-no");
	  recommentDiv.querySelector(".har-cmt-input").style.display = "none";
	  recommentDiv.querySelector(".har-cmt-content").style.display = "";

	  var url = '';

	  if (recommentDiv.getAttribute("har-cmt-type") == 1) {
	    url = "comment/update";
	  } else {
	    url = "reComment/update";
	  }

	  $.ajax(url, {
	    method: "POST",
	    data: "no=" + no + "&content=" + content,
	    success: function() {
	    },
	    error: function() {
	      alert("다시 시도해 주세요.");
	      location.reload();
	    }
	  });

	  location.reload();
	}
	
	
	var imageDiv = document.getElementById("har-feed-file");
	var images = imageDiv.querySelectorAll("img");
	
	var firstImg = images[0].style.display = "block";
	
	var imgIndex = (images[0].getAttribute("har-file-no"));
	
	function nextBtn(e) {
		
		if (imgIndex == images[images.length-1].getAttribute("har-file-no")) {
			  imgIndex = (images[0].getAttribute("har-file-no")) -1;
		} 
		
		++imgIndex;
		
		for (var i of images) {
			if (i.getAttribute("har-file-no") == (imgIndex)) {
				i.style.display = "block";
			} else {
				i.style.display = "none";
			}
		}
		
	}
	
	
	function preBtn(e) {
		
    if (imgIndex == images[0].getAttribute("har-file-no")) {
        imgIndex = parseInt(images[images.length-1].getAttribute("har-file-no")) + 1;
    }
    
    --imgIndex;
    
    for (var i of images) {
      if (i.getAttribute("har-file-no") == (imgIndex)) {
        i.style.display = "block";
      } else {
        i.style.display = "none";
      }
    }
    
	}
	
	
	function deleteCheck(link) {
		  var ok = confirm("정말 삭제 하시겠습니까?");
		  
		  if (ok == true) {
			  console.log("옙");
			  location.href=link;
		  } else {
			  return;
		  }
	}
	
	
 	function loginCheck(e, login) {
		var submitBtn = document.querySelector(".har-comment-btn");
		
		console.log(submitBtn);
		
	  if (login == "N") {
		  submitBtn.type="button";
	    alert("로그인 후 다시 시도해주세요.");
	    
	    window.location.href="../login_form";
	  } 
	} 


	</script>

	

</body>
</html>
