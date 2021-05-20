<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>체험 신청</title>
</head>
<body>
<h1>체험 신청 정보</h1>
<form action="update" method='post'>
<table border='1'>
<tbody>
<tr><th>신청 번호</th> <td><input type='text' name='no' value='${learningApplication.no}' readonly></td></tr>
<tr><th>회원 번호</th> <td><input type='text' name='no' value='${learningApplication.memberNo}' readonly></td></tr>
<!--  
<tr><th>날짜</th> <td>${learningSchedule.LearningDate}</td></tr>
<tr><th>시작 시간</th> <td>${learningSchedule.startTime}</td></tr>
<tr><th>종료 시간</th> <td>${learningSchedule.endTime}</td></tr>
-->
<tr><th>인원수</th> <td>${learningApplications.applySize}</td></tr>
<tr><th>등록일</th> <td>${learningApplications.registeredDate2}</td></tr>
</tbody>
<tfoot>
<a href='delete?no=${learningApplications.no}'>환불</a>
</tfoot>
</form>
<p><a href='list'>목록</a></p>
</body>
</html>