<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

.form-control-sm {
    width: 510px;
    display: inline-block;
    margin-bottom: 10px;
}

 .btn-outline-secondary {
    margin: 0;
    float: right;
    border: 1px solid #ced4da;
 }

 .form-label {
     display: block;
 }

 .text-start {
     margin-top: 20px;
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
    
</style>

</head>
<body>
<h1>스토리 작성</h1>

	<section>
		<div id="har-feed-add1">
			<form action="add" method="post" enctype="multipart/form-data">
			<div id="har-feed-add2">
				<div class="mb-3">
					<label for="exampleFormControlTextarea1" class="form-label">내용</label>
					<textarea name="content" class="form-control" id="exampleFormControlTextarea1" ></textarea>
				</div>

				<div class="mb-3">
					<label for="formFileSm" class="form-label form-label2">파일 선택</label> 
					<input class="form-control form-control-sm" name="files" type="file"> 

					<button type="button" class="btn btn-outline-secondary">추가</button>
				</div>

				<p class="text-start">
					<sapn class="har-feed-check">확인해주세요!</sapn> <br> 
					- 이미지만 업로드 가능합니다.<br> 
					- 첫번째로 선택하신 이미지가 피드의 섬네일로 보여집니다.<br> 
					- 이미지의 최대크기는 1000KB 입니다.
				</p>
			</div>


			<button type="submit" class="btn btn-primary">등록</button>
				</form>
		</div>
	</section>

</body>
</html>