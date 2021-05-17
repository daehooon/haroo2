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
@WebServlet("/learning/add")
public class LearningAddHandler extends HttpServlet {

  //  List<LearningSchedule> schedules = new ArrayList<LearningSchedule>();
  //  LearningSchedule schedule = new LearningSchedule();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    //    NarrowCategoryService narrowCategoryService = (NarrowCategoryService) request.getServletContext().getAttribute("narrowCategoryService");

    try {
      //      request.setAttribute("narrowCategorys", narrowCategoryService.list());

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learning/form.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    try {
      // 커버이미지
      // 서비스이름, 대분류명(드롭다운), 소분류명(드롭다운), 상세주소, 서비스소개,
      // 진행순서, 환불정보, 최소인원수, 최대인원수, 날짜, 시작시각, 종료시각, 가격
      Learning l = new Learning();
      l.setName(request.getParameter("name"));
      //      l.setNarrowCategoryNo(Integer.parseInt(request.getParameter("narrowCategoryNo")));
      l.setDetailAddress(request.getParameter("detailAddress"));
      l.setIntro(request.getParameter("intro"));
      l.setProgressOrder(request.getParameter("progressOrder"));
      l.setRefundInformation(request.getParameter("refundInformation"));
      l.setMinPeople(Integer.parseInt(request.getParameter("minPeople")));
      l.setMaxPeople(Integer.parseInt(request.getParameter("maxPeople")));
      //      schedule.setLearningDate(Date.valueOf(request.getParameter("learningDate")));
      //      schedule.setStartTime(Time.valueOf(request.getParameter("learningStartTime")));
      //      schedule.setEndTime(Time.valueOf(request.getParameter("learningEndTime")));
      //      schedules.add(schedule);
      //      l.setSchedules(schedules);
      l.setPrice(Integer.parseInt(request.getParameter("price")));

      learningService.add(l, l);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






