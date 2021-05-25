<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>게시글 상세</title>
</head>
<body>
<h1>게시글 상세보기(JSP + JSP 액션태그 + EL)</h1>

<c:if test="${not empty question}">
<form action='update' method='post'>
<table border='1'>
	<tbody>
		<tr><th>번호</th> <td><input type='text' name='no' value='${question.no}' readonly></td></tr>
		<tr><th>제목</th> <td><input name='title' type='text' value='${question.title}'></td></tr>
		<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'>${question.content}</textarea></td></tr>
		<tr><th>작성자</th> <td>${question.writer.name}</td></tr>
		<tr><th>등록일</th> <td>${question.writingDate}</td></tr>
		<tr><th>조회수</th> <td>${question.viewCount}</td></tr>
	</tbody>

  <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
	<tfoot>
	<tr>
	  <td colspan='2'>
	    <input type='submit' value='수정'><a href='delete?no=${board.no}'>삭제</a>
	     <input type="submit" value="답글" onclick=>
	  </td>
	</tr>
	</tfoot>    
  </c:if>
  
</table>
</form>

</c:if>

<c:if test="${empty question}">
<p>해당 번호의 게시글이 없습니다.</p>
</c:if>

<p><a href='list'>목록</a></p>
</body>
</html>