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
<title>피드 상세</title>
</head>
<body>
<h1>피드 상세보기</h1>
<form action='update' method='post'>
<table border='1'>
<tbody>
<% Feed f = (Feed) request.getAttribute("feed"); %>
<% List<Comment> comments = (List<Comment>) request.getAttribute("comments"); %>
<tr><th>번호</th> <td><input type='text' name='no' value='<%= f.getNo() %>' readonly></td></tr>
<tr><th>프로필사진</th> <td><%= f.getWriter().getProfilePicture() %></td></tr>
<tr><th>튜터이름</th> <td><%= f.getWriter().getName() %></td></tr>
<tr><th>등록일</th> <td><%= f.getWritingDate() %></td></tr>
<tr><th>사진</th> <td>
<% for (AttachedFile file : f.getAttachedFiles()) {%>
<%= file.getName() %>
<% } %>
</td></tr>
<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'><%= f.getContent() %></textarea></td></tr>
<tr><th>조회수</th> <td><%= f.getViewCount() %></td></tr>
<tr><th>좋아요수</th> <td><%= f.getLikeCount() %></td></tr>
<tr><th>댓글수</th> <td><%= f.getCommentCount() %></td></tr>
</tbody>
</table>
<input type="submit" value="수정">
</form>
<% for (Comment c : comments)  { %>
<pre><b><%= c.getWriter().getName() %></b> <%= c.getContent() %></pre>
<% for (ReComment r : c.getReComments())  {%>
<pre>     <b><%= r.getReWriter().getName() %></b> <%= r.getTaggedMember().getName() %> <%= r.getContent() %></pre>
<% } %>
<% } %>
<form action='../comment/add' method='post'>
<input type="hidden" name="no" value="<%= f.getNo() %>" />
<input type='text' name='content' placeholder="댓글을 남주세요.">
<input type='submit' value='등록'>
</form>
<p><a href='list'>목록</a></p>
</body>
</html>
