package com.bit189.haroo.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;

@Controller
public class LoginHandler {

  MemberService memberService;

  public LoginHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/login")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    if (request.getMethod().equals("GET")) {
      return "/jsp/login_form.jsp";
    } 
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (request.getParameter("saveEmail") != null) {
      Cookie cookie = new Cookie("email", email);
      cookie.setMaxAge(60 * 60 * 24 * 7); 
      response.addCookie(cookie);
    } else {
      Cookie cookie = new Cookie("email", "");
      cookie.setMaxAge(0);  
      response.addCookie(cookie);
    }

    Member member = memberService.get(email, password);

    if (member == null) {
      request.getSession().invalidate(); 
      return "/jsp/login_fail.jsp";

    } else {
      request.getSession().setAttribute("loginUser", member);
      return "/jsp/login_success.jsp";
    }
  }
}






