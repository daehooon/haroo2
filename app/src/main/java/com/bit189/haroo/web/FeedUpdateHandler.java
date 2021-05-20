package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.CommentService;
import com.bit189.haroo.service.FeedService;

@SuppressWarnings("serial")
@WebServlet("/feed/update")
public class FeedUpdateHandler extends HttpServlet {

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    FeedService feedService = (FeedService) request.getServletContext().getAttribute("feedService");
    CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");

    int no = Integer.parseInt(request.getParameter("no"));

    try {
      Feed oldFeed = feedService.get(no);

      if (oldFeed == null) {
        throw new Exception("해당 번호의 스토리가 없습니다.");
      }

      Feed feed = new Feed();





      response.sendRedirect("list");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
    }
  }
}






