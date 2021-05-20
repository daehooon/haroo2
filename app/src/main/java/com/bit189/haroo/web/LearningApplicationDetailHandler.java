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
@WebServlet("/application/detail")
public class LearningApplicationDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningApplicationService learningApplicationService = (LearningApplicationService)
        request.getServletContext().getAttribute("learningApplicationService");

    //    LearningScheduleService learningScheduleService = (LearningScheduleService)
    //        request.getServletContext().getAttribute("learningScheduleService");


    try { 
      int no = Integer.parseInt(request.getParameter("no"));

      LearningApplication learningApplications = learningApplicationService.get(no);
      if (learningApplications == null) {
        throw new Exception("해당 번호의 체험 신청이 없습니다.");
      }


      request.setAttribute("learningApplications", learningApplications);
      // request.setAttribute("learningScheduleService", learningScheduleService.list());

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learningapplication/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
