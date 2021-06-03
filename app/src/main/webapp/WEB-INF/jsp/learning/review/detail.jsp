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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>체험 후기</title>
</head>
<body>

<jsp:include page="/jsp/header/header.jsp"/>
<h1>체험 후기</h1>

<c:if test="${not empty review}">
<h2>${review.serviceInfo.name}</h2>

<fmt:formatDate value="${review.writingDate}" pattern="yyyy-MM-dd hh:mm:ss" var="writingDate"/>
<form action='update' method='post'>
<table border='1'>
  <tbody>
    <tr><th>번호</th> <td><input type='text' name='no' value='${review.no}' readonly></td>
	    <th>평점</th> <td><input class='har-lrv-det-updatable' name='rate' type='text' value='${review.rate}' readonly></td>
	    <th>조회수</th> <td>${review.viewCount}</td>
    </tr>
    <tr>
      <th>제목</th> <td colspan='3'><input class='har-lrv-det-updatable'
       name='title' type='text' value='${review.title}' readonly></td>
       <th>추천수</th> <td>${review.recommendCount}</td>
      </tr>
    <tr>
	    <th>작성자</th> <td>${review.writer.nickname}</td>
	    <th>작성일</th> <td colspan='3'>${writingDate}</td>
    </tr>
    <tr>
      <th>내용</th> <td colspan='5'><textarea class='har-lrv-det-updatable' name='content' 
      rows='30' cols='180' readonly>${review.content}</textarea></td>
    </tr>
    <tr></tr>
    <tr></tr>
    <tr></tr>
  </tbody>
</table>
<input class='har-lrv-det-up' type='submit' style='display: none;' value='확인'><a class='har-lrv-det-up' style='display: none;'>취소</a>
</form>
	<c:if test="${not empty loginUser and loginUser.no == review.writer.no}">
	  <button id='har-lrv-det-up-btn' class = 'har-lrv-det-up-hid'>수정</button><a class = 'har-lrv-det-up-hid' href='delete?rno=${review.no}'>삭제</a>
	</c:if>
	<c:if test="${not empty loginUser and loginUser.no != review.writer.no}">
   <c:if test="${isRecommended == 'false'}">
     <form action='recommend' method='post'>
       <input name='lno' type='hidden' value='${review.serviceInfo.no}'>
       <input name='mno' type='hidden' value='${loginUser.no}'>
       <input name='rno' type='hidden' value='${review.no}'>
       <input id='har-lrv-det-rcm-btn' type='submit' value='추천'>
     </form>
   </c:if>
   <c:if test="${isRecommended == 'true'}">
     <form action='unRecommend' method='post'>
       <input name='lno' type='hidden' value='${review.serviceInfo.no}'>
       <input name='mno' type='hidden' value='${loginUser.no}'>
       <input name='rno' type='hidden' value='${review.no}'>
       <input id='har-lrv-det-unrcm-btn' type='submit' value='추천 취소'>
     </form>
   </c:if>
	</c:if>
	
</c:if>

<c:if test="${empty review}">
<p>해당 번호의 게시글이 없습니다.</p>
</c:if>

<p><a href='list?lno=${review.serviceInfo.no}'>목록</a></p>

  <jsp:include page="/jsp/footer/footer.jsp"/>
<script>
"use stricet";

$("#har-lrv-det-up-btn").click(() => {
	console.log("클릭");
	$('.har-lrv-det-up-hid').css('display','none');
	$('.har-lrv-det-up').css('display','inline-block');
	$('.har-lrv-det-updatable').attr('readonly',false);
});

/*
$('#har-lrv-det-rcm-btn').click(() => {
	
});

$('#har-lrv-det-unrcm-btn').click(() => {
	  
});
*/
</script>
</body>
</html>