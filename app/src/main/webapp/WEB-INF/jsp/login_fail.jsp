<%@ page language="java" 
  contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>로그인</title>
<meta http-equiv="Refresh" content="1;url=login_form">
</head>
<body>

<header>
    <div id="har-header">
      <div id="har-logo" onclick="location.href='main'">
        <a href="main"><h1>하루</h1></a>
      </div>

      <button type="button" id="har-menu-btn"></button>

      <form action="" method="GET">
        <input type="search" name="" placeholder="재미있는 시간, 다양한 클래스를 검색해보세요!"
          class="har-search"> <input type="submit" value="검색"
          class="har-search-btn">
      </form>

    </div>
  </header>
  
  <section>
<h1>로그인 결과</h1>
<p>사용자 정보가 맞지 않습니다.</p>
</section>

<footer>
    <div id="har-footer">
        <img src="../images/footer-01.png">
    </div>
</footer>
</body>
</html>
