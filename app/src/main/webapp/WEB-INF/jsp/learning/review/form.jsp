<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

</head>
<body>
<h1>체험 학습 후기 작성</h1>
<h2>${learning.name}</h2>

<form action='add' method='POST'>
	<table border='1'>
	 <tbody>
	   <tr> <th>제목</th> <td><input type='text' name="title" /></td> </tr>
	   <tr> <th>평점</th> <td><input type='text' name="rate" /></td> </tr>
	   <tr> <th>사진</th> <td><input type='file' name="files" /></td> </tr>
	   <tr> <th>내용</th> <td><textarea name="content" ></textarea></td> </tr>
	 </tbody>
  </table>
  <input type='submit' value='등록'/>
</form>
</body>
</html>