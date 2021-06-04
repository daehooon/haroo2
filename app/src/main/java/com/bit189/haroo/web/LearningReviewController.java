package com.bit189.haroo.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bit189.haroo.domain.AttachedFile;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningReview;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Post;
import com.bit189.haroo.service.LearningReviewService;
import com.bit189.haroo.service.LearningService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/learning/review/")
public class LearningReviewController {

  LearningService learningService;
  LearningReviewService learningReviewService;
  ServletContext sc;

  public LearningReviewController(LearningService learningService,
      LearningReviewService learningReviewService, ServletContext sc) {
    this.learningService = learningService;
    this.learningReviewService = learningReviewService;
    this.sc = sc;
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
    //    model.addAttribute("mode", 0);
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
      model.addAttribute("mode", 1);
      return String.format("forward:list?lno=%d",learning.getNo());
    }

    // mno와 lno를 가지고 신청번호 구하기
    int applNo = learningReviewService.getApplicationNo(loginUser.getNo(), lno);
    model.addAttribute("applNo", applNo);

    if (applNo == 0) {
      model.addAttribute("mode", 2);
      return String.format("forward:list?lno=%d",learning.getNo());
    }

    // 썼냐 안썼냐 확인

    if (learningReviewService.isReviewed(applNo)) {
      model.addAttribute("mode", 3);
      return String.format("forward:list?lno=%d",learning.getNo());
    }

    model.addAttribute("mode", 1);
    System.out.println("진입");

    return "learning/review/form";

  }

  @PostMapping("add")
  public String add(Post post, int applNo, String title, double rate, int lno,
      HttpServletRequest request) throws Exception {

    String uploadDir = sc.getRealPath("/upload");

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("files") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        file.write(uploadDir + "/" + filename);

        AttachedFile f = new AttachedFile();
        f.setName(filename);

        attachedFiles.add(f);

        // 썸네일 이미지 생성
        Thumbnails.of(uploadDir + "/" + filename)
        .size(330, 220)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_330x220";
          }
        });

        Thumbnails.of(uploadDir + "/" + filename)
        .size(500, 500)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_500x500";
          }
        });
      }
    }

    learningReviewService.add(post, attachedFiles, applNo, title, rate);

    return String.format("redirect:list?lno=%d", lno);
  }

  @PostMapping("update")
  public String update(Post post, String title, double rate, int lno,
      Model model, HttpServletRequest request) throws Exception {

    String uploadDir = sc.getRealPath("/upload");

    ArrayList<AttachedFile> attachedFiles = new ArrayList<>();

    Collection<Part> files = request.getParts();
    for (Part file : files) {
      if (file.getName().equals("files") && file.getSize() > 0) {
        System.out.println(">" + file.getSubmittedFileName());

        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        file.write(uploadDir + "/" + filename);

        AttachedFile f = new AttachedFile();
        f.setName(filename);

        attachedFiles.add(f);

        // 썸네일 이미지 생성
        Thumbnails.of(uploadDir + "/" + filename)
        .size(330, 220)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_330x220";
          }
        });

        Thumbnails.of(uploadDir + "/" + filename)
        .size(500, 500)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_500x500";
          }
        });
      }
    }

    learningReviewService.update(post, attachedFiles, title, rate);

    return String.format("redirect:list?lno=%d", lno);
  }

  @GetMapping("delete")
  public String delete(@RequestParam(defaultValue = "0") int lno,
      @RequestParam(defaultValue = "0") int rno) throws Exception {

    if (rno == 0) {
      throw new ServletException("파라미터가 없습니다.");
    }

    learningReviewService.delete(rno);

    return String.format("redirect:list?lno=%d", lno);

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
