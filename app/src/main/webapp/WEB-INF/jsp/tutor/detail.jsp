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
<!--  <link href="../css/common.css" rel="stylesheet" >-->
<style>

.col-sm-1 {
width: 100px;
}

.button {
margin-top: 30px;
    float: left;
    }

a {
  text-decoration: none; 
  color: #333;
}

body {
  line-height: 1;
  color: #333;
}

section {
  width: 550px;
    margin: 0 auto;
    padding: 50px;
    border: 1px solid #dadada;
    border-radius: 15px;
    height: 1262px;
}

button {
  border: 0;
  background-color: #fff;
  color: #666;
}

.har-tutor-info {
  padding: 30px;
  height: 120px;
}
.har-tutor-pro {
  width: 110px;
  height: 110px;
  overflow: hidden;
  border-radius: 50px;
  float: left;
  margin-right: 15px;
}

.btn-primary {
  width: 72px;
  height: 27px;
  border-radius: 10px;
  float: right;
  font-size: 12px;
  padding-top: 4px;
  position: relative;
  top: -13px;
  margin-right: 15px;
}

.har-tutor-pro img {
  width: 110px;
}

.har-tutor-font {
  font-size: 15px;
  display: inline;
  position: relative;
  top: 10px;
}

.har-tutor-font2 {
  font-size: 13px;
  margin: 3px 0 0 0px;
  color: #999;
  position: relative;
  top: 15px;
}

#har-tutor-file {
    position: relative;
  }

#profileFile {
    width: 250px;
    margin-top: 80px;
  }
  
  #har-tutor-file img {
    display: none;
  }

  .har-tutor-fileBtn {
    width: 30px;
    position: absolute;
    top:260px;
  }
  
  .box {
    display: block;
    box-sizing: border-box;
    margin-bottom: 10px;
    background: #fff;
    position: relative;
}

.form-control-plaintext {
  width : 200px;
  display : inline-block;
  border: solid 1px #dadada;
  padding: 10px;
}

h1 {
text-align: center;
}

</style>
</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>

<section>
<h1>튜터 상세보기</h1>
<c:if test="${not empty tutor}">
<form action='update' method='post' enctype='multipart/form-data'>
          <input type="hidden" name='no' value='${tutor.no}' readonly>
          <div class="har-tutor-info">
            <div class="har-tutor-pro">
              <c:if test="${not empty tutor.profilePicture}">
                <c:set var="profilePicture110x110Url">../../upload/${tutor.profilePicture}_110x110.jpg</c:set>
                <c:set var="profilePictureUrl">../../upload/${tutor.profilePicture}</c:set>
              </c:if>
              <c:if test="${empty tutor.profilePicture}">
                <c:set var="profilePicture80x80Url">../../images/person_80x80.jpg</c:set>
                <c:set var="profilePictureUrl"></c:set>
              </c:if>
              <img src="${profilePictureUrl}">
            </div>
              <input type="file" class="form-control-plaintext form-control-sm" id="profileFile"  name="profileFile" value='${tutor.profilePicture}' 
              style= "border: 0; padding-left : 20px">
    </div>
    
  <!--<c:if test="${not empty tutor.profilePicture}">
    <c:set var="profilePicture110x110Url">../../upload/${tutor.profilePicture}_110x110.jpg</c:set>
    <c:set var="profilePictureUrl">../../upload/${tutor.profilePicture}</c:set>
  </c:if>
  <c:if test="${empty tutor.profilePicture}">
    <c:set var="profilePicture80x80Url">../../images/person_80x80.jpg</c:set>
    <c:set var="profilePictureUrl"></c:set>
  </c:if>
  -->
  <br>
  <br>
  <br>
  <span class="box int_id">
    <label for="name" class="col-sm-1 col-form-label">이름</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="name" name="name" value='${tutor.name}'>
    </span>
  
    <span class="box int_id">
    <label for="nickname" class="col-sm-1 col-form-label">닉네임</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="name" name="name" value='${tutor.nickname}'>
    </span>
  
    <span class="box int_id">
    <label for="email" class="col-sm-1 col-form-label">이메일</label>
      <input type="email" class="form-control-plaintext form-control-sm" id="email" name="email" value='${tutor.email}'>
    </span>
  
    <label for="sex" class="col-sm-1 col-form-label">성별</label>
          <input type='checkbox' ${member.sex == 1 ? "checked" : ""}  onclick='return(false);'>남 
          <input type='checkbox' ${member.sex == 2 ? "checked" : ""}  onclick='return(false);'>여
    
    
    <span class="box int_id">
    <label for="tel" class="col-sm-1 col-form-label">전화번호</label>
      <input type="tel" class="form-control-plaintext form-control-sm" id="tel" name="tel" value='${tutor.tel}'>
      <input type='button' value='문자인증'>
      </span>
    <span class="box int_id">
    <label for="birthDate" class="col-sm-1 col-form-label">생일</label>
      <input type="date" class="form-control-plaintext form-control-sm" id="birthDate"  value='${tutor.birthDate}'>
      </span>
    <span class="box int_id">
    <label for="zipcode" class="col-sm-1 col-form-label">우편번호</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="zipcode"  name="zipcode" value='${tutor.zipcode}'>
      <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
    </span>
    
    <span class="box int_id">
    <label for="address" class="col-sm-1 col-form-label">기본주소</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="address" name="address" value='${tutor.address}'>
    </span>
    
    <span class="box int_id">
    <label for="detailAddress" class="col-sm-1 col-form-label">상세주소</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="detailAddress" name="detailAddress" value='${tutor.detailAddress}'>
    </span>
    
		
  <span class="box int_id">
    <label for="intro" class="col-sm-1 col-form-label">소개서</label>
      <textarea class="form-control-plaintext form-control-sm" name="intro" rows='3' cols='40'>${tutor.intro}</textarea>
  </span>
  
  <span class="box int_id">
    <label for="application" class="col-sm-1 col-form-label">신청서</label>
      <textarea class="form-control-plaintext form-control-sm" name="application" rows='3' cols='40'>${tutor.application}</textarea>
  </span>
  
    <span class="box int_id">
    <label for="registeredDate" class="col-sm-1 col-form-label">가입일</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="registeredDate" value='${tutor.registeredDate}'>
    </span>
  
    <span class="box int_id">
    <label for="promotedDate" class="col-sm-1 col-form-label">등업일</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="promotedDate" value='${tutor.promotedDate}'>
    </span>
    
      <c:forEach items="${tutor.tutorCategories}" var="tc">
  <span class="box int_id">
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
</span>

	    </c:forEach>
		    <c:forEach items="${tutor.tutorDistricts}" var="td">
		    <span class="box int_id">
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
      </span>
	    </c:forEach> 
	    <div class="button"><button class="btn btn-primary btn-sm">변경</button>
      <a href='delete?no=${tutor.no}' class="btn btn-primary btn-sm">탈퇴</a>
  
   <a href='list' class="btn btn-primary btn-sm">목록</a></div>
		</tbody>
		</table>
		</form>
</c:if>

<c:if test="${empty tutor}">
<p>해당 번호의 튜터가 없습니다.</p>
</c:if>
</section>

</section>
<jsp:include page="/jsp/footer/footer.jsp"/>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

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

function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById("zipcode").value = data.zonecode;
            document.getElementById("address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("detailAddress").focus();
        }
    }).open();
}

</script>
</body>
</html>
</html>
