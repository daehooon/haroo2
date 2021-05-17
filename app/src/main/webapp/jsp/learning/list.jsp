<%@page import="java.util.List"%>
<%@page import="com.bit189.haroo.domain.Learning"%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<title>체험학습 목록</title>
</head>
<body>
<h1>체험학습 목록</h1>
<p><a href='basket'>장바구니에 넣기</a></p>
<p><a href='wish'>찜하기</a></p>
<p><a href='add'>체험학습 등록</a></p>
<table border='1'>
<thead>
<tr>
<th>썸네일</th> <th>대분류</th> <th>소분류</th> <th>제목</th> <!-- <th>구매횟수</th> -->
<th>광역시도</th> <th>시군구</th> <th>튜터프로필사진</th> <th>튜터명</th> <th>가격</th>
</tr>
</thead>
<tbody>
<jsp:useBean id="learnings" type="java.util.List<Learning>" scope="request"/>
<%
for (Learning l : learnings) {
  pageContext.setAttribute("l", l);
  pageContext.setAttribute("coverImage",
      l.getCoverImage() != null ? "../upload/" + l.getCoverImage() + " _80x80.jpg" : "../images/cover_80x80.jpg");
%>
<tr>
  <td><img src='${photoUrl}'></td>
  <td>${l.broadCategory}</td>
  <td>${l.narrowCategory}</td>
  <td><a href='detail?no=${l.no}'>${l.name}</a></td>
  <td>${l.metropolitanCity}</td>
  <!-- 구매횟수 -->
  <td>${l.sigungu}</td>
  <td>${l.owner.profilePicture}</td>
  <td>${l.owner.nickname}</td>
  <td>${l.price}</td>
</tr>
<%
}
%>
</tbody>
</table>

</body>
</html>