<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>문의</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<div class="container">
<h1>문의</h1>
<c:if test="${not empty question}">
<h2>${question.serviceInfo.name}</h2>
<fmt:formatDate value="${question.writingDate}" pattern="yyyy-MM-dd HH:mm:ss" var="writingDate"/>
<form action='update' method='post'>
<table border='1'>
  <tbody>
    <tr><th>번호</th> <td><input type='text' name='no' value='${question.no}' readonly></td>
    <th>조회수</th> <td>${question.viewCount}</td></tr>
    <tr><th>제목</th> <td colspan='5'><input name='title' type='text' value='${question.title}' readonly></td></tr>
    <tr><th>내용</th> <td colspan='5'><textarea name='content' rows='30' cols='180'>${question.content}</textarea></td></tr>
    <tr><th>첨부파일</th> <td>
          <c:forEach items="${question.attachedFiles}" var="file">
            <c:if test="${not empty file.name}">
             <c:set var="photoUrl">../upload/${file.name}_500x500.jpg</c:set>
            </c:if>     
            <img src='${photoUrl}'>
          </c:forEach>
        </td>
      </tr>
 <tr><th>작성자</th> <td>${question.writer.name}</td><th>작성일</th> <td colspan='3'>${writingDate}</td></tr>
    
  </tbody>

 <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
  <tfoot>
  <tr>
    <td colspan='2'>
      <input type='submit' value='수정'><a href='delete?no=${question.no}'>삭제</a>
    </td>
  </tr>
  
  <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
  <td colspan='2'>
  <a href='form2' class="btn btn-outline-primary btn-sm" type="button">답글</a>
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