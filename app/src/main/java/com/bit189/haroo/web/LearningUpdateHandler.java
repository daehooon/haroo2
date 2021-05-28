package com.bit189.haroo.web;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit189.haroo.domain.Learning;
import com.bit189.haroo.service.LearningService;
import com.eomcs.pms.domain.Project;

@SuppressWarnings("serial")
@WebServlet("/learning/update")
public class LearningUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    LearningService learningService = (LearningService) request.getServletContext().getAttribute("learningService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Learning oldLearning = learningService.get(no);

      if (oldLearning == null) {
        throw new Exception("해당 번호의 체험학습이 없습니다.");
      } 

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldLearning.getOwner().getNo() != loginUser.getNo()) {
        throw new Exception("변경 권한이 없습니다!");
      }

      // 사용자에게서 변경할 데이터를 입력 받는다.
      Project project = new Project();
      project.setNo(no);
      project.setTitle(request.getParameter("title"));
      project.setContent(request.getParameter("content"));
      project.setStartDate(Date.valueOf(request.getParameter("startDate")));
      project.setEndDate(Date.valueOf(request.getParameter("endDate")));
      project.setOwner(loginUser);

      // ...&member=1&member=18&member=23
      String[] values = request.getParameterValues("member");
      ArrayList<Member> memberList = new ArrayList<>();
      if (values != null) {
        for (String value : values) {
          Member member = new Member();
          member.setNo(Integer.parseInt(value));
          memberList.add(member);
        }
      }
      project.setMembers(memberList);

      // DBMS에게 프로젝트 변경을 요청한다.
      projectService.update(project);

      request.setAttribute("redirect", "list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






