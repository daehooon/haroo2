package com.bit189.haroo.web;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.service.BroadCategoryService;
import com.bit189.haroo.service.LearningService;
import com.bit189.haroo.service.NarrowCategoryService;
import com.bit189.haroo.service.SidoService;
import com.bit189.haroo.service.SigunguService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/learning/update")
public class LearningUpdateHandler extends HttpServlet {

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BroadCategoryService broadCategoryService = (BroadCategoryService) request.getServletContext().getAttribute("broadCategoryService");
    NarrowCategoryService narrowCategoryService = (NarrowCategoryService) request.getServletContext().getAttribute("narrowCategoryService");
    SidoService sidoService = (SidoService) request.getServletContext().getAttribute("sidoService");
    SigunguService sigunguService = (SigunguService) request.getServletContext().getAttribute("sigunguService");

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    try {
      request.setAttribute("broadCategorys", broadCategoryService.list());
      request.setAttribute("narrowCategorys", narrowCategoryService.list());
      request.setAttribute("sidos", sidoService.list());
      request.setAttribute("sigungus", sigunguService.list());

      int no = Integer.parseInt(request.getParameter("no"));
      Learning learning = learningService.get(no);
      request.setAttribute("learning", learning);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/learning/update.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    try {
      //      보류 (jsp로 옮길지)
      //      int no = Integer.parseInt(request.getParameter("no"));
      //
      //      Learning oldLearning = learningService.get(no);
      //
      //      if (oldLearning == null) {
      //        throw new Exception("해당 번호의 체험학습이 없습니다.");
      //      }

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (oldLearning.getOwner().getNo() != loginUser.getNo()) {
      //        throw new Exception("변경 권한이 없습니다!");
      //      }

      ServiceInfo s = new ServiceInfo();
      Learning l = new Learning();

      s.setName(request.getParameter("name"));
      s.setBroadCategoryNo(Integer.parseInt(request.getParameter("broadCategoryNo")));
      s.setNarrowCategoryNo(Integer.parseInt(request.getParameter("narrowCategoryNo")));

      // 추후 우편번호 API로 교체
      l.setZipcode(request.getParameter("zipcode"));
      l.setAddress(request.getParameter("address"));
      l.setSidoNo(Integer.parseInt(request.getParameter("sidoNo")));
      l.setSigunguNo(Integer.parseInt(request.getParameter("sigunguNo")));

      l.setDetailAddress(request.getParameter("detailAddress"));
      s.setIntro(request.getParameter("intro"));
      l.setProgressOrder(request.getParameter("progressOrder"));
      l.setRefundInformation(request.getParameter("refundInformation"));
      l.setMinPeople(Integer.parseInt(request.getParameter("minPeople")));
      l.setMaxPeople(Integer.parseInt(request.getParameter("maxPeople")));

      List<LearningSchedule> schedules = new ArrayList<>();
      LearningSchedule schedule = new LearningSchedule();
      schedule.setLearningDate(Date.valueOf(request.getParameter("learningDate")));
      schedule.setStartTime(Time.valueOf(request.getParameter("learningStartTime") + ":00"));
      schedule.setEndTime(Time.valueOf(request.getParameter("learningEndTime") + ":00"));

      schedules.add(schedule);
      l.setSchedules(schedules);

      l.setPrice(Integer.parseInt(request.getParameter("price")));

      Part coverImagePart = request.getPart("coverImage");
      if (coverImagePart.getSize() > 0) {
        String filename = UUID.randomUUID().toString();
        coverImagePart.write(this.uploadDir + "/" + filename);
        s.setCoverImage(filename);

        Thumbnails.of(this.uploadDir + "/" + filename)
        .size(240, 160)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_240x160";
          }
        });

        Thumbnails.of(this.uploadDir + "/" + filename)
        .size(800, 450)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_800x450";
          }
        });
      }

      learningService.update(s, l);

      // list말고 detail?
      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






