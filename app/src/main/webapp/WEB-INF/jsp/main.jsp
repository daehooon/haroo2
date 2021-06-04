<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>메인</title>

<style>
 
 body {
     padding: 0;
     margin: 0;
 }

 header {
     height: 65px;
     border-bottom: 1px solid #dadada;
     margin-bottom: 50px;
 }

 a {
     text-decoration: none;
 }

 #har-header {
    margin: 0 auto;
     width: 1100px;
     padding-top: 8px;
 }

#har-logo {
    overflow: hidden;
    display: inline-block;
    height: 46px;
    width: 125px;
    background-image: url('../images/haroo_logo.png');
    background-repeat: no-repeat;
    background-position: 0px 0px;
    cursor: pointer;
}

#har-logo h1 {
    position: relative;
    top: 100px;
}

#har-menu-btn {
    height: 45px;
    width: 45px;
    background-image: url('../images/icon-01.png');
    background-repeat: no-repeat;
    background-position: -147px 0px;
    background-size: 650px;
    background-color: #fff;
    border: 1px solid #dadada;
    border-radius: 10px;
    margin-left: 105px;
    margin-right: 20px;
}

#har-header form {
    display: inline-block;
    position: relative;
    top: -17px;
}

.har-search {
    width: 530px;
    height: 45px;
    border: 1px solid #0566A3;
    border-radius: 30px;
    padding-left: 25px;
    padding-right: 25px;
    margin-right: 10px;
}

.har-search-btn {
    width: 55px;
    height: 45px;
    border: 0;
    background-color: #0566A3;
    color: #fff;
    font-size: 13px;
    border-radius: 30px;
    position: relative;
    top: -1px;
}

#har-login {
    font-size: 13px;
    color: #666;
    float: right;
    /* border: 1px solid #0566A3;
    border-radius: 10px; */
    width: 84px;
    height: 18px;
    margin-top: 18px;
}

#har-login:hover {
    border-bottom: 1px solid #0566A3;
}

#har-member {
    float: right;
    cursor: pointer;
}

#har-member-pro {
    overflow: hidden;
    width: 50px;
    height: 50px;
    border-radius: 30px;
    display: inline-block;
    margin-left: 15px;
}

#har-member-pro img {
    width: 50px;
    height: 50px;
}

.har-member-name {
    font-size: 13px;
    color: #333;
    position: relative;
    top: -20px;
}

   body {
        margin: 0;
        padding: 0;
    }

    footer {
        height: 210px;
        width: 100%;
        border-top: 1px solid #dadada;
        margin-top: 50px;
    }

    #har-footer {
        width: 1100px;
        height: 100%;
        margin: 0 auto;
    }

 
section {
      padding: 150px;
      margin: 0 auto;
      min-height: 200px;
    }
    
#har-main {
  display:table;
  margin : 0 auto;
  }
    
.har-list {
  width: 250px;
  height: 100px;
  border: 1px solid #0566A3;
  border-radius: 60px;
  font-size: 20px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  color: #666;
  font-weight: bold;
  padding-top: 75px;
  margin: 30px;
}

.har-list:hover {
  background-color: #0566A3;
  text-decoration: none;
  color: #fff;
  font-weight: bold;
}
    
</style>
</head>
<body>

	<header>
		<div id="har-header">
			<div id="har-logo" onclick="location.href='main'">
				<h1>하루</h1>
			</div>

			<button type="button" id="har-menu-btn"></button>

			<form action="" method="GET">
				<input type="search" name="" placeholder="재미있는 시간, 다양한 클래스를 검색해보세요!"
					class="har-search"> <input type="submit" value="검색"
					class="har-search-btn">
			</form>

			<c:if test="${empty loginUser}">
				<a href="login_form" id="har-login">로그인/회원가입</a>
			</c:if>

			<c:if test="${not empty loginUser}">
				<div id="har-member">
					<%-- <span class="har-member-name">${loginUser.name}</span> --%>
					<a id="har-login">로그아웃</a>

					<c:if test="${not empty loginUser.profilePicture}">
						<c:set var="profilePictureUrl">../upload/${loginUser.profilePicture}_110x110.jpg</c:set>
					</c:if>
					<c:if test="${empty loginUser.profilePicture}">
						<c:set var="profilePictureUrl">../images/person_80x80.jpg</c:set>
					</c:if>
					<div id="har-member-pro">
						<img src="${profilePictureUrl}" />
					</div>
				</div>
			</c:if>
		</div>
	</header>

	<section>
	 <div id="har-main">
    <a href="learning/list" id="har-class-list" class="har-list">클래스</a> 
    <a href="tutor/list" id="har-tutor-list" class="har-list">튜터</a>
    </div>
  </section>
   
   
   <footer>
    <div id="har-footer">
        <img src="../images/footer-01.png">
    </div>
</footer>
</body>
</html>