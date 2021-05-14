package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.LearningService;

@SuppressWarnings("serial")
@WebServlet("/learning/detail")
public class LearningDetailHandler extends HttpServlet {

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("no"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>체험학습 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>체험학습 상세보기</h1>");

    try {
      Learning l = learningService.get(no);
      if (l == null) {
        out.println("<p>해당 번호의 체험학습이 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }
      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");

      out.printf("<tr><th>대분류</th> <td>%s</td></tr>\n", l.getBroadCategory());
      out.printf("<tr><th>소분류</th> <td>%s</td></tr>\n", l.getNarrowCategory());
      out.printf("<tr><th>제목</th> <td>%s</td></tr>\n", l.getName());
      out.printf("<tr><th>광역시도</th> <td>%s</td></tr>\n", l.getMetropolitanCity());
      out.printf("<tr><th>시군구</th> <td>%s</td></tr>\n", l.getSigungu());
      out.printf("<tr><th>평균평점</th> <td>%s</td></tr>\n", l.getAverageRate());
      out.printf("<tr><th>등록일</th> <td>%s</td></tr>\n", formatter.format(l.getRegisteredDate()));

      out.printf("<tr><th>커버이미지</th> <td>%s</td></tr>\n", l.getCoverImage());
      out.printf("<tr><th>소개글</th> <td>%s</td></tr>\n", l.getIntro());
      out.printf("<tr><th>진행순서</th> <td>%s</td></tr>\n", l.getProgressOrder());
      out.printf("<tr><th>튜터사진</th> <td>%s</td></tr>\n", l.getOwner().getProfilePicture());
      out.printf("<tr><th>작성자</th> <td>%s</td></tr>\n", l.getOwner().getName());
      out.printf("<tr><th>별명</th> <td>%s</td></tr>\n", l.getOwner().getNickname());
      out.printf("<tr><th>소개</th> <td>%s</td></tr>\n", l.getOwner().getIntro());
      // MAP API
      // 후기
      out.printf("<tr><th>환불정보</th> <td>%s</td></tr>\n", l.getRefundInformation());

      out.println("</tbody>");

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (loginUser != null && b.getWriter().getNo() == loginUser.getNo()) {
      //        out.println("<tfoot>");
      //        out.println("<tr><td colspan='2'>");
      //        out.println("<input type='submit' value='변경'> "
      //            + "<a href='delete?no=" + l.getNo() + "'>삭제</a> ");
      //        out.println("</td></tr>");
      //        out.println("</tfoot>");
      //      }

      out.println("</table>");
      out.println("</form>");


    } catch (Exception e) {
      //      request.setAttribute("exception", e);
      //      request.getRequestDispatcher("/error").forward(request, response);
      e.printStackTrace();
      return;
    }

    out.println("</body>");
    out.println("</html>");
  }
}





