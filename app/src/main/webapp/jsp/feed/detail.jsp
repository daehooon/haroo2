<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<title>피드 상세</title>
</head>
<body>
	<h1>피드 상세보기(JSTL)</h1>
	
	<c:if test="${not empty feed}">
		<form action='update' method='post'>
			<table border='1'>
			<tbody>
			<tr><th>번호</th> <td><input type='text' name='no' value='${feed.no}' readonly></td></tr>
			<tr><th>프로필사진</th> <td>${feed.writer.profilePicture}</td></tr>
			<tr><th>튜터이름</th> <td>${feed.writer.name}</td></tr>
			<tr><th>등록일</th> <td>${feed.writingDate}</td></tr>
			<tr>
				<th>사진</th>
				<td>
					<c:forEach items="${feed.attachedFiles}" var="file">
						<c:if test="${not empty file.name}">
	           <c:set var="photoUrl">../upload/${file.name}_500x500.jpg</c:set>
	          </c:if>
	          
					  <img src='${photoUrl}'>
					</c:forEach>
				</td>
			</tr>
			<tr><th>내용</th> <td><textarea name='content' rows='10' cols='60'>${feed.content}</textarea></td></tr>
			<tr><th>조회수</th> <td>${feed.viewCount}</td></tr>
			<tr><th>좋아요수</th> <td>${feed.likeCount}</td></tr>
			<tr><th>댓글수</th> <td>${feed.commentCount}</td></tr>
			</tbody>
			</table>
			
			<c:if test="${not empty loginUser and loginUser.no == feed.writer.no}">
			<input type="submit" value="수정">
			
			 <a href="delete?no=${feed.no}">삭제</a>
			</c:if>
		</form>
	
	
		<c:forEach items="${comments}" var="comment">
		  <form action="reComment/add" method="post">
		    <input type="hidden" name="commentNo" value="${comment.no}"/>
		    <input type="hidden" name="taggedNo" value="${comment.writer.no}"/>
		    <input type="hidden" name="feedNo" value="${feed.no}" />
				<pre><b>${comment.writer.name}</b> ${comment.content}</pre>
				<input type="text" name="content" placeholder="답글을 달아주세요."/>
        <input type='submit' value='등록'>
	     	<%-- <a href="reComment/add?no=${comment.no}">답글달기</a> --%>
	     	
	     	<c:if test="${not empty loginUser and loginUser.no == comment.writer.no}">
	     	  <!-- <input type="submit" value="수정"/> -->
	     	  <%-- <a href="comment/update?no=${comment.no}">수정</a> --%>
	     	  <a href="comment/delete?no=${comment.no}&feedNo=${feed.no}">댓글삭제</a>
	     	</c:if>
	    </form>
     	
		  <c:forEach items="${comment.reComments}" var="reComment">
		  <c:if test="${reComment.state == true}">
		    <form action="" method="post">
		    <input type="hidden" name="no" value="${comment.no}"/>
				<pre>     <b>${reComment.reWriter.name}</b> @${reComment.taggedMember.name} ${reComment.content}</pre>
				<pre>     <input type="text" name="content" placeholder="답글의 답글을 달아주세요."/><input type='submit' value='등록'></pre>
        
        <%-- <a href="reComment/add?no=${comment.no}">답글달기</a> --%>
        
        <c:if test="${not empty loginUser and loginUser.no == reComment.reWriter.no}">
          <!-- <input type="submit" value="수정"/> -->
          <%-- <a href="comment/update?no=${comment.no}">수정</a> --%>
          <a href="reComment/delete?no=${reComment.no}&feedNo=${feed.no}">대댓글삭제</a>
        </c:if>
				</form>
			</c:if>
		  </c:forEach>
		</c:forEach>
		
		<form action='comment/add' method='post'>
			<input type="hidden" name="no" value="${feed.no}" />
			<input type="text" name="content" placeholder="댓글을 달아주세요."/>
			<input type='submit' value='등록'>
		</form>
		
	</c:if>
	
	<c:if test="${empty feed}">
   <p>없는 피드입니다.</p>
  </c:if>
	
	<p><a href='list'>목록</a></p>
</body>
</html>
