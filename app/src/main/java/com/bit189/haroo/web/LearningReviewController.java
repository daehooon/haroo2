package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.ServletException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.service.LearningReviewService;
import com.bit189.haroo.service.LearningService;

@Controller
@RequestMapping("/learning/review/")
public class LearningReviewController {

  LearningService learningService;
  LearningReviewService learningReviewService;

  public LearningReviewController(LearningService learningService,
      LearningReviewService learningReviewService) {
    this.learningService = learningService;
    this.learningReviewService = learningReviewService;
    System.out.println("LearningReviewController 객체 생성됨!");
  }

  @GetMapping("list")
  public void list(@RequestParam(defaultValue = "0") int lno, Model model,
      String sortingItem, String sortingType) throws Exception { 

    if(lno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    }
    System.out.println(lno);
    Learning learning = learningService.get(lno);
    if(learning == null) {
      throw new ServletException("해당 번호의 체험 학습이 없습니다.");
    }

    model.addAttribute("learning", learning);

    sortingType = (sortingType == null ? "d" : sortingType); 

    switch (sortingType) {
      case "a":
        sortingType = "asc";
        break;
      default:
        sortingType = "desc";
    }

    List<LearningReview> reviews = 
        learningReviewService.listByLearning(lno, sortingItem, sortingType);

    model.addAttribute("reviews", reviews);
  }

  @GetMapping("detail")
  public void detail(@RequestParam(defaultValue = "0") int lno,
      @RequestParam(defaultValue = "0") int rno, Model model) throws Exception {

    if(lno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    } 

    if(rno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    }

    LearningReview review = learningReviewService.get(rno);

    model.addAttribute("review", review);
  }

}
