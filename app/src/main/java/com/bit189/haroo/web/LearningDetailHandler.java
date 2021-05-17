package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.LearningService;

@SuppressWarnings("serial")
@WebServlet("/learning/detail")
public class LearningDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Learning learning = learningService.get(no);
      if (learning == null) {
        throw new Exception("해당 번호의 체험학습이 없습니다.");
      }

      request.setAttribute("learning", learning);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learning/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}





