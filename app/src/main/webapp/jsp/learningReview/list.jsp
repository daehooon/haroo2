<%@page import="com.bit189.haroo.service.MemberService"%>
<%@page import="java.util.List"%>
<%@page import="com.bit189.haroo.domain.Review"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험 후기</title>
</head>
<body>
<h1>체험 후기</h1>
<jsp:useBean id="reviews" type="List<Review>" scope="request"/>
<h2>${learninng.name} }</h2>
<%
if (reviews.size() == 0) {
%>
<p>아직 작성된 후기가 없습니다.</p> 
<%
} else {
%>
<table border='1'>
<thead>
<tr>
<th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> 
<th>평점</th> <th>조회수</th> <th>추천수</th>
</tr>
</thead>
<tbody>
<%
  for (Review r : reviews) {
%>
<tr>
  <td>${r.no}</td>
  <td><a href='detail?rno=${r.no}'>${r.title}</a></td>
  <td>${r.writer.nickName}</td>
  <td>${r.registeredDate}</td>
  <td>${r.rate}</td>
  <td>${r.viewCount}</td>
  <td>${r.recommendCount}</td>
</tr>
<%
  }
}
%>
</tbody>
</table>
<form action='search' method='get'>
<input type='text' name='keyword' value='${param.keyword}'>
<button>검색</button>
</form>
</body>
</html>