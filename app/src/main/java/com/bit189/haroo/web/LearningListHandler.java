package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.LearningService;

@SuppressWarnings("serial")
@WebServlet("/learning/list")
public class LearningListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>체험학습 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>체험학습 목록</h1>");

    out.println("<p><a href='form.html'>체험학습 등록</a></p>");

    try {
      List<Learning> learnings = learningService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      // <th>찜 목록</th> 해야됨!!
      out.println("<th>썸네일</th> <th>대분류</th> <th>제목</th> <th>광역시도</th> <th>시군구</th>"
          + "<th>튜터프로필사진</th> <th>튜터별명 또는 이름</th> <th>가격</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Learning l : learnings) {
        if (l.getOwner().getNickname() == null) {
          out.printf("<tr>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%d</td>"
              + "</tr>\n", 
              l.getCoverImage(), 
              l.getBroadCategory(),
              l.getName(),
              l.getMetropolitanCity(),
              l.getSigungu(),
              l.getOwner().getProfilePicture(),
              l.getOwner().getName(),
              l.getPrice());
        } else {
          out.printf("<tr>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%s</td>"
              + " <td>%d</td>"
              + "</tr>\n", 
              l.getCoverImage(), 
              l.getBroadCategory(),
              l.getName(),
              l.getMetropolitanCity(),
              l.getSigungu(),
              l.getOwner().getProfilePicture(),
              l.getOwner().getNickname(),
              l.getPrice());
        }
      }
      out.println("</tbody>");
      out.println("</table>");

    } catch (Exception e) {
      // 상세 오류 내용을 StringWriter로 출력한다.
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      // StringWriter 에 들어 있는 출력 내용을 꺼내 클라이언트로 보낸다.
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}






