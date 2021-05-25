package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.service.LearningReviewService;

@SuppressWarnings("serial")
@WebServlet("/learning/review/detail")
public class LearningReviewDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningReviewService learningReviewService = 
        (LearningReviewService) request.getServletContext().getAttribute("learningReviewService");

    try {

      String lno = request.getParameter("lno");
      if(lno == null) {
        throw new ServletException("파라미터가 없습니다.");
      } 

      String rno = request.getParameter("rno");

      if(rno == null) {
        throw new ServletException("파라미터가 없습니다.");
      }


      LearningReview review = learningReviewService.get(Integer.parseInt(rno));

      request.setAttribute("lno", lno);
      request.setAttribute("review", review);
      System.out.println(review);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learningReview/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e); 
    }
  }
}
