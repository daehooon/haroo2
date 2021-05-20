<%@page import="com.bit189.haroo.domain.ReComment"%>
<%@page import="com.bit189.haroo.domain.Comment"%>
<%@page import="java.util.List"%>
<%@page import="com.bit189.haroo.domain.AttachedFile"%>
<%@page import="com.bit189.haroo.domain.Feed"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>피드 수정</title>
</head>
<body>
<h1>피드 수정</h1>
<form action='update' method='post'>
<table border='1'>
<tbody>
<% Feed f = (Feed) request.getAttribute("feed"); %>
<tr><th>번호</th> <td><input type='text' name='no' value='<%= f.getNo() %>' readonly></td></tr>
<tr><th>사진</th> <td>
<% for (AttachedFile file : f.getAttachedFiles()) {%>
<%= file.getName() %>
<% } %>
</td></tr>
<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'><%= f.getContent() %></textarea></td></tr>
</tbody>
</table>
<input type="submit" value="완료">
</form>
<p><a href='list'>취소</a></p>
</body>
</html>
