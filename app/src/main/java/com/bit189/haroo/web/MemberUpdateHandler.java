package com.bit189.haroo.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class MemberUpdateHandler {

  MemberService memberService;

  public MemberUpdateHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/update")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");
    int no = Integer.parseInt(request.getParameter("no"));

    Member oldMember = memberService.get(no);
    if (oldMember == null) {
      throw new Exception("해당 번호의 회원이 없습니다.");
    }

    //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    //      if (oldMember.getWriter().getNo() != loginUser.getNo()) {
    //        throw new Exception("변경 권한이 없습니다!");
    //      }

    Member member = new Member();
    member.setNo(oldMember.getNo());
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));
    member.setNickname(request.getParameter("nickname"));

    Part profilePart = request.getPart("profilepicture");
    if (profilePart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      profilePart.write(uploadDir + "/" + filename);
      member.setProfilePicture(filename);

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

    member.setTel(request.getParameter("tel"));
    member.setZipcode(request.getParameter("zipcode"));
    member.setAddress(request.getParameter("address"));
    member.setDetailAddress(request.getParameter("detailaddress"));
    //      member.setRank(request.getParameter("rank"));
    //      member.setState(Boolean.parseBoolean(request.getParameter("mstate")));

    memberService.update(member);

    return "redirect:list";

  }
}






