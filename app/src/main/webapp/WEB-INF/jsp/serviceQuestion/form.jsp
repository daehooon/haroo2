<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 문의글</title>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>

<div class="container">
<h1>문의글</h1>
<form action="add" method="post" enctype="multipart/form-data">
<div class="mb-3 row">
    <label for="title" class="col-sm-1 col-form-label">제목</label>
    <div class="col-sm-7">
      <input type="text" class="form-control form-control-sm" id="title" name="title">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="content" class="col-sm-1 col-form-label">내용</label>
    <div class="col-sm-7">
      <textarea class="form-control form-control-sm" id="content"name="content" rows="10" cols="60"></textarea>
    </div>
  </div>
<div class="custom-file">
            <input type="file" class="custom-file-input" id="file">
            <label class="custom-file-label" for="file">첨부파일</label>
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

<jsp:include page="/jsp/footer/footer.jsp"/>
</body>
</html>