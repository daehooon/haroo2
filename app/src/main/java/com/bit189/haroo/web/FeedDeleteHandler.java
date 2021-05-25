package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.FeedService;
import com.bit189.haroo.service.PostService;

@SuppressWarnings("serial")
@WebServlet("/feed/delete")
public class FeedDeleteHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    FeedService feedService = (FeedService) request.getServletContext().getAttribute("feedService");
    PostService postService = (PostService) request.getServletContext().getAttribute("postService");


    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Feed feed = feedService.get(no);

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (feed.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }

      postService.delete(no);

      response.sendRedirect("list");
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}
