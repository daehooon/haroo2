<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>문의</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>
<section>

<div class="container">

<h1>문의</h1>
<c:if test="${not empty question}">

<h2>${question.serviceInfo.name}</h2>
<fmt:formatDate value="${question.writingDate}" pattern="yyyy-MM-dd HH:mm:ss" var="writingDate"/>
<form action='update' method='post'>

<div class="container col-md-6">
    <div class="card">
        <div class="card-body">
            <h4 class="card-title mb-3">${question.title}</h4>
            <h6 class="card-subtitle text-muted mb-4">
                <i class="far fa-user"></i> ${question.writer.name}
                ·
                <i class="far fa-clock"></i> ${writingDate}
                ·
                <i class="fas fa-align-justify"></i> ${question.viewCount}
            </h6>
            <p class="card-text">${question.content}</p>
     <h6 class= "card-subtitle text-muted mb-4">   
       <label for="file" ></label>
       <c:forEach items="${question.attachedFiles}" var="file">
            <c:if test="${not empty file.name}">
             <c:set var="photoUrl">../../upload/${file.name}_300x300.jpg</c:set>
            </c:if>     
            <img src='${photoUrl}'> 
  </c:forEach>
     </h6>
        </div>
        <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
   <div class="card-body">
      <a href='updateForm?no=${question.no}' class="btn btn-outline-primary btn-sm" type="button">수정</a>
      <button id='har-q-det-del-btn' class="btn btn-outline-primary btn-sm" type="button">삭제</button>
  </div>
  
  <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
 <div class="card-body">
  <a href='form2?pno=${question.no}' class="btn btn-outline-primary btn-sm" type="button">답글</a>
    </div>
  </c:if>
  
  </c:if>
        <div class="card-body">
            <a href='list' class="btn btn-outline-primary btn-sm" role="button">목록으로</a>
        </div>
    </div>
</div>

</form>
</c:if>

<c:if test="${empty question}">
<p>해당 번호의 문의글이 없습니다.</p>
</c:if>
</section>
  <jsp:include page="/jsp/footer/footer.jsp"/>
  <script>


$('#har-q-det-del-btn').click(()=>{
  var del = confirm('삭제하시겠습니까?');
  if(del == true) {
    location.href='delete?no=${question.no}';
  } else {
    location.href='detail?no=${question.no}';
  }
});
</script>
</body>
</html>