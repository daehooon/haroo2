<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>체험학습 목록</title>
</head>
<body>
<h1>체험학습 목록</h1>

<!-- 체험학습 한 개당 한 쌍씩 -->
<p><a href='basket'>장바구니에 넣기</a></p>
<p><a href='wish'>찜하기</a></p>

  <c:if test="${loginUser.rank == 1 || loginUser.rank == 2}">
    <p><a href='add'>체험학습 등록</a></p>
  </c:if>

<table border='1'>
<thead>
<tr>
<th>썸네일</th> <th>대분류</th> <th>소분류</th> <th>제목</th> <!-- <th>구매횟수</th> -->
<th>광역시도</th> <th>시군구</th> <th>튜터프로필사진</th> <th>튜터명</th> <th>가격</th>
</tr>
</thead>
<tbody>

<c:forEach items="${learnings}" var="l" >
    <c:if test="${l.state == true}">
    
      <c:if test="${not empty l.coverImage}">
        <c:set var="coverUrl">../upload/${l.coverImage}_240x160.jpg</c:set>
      </c:if>
      <c:if test="${not empty l.owner.profilePicture}">
        <c:set var="profilePictureUrl">../upload/${l.owner.profilePicture}_30x30.jpg</c:set>
      </c:if>
      <c:if test="${empty l.owner.profilePicture}">
        <c:set var="profilePictureUrl">../images/person_30x30.jpg</c:set>
      </c:if>
      
			<tr>
			  <td><img src='${coverUrl}'></td>
			  <td>${l.broadCategory}</td>
			  <td>${l.narrowCategory}</td>
			  <td><a href='detail?no=${l.no}'>${l.name}</a></td>
			  <td>${l.sido}</td>
			  <!-- 구매횟수 -->
			  <td>${l.sigungu}</td>
			  
			  <!-- 튜터 마이페이지 링크 연결하기 -->
			  <td><img src='${profilePictureUrl}'></td>
			  <td>${l.owner.nickname}</td>
			  
			  <td>${l.price}</td>
			</tr>
			
    </c:if>
</c:forEach>

</tbody>
</table>

</body>
</html>