package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.domain.TutorCategory;
import com.bit189.haroo.domain.TutorDistrict;
import com.bit189.haroo.service.MemberService;
import com.bit189.haroo.service.TutorService;

@Controller
public class TutorAddHandler {

  TutorService tutorService;
  MemberService memberService;

  public TutorAddHandler(TutorService tutorService) {
    this.tutorService = tutorService;
    this.memberService = memberService;
  }

  @RequestMapping("/tutor/add")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    if (request.getMethod().equals("GET")) {
      return "/jsp/tutor/form.jsp";
    }


    TutorCategory tc = new TutorCategory();
    TutorDistrict td = new TutorDistrict();
    Tutor t = new Tutor();
    Member m = new Member();
    t.setNo(Integer.parseInt(request.getParameter("tno")));

    //      if (  == null) {
    //        throw new Exception("해당번호의 멤버가 없습니다.");
    //      }

    t.setIntro(request.getParameter("tintro"));
    t.setApplication(request.getParameter("tappl"));

    m.setNo(Integer.parseInt(request.getParameter("tno")));

    td.setTno(Integer.parseInt(request.getParameter("tno")));
    td.setSigunguNo(Integer.parseInt(request.getParameter("sgg_no")));

    tc.setTno(Integer.parseInt(request.getParameter("tno")));
    tc.setNarrowCategoryNo(Integer.parseInt(request.getParameter("ncat_no")));
    tutorService.add(t, m, td, tc);

    return "redirect:list";

  }
}






