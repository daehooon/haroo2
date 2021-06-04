package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.service.LearningApplicationService;

@Controller
@RequestMapping("/learningApplication/")
public class LearningApplicationController {

  ServletContext sc;
  LearningApplicationService learningApplicationService;

  public LearningApplicationController(ServletContext sc, LearningApplicationService learningApplicationService) {
    this.sc = sc;
    this.learningApplicationService = learningApplicationService;
  }

  @GetMapping("form")
  public void form() throws Exception {

  }

  @PostMapping("add")
  public String add(LearningApplication learningApplication, Model model) throws Exception {

    learningApplicationService.add(learningApplication);

    return "redirect:list";

  }

  @GetMapping("delete")
  public String delete(int no, HttpSession session) throws Exception {

    LearningApplication learningApplication = learningApplicationService.get(no);

    if (learningApplication== null) {
      throw new Exception("해당 번호의 체험 학습이 없습니다.");
    }

    learningApplicationService.delete(no);

    return "redirect:list";

  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {

    LearningApplication learningApplication = learningApplicationService.get(no);
    model.addAttribute("learningApplication", learningApplication);

  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    List<LearningApplication> learningApplication = learningApplicationService.list();
    model.addAttribute("learningApplication", learningApplication);

  }
}