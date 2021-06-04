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
<title>체험 후기 목록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

<jsp:include page="/jsp/header/header.jsp"/>

<section>
<div class="container">
<h1>체험 후기 목록</h1>
<h2>${learning.name}</h2>
<!-- 러닝.평균평점 만들기 -->

<p><a href='form?lno=${learning.no}'>후기 작성</a></p>

<c:if test="${empty reviews}">
  <p>아직 작성된 후기가 없습니다.</p> 
</c:if>
  <c:if test="${not empty reviews}">
    <c:if test="${param.sortingItem != 'rate' and param.sortingItem != 'rcm_cnt'}">
      <c:set var="pnoSortingType" value="${param.sortingType == 'a' ? 'd' : 'a'}"/>
    </c:if>
    <c:if test="${param.sortingItem == 'rate'}">
      <c:set var="rateSortingType" value="${param.sortingType == 'a' ? 'd' : 'a'}"/>
    </c:if>
    <c:if test="${param.sortingItem == 'rcm_cnt'}">
      <c:set var="rcm_cntSortingType" value="${param.sortingType == 'a' ? 'd' : 'a'}"/> 
    </c:if>
 <table border='1' class="table">
 <thead class="table-light">
 <tr>
  <th>
    <a href="list?lno=${learning.no}&sortingItem=pno&sortingType=${pnoSortingType}">번호
    ${pnoSortingType == 'a' ? '▼' : '▲'}</a>
  </th>
  <th>제목</th> 
  <th>작성자</th> 
  <th>작성일</th> 
  <th>
    <a href="list?lno=${learning.no}&sortingItem=rate&sortingType=${rateSortingType}">평점
    ${rateSortingType == 'a' ? '▼' : '▲'}</a>
  </th>
  <th>조회수</th> 
  <th>
    <a href="list?lno=${learning.no}&sortingItem=rcm_cnt&sortingType=${rcm_cntSortingType}">추천수
    ${rcm_cntSortingType == 'a' ? '▼' : '▲'}</a>
  </th>
</tr>
</thead>
<tbody>
  <c:forEach items="${reviews}" var="r">
    <tr>
    <fmt:formatDate value="${r.writingDate}" pattern="yyyy-MM-dd" var="writingDate"/>
      <td>${r.no}</td>
      <td><a href='detail?lno=${learning.no}&rno=${r.no}'>${r.title}</a></td>
      <td>${r.writer.nickname}</td>
      <td>${writingDate}</td>
      <td>${r.rate}</td>
      <td>${r.viewCount}</td>
      <td>${r.recommendCount}</td>
    </tr>
  </c:forEach>
</tbody>
</table>
<!--
<form action='search' method='get'>
<input type='text' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>
-->
</c:if>
</div>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>
<script>
if (${mode} == 1) {
   var login = confirm("로그인이 필요합니다. 로그인으로 이동합니다.");
   if (login) {
     location.href="../../login_form";
   }
} else if (${mode} == 2) {
	$(document).ready(() => {
     alert("신청하지 않은 체험학습 입니다.");
   });
} else if (${mode} == 3) {
	$(document).ready(() => {
     alert("이미 후기를 작성 하였습니다.");
   });
}

/*
$('#har-lrv-li-login-btn').click(()=> {
	if (confirm("로그인이 필요합니다. 로그인으로 이동합니다.")) {
		location.href="../../login_form";
	}
});
*/

</script>
</body>
</html>