<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h1>회원 가입</h1>
<form action="add" method="post" enctype="multipart/form-data">
이름:   <input type="text" name="name"><br>
이메일: <input type="email" name="email"><input type="button" value="이메일인증"><br>
비밀번호: <input type="password" name="password"><br>
닉네임:  <input type="text" name="nickname"><input type="button" value="중복확인"><br>
사진: <input type="file" name="profile_pic"><br>
생일:  <input type="date" name="bdate"><br>
전화번호: <input type="tel" name="tel"><input type="button" value="문자인증"><br>
성별: <input type="radio" name="sex" value="1">남
      <input type="radio" name="sex" value="2">여<br>
우편번호: <input type="text" name="zipcode"> <input type="button" value="우편번호찾기"><br>
기본주소: <input type="text" name="addr"> <input type="button" value="주소찾기"><br>
상세주소: <input type="text" name="det_addr"><br>
<!--회원등급: <input type="radio" name="mrno" value="회원" checked>회원
      <input type="radio" name="mrno" value="튜터">튜터
      <input type="radio" name="mrno" value="관리자">관리자<br>
 회원등급: <input type="int" name="mrno"><br> -->
<input type="submit" value="등록">
</form>
</body>
</html>