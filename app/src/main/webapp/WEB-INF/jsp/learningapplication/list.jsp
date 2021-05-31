<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.bit189.haroo.domain.LearningApplication"%>
<%@page import="java.util.List"%>
<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>체험 신청 목록</title>
</head>
<body>
<h1>체험 신청 목록</h1>
<% 
List<LearningApplication> list = (List<LearningApplication>) request.getAttribute("list");
for (LearningApplication l : list) { }
%>
<h2></h2>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>날짜</th> <th>수업 시간</th> <th>인원</th> <th>등록 시간</th>
</tr>
</thead>
<tbody> 

<c:forEach items= "${list}" var="l">

<tr>
<td colspan='5'>해당 번호의 체험 학습이 없습니다.</td>
</tr> 

  <tr> 
  <td>${l.No}</td>
  <td><a href='detail?no=${l.no}'></a></td> 
  <!--  
  <td>${l.Schedules}</td>
  -->
  <td>${l.ApplySize}</td>
  <td>${l.RegisteredDate}</td> 

  </tr>  
</c:forEach>
</tbody>
</table>
</body>
</html>