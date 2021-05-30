<%@page import="com.bit189.haroo.domain.LearningSchedule"%>
<%@page import="com.bit189.haroo.domain.LearningApplication"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>체험 신청</title>
</head>
<body>
<h1>체험 신청</h1>
<form action='add' method='post'>

<jsp:useBean id="learningApplications" type="List<LearningApplication>" scope="request"/>
<%
for (LearningApplication la : learningApplications) {
%>
<%
}
%>
인원: <input type ='number' name='applySize'><br>
<jsp:useBean id="learningSchedules" type="List<LearningSchedule>" scope="request"/>
날짜: <input type ='Date' name='applySize'><br>
시작 시간: <select name='startTime'>
종료 시간: <select name='endTime'>
</select><br>
</form>
</body>
</html>