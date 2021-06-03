<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>튜터 상세</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>


<h1>튜터 상세보기</h1>
<c:if test="${not empty tutor}">
  <c:if test="${not empty tutor.profilePicture}">
    <c:set var="profilePicture110x110Url">../../upload/${tutor.profilePicture}_110x110.jpg</c:set>
    <c:set var="profilePictureUrl">../../upload/${tutor.profilePicture}</c:set>
  </c:if>
  <c:if test="${empty tutor.profilePicture}">
    <c:set var="profilePicture80x80Url">../../images/person_80x80.jpg</c:set>
    <c:set var="profilePictureUrl"></c:set>
  </c:if>
		<form action='update' method='post' enctype='multipart/form-data'>
		<table border='1'>
		<tbody>
		<div class="mb-3 row">
    <label for="no" class="col-sm-1 col-form-label">번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="no" name="no" value='${tutor.no}'>
    </div>
    <div class="mb-3 row">
    <label for="name" class="col-sm-1 col-form-label">이름</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="name" name="name" value='${tutor.name}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="email" class="col-sm-1 col-form-label">이메일</label>
    <div class="col-sm-7">
      <input type="email" class="form-control-plaintext form-control-sm" id="email" name="email" value='${tutor.email}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="profileFile" class="col-sm-1 col-form-label">사진</label>
    <div class="col-sm-7">
      <div><a href='${profilePictureUrl}' ><img src='${profilePicture110x110Url}'></a></div>
      <input type="file" class="form-control-plaintext form-control-sm" id="profileFile"  name="profileFile" value='${tutor.profilePicture}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="nickname" class="col-sm-1 col-form-label">닉네임</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="nickname" name="nickname" value='${tutor.nickname}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="tel" class="col-sm-1 col-form-label">전화번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="tel" name="tel" value='${tutor.tel}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="sex" class="col-sm-1 col-form-label">성별</label>
          <div><input type='checkbox' ${tutor.sex == 1 ? "checked" : ""}  onclick='return(false);'>남 
          <input type='checkbox' ${tutor.sex == 2 ? "checked" : ""}  onclick='return(false);'>여
          </div>
    <div class="col-sm-7">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="birthDate" class="col-sm-1 col-form-label">생일</label>
    <div class="col-sm-7">
      <input type="date" class="form-control-plaintext form-control-sm" id="birthDate"  value='${tutor.birthDate}'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="intro" class="col-sm-1 col-form-label">소개서</label>
    <div class="col-sm-7">
      <textarea class="form-control-plaintext form-control-sm" name="intro" rows='3' cols='40'>${tutor.intro}</textarea>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="application" class="col-sm-1 col-form-label">신청서</label>
    <div class="col-sm-7">
      <textarea class="form-control-plaintext form-control-sm" name="application" rows='3' cols='40'>${tutor.application}</textarea>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="zipcode" class="col-sm-1 col-form-label">우편번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="zipcode"  name="zipcode" value='${tutor.zipcode}'>
      <input type='button' value='우편번호찾기'>
    </div>
  </div>
    
    <div class="mb-3 row">
    <label for="address" class="col-sm-1 col-form-label">기본주소</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="address" name="address" value='${tutor.address}'>
      <input type='button' value='주소찾기'>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="detailAddress" class="col-sm-1 col-form-label">상세주소</label>
    <div class="col-sm-7">
      <input type="text" class="form-control-plaintext form-control-sm" id="detailAddress" name="detailAddress" value='${tutor.detailAddress}'>
    </div>
  </div>
  <div class="col-sm-7">가입일
      <input type="text" class="form-control-plaintext form-control-sm" id="registeredDate" value='${tutor.registeredDate}'>
    </div>
  </div>  
  <div class="col-sm-7">등업일
      <input type="text" class="form-control-plaintext form-control-sm" id="promotedDate" value='${tutor.promotedDate}'>
    </div>
  </div>  
      <c:forEach items="${tutor.tutorCategories}" var="tc">
  <div class="mb-3 row">
    <label for="broadCategory" class="col-sm-1 col-form-label">카테고리</label>
<select id="broadCategory" name="broadCategoryNo" data-broadCategory="${tc.broadCategoryNo}">
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

<select id="narrowCategory" name="narrowCategoryNo" data-narrowCategory="${tc.narrowCategoryNo}">
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
</div>
	    </c:forEach>
		    <c:forEach items="${tutor.tutorDistricts}" var="td">
		    <div class="mb-3 row">
    <label for="sido" class="col-sm-1 col-form-label">지역</label>
<select id="sido" name="sidoNo" data-sido="${td.sidoNo}">
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

<select id="sigungu" name="sigunguNo" data-sigungu="${td.sigunguNo}">
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
      </div>
	    </c:forEach> 
	    <button class="btn btn-primary btn-sm">변경</button>
      <a href='delete?no=${tutor.no}' class="btn btn-primary btn-sm">삭제</a>
  
  <div> <a href='list' class="btn btn-primary btn-sm">목록</a></div>
		</tbody>
		</table>
		</form>
</c:if>

<c:if test="${empty tutor}">
<p>해당 번호의 튜터가 없습니다.</p>
</c:if>

<jsp:include page="/jsp/footer/footer.jsp"/>

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
  xhr.open("GET", "../../jsp/tutor/category2.jsp?broadCategoryNo=" + t3.value, false);
  xhr.send();
  
  t4.innerHTML = xhr.responseText;  
}

var t1 = document.querySelector("#sido");
var t2 = document.querySelector("#sigungu");
t1.onchange = function() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "../../jsp/tutor/district2.jsp?sidoNo=" + t1.value, false);
  xhr.send();
  
  t2.innerHTML = xhr.responseText;  
}

//

var xhr = new XMLHttpRequest();
xhr.open("GET", "../../jsp/tutor/category2.jsp?broadCategoryNo=" + t3.value, false);
xhr.send();

t4.innerHTML = xhr.responseText; 

var xhr = new XMLHttpRequest();
xhr.open("GET", "../../jsp/tutor/district2.jsp?sidoNo=" + t1.value, false);
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
