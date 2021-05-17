package com.bit189.haroo.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.LearningService;

@SuppressWarnings("serial")
@WebServlet("/learning/list")
public class LearningListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    try {
      List<Learning> learnings = learningService.list();
      request.setAttribute("learnings", learnings);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learning/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






