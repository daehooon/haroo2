package com.bit189.haroo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;

@Controller
public class MemberDetailHandler {

  MemberService memberService;

  public MemberDetailHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));

    Member m = memberService.get(no);
    request.setAttribute("member", m);

    return "/jsp/member/detail.jsp";

  }
}






