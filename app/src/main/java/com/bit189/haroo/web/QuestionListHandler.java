package com.bit189.haroo.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Question;
import com.bit189.haroo.service.ServiceQuestionService;



@SuppressWarnings("serial")
@WebServlet("/question/list")
public class QuestionListHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ServiceQuestionService serviceQuestionService =
        (ServiceQuestionService) request.getServletContext().getAttribute("serviceQuestionService");


    try {
      String keyword = request.getParameter("keyword");
      List<Question> questions = null;
      if (keyword != null && keyword.length() > 0) {
        questions = serviceQuestionService.Search(keyword);
      } else {
        questions = serviceQuestionService.list();
      }


      request.setAttribute("list", questions);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/serviceQuestion/list.jsp").include(request, response);


    } catch (Exception e) {
      throw new ServletException(e);
    }
  }    
}

