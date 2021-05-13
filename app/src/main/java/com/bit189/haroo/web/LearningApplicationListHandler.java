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
import com.bit189.haroo.domain.LearningApplication;
import com.bit189.haroo.service.LearningApplicationService;

@SuppressWarnings("serial")
@WebServlet("/learningApplication/list")
public class LearningApplicationListHandler extends HttpServlet{


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningApplicationService learningApplicationService = (LearningApplicationService)
        request.getServletContext().getAttribute("learningApplicationService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>체험신청</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>체험신청</h1>");



    try {
      List<LearningApplication> learningApplication = learningApplicationService.list();

      out.println("<table border='1'>");
      out.println("<thread>");
      out.println("<tr>");
      out.println("<th>번호<th> <th>신청일시</th> <th>신청수량</th>");
      out.println("</tr>");
      out.println(" </thead>");
      out.println("<tbody>");

      for (LearningApplication l : learningApplication) {
        out.printf("<tr"
            + " <td>%d</td>"
            + " <td><a href='detail?no=%1$d'>%s</a></td>"
            + " <td>%d</td>"
            + " <td>%d</td> </tr>\n", 
            l.getNo(), 
            l.getLearningDate(), 
            l.getApplySize());
      }
      out.println("</tbody>");
      out.println("</table>");

    } catch (Exception e) {

      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("<html>");

  }
}
