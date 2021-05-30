package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;


@Controller
public class QuestionUpdateHandler {

  ServiceQuestionService serviceQuestionService;

  public QuestionUpdateHandler(ServiceQuestionService serviceQuestionService) {
    this.serviceQuestionService = serviceQuestionService;
  }

  @RequestMapping("/question/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Question oldQuestion = serviceQuestionService.get(no);
    if (oldQuestion == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldQuestion.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    Question q = new Question();
    q.setNo(oldQuestion.getNo());
    q.setContent(request.getParameter("content"));
    serviceQuestionService.update(q);

    return "redirect:list";

  }
}






