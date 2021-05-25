package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/comment/delete")
public class CommentDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

    try {

      int no = Integer.parseInt(request.getParameter("no"));

      Comment comment = commentService.get(no);

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser.getNo() != comment.getWriter().getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }

      commentService.delete(no);

      response.sendRedirect("../detail?no=" + Integer.parseInt(request.getParameter("feedNo")));

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
