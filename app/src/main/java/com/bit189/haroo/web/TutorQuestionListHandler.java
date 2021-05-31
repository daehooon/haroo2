package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.TutorQuestion;
import com.bit189.haroo.service.TutorQuestionService;


@Controller
public class TutorQuestionListHandler {

  TutorQuestionService tutorQuestionService;

  public TutorQuestionListHandler(TutorQuestionService tutorQuestionService) {
    this.tutorQuestionService = tutorQuestionService;
  }

  @RequestMapping("/tutorQuestion/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<TutorQuestion> tutorQuestions = tutorQuestionService.list();

    request.setAttribute("tutorQuestions", tutorQuestions);

    return "/jsp/tutorQuestion/list.jsp";


  }    
}

