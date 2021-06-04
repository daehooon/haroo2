<%@page import="com.bit189.haroo.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>튜터 등록</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >

<style>
.box {
    display: block;
    width: 60%;
    height: px;
    border: solid 1px #dadada;
    padding: 10px 14px 10px 14px;
    box-sizing: border-box;
    background: #fff;
    position: relative;
}

section {
  width: 1100px;
  margin: 0 auto;
}
</style>
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>
<section>
<div class="container">
<h1>튜터 등록</h1>
<form action="add" method="post" enctype="multipart/form-data">
<div class="content">
    <label for="no" class="col-sm-1 col-form-label">멤버번호</label>
    <div class="col-sm-7">
      <input type="number" class="form-control form-control-sm" id="no" name="no">
    </div>
  </div>
  <div class="content">
    <label for="intro" class="col-sm-1 col-form-label">소개서</label>
    <span class="box int_id">
      <textarea class="form-control-plaintext form-control-sm" name="intro" rows='3' cols='40'></textarea>
    </span>
  </div>
  <div class="content">
    <label for="application" class="col-sm-1 col-form-label">신청서</label>
    <span class="box int_id">
      <textarea class="form-control-plaintext form-control-sm" name="application" rows='3' cols='40'></textarea>
    </span>
  </div>
  <div class="mb-3 row">
    <label for="sido" class="col-sm-1 col-form-label">지역</label>
<select id="sido" name="sidoNo">
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

<select id="sigungu" name="sigunguNo">
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
<div class="mb-3 row">
    <label for="broadCategory" class="col-sm-1 col-form-label">카테고리</label>
<select id="broadCategory" name="broadCategoryNo">
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

<select id="narrowCategory" name="narrowCategoryNo">
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
<button class="btn btn-primary btn-sm">등록</button>
</form>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>

<script>
var t1 = document.querySelector("#sido");
var t2 = document.querySelector("#sigungu");
t1.onchange = function() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "../../jsp/tutor/district2.jsp?sidoNo=" + t1.value, false);
  xhr.send();
  
  t2.innerHTML = xhr.responseText;  
}

var t3 = document.querySelector("#broadCategory");
var t4 = document.querySelector("#narrowCategory");
t3.onchange = function() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "../../jsp/tutor/category2.jsp?broadCategoryNo=" + t3.value, false);
  xhr.send();
  
  t4.innerHTML = xhr.responseText;  
}
</script>
</body>
</html>