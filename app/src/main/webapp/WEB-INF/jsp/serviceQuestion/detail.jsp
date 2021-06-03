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
<jsp:include page="/jsp/header/header.jsp"/>


<div class="container">

<h1>문의</h1>
<c:if test="${not empty question}">

<h2>${question.serviceInfo.name}</h2>
<fmt:formatDate value="${question.writingDate}" pattern="yyyy-MM-dd HH:mm:ss" var="writingDate"/>
<form action='update' method='post'>
<div class="mb-3 row">
    <label for="no" class="col-sm-1 col-form-label">번호</label>
    <div class="col-sm-7">
    <input type='text' class="form-control-plaintext form-control-sm" name='no' value='${question.no}' readonly>
        </div>
  </div>
  <div class="mb-3 row">
    <label for="viewCount" class="col-sm-1 col-form-label">조회수</label>
    <div class="col-sm-7">
    <input type="text" class="form-control-plaintext form-control-sm" id="viewCount" value='${question.viewCount}'>
    </div>
    </div>
    <div class="mb-3 row">
    <label for="title" class="col-sm-1 col-form-label">제목</label>
    <div class="col-sm-7">
   <input type='text' class="form-control form-control-sm" id="title" value='${question.title}' readonly>
   </div>
   </div>
   <div class="mb-3 row">
    <label for="content" class="col-sm-1 col-form-label">내용</label>
    <div class="col-sm-7">
    <textarea class="form-control form-control-sm" id="content" rows='30' cols='180'>${question.content}</textarea>
    </div>
    </div>
     <div class="mb-3 row">
    <label for="file" class="col-sm-1 col-form-label">첨부파일</label>
    <div class="col-sm-7">
          <c:forEach items="${question.attachedFiles}" var="file">
            <c:if test="${not empty file.name}">
             <c:set var="photoUrl">../../upload/${file.name}_300x300.jpg</c:set>
            </c:if>     
            <img src='${photoUrl}'> 
          </c:forEach>
      </div>
      </div>
   <div class="mb-3 row">
    <label for="writer" class="col-sm-1 col-form-label">작성자</label>
    <div class="col-sm-7"> 
    <input type="text" class="form-control-plaintext form-control-sm" id="writer" value='${question.writer.name}'>
    </div>
    </div>
    <div class="mb-3 row">
    <label for="writingDate" class="col-sm-1 col-form-label">작성일</label>
    <div class="col-sm-7">
<input type="text" class="form-control-plaintext form-control-sm" value='${writingDate}'>
    </div>
  </div>
    
 <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
  <tfoot>
  <tr>
    <td colspan='2'>
      <input class="btn btn-outline-primary btn-sm" type="button" value='수정'><a href='delete?no=${question.no}'class="btn btn-outline-primary btn-sm" type="button">삭제</a>
    </td>
  </tr>
  
  <c:if test="${not empty loginUser and loginUser.no == question.writer.no}">
  <td colspan='2'>
  <a href='form2?pno=${question.no}' class="btn btn-outline-primary btn-sm" type="button">답글</a>
    </td>
  </c:if>

  </tfoot>    
  </c:if>
  

</form>
</c:if>

<c:if test="${empty question}">
<p>해당 번호의 문의글이 없습니다.</p>
</c:if>
<p><a href='list'>목록</a></p>

<jsp:include page="/jsp/footer/footer.jsp"/>

</body>
</html>