package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Member;
import com.bit189.haroo.service.MemberService;

@SuppressWarnings("serial")
//@WebServlet("/member/detail")
public class MemberDetailHandler2 extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();


    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>회원 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>회원 상세보기</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Member m = memberService.get(no);

      if (m == null) {
        out.println("<p>해당 번호의 회원이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<form action='update' method='post' enctype='multipart/form-data'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", m.getNo());
      out.printf("<tr><th>이름</th>"
          + " <td><input type='text' name='name' value='%s' readonly></td></tr>\n", m.getName());
      out.printf("<tr><th>이메일</th>"
          + " <td><input type='text' name='email' value='%s' readonly></td></tr>\n", m.getEmail());
      out.printf("<tr><th>닉네임</th>"
          + " <td><input type='text' name='nickname' value='%s' ></td></tr>\n", m.getNickname());
      out.printf("<tr><th>사진</th> <td>"
          + "<a href='%s'><img src='%s'></a><br>"
          + "<input name='profilepicture' type='file'></td></tr>\n",
          m.getProfilePicture() != null ? "../upload/" + m.getProfilePicture() : "",
              m.getProfilePicture() != null ? "../upload/" + m.getProfilePicture() + "_80x80.jpg" : "../images/person_80x80.jpg");
      out.printf("<tr><th>전화번호</th>"
          + " <td><input type='text' name='tel' value='%s' >  <input type='button' value='문자인증'></td></tr>\n", m.getTel());
      out.println("<tr><th>성별</th> <td>");
      out.printf("<input type='radio' name='sex' value='1' %s onclick='return(false);'>남 \n",
          m.getSex() == 1 ? "checked" : "");
      out.printf("<input type='radio' name='sex' value='2' %s onclick='return(false);'>여 \n",
          m.getSex() == 2 ? "checked" : "");
      out.printf("<tr><th>생일</th>"
          + " <td><input type='text' name='birthdate' value='%s' readonly></td></tr>\n", m.getBirthDate());
      out.printf("<tr><th>우편번호</th>"
          + " <td><input type='text' name='zipcode' value='%s' >  <input type='button' value='우편번호찾기'></td></tr>\n", m.getZipcode());
      out.printf("<tr><th>기본주소</th>"
          + " <td><input type='text' name='address' value='%s' >  <input type='button' value='주소찾기'></td></tr>\n", m.getAddress());
      out.printf("<tr><th>상세주소</th>"
          + " <td><input type='text' name='detailaddress' value='%s' ></td></tr>\n", m.getDetailAddress());
      out.printf("<tr><th>회원등급</th>"
          + " <td>%s </td></tr>\n", m.getRank() == 1 ? "회원" : m.getRank() == 2 ? "튜터" : "관리자");
      //      out.println("<tr><th>회원등급</th> <td>");
      //      out.printf("<input type='radio' name='rank' value='회원' %s >회원 \n",
      //          m.getRank() == "회원" ? "checked" : "");
      //      out.printf("<input type='radio' name='rank' value='튜터' %s >튜터 \n",
      //          m.getRank() == "튜터" ? "checked" : "");
      //      out.printf("<input type='radio' name='rank' value='관리자' %s >관리자 \n",
      //          m.getRank() == "관리자" ? "checked" : "");
      out.printf("<tr><th>가입일</th> <td>%s</td></tr>\n", m.getRegisteredDate());
      //            out.printf("<tr><th>회원상태</th>"
      //                + " <td><input type='text' name='state' value='%s'> </td></tr>\n", m.isState() == true ? "활성" : "비활성");
      out.println("</tbody>");

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (loginUser != null && m.getName().getNo() == loginUser.getNo()) 
      //      {
      out.println("<tfoot>");
      out.println("<tr><td colspan='2'>");
      out.println("<input type='submit' value='변경'> "
          + "<a href='delete?no=" + m.getNo() + "'>삭제</a> ");
      out.println("</td></tr>");
      out.println("</tfoot>");
      //      }

      out.println("</table>");
      out.println("</form>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}






