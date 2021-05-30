package com.bit189.haroo.web;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

@Controller
public class LearningUpdateHandler {

  BroadCategoryService broadCategoryService;
  NarrowCategoryService narrowCategoryService;
  SidoService sidoService;
  SigunguService sigunguService;
  LearningService learningService;

  public LearningUpdateHandler(BroadCategoryService broadCategoryService, NarrowCategoryService narrowCategoryService,
      SidoService sidoService, SigunguService sigunguService, LearningService learningService) {

    this.broadCategoryService = broadCategoryService;
    this.narrowCategoryService = narrowCategoryService;
    this.sidoService = sidoService;
    this.sigunguService = sigunguService;
    this.learningService = learningService;
  }

  @RequestMapping("/learning/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    request.setAttribute("broadCategorys", broadCategoryService.list());
    request.setAttribute("narrowCategorys", narrowCategoryService.list());
    request.setAttribute("sidos", sidoService.list());
    request.setAttribute("sigungus", sigunguService.list());

    int no = Integer.parseInt(request.getParameter("no"));
    Learning learning = learningService.get(no);
    request.setAttribute("learning", learning);

    if (request.getMethod().equals("GET")) {
      return "/jsp/learning/update.jsp";
    }

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
      coverImagePart.write(uploadDir + "/" + filename);
      s.setCoverImage(filename);

      Thumbnails.of(uploadDir + "/" + filename)
      .size(240, 160)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_240x160";
        }
      });

      Thumbnails.of(uploadDir + "/" + filename)
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
    return "redirect:list";
  }
}






