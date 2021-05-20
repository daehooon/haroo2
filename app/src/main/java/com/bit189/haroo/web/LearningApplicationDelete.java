package com.bit189.haroo.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.service.LearningApplicationService;

@SuppressWarnings("serial")
@WebServlet("/application/delete")
public class LearningApplicationDelete extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningApplicationService learningApplicationService = (LearningApplicationService)
        request.getServletContext().getAttribute("learningApplicationService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      LearningApplication la = learningApplicationService.get(no);

      if (la == null) {
        throw new Exception("해당 번호의 체험 학습이 없습니다.");
      }
      learningApplicationService.delete(no);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
