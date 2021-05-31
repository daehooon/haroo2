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
import com.bit189.haroo.service.BroadCategoryService;
import com.bit189.haroo.service.LearningService;
import com.bit189.haroo.service.MemberService;
import com.bit189.haroo.service.NarrowCategoryService;
import com.bit189.haroo.service.SidoService;
import com.bit189.haroo.service.SigunguService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/learning")
public class LearningController {

  ServletContext sc;
  BroadCategoryService broadCategoryService;
  NarrowCategoryService narrowCategoryService;
  SidoService sidoService;
  SigunguService sigunguService;
  LearningService learningService;
  MemberService memberService;

  public LearningController(ServletContext sc, BroadCategoryService broadCategoryService, NarrowCategoryService narrowCategoryService,
      SidoService sidoService, SigunguService sigunguService, LearningService learningService, MemberService memberService) {

    this.sc = sc;
    this.broadCategoryService = broadCategoryService;
    this.narrowCategoryService = narrowCategoryService;
    this.sidoService = sidoService;
    this.sigunguService = sigunguService;
    this.learningService = learningService;
    this.memberService = memberService;
  }

  @GetMapping("form")
  public void form(Model model) throws Exception {
    model.addAttribute("broadCategorys", broadCategoryService.list());
    model.addAttribute("narrowCategorys", narrowCategoryService.list());
    model.addAttribute("sidos", sidoService.list());
    model.addAttribute("sigungus", sigunguService.list());
  }

  @PostMapping("add")
  public String add(ServiceInfo s, Learning l, Part coverImage,
      HttpSession session, HttpServletRequest request) throws Exception {

    String uploadDir = sc.getRealPath("/upload");

    // 개설자
    Member loginUser = (Member) session.getAttribute("loginUser");
    Tutor tutor = new Tutor();
    tutor.setNo(loginUser.getNo());
    l.setOwner(tutor);

    /* 커버이미지
     * 서비스이름, 대분류, 소분류
     * 우편번호 API (기본주소, 광역시도명, 시군구명 자동출력),
     * 상세주소, 서비스소개, 진행순서, 환불정보, 최소인원수, 최대인원수,
     * 날짜, 시작시각, 종료시각,
     * 가격
     */

    // 우편번호 API 추가하기

    List<LearningSchedule> schedules = new ArrayList<>();
    LearningSchedule schedule = new LearningSchedule();
    schedule.setLearningDate(Date.valueOf(request.getParameter("learningDate")));
    schedule.setStartTime(Time.valueOf(request.getParameter("learningStartTime") + ":00"));
    schedule.setEndTime(Time.valueOf(request.getParameter("learningEndTime") + ":00"));
    schedules.add(schedule);
    l.setSchedules(schedules);

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

    // list말고 detail?
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
  public void updateForm(Model model) throws Exception {
    model.addAttribute("broadCategorys", broadCategoryService.list());
    model.addAttribute("narrowCategorys", narrowCategoryService.list());
    model.addAttribute("sidos", sidoService.list());
    model.addAttribute("sigungus", sigunguService.list());
  }

  @PostMapping("update")
  public String update(int no, Model model, ServiceInfo s, Learning l, Part coverImage,
      HttpSession session, HttpServletRequest request) throws Exception {

    String uploadDir = sc.getRealPath("/upload");
    model.addAttribute("learning", learningService.get(no));

    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if (oldLearning.getOwner().getNo() != loginUser.getNo()) {
    //        throw new Exception("변경 권한이 없습니다!");
    //      }

    //    s.setNo(no);

    // 우편번호 API 추가하기

    List<LearningSchedule> schedules = new ArrayList<>();
    LearningSchedule schedule = new LearningSchedule();
    schedule.setLearningDate(Date.valueOf(request.getParameter("learningDate")));
    schedule.setStartTime(Time.valueOf(request.getParameter("learningStartTime") + ":00"));
    schedule.setEndTime(Time.valueOf(request.getParameter("learningEndTime") + ":00"));
    schedules.add(schedule);
    l.setSchedules(schedules);

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

    // list말고 detail?
    return "redirect:list";
  }
}






