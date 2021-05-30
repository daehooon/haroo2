package com.bit189.haroo.web;

import java.sql.Date;
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
public class MemberAddHandler {

  MemberService memberService;

  public MemberAddHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/add")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    if (request.getMethod().equals("GET")) {
      return "/jsp/member/form.jsp";
    }

    Member m = new Member();
    m.setName(request.getParameter("name"));
    m.setEmail(request.getParameter("email"));
    m.setPassword(request.getParameter("password"));
    m.setNickname(request.getParameter("nickname"));
    Part profilePart = request.getPart("profile_pic");
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

    m.setBirthDate(Date.valueOf(request.getParameter("bdate")));
    m.setTel(request.getParameter("tel"));
    m.setSex(Integer.parseInt(request.getParameter("sex")));
    m.setZipcode(request.getParameter("zipcode"));
    m.setAddress(request.getParameter("addr"));
    m.setDetailAddress(request.getParameter("det_addr"));
    m.setRank(1);

    memberService.add(m);
    return "redirect:list";


  }
}





