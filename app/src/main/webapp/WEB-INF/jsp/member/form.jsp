<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
<link href="../css/common.css" rel="stylesheet" >
</head>
<body>

<jsp:include page="/jsp/header/header.jsp"/>


<div class="container">
<h1>회원 가입</h1>
<form action="add" method="post" enctype="multipart/form-data">
<div class="mb-3 row">
    <label for="name" class="col-sm-1 col-form-label">이름</label>
    <div class="col-sm-7">
      <input type="text" class="form-control form-control-sm" id="name" name="name">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="email" class="col-sm-1 col-form-label">이메일</label>
    <div class="col-sm-7">
      <input type="email" class="form-control form-control-sm" id="har-email" name="email">
      <button id="checkBtn" type="button">중복검사</button>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="password" class="col-sm-1 col-form-label">비밀번호</label>
    <div class="col-sm-7">
      <input type="password" class="form-control form-control-sm" id="password" name="password">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="nickname" class="col-sm-1 col-form-label">닉네임</label>
    <div class="col-sm-7">
      <input type="text" class="form-control form-control-sm" id="har-nickname" name="nickname">
      <button id="checkBtn2" type="button" >중복검사</button>
    </div>
  </div>
  <div class="mb-3 row">
    <label for="profileFile" class="col-sm-1 col-form-label">사진</label>
    <div class="col-sm-7">
      <input type="file" class="form-control form-control-sm" id="profileFile" name="profileFile">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="birthDate" class="col-sm-1 col-form-label">생일</label>
    <div class="col-sm-7">
      <input type="date" class="form-control form-control-sm" id="birthDate" name="birthDate">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="tel" class="col-sm-1 col-form-label">전화번호</label>
    <div class="col-sm-7">
      <input type="tel" class="form-control form-control-sm" id="tel" name="tel">
      <input type="button" value="문자인증">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="sex" class="col-sm-1 col-form-label">성별</label>
    <div class="col-sm-7">
    <input type="radio" name="sex" value="1">남
      <input type="radio" name="sex" value="2">여
    </div>
    <!-- 
     성별: <input type="radio" name="sex" value="1">남
      <input type="radio" name="sex" value="2">여
     -->
  </div>
   <div class="mb-3 row">
    <label for="zipcode" class="col-sm-1 col-form-label">우편번호</label>
    <div class="col-sm-7">
      <input type="text" class="form-control form-control-sm" id="zipcode" name="zipcode">
      <a href='../../jsp/doro.html'>
      <input type="button" value="우편번호찾기">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="address" class="col-sm-1 col-form-label">기본주소</label>
    <div class="col-sm-7">
      <input type="text" class="form-control form-control-sm" id="address" name="address">
    </div>
  </div>
  <div class="mb-3 row">
    <label for="detailAddress" class="col-sm-1 col-form-label">상세주소</label>
    <div class="col-sm-7">
      <input type="text" class="form-control form-control-sm" id="detailAddress" name="detailAddress">
    </div>
  </div>
<button class="btn btn-primary btn-sm">등록</button>
</form>

<jsp:include page="/jsp/footer/footer.jsp"/>

<script>
document.querySelector("#checkBtn").onclick = function() {
	var harEmail = document.querySelector("#har-email");
	var xhr = new XMLHttpRequest();
    xhr.open("GET", "check?email=" + harEmail.value, false);
    xhr.send();
    if (xhr.responseText == "yes") {
        alert("존재하는 이메일입니다..");
        harEmail.value = "";
      } else {
        alert("이 이메일을 사용할 수 있습니다.") 
      }
};

document.querySelector("#checkBtn2").onclick = function() {
	  var harNickname = document.querySelector("#har-nickname");
	  var xhr = new XMLHttpRequest();
	    xhr.open("GET", "check2?nickname=" + harNickname.value, false);
	    xhr.send();
	    if (xhr.responseText == "yes") {
	        alert("존재하는 닉네임입니다..");
	        harNickname.value = "";
	      } else {
	        alert("이 닉네임을 사용할 수 있습니다.") 
	      }
	};
</script>
</div>
</body>
</html>