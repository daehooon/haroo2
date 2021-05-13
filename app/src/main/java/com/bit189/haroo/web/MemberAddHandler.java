package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddHandler extends HttpServlet {

  @Override
  public void service(HttpServletRequest request, HttpServletResponse response) 
      throws ServletException, IOException {

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    try {

      out.println("[회원 등록]");

      Member m = new Member();
      m.setName(request.getParameter("name"));
      m.setEmail(request.getParameter("email"));
      m.setPassword(request.getParameter("password"));
      m.setProfilePicture(request.getParameter("profile_pic"));
      m.setBirthDate(Date.valueOf(request.getParameter("bdate")));
      m.setTel(request.getParameter("tel"));
      m.setSex(Integer.parseInt(request.getParameter("sex")));
      m.setZipcode(request.getParameter("zipcode"));
      m.setAddress(request.getParameter("addr"));
      m.setDetailAddress(request.getParameter("det_addr"));

      memberService.add(m);

      out.println("회원을 등록하였습니다.");
    }catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println(strWriter.toString());
    }
  }
}






