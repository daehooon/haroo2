<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<title>체험 신청</title>
</head>
<body>
<h1>체험 신청 정보</h1>

<c:if test="${not empty learningApplication}">
<fmt:formatDate value="${learningApplication.registeredDate}" pattern="yyyy-MM-dd hh:mm:ss"  var="registeredDate"/>
  <table border='1'>
<tbody>
<tr><th>신청 번호</th> <td><input type='text' name='no' value='${learningApplication.no}' readonly></td></tr>
<tr><th>회원 이름</th> <td><input type='text' id="writer" value='${learningApplication.writer.nickname}' readonly></td></tr>
  <fmt:formatDate value="${learningApplication.schedules[0].learningDate}" pattern="yyyy-MM-dd" var="learningDate"/>
  <fmt:formatDate value="${learningApplication.schedules[0].startTime}" pattern="HH:mm" var="startTime"/>
  <fmt:formatDate value="${learningApplication.schedules[0].endTime}" pattern="HH:mm" var="endTime"/>
  <tr><th>체험날짜</th> <td>${learningDate}</td></tr>
      <tr><th>시작시간</th> <td>${startTime}</td></tr>
      <tr><th>종료시간</th> <td>${endTime}</td></tr>
<tr><th>인원수</th> <td>${learningApplication.applySize}</td></tr>
<tr><th>등록일</th> <td>${registeredDate}</td></tr>
</tbody>
</table>
<tfoot>
<a href='delete?no=${learningApplication.no}'>환불</a>
</tfoot>

</c:if>

<p><a href='list'>목록</a></p>

<c:if test="${empty learningApplication}">
  <p>해당 번호의 체험학습이 없습니다.</p>
</c:if>

</body>
</html>