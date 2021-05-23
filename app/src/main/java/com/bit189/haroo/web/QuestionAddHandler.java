package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;



@SuppressWarnings("serial")
@WebServlet("/question/add")
public class QuestionAddHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServiceQuestionService serviceQuestionService =
        (ServiceQuestionService) request.getServletContext().getAttribute("serviceQuestionService");

    Question q = new Question();

    q.setTitle(request.getParameter("title"));
    q.setContent(request.getParameter("content"));


    try {
      serviceQuestionService.add(q);
      response.sendRedirect("list");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }    
}

