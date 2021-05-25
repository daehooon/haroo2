package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bit189.haroo.domain.Comment;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.CommentService;

@SuppressWarnings("serial")
@WebServlet("/feed/comment/update")
public class CommentUpdateHandler extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Comment comment = commentService.get(no);

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (loginUser.getNo() != comment.getWriter().getNo()) {
        throw new Exception("수정할 권한이 없습니다.");
      }

      HttpSession session = request.getSession();
      request.setAttribute("commentContent", comment.getContent());


      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("../detail?no=" + comment.getFeedNo()).include(request, response);

      System.out.println("다시와?");
      response.sendRedirect("../detail?no=" + comment.getFeedNo());
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");
    //
    try {
      System.out.println("수정코드를 짜자!");
      //      Comment comment = new Comment();
      //      comment.setFeedNo(Integer.parseInt(request.getParameter("no")));
      //      comment.setContent(request.getParameter("content"));
      //
      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      comment.setWriter(loginUser);
      //
      //      commentService.add(comment);
      //
      //      response.sendRedirect("../detail?no=" + comment.getFeedNo());

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
