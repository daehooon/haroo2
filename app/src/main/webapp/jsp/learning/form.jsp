<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험학습 등록</title>
</head>
<body>
<h1>체험학습 등록</h1>
<form action="add" method="post">
커버이미지: <input type="file" name="coverImage"><br>
체험학습 이름(제목): <input type="text" name="name"><br>
<!-- 대분류 -->
  <!-- 소분류 -->
<!-- 우편번호 -->
  <!-- 기본주소, 광역시도명, 시군구명 자동출력-->
상세주소: <input type="text" name="detailAddress"><br>
본문: <textarea name="content" rows="10" cols="60"></textarea><br>
진행순서: <textarea name="content" rows="10" cols="30"></textarea><br>
환불정보: <textarea name="content" rows="10" cols="30"></textarea><br>
최소 인원수: <input type="number" name="minPeople"><br>
최대 인원수: <input type="number" name="maxPeople"><br>
<!-- 날짜, 시작시각, 종료시각 -->
가격: <input type="number" name="price"><br>
<input type="submit" value="등록">
</form>
</body>
</html>