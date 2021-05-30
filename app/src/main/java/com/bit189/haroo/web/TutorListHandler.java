package com.bit189.haroo.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bit189.haroo.domain.Tutor;
import com.bit189.haroo.service.TutorService;

@Controller
public class TutorListHandler {

  TutorService tutorService;

  public TutorListHandler(TutorService tutorService) {
    this.tutorService = tutorService;
  }

  @RequestMapping("/tutor/list")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List<Tutor> list = tutorService.list(request.getParameter("keyword"));

    request.setAttribute("list", list);
    return "/jsp/tutor/list.jsp";

  }

}
