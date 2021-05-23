package com.bit189.haroo.web;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.service.LearningApplicationService;

@SuppressWarnings("serial")
@WebServlet("/application/add")
public class LearningApplicationAddHandler extends HttpServlet{

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // LearningScheduleService 삭제해서 주석 처리했음 - 대훈
    //    LearningScheduleService learningScheduleService = (LearningScheduleService)
    //        request.getServletContext().getAttribute("learningSchedules");

    try {  
      //      request.setAttribute("learningSchedules", learningScheduleService.list());

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learningApplication/form.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningApplicationService learningApplicationService = (LearningApplicationService)
        request.getServletContext().getAttribute("learningApplicationService");

    try {

      LearningApplication la = new LearningApplication();
      LearningSchedule schedules = new LearningSchedule();

      schedules.setLearningDate(Date.valueOf(request.getParameter("schedules")));
      // la.setSchedules(schedules);
      la.setApplySize(Integer.parseInt(request.getParameter("applySize")));

      learningApplicationService.add(la);

      response.sendRedirect("list");


    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
