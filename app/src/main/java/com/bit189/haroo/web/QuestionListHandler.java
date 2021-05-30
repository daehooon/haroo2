package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;


@Controller
public class QuestionListHandler {

  ServiceQuestionService serviceQuestionService;

  public QuestionListHandler(ServiceQuestionService serviceQuestionService) {
    this.serviceQuestionService = serviceQuestionService;
  }

  @RequestMapping("/question/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Question> questions = serviceQuestionService.list();

    request.setAttribute("questions", questions);

    return "/jsp/serviceQuestion/list.jsp";


  }    
}

