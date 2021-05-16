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
import com.bit189.haroo.service.NarrowCategoryService;
import com.eomcs.pms.domain.Project;
import com.eomcs.pms.service.ProjectService;
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
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    NarrowCategoryService projectService = (ProjectService) request.getServletContext().getAttribute("projectService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>새 작업</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>새 작업</h1>");

    try {
      out.println("<form action='add' method='post'>");

      out.println("프로젝트: <select name='projectNo'>");
      List<Project> projects = projectService.list();
      for (Project project : projects) {
        out.printf("  <option value='%d'>%s</option>\n", project.getNo(), project.getTitle());
      }
      out.println("</select><br>");

      out.println("작업: <input type='text' name='content'><br>");
      out.println("마감일: <input type='date' name='deadline'><br>");

      out.println("담당자: <select name='owner'>");
      List<Member> members = memberService.list(null);
      for (Member m : members) {
        out.printf("  <option value='%d'>%s</option>\n", m.getNo(), m.getName());
      }
      out.println("</select><br>");

      out.println("상태: ");
      out.println("<input type='radio' name='status' value='0' checked>신규 ");
      out.println("<input type='radio' name='status' value='1'>진행중 ");
      out.println("<input type='radio' name='status' value='2'>완료 ");

      out.println("<input type='submit' value='등록'>");
      out.println("</form>");

    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    Learning l = new Learning();

    // 등록자는 로그인 사용자이다.
    //    HttpServletRequest httpRequest = request;
    //    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
    //    l.setOwner(loginUser);

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
      schedule.setStartTime(Time.valueOf(request.getParameter("learningStartTime")));
      schedule.setEndTime(Time.valueOf(request.getParameter("learningEndTime")));
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
      learningService.add(l, l);

      out.println("<p>체험학습을 등록했습니다.</p>");

      // 응답헤더에 리프래시 정보를 설정한다.
      response.setHeader("Refresh", "5;url=list");

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






