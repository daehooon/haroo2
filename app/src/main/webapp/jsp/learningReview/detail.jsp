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
<title>체험 후기</title>
</head>
<body>
<h1>체험 후기</h1>

<c:if test="${not empty review}">
<h2>${review.serviceInfo.name}</h2>

<fmt:formatDate value="${review.writingDate}" pattern="yyyy-MM-dd hh:mm:ss" var="writingDate"/>
<form action='update' method='post'>
<table border='1'>
  <tbody>
    <tr><th>번호</th> <td><input type='text' name='no' value='${review.no}' readonly></td>
    <th>평점</th> <td>${review.rate}</td> <th>조회수</th> <td>${review.viewCount}</td></tr>
    <tr><th>제목</th> <td colspan='5'><input name='title' type='text' value='${review.title}' readonly></td></tr>
    
    <tr><th>작성자</th> <td>${review.writer.name}</td><th>작성일</th> <td colspan='3'>${writingDate}</td></tr>
    <tr><th>내용</th> <td colspan='5'><textarea name='content'  rows='30' cols='180' readonly>${review.content}</textarea></td></tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
  </tbody>

  <c:if test="${not empty loginUser and loginUser.no == review.writer.no}">
  <tfoot>
  <tr>
    <td colspan='2'>
      <input type='submit' value='수정'><a href='delete?no=${review.no}'>삭제</a>
    </td>
  </tr>
  </tfoot>    
  </c:if>
  
</table>
</form>
</c:if>

<c:if test="${empty review}">
<p>해당 번호의 게시글이 없습니다.</p>
</c:if>

<p><a href='list?lno=${lno}'>목록</a></p>

</body>
</html>