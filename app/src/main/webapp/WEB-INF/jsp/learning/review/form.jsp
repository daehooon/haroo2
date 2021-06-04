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


</head>
<body>
<jsp:include page="/jsp/header/header.jsp"/>

<section>
<h1>체험 학습 후기 작성</h1>
<h2>${learning.name}</h2>

<form action='add' method='POST' enctype="multipart/form-data">
	<table border='1'>
	 <tbody>
	   <tr> <th>제목</th> <td><input type='text' name="title" /></td> </tr>
	   <tr> <th>평점</th> <td><input type='text' name="rate" /></td> </tr>
	   <tr> <th>사진</th> <td><input type='file' name="files" /></td> </tr>
	   <tr> <th>내용</th> <td><textarea name="content" rows='30' cols='150'></textarea></td> </tr>
	 </tbody>
  </table>
  <input type="hidden" name = "lno" value="${learning.no}"/>
  <input type="hidden" name = "applNo" value="${applNo}"/>
  <input type='submit' value='등록'/> <a href="list?lno=${learning.no}" class='har-lrv-det-up' >취소</a>
</form>
</section>
  <jsp:include page="/jsp/footer/footer.jsp"/>
</body>
</html>