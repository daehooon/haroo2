<%@page import="com.bit189.haroo.domain.Feed"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>스토리 목록</title>
</head>
<body>
<h1>스토리 목록</h1>
<p><a href='add.html'>스토리 등록</a></p>
<table border='1'>
<thead>
<tr>
<th>프로필사진</th> <th>이름</th> <th>등록일자</th> <th>사진</th> <th>좋아요수</th> <th>댓글수</th>
</tr>
</thead>
<tbody>
<% List<Feed> feeds = (List<Feed>) request.getAttribute("feeds"); %>
<% for (Feed f : feeds)  { %>
<tr><td><%= f.getWriter().getProfilePicture() %></td> <td><%= f.getWriter().getName() %></td> <td><%= f.getWritingDate() %></td> 
<td><a href='detail?no=<%= f.getNo() %>'><%= f.getAttachedFiles().get(0).getName() %></a></td> 
<td><%= f.getLikeCount() %></td>
<td><%= f.getCommentCount() %></td></tr>
<% } %>
</tbody>
</table>
</body>
</html>
