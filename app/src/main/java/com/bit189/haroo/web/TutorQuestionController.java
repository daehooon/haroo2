package com.bit189.haroo.web;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.TutorQuestion;
import com.bit189.haroo.service.TutorQuestionService;


@Controller
@RequestMapping("/tutorQuestion/")
public class TutorQuestionController {

  TutorQuestionService tutorQuestionService;

  public TutorQuestionController(TutorQuestionService tutorQuestionService) {
    this.tutorQuestionService = tutorQuestionService;
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    TutorQuestion q = tutorQuestionService.get(no);
    if (q == null) {
      throw new Exception("해당 번호의 문의글이 없습니다.");
    }

    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
    //        throw new Exception("삭제 권한이 없습니다!");
    //      }

    tutorQuestionService.delete(no);

    return "redirect:list";
  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {
    TutorQuestion q = tutorQuestionService.get(no);
    model.addAttribute("tutorQuestion", q);
  }

  @RequestMapping("list")
  public void list(Model model) throws Exception {

    List<TutorQuestion> list = tutorQuestionService.list();

    model.addAttribute("list", list);
  }    

}

