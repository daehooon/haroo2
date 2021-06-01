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
</head>
<body>
<h1>튜터에게물어봐</h1>
<p><a href='add'>새 글</a></p>
<table border='1'>
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

<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>
</body>
</html>