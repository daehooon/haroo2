<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의 답변</title>
</head>
<body>
<h1>문의 답변</h1>
<form action="add" method="post" enctype="multipart/form-data">

내용: <textarea name="content" rows="20" cols="60"></textarea><br>
첨부 파일: <input type="file" name="file" multiple><br>

<input type="submit" value="등록">
</form>
</body>
</html>