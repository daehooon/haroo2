package com.bit189.haroo.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.domain.TutorCategory;
import com.bit189.haroo.domain.TutorDistrict;
import com.bit189.haroo.service.MemberService;
import com.bit189.haroo.service.TutorService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class TutorUpdateHandler {

  TutorService tutorService;
  MemberService memberService;

  public TutorUpdateHandler(TutorService tutorService, MemberService memberService) {
    this.tutorService = tutorService;
    this.memberService = memberService;
  }

  @RequestMapping("/tutor/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    int no = Integer.parseInt(request.getParameter("no"));

    Member oldMember = memberService.get(no);
    if (oldMember == null) {
      throw new Exception("해당 번호의 멤버가 없습니다.");
    }

    Tutor oldTutor = tutorService.get(no);
    if (oldTutor == null) {
      throw new Exception("튜터가 아닙니다.");
    }

    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if (oldTutor.getWriter().getNo() != loginUser.getNo()) {
    //        throw new Exception("변경 권한이 없습니다!");
    //      }
    TutorCategory tc = new TutorCategory();
    TutorDistrict td = new TutorDistrict();
    Member m = new Member();
    Tutor t = new Tutor();
    m.setNo(no);
    m.setName(request.getParameter("name"));
    m.setEmail(request.getParameter("email"));
    m.setPassword(request.getParameter("password"));
    m.setNickname(request.getParameter("nickname"));

    Part profilePart = request.getPart("profilepicture");
    if (profilePart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      profilePart.write(uploadDir + "/" + filename);
      m.setProfilePicture(filename);

      Thumbnails.of(uploadDir + "/" + filename)
      .size(30, 30)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(uploadDir + "/" + filename)
      .size(80, 80)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_80x80";
        }
      });
    }

    m.setTel(request.getParameter("tel"));
    m.setZipcode(request.getParameter("zipcode"));
    m.setAddress(request.getParameter("address"));
    m.setDetailAddress(request.getParameter("detailaddress"));

    t.setNo(no);
    t.setIntro(request.getParameter("intro"));
    t.setApplication(request.getParameter("application"));

    td.setTno(no);
    td.setSigunguNo(Integer.parseInt(request.getParameter("sigungu")));

    tc.setTno(no);
    tc.setNarrowCategoryNo(Integer.parseInt(request.getParameter("narrowCategory")));
    tutorService.update(t, m, td, tc);

    return "redirect:list";

  }
}






