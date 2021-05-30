<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>튜터 목록</title>
</head>
<body>
<h1>튜터 목록</h1>
<p><a href='add'>튜터등록</a></p>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>이름</th> <th>이메일</th> <th></th> <th>전화번호</th> 
<th>닉네임</th> <th>성별</th> <!-- <th>대분류</th> <th>소분류</th> <th>시도</th> <th>시군구</th>-->
</tr>
</thead>
<tbody>
<c:forEach items="${list}" var="t">
	  <c:if test="${not empty t.profilePicture}">
	    <c:set var="profilePictureUrl">../../upload/${t.profilePicture}_30x30.jpg</c:set>
	  </c:if>
	  <c:if test="${empty t.profilePicture}">
	   <c:set var="profilePictureUrl">../../upload/_30x30.jpg</c:set>
	  </c:if>
  <tr>
		<td>${t.no}</td>
		<td>${t.name}</td>
		<td><a href='detail?no=${t.no}'>${t.email}</a></td>
		<td><img src='${profilePictureUrl}'></td> 
		<td>${t.tel}</td>
		<td>${t.nickname}</td>
		<td>${t.sex == 1 ? "남" : "여"}</td> 
		<!-- <c:forEach items="${t.tutorCategories}" var="tc">
		  <td>${tc.broadCategory}, ${tc.narrowCategory}</td>
		</c:forEach>
		<c:forEach items="${t.tutorDistricts}" var="td">
		<td>${td.sido}, ${td.sigungu}</td> 
		</c:forEach> -->
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