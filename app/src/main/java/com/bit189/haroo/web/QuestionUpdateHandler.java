package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;

@SuppressWarnings("serial")
@WebServlet("/question/update")
public class QuestionUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServiceQuestionService serviceQuestionService =
        (ServiceQuestionService) request.getServletContext().getAttribute("serviceQuestionService");

    try {
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
      q.setTitle(request.getParameter("title"));
      q.setContent(request.getParameter("content"));
      serviceQuestionService.update(q);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






