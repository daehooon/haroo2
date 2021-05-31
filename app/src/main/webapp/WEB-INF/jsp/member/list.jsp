<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 목록</title>
</head>
<body>
<h1>회원 목록</h1>
<p><a href='add'>회원등록</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>이메일</th> <th></th> <th>전화번호</th> <th>닉네임</th> <th>성별</th>
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="m">
	  <c:if test="${not empty m.profilePicture}">
	    <c:set var="profilePictureUrl">../upload/${m.profilePicture}_30x30.jpg</c:set>
	  </c:if>
	  <c:if test="${empty m.profilePicture}">
	   <c:set var="profilePictureUrl">../upload/_30x30.jpg</c:set>
	  </c:if>
  <tr>
		<td>${m.no}</td>
		<td>${m.name}</td>
		<td><a href='detail?no=${m.no}'>${m.email}</a></td>
		<td><img src='${profilePictureUrl}'></td> 
		<td>${m.tel}</td>
		<td>${m.nickname}</td>
		<td>${m.sex == 1 ? "남" : "여"}</td> 
  </tr>
</c:forEach>

</tbody>
</table>

<form action='list' method='get'>
<input type='search' name='keyword' value='${param.keyword}'> 
<button>검색</button>
</form>
</body>
</html>