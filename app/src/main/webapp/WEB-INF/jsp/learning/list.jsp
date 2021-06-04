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
<jsp:include page="/jsp/header/header.jsp"/>
<section>

<h1>체험학습 목록</h1>

<c:if test="${loginUser.rank == 2}">
<p><a href='form'>체험학습 등록</a></p>
</c:if>

<table border='1'>
<tbody>

<c:forEach items="${learnings}" var="l" >
    <c:if test="${l.state == true}">
    
      <c:if test="${not empty l.coverImage}">
        <c:set var="coverUrl">../../upload/${l.coverImage}_240x160.jpg</c:set>
      </c:if>
      <c:if test="${not empty l.owner.profilePicture}">
        <c:set var="profilePictureUrl">../../upload/${l.owner.profilePicture}_30x30.jpg</c:set>
      </c:if>
      <c:if test="${empty l.owner.profilePicture}">
        <c:set var="profilePictureUrl">../../images/person_30x30.jpg</c:set>
      </c:if>
      
      <tr>
        <td><a href='detail?no=${l.no}'><img src='${coverUrl}'></a></td>
        <td><b>${l.broadCategory}</b></td>
        <td><b>${l.narrowCategory}</b></td>
        <td><a href='detail?no=${l.no}'>${l.name}</a></td>
        <!-- 구매횟수 -->
        <td>${l.sido}</td>
        <td>${l.sigungu}</td>
        
        <td><a href="../tutor/detail?no=${l.owner.no}"><img src='${profilePictureUrl}'></a></td>
        <td><a href="../tutor/detail?no=${l.owner.no}">${l.owner.nickname}</a></td>
        
        <td><b>${l.price}</b></td>
      </tr>
      
    </c:if>
</c:forEach>

</tbody>
</table>

</section>
<jsp:include page="/jsp/footer/footer.jsp"/>

</body>
</html>