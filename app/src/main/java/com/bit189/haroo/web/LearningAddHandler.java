package com.bit189.haroo.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.service.LearningService;
import com.bit189.haroo.service.NarrowCategoryService;
import com.bit189.haroo.service.SigunguService;

@SuppressWarnings("serial")
@WebServlet("/learning/add")
public class LearningAddHandler extends HttpServlet {

  List<LearningSchedule> schedules = new ArrayList<LearningSchedule>();
  LearningSchedule schedule = new LearningSchedule();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    NarrowCategoryService narrowCategoryService = (NarrowCategoryService) request.getServletContext().getAttribute("narrowCategoryService");
    SigunguService sigunguService = (SigunguService) request.getServletContext().getAttribute("sigunguService");

    try {
      request.setAttribute("narrowCategorys", narrowCategoryService.list());
      request.setAttribute("sigungus", sigunguService.list());

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
      /* 커버이미지
       * 서비스이름, 대분류, 소분류
       * 우편번호 API (기본주소, 광역시도명, 시군구명 자동출력),
       * 상세주소, 서비스소개, 진행순서, 환불정보, 최소인원수, 최대인원수,
       * 날짜, 시작시각, 종료시각,
       * 가격 
       */
      Learning l = new Learning();
      l.setName(request.getParameter("name"));
      l.setBroadCategoryNo(Integer.parseInt(request.getParameter("broadCategoryNo")));
      l.setNarrowCategoryNo(Integer.parseInt(request.getParameter("narrowCategoryNo")));

      // 우편번호 API
      l.setAddress(request.getParameter("address"));
      l.setSidoNo(Integer.parseInt(request.getParameter("sidoNo")));
      l.setSigunguNo(Integer.parseInt(request.getParameter("sigunguNo")));

      l.setDetailAddress(request.getParameter("detailAddress"));
      l.setIntro(request.getParameter("intro"));
      l.setProgressOrder(request.getParameter("progressOrder"));
      l.setRefundInformation(request.getParameter("refundInformation"));
      l.setMinPeople(Integer.parseInt(request.getParameter("minPeople")));
      l.setMaxPeople(Integer.parseInt(request.getParameter("maxPeople")));

      schedule.setLearningDate(Date.valueOf(request.getParameter("learningDate")));
      schedule.setStartTime(Time.valueOf(request.getParameter("learningStartTime")));
      schedule.setEndTime(Time.valueOf(request.getParameter("learningEndTime")));
      schedules.add(schedule);
      l.setSchedules(schedules);

      l.setPrice(Integer.parseInt(request.getParameter("price")));

      // 커버이미지
      //      Part photoPart = request.getPart("photo");
      //      if (photoPart.getSize() > 0) {
      //        // 파일을 선택해서 업로드 했다면,
      //        String filename = UUID.randomUUID().toString();
      //        photoPart.write(this.uploadDir + "/" + filename);
      //        m.setPhoto(filename);
      //
      //        // 썸네일 이미지 생성
      //        Thumbnails.of(this.uploadDir + "/" + filename)
      //        .size(30, 30)
      //        .outputFormat("jpg")
      //        .crop(Positions.CENTER)
      //        .toFiles(new Rename() {
      //          @Override
      //          public String apply(String name, ThumbnailParameter param) {
      //            return name + "_30x30";
      //          }
      //        });
      //
      //        Thumbnails.of(this.uploadDir + "/" + filename)
      //        .size(80, 80)
      //        .outputFormat("jpg")
      //        .crop(Positions.CENTER)
      //        .toFiles(new Rename() {
      //          @Override
      //          public String apply(String name, ThumbnailParameter param) {
      //            return name + "_80x80";
      //          }
      //        });
      //      }

      learningService.add(l, l);

      // list말고 detail?
      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






