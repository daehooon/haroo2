package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ReComment;
import com.bit189.haroo.service.ReCommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/reComment/delete")
public class ReCommentDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReCommentService reCommentService = (ReCommentService) request.getServletContext().getAttribute("reCommentService");

    try {

      int no = Integer.parseInt(request.getParameter("no"));

      ReComment reComment = reCommentService.get(no);

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser.getNo() != reComment.getReWriter().getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }

      reCommentService.delete(no);

      response.sendRedirect("../detail?no=" + Integer.parseInt(request.getParameter("feedNo")));

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
