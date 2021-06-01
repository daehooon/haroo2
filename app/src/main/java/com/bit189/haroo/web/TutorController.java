package com.bit189.haroo.web;

import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/tutor/")
public class TutorController {

  TutorService tutorService;
  MemberService memberService;
  ServletContext sc;

  public TutorController(TutorService tutorService, MemberService memberService, ServletContext sc) {
    this.tutorService = tutorService;
    this.memberService = memberService;
    this.sc = sc;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(Tutor t, TutorDistrict td, TutorCategory tc) throws Exception {
    td.setTno(t.getNo());
    tc.setTno(t.getNo());
    tutorService.add(t, td, tc);

    return "redirect:list";

  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    Tutor tutor = tutorService.get(no);
    if (tutor == null) {
      throw new Exception("해당 번호의 튜터가 없습니다.");
    }

    tutorService.delete(no);

    return "redirect:list";

  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {

    Tutor t = tutorService.get(no);
    model.addAttribute("tutor", t);

  }

  @GetMapping("list")
  public void list(String keyword, Model model) throws Exception {

    List<Tutor> list = tutorService.list(keyword);
    model.addAttribute("list", list);

  }

  @PostMapping("update")
  public String update(Member m, Tutor t, TutorCategory tc, TutorDistrict td, Part profileFile) throws Exception {

    String uploadDir = sc.getRealPath("/upload");


    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if (oldTutor.getWriter().getNo() != loginUser.getNo()) {
    //        throw new Exception("변경 권한이 없습니다!");
    //      }
    if (profileFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      profileFile.write(uploadDir + "/" + filename);
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

    if (tutorService.update(t, m, td, tc) == 0) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }

    return "redirect:list";

  }
}






