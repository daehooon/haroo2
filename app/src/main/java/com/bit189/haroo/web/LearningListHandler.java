package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.LearningService;
import com.bit189.haroo.service.MemberService;

@Controller
public class LearningListHandler {

  LearningService learningService;
  MemberService memberService;

  public LearningListHandler(LearningService learningService, MemberService memberService) {
    this.learningService = learningService;
    this.memberService = memberService;
  }

  @RequestMapping("/learning/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Member> members = memberService.list(null);
    List<Learning> learnings = learningService.list();
    request.setAttribute("learnings", learnings);
    request.setAttribute("members", members);
    return "/jsp/learning/list.jsp";
  }
}






