<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>튜터 상세</title>
</head>
<body>
<h1>튜터 상세보기</h1>
<c:if test="${not empty tutor}">
  <c:if test="${not empty tutor.profilePicture}">
    <c:set var="profilePicture80x80Url">../upload/${tutor.profilePicture}_80x80.jpg</c:set>
    <c:set var="profilePictureUrl">../upload/${tutor.profilePicture}</c:set>
  </c:if>
  <c:if test="${empty tutor.profilePicture}">
    <c:set var="profilePicture80x80Url">../images/person_80x80.jpg</c:set>
    <c:set var="profilePictureUrl"></c:set>
  </c:if>
		<form action='update' method='post' enctype='multipart/form-data'>
		<table border='1'>
		<tbody>
		<tr>
		  <th>번호</th>
		  <td><input type='text' name='no' value='${tutor.no}' readonly></td></tr>
		<tr>
		  <th>이름</th>
		  <td><input type='text' name='name' value='${tutor.name}' readonly></td></tr>
		<tr>
		  <th>이메일</th> 
		  <td><input type='email' name='email' value='${tutor.email}' readonly></td></tr>
		<tr>
		  <th>사진</th> 
		  <td><a href='${profilePictureUrl}'>
		  <img src='${profilePicture80x80Url}'></a><br>
		  <input name='profilepicture' type='file'></td></tr>
		<tr>
		  <th>닉네임</th> 
		  <td><input type='text' name='nickname' value='${tutor.nickname}' ></td></tr>
		<tr>
		  <th>전화번호</th> 
		  <td><input type='tel' name='tel' value='${tutor.tel}' >  <input type='button' value='문자인증'></td></tr>
		<tr>
		  <th>성별</th> 
		  <td><input type='checkbox' name='sex' ${tutor.sex == 1 ? "checked" : ""}  onclick='return(false);'>남 
		      <input type='checkbox' name='sex' ${tutor.sex == 2 ? "checked" : ""}  onclick='return(false);'>여
		<tr>
		  <th>생일</th> 
		  <td><input type='date' name='birthdate' value='${tutor.birthDate}' readonly></td></tr>
		<tr>
      <th>소개서</th> 
      <td><textarea name='intro' rows='3' cols='40'>${tutor.intro}</textarea></td></tr>
    <tr>
      <th>신청서</th> 
      <td><textarea name='application' rows='3' cols='40'>${tutor.application}</textarea></td></tr>
		<tr>
		  <th>우편번호</th> 
		  <td><input type='text' name='zipcode' value='${tutor.zipcode}' >  
		      <input type='button' value='우편번호찾기'></td></tr>
		<tr>
		  <th>기본주소</th>
		  <td><input type='text' name='address' value='${tutor.address}' >
		      <input type='button' value='주소찾기'></td></tr>
		<tr>
		  <th>상세주소</th> 
		  <td><input type='text' name='detailaddress' value='${tutor.detailAddress}' ></td></tr>
		<tr>
		  <th>가입일</th> 
		  <td>${tutor.registeredDate}</td></tr>
		<tr>
      <th>등업일</th> 
      <td>${tutor.promotedDate}</td></tr>
      <c:forEach items="${tutor.tutorCategories}" var="tc">
	    <tr>
	      <th>카테고리</th>
	      <td>
<select id="broadCategory" name="broadCategory" data-broadCategory="${tc.broadCategoryNo}">
  <option value="1">공예·DIY</option>
  <option value="2">댄스</option>
  <option value="3">요리</option>
  <option value="4">음료</option>
  <option value="5">음악·예술</option>
  <option value="6">스포츠</option>
  <option value="7">사진·영상</option>
  <option value="8">미술·드로잉</option>
  <option value="9">뷰티</option>
</select>

<select id="narrowCategory" name="narrowCategory" data-narrowCategory="${tc.narrowCategoryNo}">
  <option value="1">도자기</option>
  <option value="2">가죽</option>
  <option value="3">목공</option>
  <option value="4">플라워</option>
  <option value="5">향수</option>
  <option value="6">뜨개·자수</option>
  <option value="7">캔들·석고방향제</option>
  <option value="8">비누</option>
  <option value="9">라탄·마크라메</option>
  <option value="10">액세서리·비즈</option>
  <option value="11">조명·네온사인</option>
  <option value="12">기타</option>
</select>
</td>
	    </tr>
	    </c:forEach>
		    <c:forEach items="${tutor.tutorDistricts}" var="td">
	    <tr>
		    <th>지역</th>
		    <td>
<select id="sido" name="sido" data-sido="${td.sidoNo}">
    <option value="1">서울</option> -- 특별시
    <option value="2">경기</option>
    <option value="3">인천</option> -- 광역시
    <option value="4">강원</option>
    <option value="5">부산</option> -- 광역시
    <option value="6">대구</option> -- 광역시
    <option value="7">대전</option> -- 광역시
    <option value="8">울산</option> -- 광역시
    <option value="9">경북</option>
    <option value="10">경남</option>
    <option value="11">충북</option>
    <option value="12">충남</option>
    <option value="13">전북</option>
    <option value="14">전남</option>
    <option value="15">광주</option> -- 광역시
    <option value="16">세종</option> -- 특별자치시
    <option value="17">제주</option>
</select>

<select id="sigungu" name="sigungu" data-sigungu="${td.sigunguNo}">
  <option value="1">도봉구</option>
  <option value="2">노원구</option>
  <option value="3">강북구</option>
  <option value="4">중랑구</option>
  <option value="5">성북구</option>
  <option value="6">종로구</option>
  <option value="7">동대문구</option>
  <option value="8">은평구</option>
  <option value="9">서대문구</option>
  <option value="10">중구</option>
  <option value="11">성동구</option>
  <option value="12">광진구</option>
  <option value="13">마포구</option>
  <option value="14">용산구</option>
  <option value="15">강동구</option>
  <option value="16">강서구</option>
  <option value="17">양천구</option>
  <option value="18">영등포구</option>
  <option value="19">동작구</option>
  <option value="20">서초구</option>
  <option value="21">강남구</option>
  <option value="22">송파구</option>
  <option value="23">구로구</option>
  <option value="24">금천구</option>
  <option value="25">관악구</option>
</select>
		    </td>
	    </tr>
	    </c:forEach> 
		</tbody>
		<tfoot>
		<tr>
		  <td colspan='2'>
		    <input type='submit' value='변경'> <a href='delete?no=${tutor.no}'>삭제</a> 
		</td></tr>
		</tfoot>
		</table>
		</form>
</c:if>

<c:if test="${empty tutor}">
<p>해당 번호의 튜터가 없습니다.</p>
</c:if>

<p><a href='list'>목록</a></p>
<script>

var broadCategory = document.getElementById("broadCategory");
var broadCategoryNo = broadCategory.getAttribute("data-broadCategory");
var broadCategoryChild = broadCategory.querySelectorAll("option");

for (var b of broadCategoryChild) {
  var bcNo = b.value;
  if (bcNo == broadCategoryNo) {
    b.selected = true;
  }
}

var sido = document.getElementById("sido"); // select
var sidoNo = sido.getAttribute("data-sido"); // data-no
var sidoChild = sido.querySelectorAll("option"); // option들

for (var s of sidoChild) {
	var sdNo = s.value;
	if (sdNo == sidoNo) {
		s.selected = true;
	}
}

//
var t3 = document.querySelector("#broadCategory");
var t4 = document.querySelector("#narrowCategory");
t3.onchange = function() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "../../jsp/tutor/category2.jsp?broadCategory=" + t3.value, false);
  xhr.send();
  
  t4.innerHTML = xhr.responseText;  
}

var t1 = document.querySelector("#sido");
var t2 = document.querySelector("#sigungu");
t1.onchange = function() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "../../jsp/tutor/district2.jsp?sido=" + t1.value, false);
  xhr.send();
  
  t2.innerHTML = xhr.responseText;  
}

//

var xhr = new XMLHttpRequest();
xhr.open("GET", "../../jsp/tutor/category2.jsp?broadCategory=" + t3.value, false);
xhr.send();

t4.innerHTML = xhr.responseText; 

var xhr = new XMLHttpRequest();
xhr.open("GET", "../../jsp/tutor/district2.jsp?sido=" + t1.value, false);
xhr.send();

t2.innerHTML = xhr.responseText; 

//

var narrowCategory = document.getElementById("narrowCategory");
var narrowCategoryNo = narrowCategory.getAttribute("data-narrowCategory");
var narrowCategoryChild = narrowCategory.querySelectorAll("option");

for (var nc of narrowCategoryChild) {
	var ncNo = nc.value;
	if (ncNo == narrowCategoryNo) {
		nc.selected = true;
	}
}

var sigungu = document.getElementById("sigungu");
var sigunguNo = sigungu.getAttribute("data-sigungu");
var sigunguChild = sigungu.querySelectorAll("option");

for (var sg of sigunguChild) {
  var sgNo = sg.value;
  if (sgNo == sigunguNo) {
    sg.selected = true;
  }
}


</script>
</body>
</html>
</html>
