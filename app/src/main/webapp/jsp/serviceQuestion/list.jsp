<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 목록</title>
</head>
<body>
<h1>문의 목록</h1>
<p><a href='add'>새 글</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>조회수</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="q">
    <tr>
    <c:choose>
    <c:when test="${q.secret eq 'N'}">
    <c:out value="${q.title}"/>
    </c:when>
    <c:otherwise>비밀글입니다.</c:otherwise>
    </c:choose>
    <c:when test="${q.secret eq 'Y'}">
    <c:out value="${q.title}"/>
    </c:when>
    
      <td>${q.no}</td>
  <td><a href='detail?rno=${q.no}'>${q.title}</a></td>
  <td>${q.writer.Name}</td>
  <td>${q.registeredDate}</td>
  <td>${q.viewCount}</td>        
    </tr>
</c:forEach>

</tbody>
</table>

<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>
</body>
</html>