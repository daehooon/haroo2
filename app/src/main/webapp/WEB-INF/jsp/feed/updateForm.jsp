<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

<style>
 
 section {
     width: 1050px;
     margin: 0 auto;
 }
 
 a {
  text-decoration: none; 
  color: #333;
}

 #har-feed-add1 {
    width: 700px;
    margin: 0 auto;
 }

 #har-feed-add2 {
     width: 700px;
     margin: 0 auto;
     border: 1px solid #ced4da;
     border-radius: 10px;
     padding: 50px 50px 30px 50px;
 }

 .mb-3 {
     width: 600px;
 }

 #exampleFormControlTextarea1 {
     height: 500px;
     resize: none;
     font-size: 14px;
 }
 
 .btn {
     width: 60px;
     height: 30px;
     border-radius: 10px;
     font-size: 13px;
     padding: 0;
     margin-top: 60px;
     float: right;
 }

 .btn2 {
     width: 60px;
     height: 30px;
     border-radius: 10px;
     font-size: 13px;
     padding: 0;
     float: left;
     /* position: relative;
     top:10px; */
 }

.form-control-sm {
    width: 510px;
    display: inline-block;
    margin-bottom: 10px;
}

 .btn-outline-secondary {
    margin-top: 0px;
    /* float: right; */
    border: 1px solid #ced4da;
 }

 .form-label {
     display: block;
 }

 .text-start {
     margin-top: 50px;
     font-size: 11px;
     color: #666;
     line-height:1.8;
 }

 .har-feed-check {
     color: rgb(245, 56, 56);
     font-weight: bold;
 }

.form-label2 {
  margin-top: 30px;
}

.har-file-box {
  display: inline;
}

.listBtn {
  width: 60px;
  height: 30px;
  border: 1px solid rgba(0, 0, 0, .125);
  border-radius: 10px;
  margin-top: 60px;
  margin-right:20px;
  float: right;
  display: block;
  text-align: center;
  padding-top: 5px;
  font-size: 13px;
  color: #333;
}

.listBtn:hover {
  color: #333;
}
    
</style>

</head>
<body>
<h1>스토리 수정</h1>
<c:if test="${not empty feed}">
	<section>
		<div id="har-feed-add1">
			<form action="update" method="post" enctype="multipart/form-data">
			<input type="hidden" name="no" value="${feed.no}"/>
			<div id="har-feed-add2">
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">내용</label>
					<textarea name="content" class="form-control" id="exampleFormControlTextarea1" >${feed.content}</textarea>
				</div>

					<div class="mb-3" id="har-feed-file">
						<label for="formFileSm" class="form-label form-label2">파일선택</label>
						<div class="har-file-box">
						  <div class="har-file-box2">
							<input class="form-control form-control-sm" name="files" type="file">
							<button type="button" class="btn btn-outline-secondary" onclick="fileDeleteBtn(event)" class="har-delete-btn">삭제</button>
						  </div>
						</div>
						<button type="button" class="btn2 btn-outline-secondary" id="har-add-btn">추가</button>
					</div>

					<p class="text-start">
					<span class="har-feed-check">확인해주세요!</span> <br> 
					- 이미지만 업로드 가능합니다.<br> 
					- 첫번째로 선택하신 이미지가 피드의 섬네일로 보여집니다.<br> 
					- 최소 1장 이상의 이미지를 업로드하셔야 합니다.<br> 
					- 업로드 이미지는 최대 10장 입니다.<br> 
					- 이미지의 최대크기는 1000KB 입니다.
				</p>
			</div>


			<button type="submit" id="har-feed-ok" class="btn btn-primary">등록</button>
			<a href='detail?no=${feed.no}' class="listBtn">취소</a>
				</form>
		</div>
	</section>
	</c:if>
	
	<script>
	"use strict"
	
	var btnAddName = document.getElementById("har-add-btn");
	
	btnAddName.onclick = function() {
		var fileDivs = document.querySelectorAll(".har-file-box2");
	    
	  if (fileDivs.length == 10) {
		  alert("최대 열 장의 이미지만 업로드 가능합니다.");
		  return;
	  }
	  
		var inputFile = document.querySelector(".har-file-box");
	
		inputFile.innerHTML += "<div class='har-file-box2'>"
        + "<input class='form-control form-control-sm' name='files' type='file'>"
        + "<button type='button' class='btn btn-outline-secondary' onclick='fileDeleteBtn(event)' class='har-delete-btn'>삭제</button>"
        + "</div>";
	};
	
	
	
	function fileDeleteBtn(e) {
		var fileDivs = document.querySelectorAll(".har-file-box2");
		
		if (fileDivs.length == 1) {
			alert("최소 한 장 이상의 이미지를 업로드 하셔야합니다.");
		  return;
		}		
		
		var fileBox = e.target.parentElement;
		fileBox = fileBox.parentElement;
		var child = e.target.parentElement;
		
		fileBox.removeChild(child);
	}
	
	
	var okBtn = document.getElementById("har-feed-ok");
	  
	okBtn.onclick = function() {
	    
	};
	</script>

</body>
</html>