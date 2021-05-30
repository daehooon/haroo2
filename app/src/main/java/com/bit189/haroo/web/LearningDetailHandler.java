package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.LearningService;

@Controller
public class LearningDetailHandler {

  LearningService learningService;

  public LearningDetailHandler(LearningService learningService) {
    this.learningService = learningService;
  }

  @RequestMapping("/learning/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    Learning learning = learningService.get(no);
    request.setAttribute("learning", learning);
    return "/jsp/learning/detail.jsp";
  }
}





