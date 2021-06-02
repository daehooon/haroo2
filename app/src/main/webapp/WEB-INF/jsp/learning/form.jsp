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
</select><br>

<!-- 추후 우편번호 API로 수정 -->
우편번호: <input type="text" name="zipcode"><br>
기본주소: <input type="text" name="address"><br>
<select id="sido" name="sidoNo">
    <option value="1">서울</option>
    <option value="2">경기</option>
    <option value="3">인천</option>
    <option value="4">강원</option>
    <option value="5">부산</option>
    <option value="6">대구</option>
    <option value="7">대전</option>
    <option value="8">울산</option>
    <option value="9">경북</option>
    <option value="10">경남</option>
    <option value="11">충북</option>
    <option value="12">충남</option>
    <option value="13">전북</option>
    <option value="14">전남</option>
    <option value="15">광주</option>
    <option value="16">세종</option>
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
</select><br>

상세주소: <input type="text" name="detailAddress"><br>
본문: <textarea name="intro" rows="10" cols="60"></textarea><br>
진행순서: <textarea name="progressOrder" rows="10" cols="30"></textarea><br>
환불정보: <textarea name="refundInformation" rows="10" cols="30"></textarea><br>
최소 인원수: <input type="number" name="minPeople"><br>
최대 인원수: <input type="number" name="maxPeople"><br>

<!-- 
<div class="mb-3" id="har-feed-file">
  <label for="formFileSm" class="form-label form-label2">파일선택</label>
  <div class="har-file-box">
    <div class="har-file-box2">
    <input class="form-control form-control-sm" name="files" type="file">
    <button type="button" class="btn btn-outline-secondary" onclick="fileDeleteBtn(event)" class="har-delete-btn">삭제</button>
    </div>
  </div>
  <button type="button" class="btn2 btn-outline-secondary" id="har-add-btn">추가</button>
</div>
 -->

날짜: <input type="date" name="learningDate"><br>
시작시각: <input type="time" name="startTime"><br>
종료시각: <input type="time" name="endTime"><br>

가격: <input type="number" name="price"><br>
<input type="submit" value="등록">
<p><a href='list'>취소</a></p>
</form>

<script>
var t1 = document.querySelector("#sido");
var t2 = document.querySelector("#sigungu");
t1.onchange = function() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "../../jsp/learning/district.jsp?sidoNo=" + t1.value, false);
  xhr.send();
  
  t2.innerHTML = xhr.responseText;  
}

var t3 = document.querySelector("#broadCategory");
var t4 = document.querySelector("#narrowCategory");
t3.onchange = function() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", "../../jsp/learning/category.jsp?broadCategoryNo=" + t3.value, false);
  xhr.send();
  
  t4.innerHTML = xhr.responseText;
}

/*
var btnAddName = document.getElementById("har-add-btn");

btnAddName.onclick = function() {
  var fileDivs = document.querySelectorAll(".har-file-box2");
  
  var inputFile = document.querySelector(".har-file-box");

  inputFile.innerHTML += "<div class='har-file-box2'>"
      + "<input class='form-control form-control-sm' name='files' type='file'>"
      + "<button type='button' class='btn btn-outline-secondary' onclick='fileDeleteBtn(event)' class='har-delete-btn'>삭제</button>"
      + "</div>";
};
*/
</script>

</body>
</html>







