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
<!--  <link href="../../css/har_member_detail.css" rel="stylesheet" >-->

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
    height: 887px;
}
button {
  border: 0;
  background-color: #fff;
  color: #666;
}
.har-member-info {
  padding: 30px;
  height: 120px;
}
.har-member-pro {
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
.har-member-pro img {
  width: 110px;
}
.har-member-font {
  font-size: 15px;
  display: inline;
  position: relative;
  top: 10px;
}
.har-member-font2 {
  font-size: 13px;
  margin: 3px 0 0 0px;
  color: #999;
  position: relative;
  top: 15px;
}
#har-member-file {
    position: relative;
  }
#profileFile {
    width: 250px;
    margin-top: 80px;
  }
  
  #har-member-file img {
    display: none;
  }
  .har-member-fileBtn {
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
  <h1>내정보 보기</h1>
<c:if test="${not empty member}">
        <form action='update' method='post' enctype='multipart/form-data'>
          <input type="hidden" name='no' value='${member.no}' readonly>
          <div class="har-member-info">
            <div class="har-member-pro">
              <c:if test="${not empty member.profilePicture}">
                <c:set var="profilePicture110x110Url">../../upload/${member.profilePicture}_110x110.jpg</c:set>
                <c:set var="profilePictureUrl">../../upload/${member.profilePicture}</c:set>
              </c:if>
              <c:if test="${empty member.profilePicture}">
                <c:set var="profilePicture80x80Url">../../images/person_80x80.jpg</c:set>
                <c:set var="profilePictureUrl"></c:set>
              </c:if>
              <img src="${profilePictureUrl}">
            </div>
              <input type="file" class="form-control-plaintext form-control-sm" id="profileFile"  name="profileFile" value='${member.profilePicture}' 
              style= "border: 0; padding-left : 20px">
    </div>
  <br>
  <br>
  <br>
    <span class="box int_id">
    <label for="name" class="col-sm-1 col-form-label">이름</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="name" name="name" value='${member.name}'>
    </span>
  
    <span class="box int_id">
    <label for="nickname" class="col-sm-1 col-form-label">닉네임</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="name" name="name" value='${member.nickname}'>
    </span>
  
    <span class="box int_id">
    <label for="email" class="col-sm-1 col-form-label">이메일</label>
      <input type="email" class="form-control-plaintext form-control-sm" id="email" name="email" value='${member.email}'>
    </span>
  
    <label for="sex" class="col-sm-1 col-form-label">성별</label>
          <input type='checkbox' ${member.sex == 1 ? "checked" : ""}  onclick='return(false);'>남 
          <input type='checkbox' ${member.sex == 2 ? "checked" : ""}  onclick='return(false);'>여
    
    
    <span class="box int_id">
    <label for="tel" class="col-sm-1 col-form-label">전화번호</label>
      <input type="tel" class="form-control-plaintext form-control-sm" id="tel" name="tel" value='${member.tel}'>
      <input type='button' value='문자인증'>
      </span>
    <span class="box int_id">
    <label for="birthDate" class="col-sm-1 col-form-label">생일</label>
      <input type="date" class="form-control-plaintext form-control-sm" id="birthDate"  value='${member.birthDate}'>
      </span>
    <span class="box int_id">
    <label for="zipcode" class="col-sm-1 col-form-label">우편번호</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="zipcode"  name="zipcode" value='${member.zipcode}'>
      <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기">
    </span>
    
    <span class="box int_id">
    <label for="address" class="col-sm-1 col-form-label">기본주소</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="address" name="address" value='${member.address}'>
    </span>
    
    <span class="box int_id">
    <label for="detailAddress" class="col-sm-1 col-form-label">상세주소</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="detailAddress" name="detailAddress" value='${member.detailAddress}'>
    </span>
    
    <span class="box int_id">
    <label for="registeredDate" class="col-sm-1 col-form-label">가입일</label>
      <input type="text" class="form-control-plaintext form-control-sm" id="registeredDate" value='${member.registeredDate}'>
    </span>

      <div class="button"><button class="btn btn-primary btn-sm">변경</button>
      <a href='delete?no=${member.no}' class="btn btn-primary btn-sm">삭제</a>
  
  <a href='list' class="btn btn-primary btn-sm">목록</a>
  </div>
  
    </table>
    </form>
</c:if>

<c:if test="${empty member}">
<p>해당 번호의 회원이 없습니다.</p>
</c:if>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
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