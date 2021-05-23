package com.bit189.haroo.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.service.LearningReviewService;
import com.bit189.haroo.service.LearningService;

@SuppressWarnings("serial")
@WebServlet("/learning/review/list")
public class LearningReviewListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 클라이언트가 /board/list 를 요청하면 톰캣 서버가 이 메서드를 호출한다. 

    LearningReviewService learningReviewService = 
        (LearningReviewService) request.getServletContext().getAttribute("learningReviewService");

    LearningService learningService = 
        (LearningService) request.getServletContext().getAttribute("learningService");

    try {
      String lno = request.getParameter("lno");
      if(lno == null) {
        throw new ServletException("파라미터가 없습니다.");
      } 
      Learning learning = learningService.get(Integer.parseInt(lno));
      if(learning == null) {
        throw new ServletException("해당 번호의 체험 학습이 없습니다.");
      }

      request.setAttribute("learning", learning);

      List<LearningReview> reviews = learningReviewService.listByLearning(
          Integer.parseInt(lno), LearningReviewService.WRITED_DATE, false);


      request.setAttribute("reviews", reviews);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learningReview/list.jsp").include(request, response);


    } catch (Exception e) {
      throw new ServletException(e);
    }
  }


}
