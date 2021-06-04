<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../../css/har_member_list.css" rel="stylesheet" >

<style>
section {
  width:1100px;
  margin:0 auto;
}

.addBtn {
  width: 80px;
  height: 30px;
  border: 1px solid rgba(0, 0, 0, .125);
  border-radius: 10px;
  margin-top: 20px;
  display: block;
  text-align: center;
  padding-top: 8px;
  font-size: 13px;
  color: #333;
}
</style>

</head>


<body>
<jsp:include page="/jsp/header/header.jsp"/>

<section>
<div class="container">
<h1>회원 목록</h1>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <div class="container-fluid">
    <a href='form' class="btn btn-primary btn-sm">회원등록</a>
    <form class="d-flex">
      <input class="form-control me-2" type="search" name="keyword" value='${param.keyword}' placeholder="검색" aria-label="검색">
      <button class="btn btn-outline-success col-sm-3" type="submit">검색</button>
    </form>
  </div>
</nav>

<table class="table table-hover">
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>이메일</th> <th>전화번호</th> <th>닉네임</th> <th>성별</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="m">
	 <!--   <c:if test="${not empty m.profilePicture}">
	    <c:set var="profilePictureUrl">../../upload/${m.profilePicture}_30x30.jpg</c:set>
	  </c:if>
	  <c:if test="${empty m.profilePicture}">
	   <c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
	  </c:if> 
	  -->
  <tr class="har-email" data-no="${m.no}"> 
		<td>${m.no}</td>
		<td>${m.name}</td>
		<td><a href='detail?no=${m.no}'>${m.email}</a></td>
		<!--  <td><img src='${profilePictureUrl}'></td> -->
		<td>${m.tel}</td>
		<td>${m.nickname}</td>
		<td>${m.sex == 1 ? "남" : "여"}</td> 
  </tr>
</c:forEach>

</tbody>
</table>

</div>
</section>

<jsp:include page="/jsp/footer/footer.jsp"/>

<script>
var trList = document.querySelectorAll(".har-email");
for (var tr of trList) {
  tr.querySelector("a").onclick = (e) => {
    e.preventDefault();
  };

  tr.onclick = (e) => {
    var memberNo = e.currentTarget.getAttribute("data-no");
    location.href = "detail?no=" + memberNo;
  };

}

</script>
</body>
</html>