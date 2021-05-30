package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;


@Controller
public class QuestionDetailHandler {

  ServiceQuestionService serviceQuestionService;

  public QuestionDetailHandler(ServiceQuestionService serviceQuestionService) {
    this.serviceQuestionService = serviceQuestionService;
  }


  @RequestMapping("/question/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    int no = Integer.parseInt(request.getParameter("no"));

    Question question = serviceQuestionService.get(no);
    request.setAttribute("question", question);

    return "/jsp/serviceQuestion/detail.jsp";

  }
}







