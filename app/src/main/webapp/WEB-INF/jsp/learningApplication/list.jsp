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
<title>체험 신청 목록</title>
</head>
<body>
<meta charset="UTF-8">
<jsp:include page="/jsp/header/header.jsp"/>
<section>
<h1>체험 신청 목록</h1>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet">
<div class="container">

<nav class="navbar navbar-expand-lg navbar-light bg-light">
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
<th>번호</th> <th>신청자</th> <th>인원</th> <th>등록일</th>
</tr>
</thead>
<tbody> 

<c:forEach items="${learningApplication}" var="l" >
<fmt:formatDate value="${l.registeredDate}" pattern="yyyy-MM-dd" var="registeredDate"/>
  <tr> 
  <td>${l.no}</td>
  <td><a href='detail?no=${l.no}'>${l.writer.nickname}</a></td>
  <td>${l.applySize}</td>
  <td>${registeredDate}</td> 

  </tr>  
</c:forEach>

</tbody>
</table>
<a href='form' class="btn btn-outline-primary btn-sm" type="button">신청하기</a>
</div>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>
</body>
</html>