<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 문의글</title>
</head>
<body>
<h1>새 문의글</h1>
<form action="add" method="post" enctype="multipart/form-data">
제목: <input type="text" name="title"><br>
내용: <textarea name="content" rows="20" cols="60"></textarea><br>
첨부 파일: <input type="file" name="file" multiple><br>
<td class="form-inline">
    <input type="radio" name="secret" id="secret" value="Y" class="radio" />공개&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="radio" name="secret" id="secret" value="N" class="radio" />비공개&nbsp;
</td>


<input type="submit" value="등록">
</form>
</body>
</html>