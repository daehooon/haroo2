<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>문의</title>

</head>
<body>
<h1>문의</h1>
<c:if test="${not empty tutorQuestion}">
<h2>${tutorQuestion.tutor.name}</h2>
<fmt:formatDate value="${tutorQuestion.writingDate}" pattern="yyyy-MM-dd HH:mm:ss" var="writingDate"/>
<form action='update' method='post'>
<table border='1'>
  <tbody>
    <tr><th>번호</th> <td><input type='text' name='no' value='${tutorQuestion.no}' readonly></td>
    <th>조회수</th> <td>${tutorQuestion.viewCount}</td></tr>
    <tr><th>제목</th> <td colspan='5'><input name='title' type='text' value='${tutorQuestion.title}' readonly></td></tr>
    <tr><th>내용</th> <td colspan='5'><textarea name='content' rows='30' cols='180'>${tutorQuestion.content}</textarea></td></tr>
    <tr><th>첨부파일</th> <td>
          <c:forEach items="${tutorQuestion.attachedFiles}" var="file">
            <c:if test="${not empty file.name}">
             <c:set var="photoUrl">../upload/${file.name}_500x500.jpg</c:set>
            </c:if>     
            <img src='${photoUrl}'>
          </c:forEach>
        </td>
      </tr>
 <tr><th>작성자</th> <td>${tutorQuestion.writer.name}</td><th>작성일</th> <td colspan='3'>${writingDate}</td></tr>
    
  </tbody>

 <c:if test="${not empty loginUser and loginUser.no == tutorQuestion.writer.no}">
  <tfoot>
  <tr>
    <td colspan='2'>
      <input type='submit' value='수정'><a href='delete?no=${tutorQuestion.no}'>삭제</a>
    </td>
  </tr>
  
  <c:if test="${not empty loginUser and loginUser.no == tutorQuestion.writer.no}">
  <td colspan='2'>
  <input type='button' value='답글' onclick="changeView(${tutorQuestion.no})">
    </td>
  </c:if>

  </tfoot>    
  </c:if>
  
  </table>
</form>
</c:if>

<c:if test="${empty question}">
<p>해당 번호의 문의글이 없습니다.</p>
</c:if>
<p><a href='list'>목록</a></p>

</body>
</html>