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
</head>
<body>
<h1>체험 후기 목록</h1>
<h2>${learning.name}</h2>
<!-- 러닝.평균평점 만들기 -->
<p><a href='add'>후기 작성</a></p>

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
 <table border='1'>
 <thead>
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

<form action='search' method='get'>
<input type='text' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>
</c:if>
</body>
</html>