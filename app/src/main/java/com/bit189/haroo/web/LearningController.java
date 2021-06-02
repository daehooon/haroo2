package com.bit189.haroo.web;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.ServiceInfo;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.LearningService;
import com.bit189.haroo.service.MemberService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/learning")
public class LearningController {

  ServletContext sc;
  LearningService learningService;
  MemberService memberService;

  public LearningController(ServletContext sc, LearningService learningService, MemberService memberService) {
    this.sc = sc;
    this.learningService = learningService;
    this.memberService = memberService;
  }

  @GetMapping("form")
  public void form() throws Exception {}

  @PostMapping("add")
  public String add(Part coverImage, HttpSession session, HttpServletRequest request) throws Exception {

    String uploadDir = sc.getRealPath("/upload");

    ServiceInfo s = new ServiceInfo();
    Learning l = new Learning();

    Member loginUser = (Member) session.getAttribute("loginUser");
    Tutor tutor = new Tutor();
    tutor.setNo(loginUser.getNo());
    l.setOwner(tutor);

    s.setName(request.getParameter("name"));
    s.setBroadCategoryNo(Integer.parseInt(request.getParameter("broadCategoryNo")));
    s.setNarrowCategoryNo(Integer.parseInt(request.getParameter("narrowCategoryNo")));

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
    schedule.setStartTime(Time.valueOf(request.getParameter("startTime") + ":00"));
    schedule.setEndTime(Time.valueOf(request.getParameter("endTime") + ":00"));
    schedules.add(schedule);
    l.setSchedules(schedules);

    l.setPrice(Integer.parseInt(request.getParameter("price")));

    if (coverImage.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      coverImage.write(uploadDir + "/" + filename);
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

    learningService.add(s, l);

    // 등록한 체험학습으로 연결하기 detail?
    return "redirect:list";
  }

  @RequestMapping("delete")
  public String delete(int no, HttpSession session) throws Exception {
    Learning learning = learningService.get(no);
    if (learning == null) {
      throw new Exception("해당 번호의 체험학습이 없습니다.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (learning.getOwner().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    learningService.delete(no);

    return "redirect:list";
  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {
    model.addAttribute("learning", learningService.get(no));
  }

  @GetMapping("list")
  public void list(Model model) throws Exception {
    List<Member> members = memberService.list(null);
    List<Learning> learnings = learningService.list();
    model.addAttribute("learnings", learnings);
    model.addAttribute("members", members);
  }

  @GetMapping("updateForm")
  public void updateForm(int no, Model model) throws Exception {
    model.addAttribute("learning", learningService.get(no));
  }

  @PostMapping("update")
  public String update(int no, Model model, Part coverImage,
      HttpSession session, HttpServletRequest request) throws Exception {

    Learning learning = learningService.get(no);
    String uploadDir = sc.getRealPath("/upload");

    ServiceInfo s = new ServiceInfo();
    Learning l = new Learning();

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (learning.getOwner().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    s.setNo(no);
    s.setName(request.getParameter("name"));
    s.setBroadCategoryNo(Integer.parseInt(request.getParameter("broadCategoryNo")));
    s.setNarrowCategoryNo(Integer.parseInt(request.getParameter("narrowCategoryNo")));

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
    schedule.setStartTime(Time.valueOf(request.getParameter("startTime") + ":00"));
    schedule.setEndTime(Time.valueOf(request.getParameter("endTime") + ":00"));
    schedules.add(schedule);
    l.setSchedules(schedules);

    l.setPrice(Integer.parseInt(request.getParameter("price")));

    if (coverImage.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      coverImage.write(uploadDir + "/" + filename);
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

    // 수정한 체험학습으로 연결하기 detail?
    return "redirect:list";
  }
}






