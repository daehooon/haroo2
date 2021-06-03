<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>튜터 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>

<div class="container">
<h1>튜터 목록</h1>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a href='form' class="btn btn-primary btn-sm">튜터등록</a>
    <form class="d-flex">
      <input class="form-control me-2" type="search" name="keyword" value='${param.keyword}' placeholder="검색" aria-label="검색">
      <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
    </form>
  </div>
</nav>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>이메일</th> <th>전화번호</th> 
<th>닉네임</th> <th>성별</th> <th>대분류 - 소분류</th> <th>시도 - 시군구</th> 
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="t">
	  <!-- <c:if test="${not empty t.profilePicture}">
	    <c:set var="profilePictureUrl">../../upload/${t.profilePicture}_30x30.jpg</c:set>
	  </c:if>
	  <c:if test="${empty t.profilePicture}">
	   <c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
	  </c:if> -->
  <trclass="har-email" data-no="${t.no}">
		<td>${t.no}</td>
		<td>${t.name}</td>
		<td><a href='detail?no=${t.no}'>${t.email}</a></td>
		<!--  <td><img src='${profilePictureUrl}'></td> -->
		<td>${t.tel}</td>
		<td>${t.nickname}</td>
		<td>${t.sex == 1 ? "남" : "여"}</td> 
		<c:forEach items="${t.tutorCategories}" var="tc">
		  <td>${tc.broadCategory} - ${tc.narrowCategory}</td>
		</c:forEach>
		<c:forEach items="${t.tutorDistricts}" var="td">
		<td>${td.sido} - ${td.sigungu}</td> 
		</c:forEach> 
  </tr>
</c:forEach>

</tbody>
</table>

</div>

<jsp:include page="/jsp/footer/footer.jsp"/>
<script>
var trList = document.querySelectorAll(".har-email");
for (var tr of trList) {
  tr.querySelector("a").onclick = (e) => {
    e.preventDefault();
  };

  tr.onclick = (e) => {
    var tutorNo = e.currentTarget.getAttribute("data-no");
    location.href = "detail?no=" + tutorNo;
  };

}

</script>
</body>
</html>