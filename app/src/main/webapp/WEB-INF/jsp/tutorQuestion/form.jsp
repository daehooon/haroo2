<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>튜터 문의글</title>
</head>
<body>

<jsp:include page="/jsp/header/header.jsp"/>

<h1>튜터 문의글</h1>
<form action="add" method="post" enctype="multipart/form-data">
제목: <input type="text" name="title" ><br>
내용: <textarea name="content" rows="20" cols="60"></textarea><br>
첨부 파일: <input type="file" name="file" multiple><br>

      <input type="radio" name="secret" id="secret" value="1" class="radio" />공개
      <input type="radio" name="secret" id="secret" value="0" class="radio" />비공개

<input type="submit" value="등록">
</form>

<jsp:include page="/jsp/footer/footer.jsp"/>

</body>
</html>