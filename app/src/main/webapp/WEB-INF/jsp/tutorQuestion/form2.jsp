<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>튜터문의 - 답변글</title>

</head>
<body>

<jsp:include page="/jsp/header/header.jsp"/>
<section>
<h1>튜터문의 - 답변글</h1>
<form action="reply/add" method="post" enctype="multipart/form-data">
<input type = "hidden" name = "pno" value = "${pno}">
내용: <textarea name="replyContent" rows="20" cols="60"></textarea><br>
첨부 파일: <input type="file" name="file" multiple><br>


<input type="reset" value="초기화" >
<input type="submit" value="등록" >
<input type="button" value="목록" onclick="javascript:history.go(-1)">            


</form>
</section>
<jsp:include page="/jsp/footer/footer.jsp"/>

</body>
</html>