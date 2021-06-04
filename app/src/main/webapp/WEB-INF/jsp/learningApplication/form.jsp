<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>체험 신청</title>
</head>
<body>
<h1>체험 신청</h1>
<form action='add' method='post'>

신청 인원: <input type ='number' name='applySize'><br>

날짜: <input type="date" name="learningDate"><br>
시작시각: <input type="time" name="startTime"><br>
종료시각: <input type="time" name="endTime"><br>

<input type="submit" value="신청" >
</form>
</body>
</html>