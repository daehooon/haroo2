<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험학습 수정</title>
</head>
<body>
<h1>체험학습 수정</h1>
<c:if test="${not empty learning}">
<form action="update" method="post" enctype="multipart/form-data">

<input type='hidden' name='no' value='${learning.no}'>

커버이미지: <input type="file" name="coverImage" value="${learning.coverImage}"><br>
체험학습 이름(제목): <input type="text" name="name" value="${learning.name}"><br>

<!-- 기존 분류 가져오기로 수정 -->
대분류: <select name='broadCategoryNo'>
<c:forEach items="${broadCategorys}" var="b">
  <option value='${b.no}'>${b.name}</option>
</c:forEach>
</select><br>
소분류: <select name='narrowCategoryNo'>
<c:forEach items="${narrowCategorys}" var="n">
  <option value='${n.no}'>${n.name}</option>
</c:forEach>
</select><br>

<!-- 추후 우편번호 API로 수정 -->
우편번호: <input type="text" name="zipcode" value="${learning.zipcode}"><br>
기본주소: <input type="text" name="address" value="${learning.address}"><br>
<!-- 기존 지역 가져오기로 수정 -->
광역시도: <select name='sidoNo'>
<c:forEach items="${sidos}" var="d">
  <option value='${d.no}'>${d.name}</option>
</c:forEach>
</select>
시군구: <select name='sigunguNo'>
<c:forEach items="${sigungus}" var="g">
  <option value='${g.no}'>${g.name}</option>
</c:forEach>
</select><br>

상세주소: <input type="text" name="detailAddress" value="${learning.detailAddress}"><br>
본문: <textarea name="intro" rows="10" cols="60">${learning.intro}</textarea><br>
진행순서: <textarea name="progressOrder" rows="10" cols="30"${learning.progressOrder}></textarea><br>
환불정보: <textarea name="refundInformation" rows="10" cols="30">${learning.refundInformation}</textarea><br>
최소 인원수: <input type="number" name="minPeople" value="${learning.minPeople}"><br>
최대 인원수: <input type="number" name="maxPeople" value="${learning.maxPeople}"><br>

날짜: <input type="date" name="learningDate" value="${learningSchedule.learningDate}"><br>
시작시각: <input type="time" name="learningStartTime" value="${learningSchedule.startTime}"><br>
종료시각: <input type="time" name="learningEndTime" value="${learningSchedule.endTime}"><br>

가격: <input type="number" name="price" value="${learning.price}"><br>
<input type="submit" value="변경">
</form>
</c:if>

<c:if test="${empty learning}">
  <p>해당 번호의 체험학습이 없습니다.</p>
</c:if>

</body>
</html>







