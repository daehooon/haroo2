<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>회원 상세</title>
</head>
<body>
<h1>회원 상세보기</h1>
<c:if test="${not empty member}">
  <c:if test="${not empty member.profilePicture}">
    <c:set var="profilePicture80x80Url">../../upload/${member.profilePicture}_80x80.jpg</c:set>
    <c:set var="profilePictureUrl">../../upload/${member.profilePicture}</c:set>
  </c:if>
  <c:if test="${empty member.profilePicture}">
    <c:set var="profilePicture80x80Url">../../images/person_80x80.jpg</c:set>
    <c:set var="profilePictureUrl"></c:set>
  </c:if>
		<form action='update' method='post' enctype='multipart/form-data'>
		<table border='1'>
		<tbody>
		<tr>
		  <th>번호</th>
		  <td><input type='text' name='no' value='${member.no}' readonly></td></tr>
		<tr>
		  <th>이름</th>
		  <td><input type='text' name='name' value='${member.name}' readonly></td></tr>
		<tr>
		  <th>이메일</th> 
		  <td><input type='email' name='email' value='${member.email}' readonly></td></tr>
		<tr>
		  <th>닉네임</th> 
		  <td><input type='text' name='nickname' value='${member.nickname}' ></td></tr>
		<tr>
		  <th>사진</th> 
		  <td><a href='${profilePictureUrl}'>
		  <img src='${profilePicture80x80Url}'></a><br>
		  <input name='profileFile' type='file'></td></tr>
		<tr>
		  <th>전화번호</th> 
		  <td><input type='tel' name='tel' value='${member.tel}' >  <input type='button' value='문자인증'></td></tr>
		<tr>
		  <th>성별</th> 
		  <td><input type='checkbox' ${member.sex == 1 ? "checked" : ""}  onclick='return(false);'>남 
		      <input type='checkbox' ${member.sex == 2 ? "checked" : ""}  onclick='return(false);'>여
		<tr>
		  <th>생일</th> 
		  <td><input type='date' name='birthDate' value='${member.birthDate}' readonly></td></tr>
		<tr>
		  <th>우편번호</th> 
		  <td><input type='text' name='zipcode' value='${member.zipcode}' >  
		      <input type='button' value='우편번호찾기'></td></tr>
		<tr>
		  <th>기본주소</th>
		  <td><input type='text' name='address' value='${member.address}' >
		      <input type='button' value='주소찾기'></td></tr>
		<tr>
		  <th>상세주소</th> 
		  <td><input type='text' name='detailAddress' value='${member.detailAddress}' ></td></tr>
		<tr>
		  <th>가입일</th> 
		  <td>${member.registeredDate}</td></tr>
		</tbody>
		<tfoot>
		<tr>
		  <td colspan='2'>
		    <input type='submit' value='변경'> <a href='delete?no=${member.no}'>삭제</a> 
		</td></tr>
		</tfoot>
		</table>
		</form>
</c:if>

<c:if test="${empty member}">
<p>해당 번호의 회원이 없습니다.</p>
</c:if>

<p><a href='list'>목록</a></p>
</body>
</html>
</html>
