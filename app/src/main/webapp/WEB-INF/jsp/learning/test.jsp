<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>체험학습 목록</title>

<style>
div {
  xdisplay: inline-block;
  border: 1px solid rgba(0, 0, 0, .125);
  margin: 15px;
  padding: 10px;
  width: 240px;
  height: 330px;
  text-align: center;
  float: left;
}

div > p {
  border: 1px solid rgba(0, 0, 0, .125);
  xtext-align: center;
}

div > img {
  height: 15px;
}
</style>

</head>
<body>
<%-- <jsp:include page="/jsp/header/header.jsp"/> --%>

<h1>체험학습</h1>

<c:if test="${loginUser.rank == 1 || loginUser.rank == 2}">
<a href='form'>체험학습 등록</a>
</c:if>

<body>

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
      
      <div>
        <a href='detail?no=${l.no}'><img src='${coverUrl}'></a>
        ${l.broadCategory}
        ${l.narrowCategory}
        <br>
        <a href='detail?no=${l.no}'>${l.name}</a>
        <br>
        <!-- 구매횟수 -->
        <img>
        <p>
	        ${l.sido}
	        ${l.sigungu}
	        <br>
	        <a href="../feed/list?no=${l.owner.no}"><img src='${profilePictureUrl}'></a>
	        <a href="../feed/list?no=${l.owner.no}">${l.owner.nickname}</a>
	        ${l.price}
        </p>
      </div>
      
    </c:if>
</c:forEach>

</body>

<%-- <jsp:include page="/jsp/footer/footer.jsp"/> --%>

</body>
</html>