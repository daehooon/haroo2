<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>스토리 작성</h1>

<form action="add" method="post" enctype="multipart/form-data">
<textarea name="content" rows="20" cols="60"></textarea><br>
<input type="file" name="file" multiple><br>
<input type="submit" value="등록">
</form>

</body>
</html>