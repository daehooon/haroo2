package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.CommentService;
import com.bit189.haroo.service.ReCommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/reComment/add")
public class ReCommentAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReCommentService reCommentService = (ReCommentService) request.getServletContext().getAttribute("reCommentService");
    CommentService commentSerivce = (CommentService) request.getServletContext().getAttribute("commentService");

    try {
      ReComment reComment = new ReComment();


      reComment.setCommentNo(Integer.parseInt(request.getParameter("commentNo")));
      reComment.setContent(request.getParameter("content"));
      Member taggedMember = new Member();
      taggedMember.setNo(Integer.parseInt(request.getParameter("taggedNo")));
      reComment.setTaggedMember(taggedMember);
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      reComment.setReWriter(loginUser);

      reCommentService.add(reComment);

      response.sendRedirect("../detail?no=" + Integer.parseInt(request.getParameter("feedNo")));

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
