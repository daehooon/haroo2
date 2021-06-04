<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 문의글</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>
<section>
<meta charset="UTF-8">
<div class="container col-md-6">
<h1>문의글</h1>
<form action="add" method="post" enctype="multipart/form-data">

 <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" name="title">
        </div>
         <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" name="content"></textarea>
        </div>
    <div class="form-group">
    <label for="file" class="col-sm-1 col-form-label">파일</label>
    <div class="col-sm-7">
      <input type="file" class="form-control form-control-sm" id="file" name="file">
    </div>
  </div>
<div class="form-check">
  <input class="form-check-input" type="radio" value="1" name="secret">
  <label class="form-check-label" for="secret">
    공개
  </label>
</div>
<div class="form-check">
  <input class="form-check-input" type="radio" value="0" name="secret" checked>
  <label class="form-check-label" for="secret">
    비공개
  </label>
</div>

<button class="btn btn-outline-primary">등록</button>
</form>
</div>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>
</body>
</html>