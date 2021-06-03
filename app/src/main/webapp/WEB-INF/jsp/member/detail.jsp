<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>


<h1>회원 상세보기</h1>
<c:if test="${not empty member}">
  <c:if test="${not empty member.profilePicture}">
    <c:set var="profilePicture110x110Url">../../upload/${member.profilePicture}_110x110.jpg</c:set>
    <c:set var="profilePictureUrl">../../upload/${member.profilePicture}</c:set>
  </c:if>
  <c:if test="${empty member.profilePicture}">
    <c:set var="profilePicture80x80Url">../../images/person_80x80.jpg</c:set>
    <c:set var="profilePictureUrl"></c:set>
  </c:if>
		<form action='update' method='post' enctype='multipart/form-data'>
		<table border='1'>
		<tbody>
		<div class="mb-3 row">
    <label for="no" class="col-sm-1 col-form-label">번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="no" name="no" value='${member.no}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="name" class="col-sm-1 col-form-label">이름</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="name" name="name" value='${member.name}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="email" class="col-sm-1 col-form-label">이메일</label>
    <div class="col-sm-7">
      <input type="email" class="form-control-plaintext form-control-sm" id="email" name="email" value='${member.email}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="nickname" class="col-sm-1 col-form-label">닉네임</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="nickname" name="nickname" value='${member.nickname}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="profileFile" class="col-sm-1 col-form-label">사진</label>
    <div class="col-sm-7">
      <div><a href='${profilePictureUrl}' ><img src='${profilePicture110x110Url}'></a></div>
      <input type="file" class="form-control-plaintext form-control-sm" id="profileFile"  name="profileFile" value='${member.profilePicture}'>
    </div>
  </div>
   <div class="mb-3 row">
    <label for="sex" class="col-sm-1 col-form-label">성별</label>
          <div><input type='checkbox' ${member.sex == 1 ? "checked" : ""}  onclick='return(false);'>남 
          <input type='checkbox' ${member.sex == 2 ? "checked" : ""}  onclick='return(false);'>여
          </div>
    <div class="col-sm-7">
    </div>
  </div>
		<div class="mb-3 row">
    <label for="tel" class="col-sm-1 col-form-label">전화번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="tel" name="tel" value='${member.tel}'>
      <input type='button' value='문자인증'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="birthDate" class="col-sm-1 col-form-label">생일</label>
    <div class="col-sm-7">
      <input type="date" class="form-control-plaintext form-control-sm" id="birthDate"  value='${member.birthDate}'>
    </div>
  </div>
		<div class="mb-3 row">
    <label for="zipcode" class="col-sm-1 col-form-label">우편번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="zipcode"  name="zipcode" value='${member.zipcode}'>
      <input type='button' value='우편번호찾기'>
    </div>
  </div>
		
		<div class="mb-3 row">
    <label for="address" class="col-sm-1 col-form-label">기본주소</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="address" name="address" value='${member.address}'>
      <input type='button' value='주소찾기'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="detailAddress" class="col-sm-1 col-form-label">상세주소</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="detailAddress" name="detailAddress" value='${member.detailAddress}'>
    </div>
  </div>
  <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="registeredDate" value='${member.registeredDate}'>
    </div>
  </div>  

      <button class="btn btn-primary btn-sm">변경</button>
      <a href='delete?no=${member.no}' class="btn btn-primary btn-sm">삭제</a>
  
  <div> <a href='list' class="btn btn-primary btn-sm">목록</a></div>
  
		</tbody>
		</table>
		</form>
</c:if>

<c:if test="${empty member}">
<p>해당 번호의 회원이 없습니다.</p>
</c:if>

<jsp:include page="/jsp/footer/footer.jsp"/>

</body>
</html>
</html>
