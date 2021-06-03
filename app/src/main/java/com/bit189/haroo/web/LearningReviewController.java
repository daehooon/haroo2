package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.domain.Member;
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
      String sortingItem, String sortingType, HttpSession session) throws Exception { 

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
      @RequestParam(defaultValue = "0") int rno, Model model,
      HttpSession session) throws Exception {

    if(lno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    } 

    if(rno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    }

    LearningReview review = learningReviewService.get(rno);

    Member loginUser = (Member) session.getAttribute("loginUser");

    model.addAttribute("review", review);
    if (loginUser != null) {
      System.out.println(learningReviewService.isRecommended(loginUser.getNo(), rno));
      model.addAttribute("isRecommended",
          learningReviewService.isRecommended(loginUser.getNo(), rno));
    }

  }

  @PostMapping("update")
  public void update(@RequestParam(defaultValue = "0") int lno,
      @RequestParam(defaultValue = "0") int rno, Model model) throws Exception {

    if(lno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    } 

    if(rno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    }

    LearningReview review = learningReviewService.get(rno);

    model.addAttribute("review", review);

    // 고쳐야함
  }

  @GetMapping("form")
  public String form(@RequestParam(defaultValue = "0") int lno, Model model,
      HttpSession session) throws Exception {

    // 체험학습 가져오기
    Learning learning = learningService.get(lno);
    if(learning == null) {
      throw new ServletException("해당 번호의 체험 학습이 없습니다.");
    }

    model.addAttribute("learning", learning);

    Member loginUser = (Member) session.getAttribute("loginUser");

    if (loginUser == null) {
      return "list";
    }

    // mno와 lno를 가지고 신청번호 구하기
    int applNo = learningReviewService.getApplicationNo(loginUser.getNo(), lno);
    model.addAttribute("applNo", applNo);

    if (applNo == 0) {
      throw new ServletException("로그인이 되어있지 않습니다.");
    }

    // 썼냐 안썼냐 확인
    learningReviewService.isReviewed(applNo);

    return null;
  }

  //  @GetMapping("form2")
  //  public void form2(@RequestParam(defaultValue = "0") int lno, Model model,
  //      HttpSession session) throws Exception {
  //
  //    Member loginUser = (Member) session.getAttribute("loginUser");
  //
  //    if(loginUser == null) {
  //      throw new ServletException("로그인이 되어있지 않습니다..");
  //    } else {
  //      int applNo = learningReviewService.getApplicationNo(loginUser.getNo(), lno);
  //      model.addAttribute("applNo", applNo);
  //
  //      System.out.println(applNo);
  //    }
  //  }

  @GetMapping("add")
  public void add(@RequestParam(defaultValue = "0") int lno, Model model,
      HttpSession session) throws Exception {

    // 체험학습 가져오기
    Learning learning = learningService.get(lno);
    if(learning == null) {
      throw new ServletException("해당 번호의 체험 학습이 없습니다.");
    }

    model.addAttribute("learning", learning);


  }


  @PostMapping("recommend")
  public String recommend(int lno, int mno, int rno) throws Exception {
    System.out.println("recommend진입");
    learningReviewService.recommend(mno, rno);

    return String.format("redirect:detail?lno=%d&rno=%d", lno, rno);
  }

  @PostMapping("unRecommend")
  public String unRecommend(int lno, int mno, int rno) throws Exception {
    System.out.println("unRecommend진입");
    learningReviewService.unRecommend(mno, rno);

    return String.format("redirect:detail?lno=%d&rno=%d", lno, rno);
  }
}
