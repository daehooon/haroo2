<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>피드 상세</title>
<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<style type="text/css">
  .profile-photo {
    width : 35px;
    height : 35px;
    border-radius: 10px;
  }
  
</style>
</head>
<body>
	<h1>피드 상세보기</h1>
	
	
	
	<c:if test="${not empty feed}">
	<fmt:formatDate value="${feed.writingDate}" pattern="yyyy-MM-dd" var="writingDate2"/>
		<form action='update' method='post'>
			<table border='1'>
			<tbody>
			<tr><th>번호</th> <td><input type='text' name='no' value='${feed.no}' readonly></td></tr>
			<tr><th>프로필사진</th> <td><div class="profile-photo">${feed.writer.profilePicture}</div></td></tr>
			<tr><th>튜터이름</th> <td>${feed.writer.name}</td></tr>
			
			<tr><th>등록일</th> <td>${writingDate2}</td></tr>
			<tr>
				<th>사진</th>
				<td>
					<c:forEach items="${feed.attachedFiles}" var="file">
						<c:if test="${not empty file.name}">
	           <c:set var="photoUrl">../../upload/${file.name}_500x500.jpg</c:set>
	          </c:if>
	          
					  <img src='${photoUrl}'>
					</c:forEach>
				</td>
			</tr>
			<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'>${feed.content}</textarea></td></tr>
			<tr><th>조회수</th> <td>${feed.viewCount}</td></tr>
			<tr><th>좋아요수</th> <td>${feed.likeCount}</td></tr>
			<tr><th>댓글수</th> <td>${feed.commentCount}</td></tr>
			</tbody>
			</table>
			
			<c:if test="${not empty loginUser and loginUser.no == feed.writer.no}">
			 <input type="submit" value="수정">
			 <a href="delete?no=${feed.no}">삭제</a>
			</c:if>
		</form>
		
		<button type="button" class="har-like" har-like-no="${feed.no}" har-like-type="1" onclick="likeCheck(event)">좋아요</button>
	
	
		<c:forEach items="${comments}" var="comment">
		  <div har-cmt-no="${comment.no}" har-feed-no="${feed.no}" har-cmt-type="1">
				<c:if test="${comment.state == true}">
				  <b>${comment.writer.name}</b> 
					<span class="har-cmt-content">${comment.content}</span>
					<input type="text" class="har-cmt-input" value="${comment.content}">
					<span>좋아요 ${comment.likeCount}개</span>
					<button type="button" class="har-like" har-like-no="${comment.no}" har-like-type="2" onclick="likeCheck(event)">댓글좋아요</button>
					<button type="button" onclick="reCommentAdd(${comment.no},${comment.writer.no},${feed.no})">답글달기</button>
		     	
		     	<c:if test="${not empty loginUser and loginUser.no == comment.writer.no}">
		     	  <button type="button" onclick="cmtUpdate(event)" class="har-cmt-update">수정</button>
	          <button type="button" onclick="cmtConfirm(event)" class="har-cmt-confirm">확인</button>
		     	  <a href="comment/delete?no=${comment.no}&feedNo=${feed.no}">댓글삭제</a>
		     	</c:if>
	     	</c:if>
	     	
	     	<c:if test="${comment.state == false}">
          <span>삭제 된 댓글입니다.</span>
        </c:if>
	    </div>
     	
		  <c:forEach items="${comment.reComments}" var="reComment">
			  <c:if test="${reComment.state == true}">
			    <div har-cmt-no="${reComment.no}" har-feed-no="${feed.no}" har-cmt-type="2">
						<b>${reComment.reWriter.name}</b> @${reComment.taggedMember.name} 
						<span class="har-cmt-content">${reComment.content}</span>
						<input type="text" class="har-cmt-input" value="${reComment.content}">
						<span>좋아요 ${reComment.likeCount}개</span>
		        <button type="button" class="har-like" har-like-no="${reComment.no}" har-like-type="3" onclick="likeCheck(event)">대댓글좋아요</button>
		        <button type="button" onclick="reCommentAdd(${comment.no},${reComment.reWriter.no},${feed.no})">답글달기</button>
		        
		        <c:if test="${not empty loginUser and loginUser.no == reComment.reWriter.no}">
		          <button type="button" onclick="cmtUpdate(event)" class="har-cmt-update">수정</button>
		          <button type="button" onclick="cmtConfirm(event)" class="har-cmt-confirm">확인</button>
		          <a href="reComment/delete?no=${reComment.no}&feedNo=${feed.no}">대댓글삭제</a>
		        </c:if>
	        </div>
				</c:if>
		  </c:forEach>
		</c:forEach>
		
		<form action='comment/add' method='post' id="har-comment-add">
			<input type="hidden" name="no" value="${feed.no}" />
			<input type="text" name="content" placeholder="댓글을 달아주세요."/>
			<input type='submit' value='등록'>
		</form>
		
	</c:if>
	
	<c:if test="${empty feed}">
   <p>없는 피드입니다.</p>
  </c:if>
	
	<p><a href='list'>목록</a></p>
	
	<script>
	"use strict"
	
	 var likeBtns = document.querySelectorAll(".har-like");
	
	 for (var l of likeBtns)  {
		 var no = l.getAttribute("har-like-no");
		 var lType = l.getAttribute("har-like-type");
		 
		 $.ajax("likeCheck", {
			 method: "POST",
			 data:"no=" + no + "&lType=" + lType,
			 success: function(data) {
				 console.log(no, data);
				 if (data == "yes") {
					  l.style.color = "blue";
				 } 
				 
				 if (data == "no") {
					  l.style.color = "red";
				 }
			 },
			 error : function(data) {
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
			  data:"no=" + no,
		    success: function(data) {
		      console.log(data);
		      if (data == "yes") {
		    	  likeBtn.style.color = "blue";
		      } else if (data == "no") {
		    	  likeBtn.style.color = "red";
	        }
		    },
		    error : function(data) {
		    	console.log(data);
		    }
	    });
			
			location.reload();
	  }
	
		
	
	
		function reCommentAdd(cmtNo, tgNo, fdNo) {
		    var cmtForm = document.getElementById("har-comment-add");
		    var originForm = cmtForm.innerHTML;
		    
		    cmtForm["action"] = "reComment/add";
		    
		    cmtForm.innerHTML = "<input type='hidden' name='commentNo' value='" + cmtNo + "'/>" 
		         + "<input type='hidden' name='taggedNo' value='" + tgNo + "'/>"
		         + "<input type='hidden' name='no' value='" + fdNo + "' />"
		         + "<input type='text' name='content' placeholder='댓글을 달아주세요.'/>"
		         + "<input type='submit' value='등록'>";
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
		 /* console.log("e.target", e.target); */
		 var recommentDiv = e.target.parentElement;
		 recommentDiv.querySelector(".har-cmt-input").style.display = "";
		 recommentDiv.querySelector(".har-cmt-confirm").style.display = "";
		 recommentDiv.querySelector(".har-cmt-content").style.display = "none";
		 recommentDiv.querySelector(".har-cmt-update").style.display = "none";
	 }
	 
	 function cmtConfirm(e) {
     var recommentDiv = e.target.parentElement;
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
	     	 method : "POST",
	     	 data : "no=" + no + "&content=" + content,
	     	 success : function() {
	     		 alert("성공했습니다.");
	     	 },
	     	 error : function() {
	     		 alert("실패했습니다.");
	     	 }
      });
      
      location.reload();
   }
	 
	</script>
</body>
</html>
