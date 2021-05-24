<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험학습 등록</title>
</head>
<body>
<h1>체험학습 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
커버이미지: <input type="file" name="coverImage"><br>
체험학습 이름(제목): <input type="text" name="name"><br>

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
우편번호: <input type="text" name="zipcode"><br>
기본주소: <input type="text" name="address"><br>
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

상세주소: <input type="text" name="detailAddress"><br>
본문: <textarea name="intro" rows="10" cols="60"></textarea><br>
진행순서: <textarea name="progressOrder" rows="10" cols="30"></textarea><br>
환불정보: <textarea name="refundInformation" rows="10" cols="30"></textarea><br>
최소 인원수: <input type="number" name="minPeople"><br>
최대 인원수: <input type="number" name="maxPeople"><br>

<!-- 날짜: <input type="date" name="learningDate"><br>
시작시각: <input type="time" name="learningStartTime"><br>
종료시각: <input type="time" name="learningEndTime"><br> -->

가격: <input type="number" name="price"><br>
<input type="submit" value="등록">
</form>
</body>
</html>








