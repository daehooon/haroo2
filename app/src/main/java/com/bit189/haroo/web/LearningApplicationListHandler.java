package com.bit189.haroo.web;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.service.LearningApplicationService;

@SuppressWarnings("serial")
@WebServlet("/application/list")
public class LearningApplicationListHandler extends HttpServlet{


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningApplicationService learningApplicationService = (LearningApplicationService)
        request.getServletContext().getAttribute("learningApplicationService");
    //    LearningScheduleService learningScheduleService = (LearningScheduleService)
    //        request.getServletContext().getAttribute("learningScheduleService");

    try {
      List<LearningApplication> learningApplications = null;


      request.setAttribute("learningApplications", learningApplications);
      //request.setAttribute("", learningApplications);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learningapplication/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);

    }
  }
}