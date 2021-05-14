package com.bit189.haroo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.domain.LearningSchedule;
import com.bit189.haroo.service.LearningService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/learning/add")
public class LearningAddHandler extends HttpServlet {

  private String uploadDir;
  List<LearningSchedule> schedules = new ArrayList<LearningSchedule>();
  LearningSchedule schedule = new LearningSchedule();

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>체험학습 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>체험학습 등록</h1>");

    try {
      Learning l = new Learning();

      // 서비스이름, 대분류명(드롭다운), 소분류명(드롭다운), 상세주소, 서비스소개,
      // 진행순서, 환불정보, 최소인원수, 최대인원수, 날짜, 시작시각, 종료시각, 가격
      l.setName(request.getParameter("name"));
      l.setBroadCategory(request.getParameter("broadCategory"));
      l.setNarrowCategory(request.getParameter("narrowCategory"));
      l.setDetailAddress(request.getParameter("detailAddress"));
      l.setIntro(request.getParameter("intro"));
      l.setProgressOrder(request.getParameter("progressOrder"));
      l.setRefundInformation(request.getParameter("refundInformation"));
      l.setMinPeople(Integer.parseInt(request.getParameter("minPeople")));
      l.setMaxPeople(Integer.parseInt(request.getParameter("maxPeople")));
      schedule.setLearningDate(Date.valueOf(request.getParameter("learningDate")));
      schedule.setStartTime(Time.valueOf(request.getParameter("learningDate")));
      schedule.setEndTime(Time.valueOf(request.getParameter("learningDate")));
      schedules.add(schedule);
      l.setSchedules(schedules);
      l.setPrice(Integer.parseInt(request.getParameter("price")));

      // 커버이미지
      Part photoPart = request.getPart("coverImage");
      if (photoPart.getSize() > 0) {
        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        photoPart.write(this.uploadDir + "/" + filename);
        l.setCoverImage(filename);

        // 썸네일 이미지 생성
        Thumbnails.of(this.uploadDir + "/" + filename)
        .size(30, 30)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_30x30";
          }
        });

        Thumbnails.of(this.uploadDir + "/" + filename)
        .size(80, 80)
        .outputFormat("jpg")
        .crop(Positions.CENTER)
        .toFiles(new Rename() {
          @Override
          public String apply(String name, ThumbnailParameter param) {
            return name + "_80x80";
          }
        });
      }
      learningService.add(l);

      out.println("<p>체험학습을 등록했습니다.</p>");

      // 응답헤더에 리프래시 정보를 설정한다.
      response.setHeader("Refresh", "1;url=list");

      // 질문!
      // 클라이언트에게 응답할 때 헤더를 먼저 보내고 콘텐트를 나중에 보내는데
      // 위의 코드를 보면 println()을 이용하여 콘텐트를 먼저 출력한 다음에
      // 응답 헤더를 설정하는데 이것이 가능한가요?
      // - println()을 실행할 때 출력 내용은 모두 버퍼로 보낸다.
      // - 즉 아직 클라이언트에게 응답한 상태가 아니기 때문에 응답헤더를 설정할 수 있는 것이다.

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}






