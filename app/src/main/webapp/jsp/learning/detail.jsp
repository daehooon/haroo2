<%@page import="com.bit189.haroo.domain.Learning"%>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>체험학습 상세</title>
</head>
<body>
<h1>체험학습 상세보기</h1>
<%
if (request.getAttribute("learning") != null) {
%>
<p><a href='/application/add'>체험학습 신청</a></p>

<jsp:useBean id="learning" type="com.bit189.haroo.domain.Learning" scope="request"/>
<%
if (learning != null) {
  pageContext.setAttribute("cover800x450Url",
      learning.getCoverImage() != null ?
          "../upload/" + learning.getCoverImage() + "_800x450.jpg" : "../images/cover_800x450.jpg");
  pageContext.setAttribute("coverUrl",
      learning.getCoverImage() != null ?
          "../upload/" + learning.getCoverImage() : "");
%>

<form action="detail" method="post">
<table border='1'>
<tbody>
<tr><th>커버이미지</th>
  <td><a href='${coverUrl}'>
  <img src='${cover800x450Url}'></a><br></td></tr>
<tr><th>대분류</th> <td>${learning.broadCategory}</td></tr>
<tr><th>소분류</th> <td>${learning.narrowCategory}</td></tr>
<tr><th>제목</th> <td>${learning.name}</td></tr>
<tr><th>광역시도</th> <td>${learning.metropolitanCity}</td></tr>
<tr><th>시군구</th> <td>${learning.sigungu}</td></tr>
<tr><th>평균평점</th> <td>${learning.averageRate}</td></tr>
<tr><th>등록일</th> <td>${learning.registeredDate}</td></tr>
<tr><th>본문</th> <td>${learning.intro}</td></tr>
<tr><th>진행순서</th> <td>${learning.progressOrder}</td></tr>
<tr><th>튜터사진</th> <td>${learning.owner.profilePicture}</td></tr>
<tr><th>개설자</th> <td>${learning.owner.name}</td></tr>
<tr><th>튜터별명</th> <td>${learning.owner.nickname}</td></tr>
<tr><th>튜터소개</th> <td>${learning.owner.intro}</td></tr>
<!-- 맵 api -->
<tr><th>환불정보</th> <td>${learning.refundInformation}</td></tr>
</tbody>
<p><a href='review'>후기</a></p>
<p><a href='question'>문의</a></p>

</table>
</form>

<%}
} else {%>
<p>해당 번호의 체험학습이 없습니다.</p>
<%}%>

</body>
</html>