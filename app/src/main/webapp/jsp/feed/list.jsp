<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>스토리 목록</title>
</head>
<body>
	<h1>스토리 목록(JSTL)</h1>
	
	<p><a href='add'>스토리 등록</a></p>
	
	<table border='1'>
		<thead>
			<tr>
			<th>프로필사진</th>
			<th>이름</th>
			<th>등록일자</th>
			<th>사진</th>
			<th>좋아요수</th>
			<th>댓글수</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${feeds}" var="feed">
				<c:if test="${not empty feed.attachedFiles.get(0)}">
	       <c:set var="photoUrl">../../upload/${feed.attachedFiles.get(0).name}_330x220.jpg</c:set>
	      </c:if>
			<tr>
			 <td>${feed.writer.profilePicture}</td>
			 <td>${feed.writer.name}</td>
			 <td>${feed.writingDate}</td> 
			 <td><a href='detail?no=${feed.no}'><img src='${photoUrl}'></a></td> 
			 <td>${feed.likeCount}</td>
			 <td>${feed.commentCount}</td></tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
