package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.service.LearningReviewService;
import com.bit189.haroo.service.LearningService;

@Controller
public class LearningReviewListHandler {

  LearningService learningService;
  LearningReviewService learningReviewService;

  public LearningReviewListHandler(LearningService learningService,
      LearningReviewService learningReviewService) {
    this.learningService = learningService;
    this.learningReviewService = learningReviewService;
    System.out.println("LearningReviewListHandler 객체 생성됨!");
  }

  @RequestMapping("/learning/review/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) 
      throws Exception { 

    String lno = request.getParameter("lno");
    if(lno == null) {
      throw new ServletException("파라미터가 없습니다.");
    } 
    Learning learning = learningService.get(Integer.parseInt(lno));
    if(learning == null) {
      throw new ServletException("해당 번호의 체험 학습이 없습니다.");
    }

    request.setAttribute("learning", learning);

    String sortingItem = request.getParameter("sortingItem");
    String sortingType = request.getParameter("sortingType");

    sortingType = (sortingType == null ? "d" : sortingType); 

    switch (sortingType) {
      case "a":
        sortingType = "asc";
        break;
      default:
        sortingType = "desc";
    }

    List<LearningReview> reviews = 
        learningReviewService.listByLearning(
            Integer.parseInt(lno), sortingItem, sortingType);

    request.setAttribute("reviews", reviews);

    return "/jsp/learningReview/list.jsp";
  }

}
