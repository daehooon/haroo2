<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>
<section>
<c:if test="${not empty question}">
<meta charset="UTF-8">
<div class="container col-md-6">

   <form action="update" method="post" enctype="multipart/form-data">
    <input type="hidden" name="no" value="${question.no}"/>
        <div class="form-group">
            <label for="exampleFormControlInput1">제목</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" name="title" value="${question.title}" readonly>
        </div>
        <div class="form-group">
            <label for="exampleFormControlInput1">작성자</label>
            <input type="text" class="form-control" id="exampleFormControlInput1" value="${question.writer.name}" readonly>
        </div>
        <div class="form-group">
            <label for="exampleFormControlTextarea1">내용</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="10" name="content">${question.content}</textarea>
        </div>

        <button id= 'har-q-det-upt-btn' class="btn btn-outline-primary btn-sm" >수정하기</button>
        <button type="button" class="btn btn-outline-primary btn-sm" onclick="javascript:history.go(-1)">뒤로가기</button>
        
    </form>
    
</div>
</c:if>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>
<script>


$('#har-q-det-upt-btn').click(()=>{
  var del = confirm('수정하시겠습니까?');
  if(del == true) {
    location.href='update?no=${question.no}';
  } else {
    location.href='detail?lno=${question.no}';
  }
});
</script>
</body>
</html>