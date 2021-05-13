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
import com.bit189.haroo.domain.Feed;
import com.bit189.haroo.service.FeedService;

@SuppressWarnings("serial")
@WebServlet("/feed/list")
public class FeedListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    FeedService feedService = (FeedService) request.getServletContext().getAttribute("feedService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>스토리 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>스토리 목록</h1>");

    out.println("<p><a href='form.html'>스토리 등록</a></p>");

    try {
      List<Feed> feeds = feedService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>프로필사진</th> <th>이름</th> <th>등록일자</th> <th>사진</th> <th>좋아요수</th> <th>댓글수</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Feed f : feeds) {
        out.printf("<tr>"
            + "<td>%s</td> "
            + "<td>%s</td> "
            + "<td>%s</td> "
            + "<td><a href='detail?no=%d'>%s</a></td> "
            + "<td>%d</td>"
            + "<td>%d</td>"
            + "</tr>\n", 
            f.getWriter().getProfilePicture(),
            f.getWriter().getName(),
            f.getWritingDate(),
            f.getNo(),
            f.getAttachedFiles().get(0).getName(),
            1,
            1);
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






