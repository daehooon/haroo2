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
이메일: <input id="har-email" type="email" name="email"><button id="checkBtn" type="button">중복검사</button><br>
비밀번호: <input type="password" name="password"><br>
닉네임:  <input id="har-nickname" type="text" name="nickname"><button id="checkBtn2" type="button" >중복검사</button><br>
사진: <input type="file" name="profileFile"><br>
생일:  <input type="date" name="birthDate"><br>
전화번호: <input type="tel" name="tel"><input type="button" value="문자인증"><br>
성별: <input type="radio" name="sex" value="1">남
      <input type="radio" name="sex" value="2">여<br>
우편번호: <input type="text" name="zipcode"> <input type="button" value="우편번호찾기"><br>
기본주소: <input type="text" name="address"> <input type="button" value="주소찾기"><br>
상세주소: <input type="text" name="detailAddress"><br>
<input type="submit" value="등록">
</form>

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
</body>
</html>