package com.bit189.haroo.web;

import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/member/")
public class MemberController {

  MemberService memberService;
  ServletContext sc;

  public MemberController(MemberService memberService, ServletContext sc) {
    this.memberService = memberService;
    this.sc = sc;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(Member m, Part profileFile) throws Exception {
    String uploadDir = sc.getRealPath("/upload");

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
      .size(110, 110)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_110x110";
        }
      });
    }

    m.setRank(1);

    memberService.add(m);
    return "redirect:list";

  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {
    Member member = memberService.get(no);
    if (member == null) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }

    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
    //        throw new Exception("삭제 권한이 없습니다!");
    //      }

    memberService.delete(no);

    return "redirect:list";

  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {
    Member m = memberService.get(no);
    model.addAttribute("member", m);
  }

  @GetMapping("list")
  public void list(String keyword, Model model) throws Exception {

    List<Member> list = memberService.list(keyword);
    model.addAttribute("list", list);
  }

  @PostMapping("update")
  public String update(Member member , Part profileFile) throws Exception {

    String uploadDir =sc.getRealPath("/upload");
    if (profileFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      profileFile.write(uploadDir + "/" + filename);
      member.setProfilePicture(filename);

      Thumbnails.of(uploadDir + "/" + filename)
      .size(110, 110)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_110x110";
        }
      });
    }

    if (memberService.update(member) == 0) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }
    return "redirect:list";

  }


  @PostMapping("loginCheck")
  @ResponseBody
  public String loginCheck(HttpSession session)throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    if (loginUser == null) {
      return "no";
    } else {
      return "yes";
    }


  }

}





