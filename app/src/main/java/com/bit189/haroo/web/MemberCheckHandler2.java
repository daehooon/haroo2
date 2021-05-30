package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/check2")
public class MemberCheckHandler2 extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    try {
      String nickname = request.getParameter("nickname");

      Member m = memberService.get(nickname);

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      if (m == null) {
        out.print("no");
      } else {
        out.print("yes");
      }

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






