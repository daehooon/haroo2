package com.bit189.haroo.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.service.LearningReviewService;

@Controller
public class LearningReviewDetailHandler {

  LearningReviewService learningReviewService;

  public LearningReviewDetailHandler(LearningReviewService learningReviewService) {
    this.learningReviewService = learningReviewService;
  }

  @RequestMapping("/learning/review/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) 
      throws Exception {

    LearningReviewService learningReviewService = 
        (LearningReviewService) request.getServletContext().getAttribute("learningReviewService");

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

    return "/jsp/learningReview/detail.jsp";
  }
}
