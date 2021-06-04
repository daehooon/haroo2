<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>튜터에게물어봐</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet">
</head>
<body>

<jsp:include page="/jsp/header/header.jsp"/>
<section>
<div class="container">
<h1>튜터에게물어봐</h1>

<nav class="navbar navbar-dark bg-primary">
  <div class="container-fluid">
 <form class="d-flex">
      <input class="form-control me-2" type="search" name="keyword" value='${param.keyword}' placeholder="검색" aria-label="검색">
      <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
      </form>
</div>
</nav>

<table class="table table-striped table-hover">
<thead>
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>등록일</th>
<th>조회수</th>
</tr>
</thead>
<tbody>
<c:forEach items="${tutorQuestions}" var="tutorQuestion">
<fmt:formatDate value="${tutorQuestion.writingDate}" pattern="yyyy-MM-dd" var="writingDate"/>
<tr> 
    <c:set var="title" value="${tutorQuestion.secret eq '1' || tutorQuestion.writer.no eq loginUser.no ? tutorQuestion.title : '비밀글은 작성자와 튜터만 볼 수 있습니다.'}"/>
      <td>${tutorQuestion.no}</td>
  <td><a href='detail?no=${tutorQuestion.no}'>${title}</a></td>
  <td>${tutorQuestion.writer.nickname}</td>
  <td>${writingDate}</td>
  <td>${tutorQuestion.viewCount}</td>        
    </tr>
</c:forEach>
  
<c:if test="${tutorQuestion.title > 0 }">
<c:forEach begin="1" end="${tutorQuestion.title}">
&nbsp;&nbsp;
</c:forEach>
RE :
</c:if>


</tbody>
</table>
<a href='form' class="btn btn-outline-primary btn-sm" type="button">물어보기</a>
</div>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>

</body>
</html>