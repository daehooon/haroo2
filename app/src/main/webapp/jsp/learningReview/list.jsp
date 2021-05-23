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
<title>체험 후기</title>
</head>
<body>
<h1>체험 후기</h1>
<h2>${learninng.name}</h2>
<c:if test="${empty reviews}">
  <p>아직 작성된 후기가 없습니다.</p> 
</c:if>

<c:if test="${not empty reviews}">
  <table border='1'>
  <thead>
  <tr>
    <th>번호</th> <th>제목</th> <th>작성자</th> <th>작성일</th> 
    <th>평점</th> <th>조회수</th> <th>추천수</th>
  </tr>
	</thead>
	<tbody>
  <c:forEach items="${tasks}" var="t">
    <tr>
	  <td>${r.no}</td>
	  <td><a href='detail?rno=${r.no}'>${r.title}</a></td>
	  <td>${r.writer.nickName}</td>
	  <td>${r.registeredDate}</td>
	  <td>${r.rate}</td>
	  <td>${r.viewCount}</td>
	  <td>${r.recommendCount}</td>
	  </tr>
  </c:forEach>
  </tbody>
  </table>
</c:if>

<form action='search' method='get'>
<input type='text' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>
</body>
</html>