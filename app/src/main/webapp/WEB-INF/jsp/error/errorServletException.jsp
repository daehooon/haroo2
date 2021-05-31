<%@ page 
    language="java" 
    contentType="text/html; charset=UTF-8"
    trimDirectiveWhitespaces="true"%>
    
<!DOCTYPE html>
<html>
<head>
<title>실행 오류</title>
</head>
<body>
<h1>요청 처리 중 오류 발생!</h1>
<%
String errorMessage = (String) request.getAttribute("errorMessage");

if ( errorMessage != null) {
%>
<%-- 예외 문구가 있으면 출력한다. --%>
<p><%=errorMessage%></p>
<%
}
%>
<%-- 예외에 대한 상세 정보를 출력한다. --%>
<pre><%=(String) request.getAttribute("error")%></pre>
</body>
</html>